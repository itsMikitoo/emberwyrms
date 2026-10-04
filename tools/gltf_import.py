"""Lector de glTF exportados por Blockbench (cubos). Devuelve la jerarquia, y por cada cubo su AABB local,
rotacion/traslacion del nodo y, por cada cara, el rectangulo de textura de origen. Uso: ver convert_model.py"""
import json, base64, io, math, os
import numpy as np
from PIL import Image

def load(path):
    g = json.load(open(path))
    buf = g['buffers'][0]['uri']
    data = base64.b64decode(buf.split(',', 1)[1]) if buf.startswith('data:') else open(os.path.join(os.path.dirname(path), buf), 'rb').read()
    imgs = []
    for im in g.get('images', []):
        uri = im['uri']
        imgs.append(Image.open(io.BytesIO(base64.b64decode(uri.split(',', 1)[1]))).convert('RGBA'))
    return g, data, imgs

def accessor(g, data, idx):
    a = g['accessors'][idx]; bv = g['bufferViews'][a['bufferView']]
    comp = {5126: ('f', 4), 5123: ('H', 2), 5125: ('I', 4), 5121: ('B', 1)}[a['componentType']]
    n = {'SCALAR': 1, 'VEC2': 2, 'VEC3': 3, 'VEC4': 4}[a['type']]
    off = bv.get('byteOffset', 0) + a.get('byteOffset', 0)
    stride = bv.get('byteStride')
    dt = np.dtype({'f': '<f4', 'H': '<u2', 'I': '<u4', 'B': 'u1'}[comp[0]])
    if stride and stride != comp[1] * n:
        arr = np.ndarray((a['count'], n), dtype=dt, buffer=data, offset=off, strides=(stride, comp[1]))
    else:
        arr = np.frombuffer(data, dtype=dt, count=a['count'] * n, offset=off).reshape(a['count'], n)
    return arr.astype(np.float64) if comp[0] == 'f' else arr.astype(np.int64)

def quat_to_mat(q):
    x, y, z, w = q
    return np.array([[1 - 2*(y*y + z*z), 2*(x*y - z*w), 2*(x*z + y*w)],
                     [2*(x*y + z*w), 1 - 2*(x*x + z*z), 2*(y*z - x*w)],
                     [2*(x*z - y*w), 2*(y*z + x*w), 1 - 2*(x*x + y*y)]])

def node_trs(n):
    t = np.array(n.get('translation', [0, 0, 0]), float)
    q = n.get('rotation', [0, 0, 0, 1])
    s = np.array(n.get('scale', [1, 1, 1]), float)
    return t, q, s

def meshes_of(g, data):
    """Devuelve {mesh_index: (positions Nx3, uvs Nx2, indices M, material)} (primera primitiva)."""
    out = {}
    for mi, m in enumerate(g['meshes']):
        prims = []
        for p in m['primitives']:
            pos = accessor(g, data, p['attributes']['POSITION'])
            uv = accessor(g, data, p['attributes']['TEXCOORD_0']) if 'TEXCOORD_0' in p['attributes'] else np.zeros((len(pos), 2))
            idx = accessor(g, data, p['indices']).reshape(-1) if 'indices' in p else np.arange(len(pos))
            prims.append((pos, uv, idx, p.get('material', 0)))
        out[mi] = prims
    return out
