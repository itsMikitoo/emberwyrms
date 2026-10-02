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
