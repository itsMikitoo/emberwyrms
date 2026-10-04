"""Vista previa de siluetas (lateral / superior / frontal) de un modelo, sin necesitar Minecraft."""
import sys, os, math
import numpy as np
from PIL import Image, ImageDraw
sys.path.insert(0, os.path.dirname(__file__))
import generate as G

def rot(pitch, yaw, roll):
    cx, sx = math.cos(pitch), math.sin(pitch); cy, sy = math.cos(yaw), math.sin(yaw); cz, sz = math.cos(roll), math.sin(roll)
    Rx = np.array([[1, 0, 0], [0, cx, -sx], [0, sx, cx]]); Ry = np.array([[cy, 0, sy], [0, 1, 0], [-sy, 0, cy]])
    Rz = np.array([[cz, -sz, 0], [sz, cz, 0], [0, 0, 1]])
    return Rz @ Ry @ Rx

def world(parts):
    byname = {p.name: p for p in parts}; cache = {}
    def mat(p):
        if p.name in cache: return cache[p.name]
        R = rot(*p.rot); T = np.array(p.pivot, float)
        if p.parent is None: M = (R, T)
        else:
            Rp, Tp = mat(byname[p.parent]); M = (Rp @ R, Rp @ T + Tp)
        cache[p.name] = M; return M
    return mat

COL = {'scale': (90, 90, 100), 'membrane': (200, 90, 60), 'spike': (240, 200, 90), 'horn': (230, 220, 180), 'bone': (150, 150, 160),
       'eye': (255, 255, 0), 'teeth': (255, 255, 255), 'plate': (180, 150, 110), 'claw': (40, 40, 40), 'flame': (255, 120, 20),
       'crystal': (150, 220, 255)}

def render(parts, name):
    mat = world(parts); S = 6
    views = {'lado': (lambda v: (-v[2], v[1])), 'arriba': (lambda v: (v[0], -v[2])), 'frente': (lambda v: (v[0], v[1]))}
    W = 130 * S
    out = Image.new('RGB', (3 * W + 40, 60 * S + 20 * S), (28, 30, 38))
    for vi, (vn, proj) in enumerate(views.items()):
        img = Image.new('RGB', (W, 80 * S), (28, 30, 38)); d = ImageDraw.Draw(img)
        if vn != 'arriba': d.line([(0, (24 + 40 - 40) * S + 10 * S), (W, (24 + 40 - 40) * S + 10 * S)], fill=(80, 160, 80), width=2)
        for p in parts:
            R, T = mat(p)
            for c in p.cubes:
                ox, oy, oz = c['o']; w, h, dd = c['s']; dl = c['dil'] or (0, 0, 0)
                lo = np.array([ox - dl[0], oy - dl[1], oz - dl[2]]); hi = np.array([ox + w + dl[0], oy + h + dl[1], oz + dd + dl[2]])
                pts = [R @ np.array([x, y, z]) + T for x in (lo[0], hi[0]) for y in (lo[1], hi[1]) for z in (lo[2], hi[2])]
                xy = np.array([proj(q) for q in pts]); xy = xy[:, :]
                x0, x1, y0, y1 = xy[:, 0].min(), xy[:, 0].max(), xy[:, 1].min(), xy[:, 1].max()
                # casco convexo simple via bbox de los 8 puntos
                from itertools import combinations
                hull = convex(xy)
                col = COL.get(c['mat'], (120, 120, 130))
                d.polygon([(W / 2 + px * S, 50 * S + py * S) for px, py in hull], fill=col, outline=(15, 15, 15))
        out.paste(img, (vi * (W + 20), 0))
    out.crop((0, 0, out.width, 80 * S)).save('/tmp/prev_%s.png' % name)

def convex(pts):
    pts = sorted(set(map(tuple, np.round(pts, 3)))); 
    if len(pts) <= 2: return pts
    def cross(o, a, b): return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
    lo = []
    for p in pts:
        while len(lo) >= 2 and cross(lo[-2], lo[-1], p) <= 0: lo.pop()
        lo.append(p)
    up = []
    for p in reversed(pts):
        while len(up) >= 2 and cross(up[-2], up[-1], p) <= 0: up.pop()
        up.append(p)
    return lo[:-1] + up[:-1]

if __name__ == '__main__':
    which = sys.argv[1] if len(sys.argv) > 1 else 'ashwing'
    parts = G.ashwing() if which == 'ashwing' else G.elemental(which)
    render(parts, which)


# ---------------------------------------------------------------- vista 3D sombreada (para revisar modelos antes de entregarlos)
def render3d(parts, tex_png, out, yaw=-38, pitch=22, S=5.0, size=(900, 700), bg=(150, 170, 200)):
    import math
    from PIL import Image, ImageDraw
    pack_size, pos = G.pack(parts)
    tex = Image.open(tex_png).convert('RGBA'); mat = world(parts)
    ya, pa = math.radians(yaw), math.radians(pitch)
    Ry = np.array([[math.cos(ya), 0, math.sin(ya)], [0, 1, 0], [-math.sin(ya), 0, math.cos(ya)]])
    Rx = np.array([[1, 0, 0], [0, math.cos(pa), -math.sin(pa)], [0, math.sin(pa), math.cos(pa)]])
    V = Rx @ Ry
    light = np.array([-0.4, -0.8, -0.5]); light = light / np.linalg.norm(light)

    def avg(u, v, w, h):
        r = tex.crop((int(u), int(v), int(u + max(1, w)), int(v + max(1, h)))); px = [p for p in r.getdata() if p[3] > 20]
        if not px: return None
        return tuple(sum(p[i] for p in px) // len(px) for i in range(3))

    faces = []
    for p in parts:
        R, T = mat(p)
        for c in p.cubes:
            ox, oy, oz = c['o']; w, h, d = c['s']; dl = c['dil'] or (0, 0, 0)
            u, v = pos[G.ckey(c)]
            lo = np.array([ox - dl[0], oy - dl[1], oz - dl[2]], float); hi = np.array([ox + w + dl[0], oy + h + dl[1], oz + d + dl[2]], float)
            X0, Y0, Z0 = lo; X1, Y1, Z1 = hi
            defs = [((0, 0, -1), [(X0, Y0, Z0), (X1, Y0, Z0), (X1, Y1, Z0), (X0, Y1, Z0)], (u + d, v + d, w, h)),
                    ((0, 0, 1), [(X1, Y0, Z1), (X0, Y0, Z1), (X0, Y1, Z1), (X1, Y1, Z1)], (u + 2 * d + w, v + d, w, h)),
                    ((1, 0, 0), [(X1, Y0, Z0), (X1, Y0, Z1), (X1, Y1, Z1), (X1, Y1, Z0)], (u + d + w, v + d, d, h)),
                    ((-1, 0, 0), [(X0, Y0, Z1), (X0, Y0, Z0), (X0, Y1, Z0), (X0, Y1, Z1)], (u, v + d, d, h)),
                    ((0, -1, 0), [(X0, Y0, Z1), (X1, Y0, Z1), (X1, Y0, Z0), (X0, Y0, Z0)], (u + d, v, w, d)),
                    ((0, 1, 0), [(X0, Y1, Z0), (X1, Y1, Z0), (X1, Y1, Z1), (X0, Y1, Z1)], (u + d + w, v, w, d))]
            for n, corners, rect in defs:
                col = avg(*rect)
                if col is None: continue
                wn = V @ (R @ np.array(n, float))
                if wn[2] > 0.02: continue          # cara de espaldas a la camara
                pts = [V @ (R @ np.array(q, float) + T) for q in corners]
                depth = sum(q[2] for q in pts) / 4
                lit = 0.55 + 0.45 * max(0.0, float(np.dot(-wn, light)))
                faces.append((depth, [(size[0] / 2 + q[0] * S, size[1] * 0.62 + q[1] * S) for q in pts],
                              tuple(min(255, int(ch * lit)) for ch in col)))
    faces.sort(key=lambda f: -f[0])
    img = Image.new('RGB', size, bg); d = ImageDraw.Draw(img)
    d.rectangle([0, size[1] * 0.62 + 24 * S * 0.35, size[0], size[1]], fill=(120, 130, 110))
    for _, poly, col in faces: d.polygon(poly, fill=col, outline=tuple(int(c * 0.6) for c in col))
    img.save(out)


# ---------------------------------------------------------------- render 3D CON TEXTURAS (para comprobar la conversion y para las fotos del bestiario)
def render_tex(parts, atlas_png, out, yaw=-35, pitch=18, S=4.0, size=(900, 640), bg=(0, 0, 0, 0), center=None, pose=None):
    import math
    from PIL import Image, ImageDraw
    pack_size, pos = G.pack(parts)
    atlas = Image.open(atlas_png).convert('RGBA'); mat = world(parts)
    ya, pa = math.radians(yaw), math.radians(pitch)
    Ry = np.array([[math.cos(ya), 0, math.sin(ya)], [0, 1, 0], [-math.sin(ya), 0, math.cos(ya)]])
    Rx = np.array([[1, 0, 0], [0, math.cos(pa), -math.sin(pa)], [0, math.sin(pa), math.cos(pa)]])
    V = Rx @ Ry
    light = np.array([-0.4, -0.8, -0.5]); light = light / np.linalg.norm(light)
    faces = []
    allp = []
    for p in parts:
        R, T = mat(p)
        for c in p.cubes:
            ox, oy, oz = c['o']; w, h, d = c['s']; dl = c['dil'] or (0, 0, 0)
            u, v = pos[G.ckey(c)]
            x0, y0, z0 = ox - dl[0], oy - dl[1], oz - dl[2]; Sx, Sy, Sz = w + 2 * dl[0], h + 2 * dl[1], d + 2 * dl[2]
            def P(s, t, face):
                if face == 'front': q = (x0 + s * Sx, y0 + t * Sy, z0)
                elif face == 'back': q = (x0 + (1 - s) * Sx, y0 + t * Sy, z0 + Sz)
                elif face == 'left': q = (x0 + Sx, y0 + t * Sy, z0 + s * Sz)
                elif face == 'right': q = (x0, y0 + t * Sy, z0 + (1 - s) * Sz)
                elif face == 'top': q = (x0 + s * Sx, y0, z0 + (1 - t) * Sz)
                else: q = (x0 + s * Sx, y0 + Sy, z0 + t * Sz)
                return V @ (R @ np.array(q, float) + T)
            rects = {'top': (u + d, v, w, d, (0, -1, 0)), 'bottom': (u + d + w, v, w, d, (0, 1, 0)), 'right': (u, v + d, d, h, (-1, 0, 0)),
                     'front': (u + d, v + d, w, h, (0, 0, -1)), 'left': (u + d + w, v + d, d, h, (1, 0, 0)), 'back': (u + 2 * d + w, v + d, w, h, (0, 0, 1))}
            for face, (fx, fy, fw, fh, n) in rects.items():
                if fw <= 0 or fh <= 0: continue
                wn = V @ (R @ np.array(n, float))
                if wn[2] > 0.02: continue
                c00, c10, c01, c11 = P(0, 0, face), P(1, 0, face), P(0, 1, face), P(1, 1, face)
                faces.append(((c00[2] + c11[2]) / 2, face, (fx, fy, fw, fh), c00, c10, c01, c11, max(0.0, float(np.dot(-wn, light)))))
                allp += [c00, c10, c01, c11]
    allp = np.array(allp)
    if center is None: center = ((allp[:, 0].min() + allp[:, 0].max()) / 2, (allp[:, 1].min() + allp[:, 1].max()) / 2)
    ox_, oy_ = size[0] / 2 - center[0] * S, size[1] / 2 - center[1] * S
    img = Image.new('RGBA', size, bg)
    faces.sort(key=lambda f: -f[0])
    for depth, face, (fx, fy, fw, fh), c00, c10, c01, c11, lit in faces:
        scr = lambda q: (ox_ + q[0] * S, oy_ + q[1] * S)
        p00, p10, p01, p11 = scr(c00), scr(c10), scr(c01), scr(c11)
        xs = [p[0] for p in (p00, p10, p01, p11)]; ys = [p[1] for p in (p00, p10, p01, p11)]
        bx0, by0, bx1, by1 = int(min(xs)) - 1, int(min(ys)) - 1, int(max(xs)) + 2, int(max(ys)) + 2
        bw, bh = bx1 - bx0, by1 - by0
        if bw <= 0 or bh <= 0 or bw > 3000 or bh > 3000: continue
        a = np.array([[(p10[0] - p00[0]) / fw, (p01[0] - p00[0]) / fh], [(p10[1] - p00[1]) / fw, (p01[1] - p00[1]) / fh]])
        det = np.linalg.det(a)
        if abs(det) < 1e-9: continue
        inv = np.linalg.inv(a); off = np.array([p00[0] - bx0, p00[1] - by0])
        # entrada = inv @ (salida - off)
        coef = (inv[0, 0], inv[0, 1], -(inv[0] @ off), inv[1, 0], inv[1, 1], -(inv[1] @ off))
        tile = atlas.crop((fx, fy, fx + fw, fy + fh))
        warped = tile.transform((bw, bh), Image.AFFINE, coef, resample=Image.NEAREST)
        k = 0.55 + 0.45 * lit
        r, g_, b, al = warped.split()
        warped = Image.merge('RGBA', (r.point(lambda v: int(v * k)), g_.point(lambda v: int(v * k)), b.point(lambda v: int(v * k)), al))
        mask = Image.new('L', (bw, bh), 0)
        ImageDraw.Draw(mask).polygon([(p00[0] - bx0, p00[1] - by0), (p10[0] - bx0, p10[1] - by0), (p11[0] - bx0, p11[1] - by0), (p01[0] - bx0, p01[1] - by0)], fill=255)
        am = warped.split()[3]
        from PIL import ImageChops
        mask = ImageChops.multiply(mask, am.point(lambda v: 255 if v > 20 else 0))
        img.paste(warped, (bx0, by0), mask)
    img.save(out)
    return img
