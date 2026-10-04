"""Conversor Blockbench-glTF -> modelo del mod (ModelPart) con atlas de textura reempaquetado.
Geometria: cada nodo del glTF pasa a ser una pieza (grupo = hueso, malla = cubo). Las texturas se re-muestrean cara por cara
al diseño estandar de 'box UV' del juego, asi que funciona aunque el autor usara UV libres."""
import math, os, json
import numpy as np
from PIL import Image
import gltf_import as GI

B = np.diag([-1.0, -1.0, 1.0])            # glTF/Blockbench (y arriba) -> espacio de ModelPart (y abajo): giro de 180 grados sobre z

def euler_zyx(R):
    """R = Rz(roll) Ry(yaw) Rx(pitch)  ->  (pitch, yaw, roll)"""
    sy = -R[2, 0]
    yaw = math.asin(max(-1.0, min(1.0, sy)))
    if abs(sy) < 0.99999:
        pitch = math.atan2(R[2, 1], R[2, 2]); roll = math.atan2(R[1, 0], R[0, 0])
    else:
        pitch = math.atan2(-R[1, 2], R[1, 1]); roll = 0.0
    return pitch, yaw, roll

def rot_y(deg):
    a = math.radians(deg); c, s = math.cos(a), math.sin(a)
    return np.array([[c, 0, s], [0, 1, 0], [-s, 0, c]])

class Part:
    def __init__(s, name, parent, pivot, rot, cube=None):
        s.name, s.parent, s.pivot, s.rot, s.cube = name, parent, pivot, rot, cube
        s.gname = name; s.index = -1; s.children = []

def safe(n): 
    return ''.join(ch if ch.isalnum() else '_' for ch in (n or 'x'))

class Converted:
    pass

def convert(path, f=1.0, pre_yaw=0.0, atlas_max=2048, split=None):
    g, data, imgs = GI.load(path)
    ms = GI.meshes_of(g, data)
    nodes = g['nodes']; Rpre = rot_y(pre_yaw)
    parts = []; by_node = {}
    # ---- jerarquia
    def build(i, parent, depth):
        n = nodes[i]; t, q, s_ = GI.node_trs(n); R = GI.quat_to_mat(q)
        if depth == 0: R = Rpre @ R; t = Rpre @ t
        p = Part('n%d_%s' % (len(parts), safe(n.get('name'))), parent, None, None)
        p.gname = n.get('name') or ''; p.R_bb = R; p.t_bb = t; p.node = i; p.depth = depth
        parts.append(p); by_node[i] = p
        if parent is not None: parent.children.append(p)
        if 'mesh' in n:
            p.mesh = ms[n['mesh']]
        for c in n.get('children', []): build(c, p, depth + 1)
    for r in g['scenes'][0]['nodes']: build(r, None, 0)
    # ---- mundo (BB) para y_min y para el empaquetado de cubos
    def world(p, Rp, tp):
        p.Rw = Rp @ p.R_bb; p.tw = tp + Rp @ p.t_bb
        for c in p.children: world(c, p.Rw, p.tw)
    for p in parts:
        if p.parent is None: world(p, np.eye(3), np.zeros(3))
    ymin = 1e9
    for p in parts:
        if hasattr(p, 'mesh'):
            pos = p.mesh[0][0]; w = pos @ p.Rw.T + p.tw
            ymin = min(ymin, w[:, 1].min())
    p0 = [p for p in parts if p.parent is None]
    # ---- transformacion a espacio de ModelPart
    for p in parts:
        Rm = B @ p.R_bb @ B
        p.rot = euler_zyx(Rm)
        rel = B @ p.t_bb * 16 * f
        if p.parent is None: rel = rel + np.array([0, 24 - (-16 * f * ymin) * -1 * 0, 0])
        p.pivot = rel
        if p.parent is None:                       # el suelo del modelo (y_min) a y=24
            p.pivot = np.array([-16 * f * p.t_bb[0], 24 - 16 * f * (p.t_bb[1] - ymin), 16 * f * p.t_bb[2]])
    # ---- cubos
    cubes = []
    for p in parts:
        if not hasattr(p, 'mesh'): continue
        pos, uv, idx, mat = p.mesh[0]
        mn, mx = pos.min(0), pos.max(0)
        ext = (mx - mn) * 16 * f
        # offsets en mp (relativos al pivote): x: [-16f*max_x, -16f*min_x], y igual, z: [16f*min_z, 16f*max_z]
        off = np.array([-16 * f * mx[0], -16 * f * mx[1], 16 * f * mn[2]])
        sz = [max(1, int(round(e))) for e in ext]
        dil = tuple(float((e - s) / 2.0) for e, s in zip(ext, sz))
        c = dict(part=p, off=off, ext=ext, sz=sz, dil=dil, pos=pos, uv=uv, idx=idx, mat=mat, mn=mn, mx=mx)
        p.cube = c; cubes.append(c)
    # ---- atlas: un rectangulo desplegado por cubo
    rects = []
    for c in cubes:
        w, h, d = c['sz']; c['W'] = 2 * (d + w); c['H'] = d + h
        rects.append(c)
    area = sum(c['W'] * c['H'] for c in cubes)
    size = 32
    while size < atlas_max:
        if pack(rects, size): break
        size *= 2
    else:
        raise SystemExit('atlas demasiado grande: %d' % area)
    atlas = Image.new('RGBA', (size, size), (0, 0, 0, 0)); A = atlas.load()
    mats = g['materials']; textures = g.get('textures', [])
    for c in cubes:
        paint_cube(c, atlas, A, imgs, mats, textures, g)
    cv = Converted(); cv.parts = parts; cv.cubes = cubes; cv.atlas = atlas; cv.size = size; cv.f = f
    cv.ymin = ymin; cv.g = g
    return cv

def pack(rects, size):
    order = sorted(rects, key=lambda c: (-c['H'], -c['W']))
    x = y = rowh = 0
    for c in order:
        if c['W'] > size: return False
        if x + c['W'] > size: x, y, rowh = 0, y + rowh, 0
        if y + c['H'] > size: return False
        c['u'], c['v'] = x, y; x += c['W']; rowh = max(rowh, c['H'])
    return True

# caras: (id, eje_normal, signo, vector_derecha, vector_arriba_de_imagen)
AX = {'x': np.array([1.0, 0, 0]), 'y': np.array([0, 1.0, 0]), 'z': np.array([0, 0, 1.0])}
FACES = {
    'front':  ('z', -1, -AX['x'], AX['y']),
    'back':   ('z', +1, +AX['x'], AX['y']),
    'right':  ('x', +1, -AX['z'], AX['y']),
    'left':   ('x', -1, +AX['z'], AX['y']),
    'top':    ('y', +1, -AX['x'], AX['z']),
    'bottom': ('y', -1, -AX['x'], AX['z']),
}

def face_groups(c):
    """4 vertices por cara del glTF -> [(posiciones 4x3, uvs 4x2)]"""
    pos, uv, idx = c['pos'], c['uv'], c['idx']
    out = []
    for k in range(0, len(idx) - 5, 6):
        v = list(dict.fromkeys(idx[k:k + 6].tolist()))
        if len(v) == 4: out.append((pos[v], uv[v]))
    if not out and len(pos) == 4: out.append((pos, uv))
    return out

def material_info(c, mats, textures, g, imgs):
    m = mats[c['mat']] if c['mat'] < len(mats) else {}
    pbr = m.get('pbrMetallicRoughness', {})
    bct = pbr.get('baseColorTexture'); fac = pbr.get('baseColorFactor', [1, 1, 1, 1])
    if bct is not None:
        img = imgs[textures[bct['index']]['source']]
        return img, np.array(fac)
    return None, np.array(fac)

def paint_cube(c, atlas, A, imgs, mats, textures, g):
    img, fac = material_info(c, mats, textures, g, imgs)
    arr = np.array(img) if img is not None else None
    w, h, d = c['sz']; u0, v0 = c['u'], c['v']
    regions = {'top': (u0 + d, v0, w, d), 'bottom': (u0 + d + w, v0, w, d), 'right': (u0, v0 + d, d, h),
               'front': (u0 + d, v0 + d, w, h), 'left': (u0 + d + w, v0 + d, d, h), 'back': (u0 + 2 * d + w, v0 + d, w, h)}
    groups = face_groups(c)
    mn, mx = c['mn'], c['mx']; ctr = (mn + mx) / 2
    flat = [(a, (p[:, a].max() - p[:, a].min()) < 1e-7) for p, _ in groups for a in range(3)]
    for fname, (ax, sign, e_r, e_u) in FACES.items():
        ai = 'xyz'.index(ax)
        # buscar el grupo cuyo plano corresponde a esta cara
        best = None
        if c.get('tags') and len(groups) == len(c['tags']):
            best = groups[c['tags'].index(fname)]
        for p, uvv in ([] if best is not None else groups):
            if (p[:, ai].max() - p[:, ai].min()) < 1e-7:
                side = np.sign(p[0, ai] - ctr[ai]) if abs(mx[ai] - mn[ai]) > 1e-7 else 0
                if side == sign or side == 0: best = (p, uvv); break
        if best is None and not c.get('tags'):
            # plano de grosor cero: cualquier grupo plano en este eje vale para ambas caras
            for p, uvv in groups:
                if (p[:, ai].max() - p[:, ai].min()) < 1e-7: best = (p, uvv); break
        rw, rh, rx, ry = regions[fname][2], regions[fname][3], regions[fname][0], regions[fname][1]
        if best is None or rw <= 0 or rh <= 0:
            continue
        p, uvv = best
        r_axis = int(np.argmax(np.abs(e_r))); u_axis = int(np.argmax(np.abs(e_u)))
        r_min = (p[:, r_axis] * e_r[r_axis]).min(); u_min = (p[:, u_axis] * e_u[u_axis]).min()
        rc = p[:, r_axis] * e_r[r_axis] - r_min; uc = p[:, u_axis] * e_u[u_axis] - u_min
        ext_r = max(rc.max(), 1e-9); ext_u = max(uc.max(), 1e-9)
        M, *_ = np.linalg.lstsq(np.stack([rc, uc, np.ones(len(rc))], 1), uvv, rcond=None)
        ss = 3
        gi, gj = np.meshgrid((np.arange(rw * ss) + 0.5) / (rw * ss), (np.arange(rh * ss) + 0.5) / (rh * ss))
        rcoord = gi * ext_r; ucoord = (1 - gj) * ext_u
        UV = np.stack([rcoord, ucoord, np.ones_like(rcoord)], -1) @ M
        if arr is not None:
            H, W = arr.shape[:2]
            px = np.clip((UV[..., 0] * W).astype(int), 0, W - 1); py = np.clip((UV[..., 1] * H).astype(int), 0, H - 1)
            samp = arr[py, px].astype(float)
        else:
            samp = np.tile((fac * 255).reshape(1, 1, 4), (rh * ss, rw * ss, 1))
        samp[..., :3] *= samp[..., 3:4] / 255.0           # promedio con alpha premultiplicado
        samp = samp.reshape(rh, ss, rw, ss, 4).mean(axis=(1, 3))
        a = samp[..., 3:4]
        rgb = np.where(a > 1e-6, samp[..., :3] / np.maximum(a / 255.0, 1e-6), 0)
        out = np.concatenate([np.clip(rgb, 0, 255), np.where(a > 127, 255.0, 0.0)], -1).astype(np.uint8)
        atlas.paste(Image.fromarray(out, 'RGBA'), (rx, ry))


# ====================================================================== operaciones de esqueleto (antes de pasar a espacio mp)
def find(parts, gname, under=None):
    for p in parts:
        if p.gname == gname:
            if under is None: return p
            q = p
            while q is not None:
                if q is under: return p
                q = q.parent
    raise KeyError(gname)

def reparent(cv_parts, child, new_parent):
    """Cambia el padre de un nodo conservando su posicion en el mundo (todo en espacio glTF/BB)."""
    if child.parent is not None: child.parent.children.remove(child)
    child.parent = new_parent; new_parent.children.append(child)
    child.R_bb = new_parent.Rw.T @ child.Rw
    child.t_bb = new_parent.Rw.T @ (child.tw - new_parent.tw)

def slice_chain(parts, group, n, axis, reverse=False):
    """Parte los cubos de un grupo en n tramos a lo largo de un eje y los encadena como huesos (para ondular colas/serpientes)."""
    ai = 'xyz'.index(axis)
    cubes = [c for c in group.children if hasattr(c, 'mesh')]
    cz = {c: (c.tw[ai]) for c in cubes}
    lo, hi = min(cz.values()), max(cz.values())
    order = sorted(cubes, key=lambda c: cz[c], reverse=reverse)
    chain = []
    prev = group
    for k in range(n):
        a = lo + (hi - lo) * (k / n) if not reverse else hi - (hi - lo) * (k / n)
        piv_w = group.tw.copy(); piv_w[ai] = a
        p = Part('slice%d_%s' % (len(parts), safe(group.gname)), prev, None, None)
        p.gname = '%s_s%d' % (group.gname, k); p.depth = prev.depth + 1
        p.Rw = group.Rw.copy(); p.tw = piv_w
        p.R_bb = prev.Rw.T @ p.Rw; p.t_bb = prev.Rw.T @ (p.tw - prev.tw)
        prev.children.append(p); parts.append(p); chain.append(p); prev = p
    for c in cubes:
        k = min(n - 1, int((cz[c] - lo) / max(hi - lo, 1e-9) * n)) if not reverse else min(n - 1, int((hi - cz[c]) / max(hi - lo, 1e-9) * n))
        reparent(parts, c, chain[k])
    return chain

def convert2(path, f=1.0, pre_yaw=0.0, atlas_max=2048, ops=None):
    """Igual que convert() pero permite ops=[('reparent', hijo, padre), ('slice', grupo, n, eje[, reverse])] entre el mundo BB y el paso a mp."""
    import types
    cv = _convert_stage1(path, f, pre_yaw)
    for op in (ops or []):
        if op[0] == 'reparent': reparent(cv.parts, find(cv.parts, op[1]), find(cv.parts, op[2]))
        elif op[0] == 'slice': cv.chains = getattr(cv, 'chains', {}); cv.chains[op[1]] = slice_chain(cv.parts, find(cv.parts, op[1]), op[2], op[3], op[4] if len(op) > 4 else False)
    return _convert_stage2(cv, atlas_max)

def _convert_stage1(path, f, pre_yaw):
    g, data, imgs = GI.load(path)
    ms = GI.meshes_of(g, data); nodes = g['nodes']; Rpre = rot_y(pre_yaw)
    parts = []
    def build(i, parent, depth):
        n = nodes[i]; t, q, s_ = GI.node_trs(n); R = GI.quat_to_mat(q)
        if depth == 0: R = Rpre @ R; t = Rpre @ t
        p = Part('n%d_%s' % (len(parts), safe(n.get('name'))), parent, None, None)
        p.gname = n.get('name') or ''; p.R_bb = R; p.t_bb = t; p.depth = depth
        parts.append(p)
        if parent is not None: parent.children.append(p)
        if 'mesh' in n: p.mesh = ms[n['mesh']]
        for c in n.get('children', []): build(c, p, depth + 1)
    for r in g['scenes'][0]['nodes']: build(r, None, 0)
    def world(p, Rp, tp):
        p.Rw = Rp @ p.R_bb; p.tw = tp + Rp @ p.t_bb
        for c in p.children: world(c, p.Rw, p.tw)
    for p in parts:
        if p.parent is None: world(p, np.eye(3), np.zeros(3))
    cv = Converted(); cv.parts = parts; cv.g = g; cv.imgs = imgs; cv.f = f
    return cv

def _convert_stage2(cv, atlas_max):
    parts, g, imgs, f = cv.parts, cv.g, cv.imgs, cv.f
    # recalcular mundo tras las operaciones
    def world(p, Rp, tp):
        p.Rw = Rp @ p.R_bb; p.tw = tp + Rp @ p.t_bb
        for c in p.children: world(c, p.Rw, p.tw)
    roots = [p for p in parts if p.parent is None]
    for r in roots: world(r, np.eye(3), np.zeros(3))
    ymin = 1e9
    for p in parts:
        if hasattr(p, 'mesh'):
            pos = p.mesh[0][0]; ymin = min(ymin, (pos @ p.Rw.T + p.tw)[:, 1].min())
    for p in parts:
        p.rot = euler_zyx(B @ p.R_bb @ B)
        if p.parent is None: p.pivot = np.array([-16 * f * p.t_bb[0], 24 - 16 * f * (p.t_bb[1] - ymin), 16 * f * p.t_bb[2]])
        else: p.pivot = B @ p.t_bb * 16 * f
        p.cube = None
    cubes = []
    for p in parts:
        if not hasattr(p, 'mesh'): continue
        pos, uv, idx, mat = p.mesh[0]
        mn, mx = pos.min(0), pos.max(0); ext = (mx - mn) * 16 * f
        off = np.array([-16 * f * mx[0], -16 * f * mx[1], 16 * f * mn[2]])
        sz = [max(1, int(round(e))) for e in ext]
        dil = tuple(float((e - s) / 2.0) for e, s in zip(ext, sz))
        c = dict(part=p, off=off, ext=ext, sz=sz, dil=dil, pos=pos, uv=uv, idx=idx, mat=mat, mn=mn, mx=mx, tags=getattr(p, 'tags', None))
        p.cube = c; cubes.append(c)
    for c in cubes:
        w, h, d = c['sz']; c['W'] = 2 * (d + w); c['H'] = d + h
    size = 32
    while size <= atlas_max:
        if pack(cubes, size): break
        size *= 2
    else:
        raise SystemExit('atlas demasiado grande')
    atlas = Image.new('RGBA', (size, size), (0, 0, 0, 0)); A = atlas.load()
    for c in cubes: paint_cube(c, atlas, A, imgs, g['materials'], g.get('textures', []), g)
    cv.cubes = cubes; cv.atlas = atlas; cv.size = size; cv.ymin = ymin
    return cv


# ====================================================================== lector de geometria Bedrock (Blockbench)
def _rot_scene(rot):
    """Rotacion Bedrock (grados x,y,z) -> matriz del espacio de la escena. Convenio comprobado contra el glTF del mismo modelo:
    orden ZYX con los signos (-rx, -ry, +rz)."""
    if not rot: return np.eye(3)
    rx, ry, rz = math.radians(-rot[0]), math.radians(-rot[1]), math.radians(rot[2])
    cx, sx = math.cos(rx), math.sin(rx); cy, sy = math.cos(ry), math.sin(ry); cz, sz = math.cos(rz), math.sin(rz)
    Rx = np.array([[1, 0, 0], [0, cx, -sx], [0, sx, cx]]); Ry = np.array([[cy, 0, sy], [0, 1, 0], [-sy, 0, cy]])
    Rz = np.array([[cz, -sz, 0], [sz, cz, 0], [0, 0, 1]])
    return Rz @ Ry @ Rx

def _box_mesh(origin, size, inflate, pivot_scene, uv, mirror, TW, TH, uvdict=None):
    """Cubo Bedrock (en escena, relativo a su pivote) -> malla de 24 vertices con UV estandar de 'box UV'."""
    ox, oy, oz = origin; sx, sy, sz = size; inf = inflate or 0.0
    lo = np.array([-(ox + sx) - inf, oy - inf, oz - inf]) - pivot_scene
    hi = np.array([-ox + inf, oy + sy + inf, oz + sz + inf]) - pivot_scene
    w, h, d = sx, sy, sz
    u0, v0 = (uv if not isinstance(uv, dict) else (0, 0))
    reg = {'top': (u0 + d, v0, w, d), 'bottom': (u0 + d + w, v0, w, d), 'right': (u0, v0 + d, d, h),
           'front': (u0 + d, v0 + d, w, h), 'left': (u0 + d + w, v0 + d, d, h), 'back': (u0 + 2 * d + w, v0 + d, w, h)}
    if mirror:
        reg['right'], reg['left'] = reg['left'], reg['right']
    if isinstance(uv, dict):                       # uv por cara (nombres Bedrock; x invertida respecto a la escena)
        m = {'north': 'front', 'south': 'back', 'up': 'top', 'down': 'bottom', 'east': 'left', 'west': 'right'}
        for k, val in uv.items():
            if k in m and isinstance(val, dict) and 'uv' in val:
                us = val.get('uv_size', [0, 0]); reg[m[k]] = (val['uv'][0], val['uv'][1], abs(us[0]) or 1, abs(us[1]) or 1)
    pos, uvs, idx = [], [], []
    for fname, (ax, sign, e_r, e_u) in FACES.items():
        rx, ry, rw, rh = reg[fname]
        ai = 'xyz'.index(ax)
        r_axis = int(np.argmax(np.abs(e_r))); u_axis = int(np.argmax(np.abs(e_u)))
        base = len(pos)
        for rr, uu in ((0, 0), (1, 0), (0, 1), (1, 1)):
            P = np.zeros(3)
            P[ai] = hi[ai] if sign > 0 else lo[ai]
            rc = (rr if e_r[r_axis] > 0 else 1 - rr); P[r_axis] = lo[r_axis] + rc * (hi[r_axis] - lo[r_axis])
            uc = (uu if e_u[u_axis] > 0 else 1 - uu); P[u_axis] = lo[u_axis] + uc * (hi[u_axis] - lo[u_axis])
            rrr = (1 - rr) if mirror else rr
            pos.append(P); uvs.append(((rx + rrr * rw) / TW, (ry + (1 - uu) * rh) / TH))
        idx += [base, base + 1, base + 2, base + 2, base + 1, base + 3]
    return np.array(pos), np.array(uvs), np.array(idx)

def convert_bedrock(geo_path, tex_path, f=1.0, atlas_max=2048, ops=None):
    geo = json.load(open(geo_path)); G = geo['minecraft:geometry'][0]
    TW, TH = G['description']['texture_width'], G['description']['texture_height']
    tex = Image.open(tex_path).convert('RGBA')
    bones = G['bones']; by = {b['name']: b for b in bones}
    parts, node_of = [], {}
    cvg = {'materials': [{'pbrMetallicRoughness': {'baseColorTexture': {'index': 0}}}], 'textures': [{'source': 0}]}
    def piv(b): return np.array([-b.get('pivot', [0, 0, 0])[0], b.get('pivot', [0, 0, 0])[1], b.get('pivot', [0, 0, 0])[2]], float)
    def make(b):
        if b['name'] in node_of: return node_of[b['name']]
        parent = make(by[b['parent']]) if b.get('parent') in by else None
        p = Part('b%d_%s' % (len(parts), safe(b['name'])), parent, None, None)
        p.gname = b['name']; p.depth = 0 if parent is None else parent.depth + 1
        p.R_bb = _rot_scene(b.get('rotation'))
        p.t_bb = (piv(b) - (piv(by[b['parent']]) if parent is not None else 0)) / 16.0
        parts.append(p); node_of[b['name']] = p
        if parent is not None: parent.children.append(p)
        p.piv_scene = piv(b)
        return p
    for b in bones: make(b)
    for b in bones:
        pb = node_of[b['name']]
        for ci, c in enumerate(b.get('cubes', [])):
            cp = np.array([-c['pivot'][0], c['pivot'][1], c['pivot'][2]], float) if 'pivot' in c else pb.piv_scene
            q = Part('c%d_%s' % (len(parts), safe(b['name'])), pb, None, None)
            q.gname = b['name'] + '_cube'; q.depth = pb.depth + 1
            q.R_bb = _rot_scene(c.get('rotation')) if 'rotation' in c else np.eye(3)
            q.t_bb = (cp - pb.piv_scene) / 16.0
            pos, uvs, idx = _box_mesh(c['origin'], c['size'], c.get('inflate'), cp, c['uv'], c.get('mirror', b.get('mirror', False)), TW, TH)
            q.mesh = [(pos / 16.0, uvs, idx, 0)]
            q.tags = list(FACES.keys())
            parts.append(q); pb.children.append(q)
    cv = Converted(); cv.parts = parts; cv.g = cvg; cv.imgs = [tex]; cv.f = f
    def world(p, Rp, tp):
        p.Rw = Rp @ p.R_bb; p.tw = tp + Rp @ p.t_bb
        for c in p.children: world(c, p.Rw, p.tw)
    for p in parts:
        if p.parent is None: world(p, np.eye(3), np.zeros(3))
    for op in (ops or []):
        if op[0] == 'reparent': reparent(parts, find(parts, op[1]), find(parts, op[2]))
        elif op[0] == 'slice': cv.chains = getattr(cv, 'chains', {}); cv.chains[op[1]] = slice_chain(parts, find(parts, op[1]), op[2], op[3], op[4] if len(op) > 4 else False)
    return _convert_stage2(cv, atlas_max)
