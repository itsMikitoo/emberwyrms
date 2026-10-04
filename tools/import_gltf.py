#!/usr/bin/env python3
"""Convierte un modelo glTF exportado desde Blockbench (cubos + grupos) en partes de modelo de Minecraft:
  - conserva la jerarquia de grupos (pivotes y rotaciones),
  - cada cubo/plano pasa a ser un cuboide con UV estandar,
  - las texturas originales (una o varias) se re-muestrean cara a cara en UN atlas.
Uso desde otros scripts:  parts, atlas, info = convert(path)"""
import json, base64, io, os, re, math, sys
import numpy as np
from PIL import Image
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import generate as G

S_FLIP = np.diag([1.0, -1.0, 1.0])

def quat_to_mat(q):
    x, y, z, w = q
    return np.array([[1 - 2 * (y * y + z * z), 2 * (x * y - z * w), 2 * (x * z + y * w)],
                     [2 * (x * y + z * w), 1 - 2 * (x * x + z * z), 2 * (y * z - x * w)],
                     [2 * (x * z - y * w), 2 * (y * z + x * w), 1 - 2 * (x * x + y * y)]])

def euler_zyx(R):
    """R = Rz(roll) @ Ry(yaw) @ Rx(pitch) -> (pitch, yaw, roll)"""
    b = -math.asin(max(-1.0, min(1.0, R[2][0])))
    if abs(math.cos(b)) > 1e-6:
        a = math.atan2(R[2][1], R[2][2]); c = math.atan2(R[1][0], R[0][0])
    else:
        c = 0.0; a = math.atan2(-R[1][2], R[1][1])
    return (a, b, c)

class Gltf:
    def __init__(self, path):
        self.path = path; self.base = os.path.dirname(path); g = json.load(open(path)); self.g = g
        self.bufs = []
        for b in g['buffers']:
            uri = b['uri']
            self.bufs.append(base64.b64decode(uri.split(',', 1)[1]) if uri.startswith('data:') else open(os.path.join(self.base, uri), 'rb').read())
        self.imgs = []
        for im in g.get('images', []):
            uri = im.get('uri')
            if uri and uri.startswith('data:'): self.imgs.append(Image.open(io.BytesIO(base64.b64decode(uri.split(',', 1)[1]))).convert('RGBA'))
            elif uri:
                p = os.path.join(self.base, uri)
                if not os.path.exists(p): p = os.path.join(self.base, '..', 'textures', os.path.basename(uri))
                self.imgs.append(Image.open(p).convert('RGBA'))
            else:
                bv = g['bufferViews'][im['bufferView']]; off = bv.get('byteOffset', 0)
                self.imgs.append(Image.open(io.BytesIO(self.bufs[bv['buffer']][off:off + bv['byteLength']])).convert('RGBA'))

    def acc(self, idx):
        g = self.g; a = g['accessors'][idx]; bv = g['bufferViews'][a['bufferView']]
        ct = {5126: '<f4', 5123: '<u2', 5125: '<u4', 5121: 'u1'}[a['componentType']]
        n = {'SCALAR': 1, 'VEC2': 2, 'VEC3': 3, 'VEC4': 4}[a['type']]
        off = bv.get('byteOffset', 0) + a.get('byteOffset', 0)
        arr = np.frombuffer(self.bufs[bv['buffer']], dtype=ct, count=a['count'] * n, offset=off)
        return arr.reshape(-1, n) if n > 1 else arr

    def material_image(self, mi):
        """-> ('img', PIL) o ('color', (r,g,b,a))"""
        if mi is None: return ('color', (200, 200, 200, 255))
        m = self.g['materials'][mi]; pbr = m.get('pbrMetallicRoughness', {}); bct = pbr.get('baseColorTexture')
        if bct is not None:
            tex = self.g['textures'][bct['index']]
            return ('img', self.imgs[tex['source']])
        f = pbr.get('baseColorFactor', [0.8, 0.8, 0.8, 1])
        return ('color', tuple(int(round(max(0, min(1, v)) ** (1 / 2.2) * 255)) if k < 3 else int(v * 255) for k, v in enumerate(f)))

    def mesh_faces(self, mi):
        """Devuelve (aabb_min, aabb_max, faces) donde faces = {'+x'|'-x'|'+y'|'-y'|'+z'|'-z': (pos4, uv4, material)}"""
        faces = {}; lo = np.array([1e9] * 3); hi = np.array([-1e9] * 3)
        for prim in self.g['meshes'][mi]['primitives']:
            at = prim['attributes']; P = self.acc(at['POSITION']).astype(float)
            N = self.acc(at['NORMAL']).astype(float) if 'NORMAL' in at else None
            UV = self.acc(at['TEXCOORD_0']).astype(float) if 'TEXCOORD_0' in at else np.zeros((len(P), 2))
            lo = np.minimum(lo, P.min(0)); hi = np.maximum(hi, P.max(0))
            idx = self.acc(prim['indices']).astype(int) if 'indices' in prim else np.arange(len(P))
            # agrupar por cara: cada triangulo -> normal axial; juntar vertices del mismo plano/normal
            groups = {}
            for t in range(0, len(idx) - 2, 3):
                tri = idx[t:t + 3]; p = P[tri]
                n = np.cross(p[1] - p[0], p[2] - p[0]); ln = np.linalg.norm(n)
                if ln < 1e-12: continue
                n = n / ln
                if N is not None: n = N[tri].mean(0); n = n / (np.linalg.norm(n) + 1e-12)
                ax = int(np.argmax(np.abs(n))); key = ('+' if n[ax] > 0 else '-') + 'xyz'[ax]
                groups.setdefault(key, set()).update(int(i) for i in tri)
            for key, vs in groups.items():
                vs = sorted(vs)
                if key in faces and len(vs) < 3: continue
                faces[key] = (P[vs], UV[vs], prim.get('material'))
        return lo, hi, faces

def fit_affine(pos, uv):
    """uv = pos @ A + b  (minimos cuadrados)"""
    X = np.hstack([pos, np.ones((len(pos), 1))])
    sol, *_ = np.linalg.lstsq(X, uv, rcond=None)
    return sol   # (4,2)

def sanitize(name, used):
    n = re.sub(r'[^a-z0-9]+', '_', (name or 'part').lower()).strip('_') or 'part'
    if n[0].isdigit(): n = 'p' + n
    base = n; k = 2
    while n in used: n = '%s_%d' % (base, k); k += 1
    used.add(n); return n

def convert(path, flatten_root=True, k=1.0):
    gl = Gltf(path); g = gl.g; nodes = g['nodes']
    parts = []; used = set(); cubes_info = []   # cubes_info: (cube_dict) para pintar luego
    mesh_cache = {}

    def is_ident(n):
        return 'translation' not in n or all(abs(v) < 1e-9 for v in n['translation']) and 'rotation' not in n

    def add_cube(parent_name, node, parent_frame_is_group=True):
        mi = node['mesh']
        if mi not in mesh_cache: mesh_cache[mi] = gl.mesh_faces(mi)
        lo, hi, faces = mesh_cache[mi]
        T = np.array(node.get('translation', [0, 0, 0]), float) * 16 * k
        Tmc = np.array([T[0], -T[1], T[2]])
        ux0, ux1 = lo[0] * 16, hi[0] * 16; uy0, uy1 = -hi[1] * 16, -lo[1] * 16; uz0, uz1 = lo[2] * 16, hi[2] * 16
        U_lo = np.array([ux0, uy0, uz0]); U_S = np.array([ux1 - ux0, uy1 - uy0, uz1 - uz0])
        x0, x1, y0, y1, z0, z1 = ux0 * k, ux1 * k, uy0 * k, uy1 * k, uz0 * k, uz1 * k
        S = np.array([x1 - x0, y1 - y0, z1 - z0])
        Nsz = [0 if s < 0.05 else int(math.ceil(s - 1e-3)) for s in S]
        dil = [0.0 if Nsz[k] == 0 else (S[k] - Nsz[k]) / 2 for k in range(3)]
        mat = 'imp%d' % len(cubes_info)
        has_rot = 'rotation' in node and np.linalg.norm(np.array(node['rotation'][:3])) > 1e-6
        origin = np.array([x0 - dil[0], y0 - dil[1], z0 - dil[2]])
        cube = G.C(0, 0, 0, Nsz[0], Nsz[1], Nsz[2], mat, dil=tuple(round(d, 4) for d in dil) if any(abs(d) > 1e-6 for d in dil) else None)
        cube['src'] = dict(faces=faces, lo=U_lo, S=U_S, N=Nsz)
        if has_rot:
            R = quat_to_mat(node['rotation']); Rmc = S_FLIP @ R @ S_FLIP; rot = euler_zyx(Rmc)
            cube['o'] = tuple(origin)
            pname = sanitize((node.get('name') or 'cube'), used)
            parts.append(G.Part(pname, parent_name, tuple(Tmc), rot, [cube]))
        else:
            cube['o'] = tuple(origin + Tmc)
            if parent_name is None:
                pname = sanitize('cube', used)
                parts.append(G.Part(pname, None, (0, 24, 0), (0, 0, 0), [cube]))
            else:
                next(p for p in parts if p.name == parent_name).cubes.append(cube)
        cubes_info.append(cube)

    def walk(i, parent_name, depth_root):
        n = nodes[i]
        if n.get('mesh') is not None:
            add_cube(parent_name, n); return
        ch = n.get('children', [])
        if flatten_root and parent_name is None and is_ident(n) and (n.get('name') is None or depth_root < 2) and any(nodes[c].get('mesh') is None for c in ch) and not any(nodes[c].get('mesh') is not None for c in ch):
            for c in ch: walk(c, None, depth_root + 1)
            return
        name = sanitize(n.get('name') or 'group', used)
        T = np.array(n.get('translation', [0, 0, 0]), float) * 16 * k
        piv = (T[0], 24 - T[1], T[2]) if parent_name is None else (T[0], -T[1], T[2])
        rot = (0.0, 0.0, 0.0)
        if 'rotation' in n:
            R = quat_to_mat(n['rotation']); rot = euler_zyx(S_FLIP @ R @ S_FLIP)
        parts.append(G.Part(name, parent_name, tuple(round(float(v), 4) for v in piv), tuple(round(float(v), 5) for v in rot), []))
        for c in ch: walk(c, name, depth_root + 1)

    for r in g['scenes'][0]['nodes']: walk(r, None, 0)
    # cubos raiz sin grupo reciben pivote en el suelo (24) - ya cubierto arriba
    return gl, parts, cubes_info

def convert_auto(path, target=270.0):
    """Elige solo el factor de escala para que el modelo no pase de 'target' pixeles de ancho/largo."""
    gl, parts, cubes = convert(path)
    lo, hi = bbox(parts); d = hi - lo; mx = max(d[0], d[2]); k = min(1.0, target / mx)
    if k < 0.999: gl, parts, cubes = convert(path, k=k)
    return gl, parts, cubes, k

def build_atlas(gl, parts, cubes, out_png):
    size, pos = G.pack(parts)
    atlas = Image.new('RGBA', (size, size), (0, 0, 0, 0)); px = atlas.load()
    cache = {}
    def src(mi):
        if mi not in cache: cache[mi] = gl.material_image(mi)
        return cache[mi]
    FACEMAP = {'front': '-z', 'back': '+z', 'left': '+x', 'right': '-x', 'top': '+y', 'bottom': '-y'}
    for c in cubes:
        u0, v0 = pos[G.ckey(c)]; Nw, Nh, Nd = c['s']; info = c['src']; lo = info['lo']; S = info['S']
        rects = {'top': (u0 + Nd, v0, Nw, Nd), 'bottom': (u0 + Nd + Nw, v0, Nw, Nd), 'right': (u0, v0 + Nd, Nd, Nh),
                 'front': (u0 + Nd, v0 + Nd, Nw, Nh), 'left': (u0 + Nd + Nw, v0 + Nd, Nd, Nh), 'back': (u0 + 2 * Nd + Nw, v0 + Nd, Nw, Nh)}
        for face, (fx, fy, fw, fh) in rects.items():
            if fw <= 0 or fh <= 0: continue
            key = FACEMAP[face]
            if key not in info['faces']: continue
            pos4, uv4, mi = info['faces'][key]
            kind, data = src(mi)
            A = fit_affine(pos4, uv4)
            for j in range(fh):
                for i in range(fw):
                    s = (i + 0.5) / fw; t = (j + 0.5) / fh
                    x0, y0, z0 = lo; Sx, Sy, Sz = S
                    if face == 'front': p = (x0 + s * Sx, y0 + t * Sy, z0)
                    elif face == 'back': p = (x0 + (1 - s) * Sx, y0 + t * Sy, z0 + Sz)
                    elif face == 'left': p = (x0 + Sx, y0 + t * Sy, z0 + s * Sz)
                    elif face == 'right': p = (x0, y0 + t * Sy, z0 + (1 - s) * Sz)
                    elif face == 'top': p = (x0 + s * Sx, y0, z0 + (1 - t) * Sz)
                    else: p = (x0 + s * Sx, y0 + Sy, z0 + t * Sz)
                    pg = np.array([p[0] / 16, -p[1] / 16, p[2] / 16, 1.0])
                    uv = pg @ A
                    if kind == 'img':
                        W, H = data.size
                        xx = min(W - 1, max(0, int(uv[0] * W))); yy = min(H - 1, max(0, int(uv[1] * H)))
                        px[fx + i, fy + j] = data.getpixel((xx, yy))
                    else:
                        px[fx + i, fy + j] = data
    atlas.save(out_png)
    return size, pos

def bbox(parts):
    import preview as PV
    mat = PV.world(parts); lo = np.array([1e9] * 3); hi = np.array([-1e9] * 3)
    for p in parts:
        R, T = mat(p)
        for c in p.cubes:
            ox, oy, oz = c['o']; w, h, d = c['s']; dl = c['dil'] or (0, 0, 0)
            for x in (ox - dl[0], ox + w + dl[0]):
                for y in (oy - dl[1], oy + h + dl[1]):
                    for z in (oz - dl[2], oz + d + dl[2]):
                        v = R @ np.array([x, y, z]) + T; lo = np.minimum(lo, v); hi = np.maximum(hi, v)
    return lo, hi

if __name__ == '__main__':
    path = sys.argv[1]; out = sys.argv[2]
    gl, parts, cubes = convert(path)
    size, pos = build_atlas(gl, parts, cubes, out)
    lo, hi = bbox(parts)
    print('partes:', len(parts), 'cubos:', len(cubes), 'atlas:', size, 'bbox px:', np.round(lo, 1), np.round(hi, 1), 'en bloques (ancho,alto,largo):', np.round((hi - lo) / 16, 2))
