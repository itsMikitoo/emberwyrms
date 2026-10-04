#!/usr/bin/env python3
"""Generador de modelos (Java) + texturas (PNG) de Emberwyrms.
Una sola fuente de verdad: las piezas se definen aqui, el UV se empaqueta
automaticamente y la textura se pinta con exactamente ese UV.
Uso:  python3 tools/generate.py      (desde la raiz del proyecto)"""
import os, zlib, math, random
from PIL import Image, ImageDraw

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
JAVA = os.path.join(ROOT, 'src/main/java/io/emberwyrms/client')
TEX = os.path.join(ROOT, 'src/main/resources/assets/emberwyrms/textures')
os.makedirs(JAVA, exist_ok=True); os.makedirs(TEX + '/entity', exist_ok=True); os.makedirs(TEX + '/item', exist_ok=True)

# ------------------------------------------------------------------ modelo
class Part:
    def __init__(s, name, parent, pivot=(0, 0, 0), rot=(0, 0, 0), cubes=()):
        s.name, s.parent, s.pivot, s.rot, s.cubes = name, parent, pivot, rot, list(cubes)

def C(ox, oy, oz, w, h, d, mat, f=None, dil=None):
    return dict(o=(ox, oy, oz), s=(w, h, d), mat=mat, f=tuple(sorted((f or {}).items())), dil=dil)

def jname(n):
    p = n.split('_'); return p[0] + ''.join(x.capitalize() for x in p[1:])

def fm(v):
    t = ('%.4f' % v).rstrip('0').rstrip('.')
    if t in ('-0', ''): t = '0'
    return t + 'f'

def ckey(c): return (c['s'], c['mat'], c['f'], c['dil'])

def pack(parts):
    keys = []
    for p in parts:
        for c in p.cubes:
            if ckey(c) not in keys: keys.append(ckey(c))
    def fp(k): w, h, d = k[0]; return 2 * (d + w), d + h
    order = sorted(keys, key=lambda k: (-fp(k)[1], -fp(k)[0]))
    for size in (64, 128, 256, 512, 1024):
        x = y = rowh = 0; pos = {}; ok = True
        for k in order:
            W, H = fp(k)
            if x + W > size: x, y, rowh = 0, y + rowh, 0
            if y + H > size or W > size: ok = False; break
            pos[k] = (x, y); x += W; rowh = max(rowh, H)
        if ok: return size, pos
    raise SystemExit('no cabe la textura')

# ------------------------------------------------------------------ pintura
def shade(c, k): return tuple(max(0, min(255, int(v * k))) for v in c)
def mix(a, b, t): return tuple(int(a[i] * (1 - t) + b[i] * t) for i in range(3))


def _h(ix, iy, seed):
    v = (ix * 374761393 + iy * 668265263 + seed * 144665) & 0xffffffff
    v = ((v ^ (v >> 13)) * 1274126177) & 0xffffffff
    return ((v ^ (v >> 16)) & 0xffff) / 65535.0

def vnoise(x, y, sc, seed):
    gx, gy = x / sc, y / sc; ix, iy = math.floor(gx), math.floor(gy); fx, fy = gx - ix, gy - iy
    a, b, c, d = _h(ix, iy, seed), _h(ix + 1, iy, seed), _h(ix, iy + 1, seed), _h(ix + 1, iy + 1, seed)
    fx = fx * fx * (3 - 2 * fx); fy = fy * fy * (3 - 2 * fy)
    return a * (1 - fx) * (1 - fy) + b * fx * (1 - fy) + c * (1 - fx) * fy + d * fx * fy

SIDES = ('front', 'back', 'left', 'right')

def voronoi(x, y, size, seed):
    gx, gy = x / size, y / size
    ix, iy = math.floor(gx), math.floor(gy)
    d1 = d2 = 9.0; best = (0, 0, 0.0, 0.0)
    for dy in (-1, 0, 1):
        for dx in (-1, 0, 1):
            cx, cy = ix + dx, iy + dy
            px_ = cx + 0.15 + 0.7 * _h(cx, cy, seed * 7 + 1); py_ = cy + 0.15 + 0.7 * _h(cx, cy, seed * 7 + 2)
            d = math.hypot(gx - px_, gy - py_)
            if d < d1: d2 = d1; d1 = d; best = (cx, cy, gx - px_, gy - py_)
            elif d < d2: d2 = d
    return d1, d2, (best[0], best[1]), best[2], best[3]

def pixel(mat, i, j, w, h, face, pal, rng, seed):
    base = pal.get(mat, (0, 0, 0)); n = rng.uniform(-0.05, 0.05)
    if mat == 'scale':
        belly = pal.get('belly', base)
        size = pal.get('scale_size', 3.3)
        t = j / max(1, h - 1)
        if face in SIDES: c = mix(base, belly, (t ** 1.7) * 0.92)
        elif face == 'top': c = shade(base, 0.86)
        else: c = belly
        c = shade(c, 0.84 + 0.3 * vnoise(i + seed * 3, j, 9, seed))
        d1, d2, cid, ox_, oy_ = voronoi(i + 0.5 + seed * 5.3, j + 0.5 + seed * 2.1, size, seed)
        groove = min(1.0, max(0.0, (d2 - d1) / 0.30))
        dome = max(0.0, 1.0 - d1 / 0.8)
        light = min(1.3, max(0.72, 1.0 + 0.6 * (-(ox_ + oy_)) * dome))
        cellv = 0.88 + 0.24 * _h(cid[0], cid[1], seed + 5)
        c = shade(c, cellv * (0.55 + 0.45 * groove) * light + n)
        if 'ember' in pal and groove < 0.5 and _h(cid[0], cid[1], seed + 11) > 0.93: c = mix(c, pal['ember'], 0.6)
        style, mk = pal.get('mark_style'), pal.get('mark')
        if style == 'cracks' and mk and abs(vnoise(i, j, 6, seed + 3) - 0.5) < 0.04: c = mix(c, mk, 0.92)
        if style and face in SIDES and mk:
            if style == 'stripe':
                if ((i + int(3 * vnoise(j, 3, 6, seed))) % 9) in (0, 1) and j < h * 0.75: c = mix(c, mk, 0.5)
            elif style == 'streak':
                if (i + 2 * j + seed) % 13 == 0 and vnoise(i, j, 5, seed + 9) > 0.35: c = mix(c, mk, 0.85)
            elif style == 'frost':
                if vnoise(i, j, 6, seed + 4) > 0.66: c = mix(c, mk, 0.5)
            elif style == 'spots':
                if vnoise(i, j, 3, seed + 7) > 0.76: c = mix(c, mk, 0.6)
        return c
    if mat == 'plate':
        c = shade(base, 0.97 + n + 0.1 * vnoise(i, j, 4, seed))
        if j % 3 == 2: c = shade(c, 0.8)
        elif i % 7 == 0: c = shade(c, 0.93)
        return c
    if mat == 'horn':
        t = j / max(1, h - 1)
        c = mix(base, shade(base, 0.42), (t ** 1.3) * 0.9)
        ridge = 0.78 + 0.44 * (0.5 + 0.5 * math.sin(i * 1.9 + vnoise(i, j, 3, seed) * 4))
        c = shade(c, ridge * (0.92 + 0.16 * vnoise(i, j, 4, seed)))
        return shade(c, 0.75) if j % 5 == 0 else c
    if mat == 'membrane':
        c = shade(base, 0.74 + 0.5 * vnoise(i, j, 7, seed) + n)
        if abs(vnoise(i, j, 4, seed + 2) - 0.5) < 0.05: c = shade(c, 0.5)
        if abs(vnoise(i * 0.4, j, 9, seed + 5) - 0.5) < 0.03: c = shade(c, 0.6)
        if 'ember' in pal and vnoise(i, j, 5, seed + 8) > 0.8: c = mix(c, pal['ember'], 0.14)
        return c
    if mat == 'teeth':
        t = j / max(1, h - 1)
        return mix(shade(base, 0.62), shade(base, 1.08), 1 - t) if h > 1 else base
    if mat == 'claw':
        t = j / max(1, h - 1)
        return shade(base, 1.35 - 0.8 * t + n) if h > 1 else shade(base, 1 + n)
    if mat in ('bone', 'beak', 'leg', 'gold', 'skin'):
        c = shade(base, 1 + n)
        return shade(c, 0.85) if (mat == 'gold' and (i + j) % 4 == 0) else c
    if mat == 'spike':
        return shade(base, 1.15 - 0.5 * j / max(1, h - 1) + n)
    if mat == 'eye':
        if w >= 2 and i == w // 2: return shade(base, 0.12)
        return base
    if mat == 'mouth':
        return shade(base, 0.85 + 0.3 * vnoise(i, j, 3, seed))
    if mat == 'crystal':
        facet = (i * 3 + j * 2) % 5
        return shade(base, 0.82 + facet * 0.08 + n)
    if mat == 'feather':
        t = (i + j) / max(1, w + h); c = mix(pal['f_a'], pal['f_b'], t)
        c = shade(c, 0.78 + 0.45 * rng.random())
        return mix(c, pal['f_c'], 0.45) if rng.random() < 0.07 else c
    if mat == 'feather_tail':
        t = (i + j) / max(1, w + h)
        c = mix(pal['f_a'], pal['f_b'], t * 2) if t < .5 else mix(pal['f_b'], pal['f_c'], (t - .5) * 2)
        return shade(c, 0.9 + n) if i % 2 == 0 else shade(c, 1.05 + n)
    if mat == 'flame':
        t = (i * 0.5 + j) / max(1, w * 0.5 + h); return shade(mix(pal['f_c'], pal['f_a'], t), 1 + n * 2)
    if mat == 'snake_head':
        c = shade(pal['snake'], 1.1 + n)
        if face == 'front':
            if j == 0 and i in (0, w - 1): return pal['eye']
            if j >= 1 and 0 < i < w - 1: return (168, 40, 44)
            if j >= 1: return shade(c, 0.7)
        if face == 'bottom': return (150, 36, 40)
        return c
    if mat == 'hair':
        c = shade(base, 0.7 + 0.5 * vnoise(i * 0.6, j, 6, seed) + n)
        return shade(c, 1.35) if vnoise(i * 2.2, j * 0.4, 3, seed + 1) > 0.72 else c
    if mat == 'snake':
        d1, d2, cid, ox_, oy_ = voronoi(i + 0.5 + seed * 3.1, j + 0.5 + seed * 1.7, 2.2, seed)
        g = min(1.0, max(0.0, (d2 - d1) / 0.3))
        c = shade(base, (0.85 + 0.3 * _h(cid[0], cid[1], seed)) * (0.5 + 0.5 * g))
        return shade(c, 1.2) if j % 4 == 0 else c
    if mat == 'pauldron':
        cx, cy = (w - 1) / 2, (h - 1) / 2
        ring = int(max(abs(i - cx), abs(j - cy)))
        c = shade(base, 0.92 + 0.16 * vnoise(i, j, 3, seed))
        return shade(c, 0.78) if ring % 2 == 1 else c
    if mat == 'cloth':
        c = shade(base, 1 + n * 2)
        return shade(c, 0.8) if ((i // 2) + (j // 2)) % 2 else c
    if mat == 'face':
        if face != 'front': return shade(pal['skin'], 0.92 + 0.2 * vnoise(i, j, 3, seed))
        FACE = ["hhhhhhhh", "hsssssbh", "sbbssbbs", "sepsspeS", "sssnnsss", "sssnnsss", "ssmmmmss", "sssmmsss"]
        ch = FACE[min(j, 7)][min(i, 7)]
        skin = shade(pal['skin'], 0.95 + 0.14 * vnoise(i, j, 3, seed))
        return {'s': skin, 'S': skin, 'h': pal['hair_dark'], 'b': pal['hair_dark'], 'e': pal.get('iris', (130, 90, 190)), 'p': (18, 16, 28),
                'n': shade(skin, 0.78), 'm': (98, 48, 52)}[ch]
    return (255, 0, 255)

def paint(parts, size, pos, pal, name, sub='entity'):
    img = Image.new('RGBA', (size, size), (0, 0, 0, 0)); px = img.load()
    for k, (x0, y0) in pos.items():
        (w, h, d), mat, f, _ = k; fo = dict(f)
        seed = zlib.crc32(repr(k).encode()) % 97; rng = random.Random(seed)
        faces = {'top': (x0 + d, y0, w, d), 'bottom': (x0 + d + w, y0, w, d),
                 'right': (x0, y0 + d, d, h), 'front': (x0 + d, y0 + d, w, h),
                 'left': (x0 + d + w, y0 + d, d, h), 'back': (x0 + 2 * d + w, y0 + d, w, h)}
        for face, (fx, fy, fw, fh) in faces.items():
            m = fo.get(face, mat)
            for j in range(fh):
                for i in range(fw):
                    c = pixel(m, i, j, fw, fh, face, pal, rng, seed)
                    if m not in ('eye', 'flame'):
                        c = shade(c, {'top': 1.12, 'bottom': 0.78, 'right': 0.92, 'left': 0.92, 'front': 1.0, 'back': 0.95}[face])
                        if fw >= 4 and fh >= 4 and (i in (0, fw - 1) or j in (0, fh - 1)): c = shade(c, 0.9)
                    px[fx + i, fy + j] = c + (255,)
    img.save(os.path.join(TEX, sub, name + '.png'))

# ------------------------------------------------------------------ java
def emit(cls, state, layer_hint, parts, size, pos, anim):
    L = []
    L.append('package io.emberwyrms.client;\n')
    for imp in ('Dilation', 'ModelData', 'ModelPart', 'ModelPartBuilder', 'ModelPartData', 'ModelTransform', 'TexturedModelData'):
        L.append('import net.minecraft.client.model.%s;' % imp)
    L.append('import net.minecraft.client.render.entity.model.EntityModel;\n')
    L.append('/** GENERADO por tools/generate.py. Edita el generador, no este archivo. */')
    L.append('public class %s extends EntityModel<%s> {' % (cls, state))
    names = [jname(p.name) for p in parts]
    assert len(set(names)) == len(names), 'nombres repetidos'
    for n in names: L.append('    private final ModelPart %s;' % n)
    L.append('\n    public %s(ModelPart root) {\n        super(root);' % cls)
    for p in parts:
        par = 'root' if p.parent is None else jname(p.parent)
        L.append('        this.%s = %s.getChild("%s");' % (jname(p.name), par, p.name))
    L.append('    }\n')
    L.append('    public static TexturedModelData getTexturedModelData() {')
    L.append('        ModelData data = new ModelData();\n        ModelPartData root = data.getRoot();')
    for p in parts:
        par = 'root' if p.parent is None else jname(p.parent)
        b = 'ModelPartBuilder.create()'
        for c in p.cubes:
            u, v = pos[ckey(c)]; o, s = c['o'], c['s']
            args = ', '.join(fm(x) for x in (*o, *s))
            if c['dil']: args += ', new Dilation(%s)' % ', '.join(fm(x) for x in c['dil'])
            b += '\n                .uv(%d, %d).cuboid(%s)' % (u, v, args)
        t = 'ModelTransform.of(%s)' % ', '.join(fm(x) for x in (*p.pivot, *p.rot))
        L.append('        ModelPartData %s = %s.addChild("%s", %s,\n                %s);' % (jname(p.name), par, p.name, b, t))
    L.append('        return TexturedModelData.of(data, %d, %d);\n    }\n' % (size, size))
    L.append('    private static float sin(float v) { return (float) Math.sin(v); }')
    L.append('    private static float cos(float v) { return (float) Math.cos(v); }\n')
    L.append(anim)
    L.append('}')
    open(os.path.join(JAVA, cls + '.java'), 'w').write('\n'.join(L) + '\n')

def build(cls, state, parts, pal, tex, anim):
    ids = {p.name for p in parts}
    for p in parts: assert p.parent is None or p.parent in ids, p.name
    size, pos = pack(parts)
    paint(parts, size, pos, pal, tex)
    emit(cls, state, None, parts, size, pos, anim)
    print('%s: %d piezas, textura %dx%d' % (cls, len(parts), size, size))
    return parts, size, pos

# =================================================================== DRAGON V2 (realista)
HIND_L, HIND_A = (6.5, 7.5, 5.0), (-0.65, 0.55, -0.15)
FORE_L, FORE_A = (6.0, 6.0, 4.0), (0.40, -0.45, 0.10)
HIP_REL_Y = 5.5
NECK_REL = (-0.45, -0.25, -0.05, 0.1, 0.2, 0.2)
FING_ANG = (0.30, 0.75, 1.15, 1.5)

def chain_drop(Ls, As, foot=1.0): return sum(L * math.cos(a) for L, a in zip(Ls, As)) + foot

def ashwing():
    """Dragon cuadrupedo estilo Ice and Fire: torso profundo con musculatura, cuello grueso en S con crestas,
    cabeza grande con fauces y cuernos, cola larga con pinchos, alas con 4 dedos y membrana, patas con dedos y garras."""
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    sides = (('l', 1), ('r', -1))
    body_abs = 24 - chain_drop(HIND_L, HIND_A) - HIP_REL_Y
    fore_hip = (24 - chain_drop(FORE_L, FORE_A)) - body_abs
    part('frame', None, (0, 24, 0))
    # ---- torso: pecho, vientre, cadera + musculatura + placas dorsales
    dorsal = []
    for z, h in ((-12, 5), (-8, 4), (-4, 4), (1, 4), (5, 4), (10, 5)):
        top = 8.5 if z < -4 else 7.5
        dorsal += [C(-1.5, -top - h, z, 3, h, 3, 'spike'), C(-4.5, -top - h + 2, z + 0.5, 2, h - 2, 2, 'spike'), C(2.5, -top - h + 2, z + 0.5, 2, h - 2, 2, 'spike')]
    part('body', 'frame', (0, body_abs - 24, 0), cubes=[
        C(-8, -8.5, -14, 16, 17, 10, 'scale', {'bottom': 'plate'}),
        C(-6.5, -7, -4, 13, 14, 8, 'scale', {'bottom': 'plate'}),
        C(-7.5, -7.5, 4, 15, 15, 9, 'scale', {'bottom': 'plate'}),
        C(8, -6, -12, 2, 10, 8, 'scale'), C(-10, -6, -12, 2, 10, 8, 'scale'),           # hombros
        C(7.5, -5, 5, 2, 10, 7, 'scale'), C(-9.5, -5, 5, 2, 10, 7, 'scale'),            # caderas
        C(-6, 6, -13, 12, 3, 8, 'plate')] + dorsal)                                     # peto del vientre
    # ---- cuello: 6 segmentos gruesos con crestas dorsales y laterales
    nw = (12, 11, 10, 9, 8, 7); prev = 'body'
    for k in range(6):
        w = nw[k]
        part('neck%d' % (k + 1), prev, (0, -6.5, -12) if k == 0 else (0, 0, -7), (NECK_REL[k], 0, 0), [
            C(-w / 2, -w / 2, -7, w, w, 7, 'scale', {'bottom': 'plate'}),
            C(-1.5, -w / 2 - (4 if k % 2 == 0 else 3), -6, 3, 4 if k % 2 == 0 else 3, 3, 'spike'),
            C(w / 2, -w / 4, -6, 1, w // 2, 4, 'spike'), C(-w / 2 - 1, -w / 4, -6, 1, w // 2, 4, 'spike')])
        prev = 'neck%d' % (k + 1)
    # ---- cabeza
    teeth = [C(x, 3.5, z, 1, 2, 1, 'teeth') for x in (-3.5, 2.5) for z in (-15, -13, -11)] + \
            [C(x, 3, z, 1, 2, 1, 'teeth') for x in (-3, 2) for z in (-21, -19, -17)] + \
            [C(-3, 3, -22, 1, 3, 1, 'teeth'), C(2, 3, -22, 1, 3, 1, 'teeth')]
    part('head', 'neck6', (0, 0, -7), (0.4, 0, 0), [
        C(-5.5, -4.5, -9, 11, 9, 9, 'scale'), C(-6, -5.5, -7, 12, 1, 4, 'scale'),
        C(-3.5, -2.5, -16, 7, 6, 7, 'scale', {'bottom': 'mouth'}), C(-3, -2, -22, 6, 5, 6, 'scale', {'bottom': 'mouth'}),
        C(-1.5, -3.5, -21, 3, 1, 12, 'scale'),                                           # caballete nasal
        C(-5.5, -4.5, -12.5, 2, 1, 4, 'scale'), C(3.5, -4.5, -12.5, 2, 1, 4, 'scale'),
        C(-2.5, -2.5, -22.5, 1, 1, 1, 'claw'), C(1.5, -2.5, -22.5, 1, 1, 1, 'claw'),
        C(-3.5, -3.5, -22, 1, 1, 2, 'scale'), C(2.5, -3.5, -22, 1, 1, 2, 'scale'),       # fosas
        C(5.2, -3.8, -8, 1, 3, 3, 'claw'), C(-6.2, -3.8, -8, 1, 3, 3, 'claw'),           # cuencas
        C(5.4, -3, -7, 1, 2, 2, 'eye'), C(-6.4, -3, -7, 1, 2, 2, 'eye'),
        C(5.5, -1, -4, 1, 4, 5, 'spike'), C(-6.5, -1, -4, 1, 4, 5, 'spike'),
        C(5.5, 2, -6, 1, 2, 4, 'spike'), C(-6.5, 2, -6, 1, 2, 4, 'spike'),
        C(6, -5, -3, 1, 6, 7, 'membrane', dil=(-0.25, 0, 0)), C(-7, -5, -3, 1, 6, 7, 'membrane', dil=(-0.25, 0, 0)),   # aletas de las orejas
        C(-1, -6.5, -8, 2, 2, 4, 'spike'), C(-1, -8, -3, 2, 3, 4, 'spike'), C(-1, -9, 2, 2, 3, 3, 'spike')] + teeth)
    part('jaw', 'head', (0, 3.5, -0.5), cubes=[C(-3.5, 0, -20, 7, 3, 19, 'scale', {'top': 'mouth'}),
        C(-1, -0.6, -18, 2, 1, 15, 'mouth'),                                             # lengua
        *[C(x, -2, z, 1, 2, 1, 'teeth') for x in (-3, 2) for z in (-19, -17, -15, -13, -11)],
        C(-1, 3, -19, 2, 3, 2, 'spike'), C(-1, 3, -14, 2, 2, 2, 'spike')])
    for lr, sg in sides:
        part('horn_' + lr, 'head', (4.5 * sg, -4.5, -1), (0.2, 0.3 * sg, 0), [C(-2, -2, 0, 4, 4, 8, 'horn')])
        part('horn_%s_2' % lr, 'horn_' + lr, (0, 0, 8), (0.1, 0.12 * sg, 0), [C(-1.5, -1.5, 0, 3, 3, 8, 'horn')])
        part('horn_%s_3' % lr, 'horn_%s_2' % lr, (0, 0, 8), (0.25, 0.05 * sg, 0), [C(-1, -1, 0, 2, 2, 7, 'horn')])
        part('brow_' + lr, 'head', (5 * sg, -5.5, -6), (0.25, -0.35 * sg, 0), [C(-1.5, -1.5, -6, 3, 3, 6, 'horn')])
    # ---- cola: 9 segmentos con pinchos dorsales y laterales, punta afilada
    tw = (12, 10, 9, 8, 7, 6, 5, 4, 3); th = (12, 10, 8, 7, 6, 5, 4, 3, 3); prev = 'body'
    for k in range(9):
        cubes = [C(-tw[k] / 2, -th[k] / 2, 0, tw[k], th[k], 7, 'scale', {'bottom': 'plate'})]
        if k < 8: cubes.append(C(-1.5, -th[k] / 2 - 4, 1, 3, 4, 4, 'spike'))
        if k < 6: cubes += [C(tw[k] / 2, -th[k] / 4, 2, 1, 2, 3, 'spike'), C(-tw[k] / 2 - 1, -th[k] / 4, 2, 1, 2, 3, 'spike')]
        part('tail%d' % (k + 1), prev, (0, -0.5, 13) if k == 0 else (0, 0, 7), cubes=cubes)
        prev = 'tail%d' % (k + 1)
    part('tail_tip', 'tail9', (0, 0, 7), cubes=[C(-0.5, -5, 0, 1, 10, 9, 'horn'), C(-4.5, -0.5, 1, 9, 1, 6, 'horn')])
    # ---- alas: hombro, brazo, antebrazo con espolon, 4 dedos con garra y membrana en paneles
    lens, gaps = (30, 26, 22, 16), (0.45, 0.4, 0.35, 0.3)
    for lr, sg in sides:
        ox = lambda x0, ln: x0 if sg > 0 else -(x0 + ln)
        part('wing_' + lr, 'body', (7.5 * sg, -7.5, -9), cubes=[C(ox(0, 8), -4, -4, 8, 8, 8, 'scale')])
        part('arm_' + lr, 'wing_' + lr, (6 * sg, 0, 0), cubes=[C(ox(0, 12), -3, -3, 12, 6, 6, 'scale'),
             C(ox(0, 12), -0.5, 4, 12, 1, 20, 'membrane', dil=(0, -0.25, 0)), C(ox(2, 3), -4.5, -1, 3, 2, 2, 'spike')])
        part('fore_' + lr, 'arm_' + lr, (12 * sg, 0, 0), cubes=[C(ox(0, 16), -2.5, -2.5, 16, 5, 5, 'scale'),
             C(ox(0, 16), -0.5, 3, 16, 1, 14, 'membrane', dil=(0, -0.25, 0)), C(ox(0, 3), -2, -6, 3, 3, 6, 'claw'),
             C(ox(6, 3), -4, -1, 3, 2, 2, 'spike')])
        for k in range(4):
            L = lens[k]; seg = L // 3; x0 = 0; bt = 3 if k < 2 else 2
            cubes = [C(ox(0, L), -bt / 2, -bt / 2, L, bt, bt, 'bone'), C(ox(L, 2), -1, -1, 2, 2, 2, 'claw')]
            for q in range(3):
                ln = seg if q < 2 else L - 2 * seg
                wd = max(2, int((x0 + ln / 2) * gaps[k]))
                cubes.append(C(ox(x0, ln), -0.5, bt / 2, ln, 1, wd, 'membrane', dil=(0, -0.25, 0)))
                x0 += ln
            part('f%d_%s' % (k + 1, lr), 'fore_' + lr, (16 * sg, 0, 0), (0, -FING_ANG[k] * sg, 0), cubes)
    # ---- patas: muslo, espinilla, metatarso, pie con 3 dedos, garras y espolon
    for n, sx, z, hind in (('fl', 1, -11, False), ('fr', -1, -11, False), ('bl', 1, 9, True), ('br', -1, 9, True)):
        Ls, As = (HIND_L, HIND_A) if hind else (FORE_L, FORE_A)
        hy = HIP_REL_Y if hind else fore_hip
        up = [C(-4, -2.5, -4, 8, math.ceil(Ls[0]) + 3, 8, 'scale'), C(-5, -5, -5, 10, 10, 10, 'scale')] if hind else \
             [C(-3.5, -2.5, -3.5, 7, math.ceil(Ls[0]) + 3, 7, 'scale'), C(-4.5, -4.5, -5, 9, 9, 10, 'scale')]
        part('leg_' + n, 'body', ((7 if hind else 7.5) * sx, hy, z), (As[0], 0, 0), up)
        part('shin_' + n, 'leg_' + n, (0, Ls[0], 0), (As[1] - As[0], 0, 0), [C(-2.5, -1, -2.5, 5, math.ceil(Ls[1]) + 1, 5, 'scale'), C(-1, -1, 2.5, 2, 4, 2, 'spike')])
        part('meta_' + n, 'shin_' + n, (0, Ls[1], 0), (As[2] - As[1], 0, 0), [C(-2, -0.5, -2, 4, math.ceil(Ls[2]) + 1, 4, 'scale')])
        part('foot_' + n, 'meta_' + n, (0, Ls[2], 0), (-As[2], 0, 0), [C(-3.5, -1, -6, 7, 2, 9, 'scale'),
             *[C(x, -1, -10, 2, 2, 4, 'scale') for x in (-3.5, -1, 1.5)],
             *[C(x + 0.5, -0.5, -13, 1, 1, 3, 'claw') for x in (-3.5, -1, 1.5)], C(-0.5, -1.5, 3, 1, 1, 3, 'claw')])
    return P

ASH_ANIM = r'''    private static final float HA1 = @HA1@, HR2 = @HR2@, HR3 = @HR3@, HF = @HF@;
    private static final float FA1 = @FA1@, FR2 = @FR2@, FR3 = @FR3@, FF = @FF@;
    private static final float[] NECK = {@NECK@};
    private static final float[] FING = {@FING@};

    private static void leg(ModelPart leg, ModelPart shin, ModelPart meta, ModelPart foot,
                            float a1, float r2, float r3, float ff, float dh, float dk, float da) {
        leg.pitch = a1 + dh;
        shin.pitch = r2 + dk;
        meta.pitch = r3 + da;
        foot.pitch = ff - (dh + dk + da);
    }

    @Override
    public void setAngles(AshwingRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float f = s.walkPhase * 0.6662f;
        float breathe = sin(t * 0.09f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;
        boolean sit = s.sitting;
        boolean fly = s.flying;

        this.frame.pitch = sit ? -0.4f : (fly ? 0.12f : 0f);
        this.body.pitch = breathe * 0.01f;

        ModelPart[] neck = {neck1, neck2, neck3, neck4, neck5, neck6};
        for (int i = 0; i < 6; i++) {
            neck[i].pitch = NECK[i] + (fly ? 0.06f : 0f) + (s.breathing ? -0.04f : 0f) + (sit ? 0.08f : 0f);
            neck[i].yaw = yawLook * 0.1f + sin(t * 0.05f - i * 0.5f) * 0.03f;
        }
        this.head.yaw = yawLook * 0.4f;
        this.head.pitch = 0.4f + pitchLook * 0.5f + breathe * 0.02f - (s.breathing ? 0.35f : 0f);
        this.jaw.pitch = s.breathing ? 0.85f : 0.2f + (breathe + 1f) * 0.03f;

        ModelPart[] tail = {tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9};
        float walkSway = cos(f) * 0.06f * amp;
        for (int i = 0; i < 9; i++) {
            tail[i].yaw = sin(t * 0.06f - i * 0.55f) * (0.06f + i * 0.012f) + walkSway;
            tail[i].pitch = sit ? (i == 0 ? 0.35f : 0.05f) : (fly ? -0.02f : 0f);
        }
        this.tailTip.yaw = sin(t * 0.06f - 5f) * 0.2f;

        float swA = cos(f) * amp, swB = -swA;
        float liftA = Math.max(0f, sin(f)) * amp, liftB = Math.max(0f, -sin(f)) * amp;
        float sh = sit ? -0.9f : (fly ? 0.9f : 0f);
        float sk = sit ? 1.1f : (fly ? 0.8f : 0f);
        float sa = sit ? -0.2f : (fly ? 0.2f : 0f);
        leg(legBl, shinBl, metaBl, footBl, HA1, HR2, HR3, HF, swA * 0.55f + sh, liftA * 0.7f + sk, -liftA * 0.35f + sa);
        leg(legBr, shinBr, metaBr, footBr, HA1, HR2, HR3, HF, swB * 0.55f + sh, liftB * 0.7f + sk, -liftB * 0.35f + sa);
        float fh = fly ? 0.6f : 0f;
        leg(legFr, shinFr, metaFr, footFr, FA1, FR2, FR3, FF, swA * 0.5f + fh, liftA * 0.6f + fh, -liftA * 0.3f);
        leg(legFl, shinFl, metaFl, footFl, FA1, FR2, FR3, FF, swB * 0.5f + fh, liftB * 0.6f + fh, -liftB * 0.3f);

        float fold = fly ? 0f : 0.9f;
        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.04f;
        this.wingL.yaw = -0.8f * fold + (fly ? -0.1f : 0f);
        this.wingR.yaw = -this.wingL.yaw;
        this.wingL.roll = 0.3f * fold - flap * (fly ? 0.75f : 1f);
        this.wingR.roll = -this.wingL.roll;
        this.armL.roll = fly ? -flap * 0.25f : 0f;
        this.armR.roll = -this.armL.roll;
        this.foreL.yaw = -1.2f * fold;
        this.foreR.yaw = -this.foreL.yaw;
        this.foreL.roll = fly ? -flap * 0.5f : 0f;
        this.foreR.roll = -this.foreL.roll;
        ModelPart[] fl = {f1L, f2L, f3L, f4L};
        ModelPart[] fr = {f1R, f2R, f3R, f4R};
        for (int i = 0; i < 4; i++) {
            fl[i].yaw = -FING[i] * (1f - 0.72f * fold);
            fr[i].yaw = -fl[i].yaw;
            fl[i].roll = fly ? -flap * 0.25f * (i + 1) / 4f : 0f;
            fr[i].roll = -fl[i].roll;
        }
    }'''
ASH_ANIM = (ASH_ANIM.replace('@HA1@', fm(HIND_A[0])).replace('@HR2@', fm(HIND_A[1] - HIND_A[0])).replace('@HR3@', fm(HIND_A[2] - HIND_A[1]))
            .replace('@HF@', fm(-HIND_A[2])).replace('@FA1@', fm(FORE_A[0])).replace('@FR2@', fm(FORE_A[1] - FORE_A[0]))
            .replace('@FR3@', fm(FORE_A[2] - FORE_A[1])).replace('@FF@', fm(-FORE_A[2]))
            .replace('@NECK@', ', '.join(fm(x) for x in NECK_REL)).replace('@FING@', ', '.join(fm(x) for x in FING_ANG)))

ASH_PAL = dict(scale=(48, 44, 50), belly=(150, 118, 92), plate=(150, 118, 92), horn=(196, 180, 154), membrane=(96, 38, 34),
               bone=(70, 62, 62), claw=(28, 26, 28), eye=(255, 176, 40), teeth=(228, 218, 196),
               spike=(84, 70, 70), ember=(236, 96, 26), mark=(30, 26, 30), mark_style='stripe', mouth=(150, 40, 52), fur=(122, 112, 108))

# =================================================================== PHOENIX
PRIM_N, TAIL_LEN = 8, (14, 18, 22, 26, 22, 18, 14)

def phoenix():
    """Fenix grande y esbelto: cuello en S con gorguera, pico ganchudo, cresta de 5 llamas, alas de 3 hileras de plumas
    con 8 primarias de punta de fuego, cola de 7 plumas largas curvadas, patas finas con garras."""
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    sides = (('l', 1), ('r', -1))
    ox = lambda sg, x0, ln: x0 if sg > 0 else -(x0 + ln)
    part('body', None, (0, 14.5, 0), cubes=[
        C(-3.5, -3.5, -9, 7, 7, 7, 'feather'), C(-3, -3, -2, 6, 6, 7, 'feather'), C(-2.5, -2.5, 5, 5, 5, 4, 'feather'),
        C(-3, -1, -11, 6, 5, 3, 'feather')] + [C(-1, -5, -7 + k * 3, 2, 2, 2, 'flame') for k in range(5)])
    part('neck1', 'body', (0, -1, -10), (-0.6, 0, 0), [C(-2, -2, -4, 4, 4, 4, 'feather'), C(-3, -2.5, -3, 6, 5, 2, 'feather')])
    part('neck2', 'neck1', (0, 0, -4), (-0.15, 0, 0), [C(-1.5, -1.5, -4, 3, 3, 4, 'feather')])
    part('neck3', 'neck2', (0, 0, -4), (0.55, 0, 0), [C(-1.5, -1.5, -4, 3, 3, 4, 'feather')])
    part('head', 'neck3', (0, 0, -4), (0.3, 0, 0), [C(-2, -2, -4, 4, 4, 4, 'feather'),
         C(-1, -0.5, -8, 2, 2, 4, 'beak'), C(-0.5, 1, -8.5, 1, 2, 1, 'beak'), C(-1, 1.5, -7, 2, 1, 3, 'beak'),
         C(1.7, -1, -3, 1, 1, 1, 'eye'), C(-2.7, -1, -3, 1, 1, 1, 'eye'),
         C(2, 0, -1, 1, 2, 3, 'flame'), C(-3, 0, -1, 1, 2, 3, 'flame')])
    for k in range(5):
        d = abs(k - 2); L = 9 - 2 * d
        part('crest_%d' % k, 'head', (0, -2, -1), (0.95 - d * 0.12, (k - 2) * 0.28, 0), [C(-0.5, -0.5, 0, 1, 1, L, 'flame')])
        part('crest_%d_b' % k, 'crest_%d' % k, (0, 0, L), (0.5, 0, 0), [C(-0.5, -0.5, 0, 1, 1, 5, 'flame')])
    for lr, sg in sides:
        part('wing_' + lr, 'body', (3.5 * sg, -2.5, -5), cubes=[C(ox(sg, 0, 7), -1, -1.5, 7, 2, 3, 'feather'),
             C(ox(sg, 0, 7), -1.5, 1.5, 7, 1, 4, 'feather'), C(ox(sg, 1, 6), -1.5, 5.5, 6, 1, 3, 'feather')])
        sec = []
        for k in range(6):
            Ls = 9 + k
            sec += [C(ox(sg, round(k * 1.3), 2), -0.5, 3, 2, 1, Ls, 'feather'), C(ox(sg, round(k * 1.3), 2), -0.5, 3 + Ls, 2, 1, 3, 'flame')]
        part('fore_' + lr, 'wing_' + lr, (7 * sg, 0, 0), cubes=[C(ox(sg, 0, 8), -1, -1.5, 8, 2, 3, 'feather'),
             C(ox(sg, 0, 8), -1.5, 1.5, 8, 1, 4, 'feather')] + sec)
        part('hand_' + lr, 'fore_' + lr, (8 * sg, 0, 0), cubes=[C(ox(sg, 0, 5), -1, -1, 5, 2, 2, 'feather')])
        for k in range(PRIM_N):
            L = int(round(21 - k * 1.5)); bsz = int(L * 0.65)
            part('prim_%d_%s' % (k, lr), 'hand_' + lr, (4 * sg, 0, 0), (0, -(0.04 + 0.11 * k) * sg, 0), [
                C(ox(sg, 0, bsz), -0.5, -1, bsz, 1, 3, 'feather'), C(ox(sg, bsz, L - bsz), -0.5, -1, L - bsz, 1, 3, 'flame')])
    part('tail', 'body', (0, -1, 9))
    for k, L in enumerate(TAIL_LEN):
        La = int(L * 0.6)
        part('tail_%d' % k, 'tail', (0, 0, 0), (-0.08, (k - 3) * 0.18, 0), [C(-1, -0.5, 0, 2, 1, La, 'feather_tail')])
        part('tail_%d_b' % k, 'tail_%d' % k, (0, 0, La), (-0.2, 0, 0), [C(-1, -0.5, 0, 2, 1, L - La, 'feather_tail'), C(-1.5, -0.5, L - La, 3, 1, 4, 'flame')])
    for lr, sg in sides:
        part('leg_' + lr, 'body', (2 * sg, 3, 0), cubes=[C(-2, 0, -2, 4, 3, 4, 'feather')])
        part('shin_' + lr, 'leg_' + lr, (0, 3, 0), cubes=[C(-0.5, 0, -0.5, 1, 4, 1, 'leg')])
        part('foot_' + lr, 'shin_' + lr, (0, 3.5, 0), cubes=[C(x, -0.5, -4, 1, 1, 4, 'leg') for x in (-1.5, -0.5, 0.5)] +
             [C(-0.5, -0.5, 0, 1, 1, 2, 'leg')] + [C(x, -0.5, -5, 1, 1, 1, 'claw') for x in (-1.5, -0.5, 0.5)])
    return P

PHX_ANIM = r'''    private static final float[] NB = {-0.6f, -0.15f, 0.55f};

    @Override
    public void setAngles(PhoenixRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.5f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        ModelPart[] neck = {neck1, neck2, neck3};
        for (int i = 0; i < 3; i++) neck[i].pitch = NB[i] + (s.flying ? 0.25f : 0f) + sin(t * 0.08f - i * 0.7f) * 0.04f;
        this.head.pitch = 0.3f + pitchLook * 0.5f;
        this.head.yaw = yawLook * 0.6f;
        ModelPart[] crest = {crest0, crest1, crest2, crest3, crest4};
        ModelPart[] crestB = {crest0B, crest1B, crest2B, crest3B, crest4B};
        for (int i = 0; i < 5; i++) {
            int d = Math.abs(i - 2);
            crest[i].pitch = 0.95f - d * 0.12f + sin(t * 0.2f + i) * 0.1f;
            crest[i].yaw = (i - 2) * 0.28f + sin(t * 0.15f + i * 2f) * 0.06f;
            crestB[i].pitch = 0.5f + sin(t * 0.25f + i) * 0.15f;
        }

        ModelPart[] pl = {prim0L, prim1L, prim2L, prim3L, prim4L, prim5L, prim6L, prim7L};
        ModelPart[] pr = {prim0R, prim1R, prim2R, prim3R, prim4R, prim5R, prim6R, prim7R};
        float spread;
        if (s.flying) {
            float flap = sin(t * 0.5f);
            spread = 1f;
            this.body.pitch = 0.1f;
            this.wingL.yaw = 0f; this.wingR.yaw = 0f; this.foreL.yaw = 0f; this.foreR.yaw = 0f; this.handL.yaw = 0f; this.handR.yaw = 0f;
            this.wingL.roll = -flap * 0.8f;  this.wingR.roll = flap * 0.8f;
            this.foreL.roll = -flap * 0.45f - 0.05f;  this.foreR.roll = flap * 0.45f + 0.05f;
            this.handL.roll = -flap * 0.35f;  this.handR.roll = flap * 0.35f;
            this.legL.pitch = 0.9f; this.legR.pitch = 0.9f;
            this.shinL.pitch = 0.7f; this.shinR.pitch = 0.7f;
        } else {
            spread = 0.25f;
            this.body.pitch = 0f;
            this.wingL.yaw = -0.6f;  this.wingR.yaw = 0.6f;
            this.wingL.roll = 0.45f;  this.wingR.roll = -0.45f;
            this.foreL.yaw = -1.2f;  this.foreR.yaw = 1.2f;
            this.foreL.roll = 0f;  this.foreR.roll = 0f;
            this.handL.yaw = -0.8f;  this.handR.yaw = 0.8f;
            this.handL.roll = 0f;  this.handR.roll = 0f;
            float sw = cos(f) * 0.9f * amp;
            this.legL.pitch = sw;  this.legR.pitch = -sw;
            this.shinL.pitch = 0f;  this.shinR.pitch = 0f;
        }
        for (int i = 0; i < 8; i++) {
            float py = -(0.04f + 0.11f * i) * spread;
            pl[i].yaw = py;
            pr[i].yaw = -py;
        }
        ModelPart[] tf = {tail0, tail1, tail2, tail3, tail4, tail5, tail6};
        ModelPart[] tb = {tail0B, tail1B, tail2B, tail3B, tail4B, tail5B, tail6B};
        for (int i = 0; i < 7; i++) {
            tf[i].yaw = (i - 3) * 0.18f * (s.flying ? 1.25f : 0.7f) + sin(t * 0.1f + i) * 0.04f;
            tf[i].pitch = -0.08f + (s.flying ? sin(t * 0.5f) * 0.08f : 0f);
            tb[i].pitch = -0.2f + sin(t * 0.12f + i) * 0.08f;
        }
    }'''

PHX_PAL = dict(feather=(210, 50, 28), f_a=(190, 28, 22), f_b=(255, 138, 30), f_c=(255, 226, 112),
               beak=(240, 178, 50), eye=(255, 250, 170), leg=(196, 138, 46), claw=(70, 44, 30), flame=(255, 200, 60))

# =================================================================== MEDUSA
COIL = [(8, 8, 10), (7, 7, 10), (6, 6, 10), (6, 5, 10), (5, 5, 10), (4, 4, 10), (4, 3, 10), (3, 3, 8)]   # (ancho, alto, largo) tramos tumbados
NSNAKE = 8

def medusa():
    """Gorgona (referencia: modelo de Sketchfab): proporciones de jugador de Minecraft, piel gris verdosa, tunica marron a cuadros,
    ojos morados, 8 serpientes de boca roja en el pelo y una cola larga que sale de la cintura y se arrastra por el suelo."""
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    part('coil1', None, (0, 12, 0), cubes=[C(-4, 0, -3, 8, 12, 6, 'scale', {'bottom': 'plate'}), C(-4.5, 0, -3.5, 9, 3, 7, 'cloth')])
    for k, (wd, hg, ln) in enumerate(COIL):
        if k == 0: piv = (0, 12 - hg / 2, 3)
        else: piv = (0, (COIL[k - 1][1] - hg) / 2, COIL[k - 1][2])
        part('coil%d' % (k + 2), 'coil%d' % (k + 1), piv, (0, 0.18 * (1 if k % 2 == 0 else -1), 0),
             [C(-wd / 2, -hg / 2, 0, wd, hg, ln, 'scale', {'bottom': 'plate'})])
    part('torso', None, (0, 12, 0), cubes=[C(-4, -12, -2, 8, 12, 4, 'cloth')])
    part('head', 'torso', (0, -12, 0), cubes=[C(-4, -8, -4, 8, 8, 8, 'face'),
         C(-4.5, -8.5, -4.5, 9, 3, 9, 'hair'), C(-4.5, -6, 3.2, 9, 9, 1, 'hair')])
    for lr, sg in (('l', 1), ('r', -1)):
        part('arm_' + lr, 'torso', (6 * sg, -10, 0), cubes=[C(-2, -2, -2, 4, 6, 4, 'cloth'), C(-2, 4, -2, 4, 6, 4, 'skin')])
    dirs = []
    for k in range(NSNAKE):
        a_ = k * 2 * math.pi / NSNAKE; dx, dz = math.cos(a_), math.sin(a_); dirs.append((dx, dz))
        yaw = math.atan2(-dx, -dz)
        part('snake%d' % k, 'head', (3.4 * dx, -8.5, 3.4 * dz), (-0.7 * dz, 0, 0.7 * dx), [C(-1, -6, -1, 2, 6, 2, 'snake')])
        part('snake%d_b' % k, 'snake%d' % k, (0, -6, 0), (-0.45 * dz, 0, 0.45 * dx), [C(-1, -6, -1, 2, 6, 2, 'snake')])
        part('snake%d_h' % k, 'snake%d_b' % k, (0, -6, 0), (0.6, yaw, 0), [C(-1.5, -1.5, -3, 3, 3, 5, 'snake_head')])
    global MED_DIRS; MED_DIRS = dirs
    return P

MED_ANIM_T = r'''    private static final float[] SNAKE_DX = {@DX@};
    private static final float[] SNAKE_DZ = {@DZ@};

    @Override
    public void setAngles(MedusaRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.head.yaw = yawLook * 0.8f;
        this.head.pitch = pitchLook * 0.7f;
        this.torso.yaw = sin(t * 0.06f) * 0.06f + cos(f) * 0.15f * amp;
        this.torso.pitch = sin(t * 0.05f) * 0.02f;

        float sw = 0.08f + 0.22f * amp;
        float sp = t * 0.07f + f * 0.5f;
        this.coil1.yaw = sin(sp) * sw * 0.5f;
        ModelPart[] coil = {@COILS@};
        for (int i = 0; i < coil.length; i++) coil[i].yaw = (i % 2 == 0 ? 0.18f : -0.18f) + sin(sp - 0.6f * (i + 1)) * (sw + 0.05f * i);

        this.armL.pitch = -0.1f + cos(f) * 0.5f * amp;
        this.armR.pitch = -0.1f - cos(f) * 0.5f * amp;
        this.armL.roll = -0.05f + sin(t * 0.05f) * 0.03f;
        this.armR.roll = 0.05f - sin(t * 0.05f) * 0.03f;

        ModelPart[] a = {@A@};
        ModelPart[] b = {@B@};
        for (int i = 0; i < @N@; i++) {
            a[i].roll = 0.6f * SNAKE_DX[i] + sin(t * 0.15f + i * 1.3f) * 0.2f;
            a[i].pitch = -0.6f * SNAKE_DZ[i] + sin(t * 0.13f + i) * 0.16f;
            b[i].roll = 0.4f * SNAKE_DX[i] + sin(t * 0.17f + i * 0.9f) * 0.3f;
            b[i].pitch = -0.4f * SNAKE_DZ[i] + cos(t * 0.15f + i) * 0.25f;
        }
    }'''

def med_anim():
    names = lambda pat: ', '.join(pat % k for k in range(NSNAKE))
    return (MED_ANIM_T.replace('@DX@', ', '.join(fm(d[0]) for d in MED_DIRS)).replace('@DZ@', ', '.join(fm(d[1]) for d in MED_DIRS))
            .replace('@COILS@', ', '.join('coil%d' % (k + 2) for k in range(len(COIL))))
            .replace('@A@', names('snake%d')).replace('@B@', names('snake%dB')).replace('@N@', str(NSNAKE)))

MED_PAL = dict(scale=(60, 84, 74), belly=(104, 122, 100), plate=(92, 110, 92), mark=(40, 58, 52), mark_style='stripe', scale_size=3.6,
               skin=(118, 142, 132), cloth=(112, 72, 58), gold=(190, 152, 62), snake=(40, 66, 42), eye=(196, 214, 64), iris=(130, 90, 190),
               hair_dark=(32, 26, 30), hair=(36, 30, 34), teeth=(238, 238, 220), claw=(40, 34, 40), horn=(200, 190, 150))

# =================================================================== DRAGONES ELEMENTALES
def elemental(el):
    P = ashwing()
    def part(*a, **k): P.append(Part(*a, **k))
    sides = (('l', 1), ('r', -1))
    ox = lambda sg, L: 0 if sg > 0 else -L
    if el == 'fire':
        for lr, sg in sides:
            part('fbrow_' + lr, 'head', (4.5 * sg, -6, -6), (0.15, -0.35 * sg, 0), [C(-1, -1, -7, 2, 2, 7, 'horn')])
        part('tail_flame', 'tail_tip', (0, 0, 7), cubes=[C(-1, -4, 0, 2, 8, 7, 'flame'), C(-3, -1, 0, 6, 2, 5, 'flame')])
        for k in range(3):
            part('ember_%d' % k, 'body', (0, -8.5, -10 + k * 9), cubes=[C(-2, -7, -2, 4, 7, 4, 'flame')])
    elif el == 'ice':
        for k, z in enumerate((-12, -6, 0, 6, 11)):
            part('crystal_%d' % k, 'body', (0, -8, z), cubes=[C(-2, -7, -2, 4, 7, 4, 'crystal'),
                 C(-1.5, -10 - (k % 2) * 3, -1.5, 3, 3 + (k % 2) * 3, 3, 'crystal')])
        for lr, sg in sides:
            part('crown_' + lr, 'head', (3.5 * sg, -5, -3), (-0.3, 0, 0.3 * sg), [C(-1.5, -7, -1.5, 3, 7, 3, 'crystal')])
        part('tail_crystal', 'tail_tip', (0, 0, 7), cubes=[C(-1.5, -7, 0, 3, 14, 3, 'crystal'), C(-5, -1.5, 0, 10, 3, 3, 'crystal')])
    elif el == 'storm':
        for lr, sg in sides:
            part('antler_' + lr, 'head', (4.5 * sg, -5, -3), (0.9, 0.35 * sg, 0), [C(-1, -1, 0, 2, 2, 7, 'horn')])
            part('antler_%s_a' % lr, 'antler_' + lr, (0, 0, 7), (-0.5, 0, 0), [C(-1, -1, 0, 2, 2, 6, 'horn')])
            part('antler_%s_b' % lr, 'antler_' + lr, (0, 0, 3), (0.2, 0.7 * sg, 0), [C(-1, -1, 0, 2, 2, 6, 'horn')])
        part('bolt_a', 'tail_tip', (0, 0, 7), (0, 0.6, 0), [C(-1, -1, 0, 2, 2, 7, 'spike')])
        part('bolt_b', 'bolt_a', (0, 0, 7), (0, -1.2, 0), [C(-1, -1, 0, 2, 2, 7, 'spike')])
        for k, z in enumerate((-11, -4, 3, 10)):
            part('spark_%d' % k, 'body', (0, -8.5, z), cubes=[C(-2, -9, -2, 4, 9, 4, 'spike')])
    else:
        for lr, sg in sides:
            part('ear_fin_' + lr, 'head', (6 * sg, -1, -3), (0, -0.6 * sg, 0), [C(ox(sg, 8), -4, -0.5, 8, 7, 1, 'membrane', dil=(0, 0, -0.25))])
        part('dorsal_fin', 'body', (0, -8.5, -11), cubes=[C(-0.5, -13, 0, 1, 13, 22, 'membrane', dil=(-0.25, 0, 0))])
        part('tail_fin', 'tail5', (0, 0, 3), cubes=[C(-0.5, -8, 0, 1, 16, 10, 'membrane', dil=(-0.25, 0, 0))])
    return P

def pal(**kw):
    d = dict(ASH_PAL); d.update(kw); return d
ELPAL = {
    'fire': pal(scale=(98, 24, 22), belly=(238, 150, 60), plate=(236, 150, 62), horn=(48, 36, 34), membrane=(176, 56, 26), bone=(62, 38, 34),
                claw=(26, 22, 24), eye=(255, 236, 90), teeth=(240, 226, 200), spike=(52, 38, 34), ember=(255, 170, 40),
                mark=(30, 12, 12), mark_style='stripe', f_a=(226, 66, 22), f_c=(255, 222, 90)),
    'ice': pal(scale=(78, 122, 168), belly=(218, 238, 250), plate=(216, 236, 248), horn=(222, 242, 252), membrane=(122, 178, 218), bone=(130, 168, 196),
               claw=(64, 84, 104), eye=(130, 245, 255), teeth=(245, 250, 255), spike=(196, 232, 250), ember=(235, 250, 255),
               mark=(244, 250, 255), mark_style='frost', crystal=(176, 228, 250)),
    'storm': pal(scale=(40, 46, 92), belly=(150, 156, 208), plate=(160, 166, 214), horn=(236, 216, 100), membrane=(46, 52, 104), bone=(58, 64, 100),
                 claw=(34, 34, 58), eye=(255, 250, 120), teeth=(240, 240, 230), spike=(250, 228, 90), ember=(255, 244, 120),
                 mark=(255, 232, 90), mark_style='streak'),
    'tide': pal(scale=(22, 90, 122), belly=(178, 222, 202), plate=(184, 224, 206), horn=(234, 228, 204), membrane=(44, 158, 178), bone=(48, 108, 128),
                claw=(28, 58, 68), eye=(190, 255, 230), teeth=(240, 248, 240), spike=(58, 170, 192), ember=(150, 240, 230),
                mark=(120, 214, 220), mark_style='spots'),
}
for _k, _f in (('fire', (78, 66, 68)), ('ice', (236, 240, 244)), ('storm', (158, 160, 180)), ('tide', (206, 228, 218))):
    ELPAL[_k]['fur'] = _f
ASH_BOSS_PAL = pal(scale=(30, 28, 32), belly=(86, 58, 46), plate=(86, 58, 46), horn=(70, 60, 56), membrane=(66, 22, 20), bone=(44, 38, 40),
                   spike=(40, 34, 36), eye=(255, 96, 30), ember=(255, 120, 30), mark=(255, 112, 24), mark_style='cracks', mouth=(190, 60, 30))
CAP = {'fire': 'Fire', 'ice': 'Ice', 'storm': 'Storm', 'tide': 'Tide'}

def scale_icon(name, c):
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    for y in range(16):
        for x in range(16):
            d = abs(x - 7.5) / 5.5 + abs(y - 7.5) / 7
            if d <= 1: px[x, y] = (shade(c, 0.6) if d > 0.8 else c if d > 0.45 else shade(c, 1.35)) + (255,)
    img.save(os.path.join(TEX, 'item', name + '.png'))

def eggblock(name, base, spot):
    os.makedirs(TEX + '/block', exist_ok=True)
    img = Image.new('RGBA', (16, 16)); px = img.load(); rng = random.Random(name)
    for y in range(16):
        for x in range(16):
            c = shade(base, 0.85 + 0.3 * ((x * 7 + y * 3) % 11) / 11 + rng.uniform(-0.05, 0.05))
            if (x * 5 + y * 9) % 13 == 0 or rng.random() < 0.07: c = spot
            px[x, y] = c + (255,)
    img.save(os.path.join(TEX, 'block', name + '.png'))


# =================================================================== ARMADURAS / FENIX
MASKS = {
 'helmet': ["", "", "....########", "...##########", "..############", "..############", "..############", "..###......###", "..###......###", "..##........##"],
 'chestplate': ["", "..####....####", ".######..######", ".##############", ".##############", ".##############", "..############", "..############", "..############", "..############", "...##########"],
 'leggings': ["", "..############", "..############", "..############", "..####....####", "..####....####", "..####....####", "..####....####", "..####....####", "..###......###", "..###......###"],
 'boots': ["", "", "", "", "", "..###......###", "..###......###", "..###......###", ".####......####", ".####......####", ".####......####"],
}

TRIM = (236, 196, 76)

def armor_icon(name, piece, pal):
    rows = [r.ljust(16, '.') for r in MASKS[piece]] + ['.' * 16] * (16 - len(MASKS[piece]))
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load(); rng = random.Random(name)
    on = lambda x, y: 0 <= x < 16 and 0 <= y < 16 and rows[y][x] == '#'
    base, belly, fur = pal['scale'], pal.get('belly', pal['scale']), pal.get('fur', (220, 220, 220))
    for y in range(16):
        for x in range(16):
            if not on(x, y): continue
            edge = not (on(x - 1, y) and on(x + 1, y) and on(x, y - 1) and on(x, y + 1))
            c = mix(shade(base, 1.3), shade(base, 0.75), min(1, y / 12))
            if y % 3 == 0: c = mix(c, belly, 0.14)
            if edge: c = shade(c, 0.42)
            elif not on(x, y - 1) or not on(x - 1, y): c = shade(c, 1.4)
            furry = (piece == 'chestplate' and y == 2) or (piece == 'helmet' and y == 3) or (piece == 'boots' and y == 5) or (piece == 'leggings' and y == 1)
            if furry and not edge: c = shade(fur, 0.8 + 0.3 * rng.random())
            if piece == 'chestplate' and not edge and x in (7, 8) and y in (5, 6): c = pal['eye']
            if piece == 'helmet' and not edge and y in (7, 8) and 4 <= x <= 11: c = shade(base, 0.2)
            if piece == 'helmet' and not edge and y == 7 and x in (5, 10): c = pal['eye']
            if piece == 'helmet' and y == 2 and x in (4, 11): c = pal.get('horn', TRIM)
            px[x, y] = c + (255,)
    img.save(os.path.join(TEX, 'item', name + '.png'))

def armor_face(px, x0, y0, w, h, part, face, pal, rng, seed):
    horn, claw = pal.get('horn', (210, 200, 180)), pal.get('claw', (30, 30, 30))
    S = face in SIDES
    mid = (w // 2 - 2, w // 2 + 1)
    for j in range(h):
        for i in range(w):
            c = pixel('scale', i, j, w, h, face, pal, rng, seed)
            if part == 'body':
                if face == 'front':
                    if mid[0] <= i <= mid[1]: c = pixel('plate', i, j, w, h, face, pal, rng, seed)
                    elif j in (2, 4, 6, 8) and (i < mid[0] or i > mid[1]): c = shade(c, 0.5)
                    elif j in (3, 5, 7, 9) and (i < mid[0] or i > mid[1]): c = shade(c, 1.2)
                    if j == 0 and i % 2 == 0: c = shade(horn, 1.0)
                elif face == 'back':
                    if i in (w // 2 - 1, w // 2): c = shade(c, 0.55 if j % 2 else 1.25)
                    if j == 0 and i % 2 == 1: c = shade(horn, 1.0)
            elif part == 'arm' and S:
                if j == 0 and i % 2 == 0: c = shade(horn, 1.0)
                elif j == 1: c = shade(c, 1.25)
                if 5 <= j <= 6: c = shade(c, 0.8)
                if j >= 10: c = shade(claw, 1.3) if i % 2 == 0 else shade(c, 0.6)
            elif part == 'leg' and S:
                if j == 5: c = shade(c, 1.35)
                if j == 6: c = shade(c, 0.6)
                if j >= 9 and j <= 10 and i % 2 == 1: c = shade(horn, 0.9)
                if j == 11: c = shade(claw, 0.9)
            if S and (i in (0, w - 1) or j == h - 1) and w > 2: c = shade(c, 0.85)
            px[x0 + i, y0 + j] = c + (255,)

def equipment_textures(el, pal):
    cubes1 = [('head', 0, 0, 8, 8, 8), ('body', 16, 16, 8, 12, 4), ('arm', 40, 16, 4, 12, 4), ('leg', 0, 16, 4, 12, 4)]
    for layer, cubes in (('humanoid', cubes1), ('humanoid_leggings', cubes1[1:2] + cubes1[3:4])):
        d = os.path.join(TEX, 'entity', 'equipment', layer); os.makedirs(d, exist_ok=True)
        img = Image.new('RGBA', (64, 32), (0, 0, 0, 0)); px = img.load(); rng = random.Random(el + layer)
        for part, u, v, w, h, dd in cubes:
            faces = {'top': (u + dd, v, w, dd), 'bottom': (u + dd + w, v, w, dd), 'right': (u, v + dd, dd, h),
                     'front': (u + dd, v + dd, w, h), 'left': (u + dd + w, v + dd, dd, h), 'back': (u + 2 * dd + w, v + dd, w, h)}
            for face, (fx, fy, fw, fh) in faces.items():
                armor_face(px, fx, fy, fw, fh, part, face, pal, rng, 11)
        img.save(os.path.join(d, el + '_dragon.png'))

def feather_icon():
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    for k in range(13):
        x, y = 2 + k, 13 - k
        for w in range(-2, 3):
            xx, yy = x + w, y
            if 0 <= xx < 16 and 0 <= yy < 16 and abs(w) <= max(0, 2 - abs(k - 6) // 3):
                t = k / 12
                px[xx, yy] = mix((220, 50, 25), (255, 215, 70), t) + (255,)
        px[x, y] = (255, 240, 170, 255)
    img.save(os.path.join(TEX, 'item', 'phoenix_feather.png'))

def horn_icon():
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    pts = []
    for k in range(60):
        t = k / 59.0
        pts.append((2 + 11.5 * t, 12.5 - 9.0 * math.sin(t * 1.35), 2.2 * (1 - t) + 0.6))
    for y in range(16):
        for x in range(16):
            for (cx, cy, r) in pts:
                d = math.hypot(x - cx, y - cy)
                if d <= r:
                    tt = (cx - 2) / 11.5
                    c = mix((236, 226, 200), (92, 78, 66), tt ** 1.5)
                    if d > r - 0.7: c = shade(c, 0.55)
                    elif cy - y > r * 0.35: c = shade(c, 1.15)
                    if tt < 0.14: c = (232, 190, 70) if d <= r - 0.7 else (140, 100, 30)
                    px[x, y] = c + (255,)
                    break
    img.save(os.path.join(TEX, 'item', 'dragon_horn.png'))

def heart_icon():
    rows = ["..##...##..", ".####.####.", "###########", "###########", ".#########.", "..#######..", "...#####...", "....###....", ".....#....."]
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    for y, r in enumerate(rows):
        for x, ch in enumerate(r):
            if ch != '#': continue
            xx, yy = x + 2, y + 3
            edge = x in (0, 10) or y == len(rows) - 1 or r[max(0, x - 1)] == '.' or r[min(10, x + 1)] == '.'
            c = (40, 34, 38) if edge else (68, 54, 56)
            d = math.hypot(x - 5, y - 3)
            if not edge and d < 3.6: c = mix((255, 150, 40), (200, 50, 20), d / 3.6)
            if not edge and (x, y) in ((2, 1), (3, 1), (1, 2)): c = (255, 210, 120)
            px[xx, yy] = c + (255,)
    img.save(os.path.join(TEX, 'item', 'ash_heart.png'))

def helm_cubes():
    """Cabeza de dragon con las fauces abiertas alrededor de la cara. Coordenadas del modelo (y hacia arriba).
    La cabeza del jugador ocupa [1.6, 14.4] en x/y/z; su cara mira al norte (z = 1.6).
    Hocico superior sobre la frente, mandibula bajo la barbilla, cuernos y cresta hacia atras, placas en las sienes."""
    L = []
    def add(x0, y0, z0, x1, y1, z1, mat, faces=None): L.append(dict(f=(x0, y0, z0), t=(x1, y1, z1), mat=mat, faces=faces or {}))
    def pair(x0, y0, z0, x1, y1, z1, mat, faces=None):
        add(x0, y0, z0, x1, y1, z1, mat, faces); add(16 - x1, y0, z0, 16 - x0, y1, z1, mat, faces)
    add(0.8, 14.6, 0.8, 15.2, 17.2, 15.6, 'scale')                         # casquete
    add(1.0, 3.0, 14.7, 15.0, 14.6, 16.9, 'scale')                         # nuca
    pair(14.6, 5.0, 3.6, 16.6, 14.2, 15.2, 'scale')                        # placas de las sienes
    pair(14.6, 2.6, 6.2, 16.2, 5.0, 14.0, 'scale')                         # pomulos
    add(4.6, 14.6, -9.0, 11.4, 17.6, 3.0, 'scale', {'bottom': 'mouth'})   # hocico superior
    add(5.4, 15.0, -14.0, 10.6, 17.4, -9.2, 'scale', {'bottom': 'mouth'}) # punta del hocico
    add(6.0, 16.0, -14.4, 7.0, 17.0, -14.0, 'claw'); add(9.0, 16.0, -14.4, 10.0, 17.0, -14.0, 'claw')   # fosas nasales
    add(2.6, 13.7, 0.4, 13.4, 14.9, 2.6, 'scale')                          # ceja
    pair(2.0, 14.7, -1.4, 4.0, 16.8, 2.0, 'horn')                          # cuernos de la ceja
    pair(4.0, 13.8, 0.9, 5.4, 14.6, 2.1, 'eye')                            # gemas de los ojos
    for x in (5.2, 9.8):
        for z in (-8.6, -5.6, -2.6): add(x, 12.2, z, x + 1.0, 14.6, z + 1.0, 'teeth')    # dientes superiores
    add(5.6, 12.0, -14.0, 6.6, 15.0, -13.0, 'teeth'); add(9.4, 12.0, -14.0, 10.4, 15.0, -13.0, 'teeth')   # colmillos
    add(4.8, -1.8, -8.0, 11.2, 1.2, 3.4, 'scale', {'top': 'mouth'})       # mandibula
    add(5.6, -1.6, -11.0, 10.4, 0.8, -8.2, 'scale')
    for x in (5.4, 9.6):
        for z in (-10.0, -7.0, -4.0, -1.0): add(x, 1.2, z, x + 1.0, 3.0, z + 1.0, 'teeth')   # dientes inferiores
    pair(12.0, -1.8, 1.4, 14.6, 2.4, 5.4, 'scale')                         # bisagra de la mandibula
    pair(11.8, 14.8, 9.5, 14.6, 17.8, 13.5, 'horn')                        # cuernos en escalera hacia atras
    pair(12.2, 16.8, 13.0, 14.3, 19.2, 16.4, 'horn')
    pair(12.5, 18.4, 16.0, 14.0, 20.2, 19.8, 'horn')
    pair(12.8, 19.6, 19.2, 13.8, 21.0, 22.4, 'horn')
    for k, z in enumerate((6.0, 9.5, 13.0)): add(7.2, 17.4 - k * 0.5, z, 8.8, 20.2 - k * 0.9, z + 2.0, 'spike')   # cresta
    add(2.0, 2.6, 17.2, 14.0, 15.6, 18.2, 'membrane')                      # volante del cuello
    for x in (2.6, 5.2, 7.8, 10.4, 12.6): add(x, 15.6, 17.2, x + 1.0, 17.6, 18.2, 'spike')
    return L

def helm_model(el, pal):
    import json as _json
    cubes = helm_cubes()
    sz = lambda c, k: max(1, math.ceil(c['t'][k] - c['f'][k]))
    cs = [C(0, 0, 0, sz(c, 0), sz(c, 1), sz(c, 2), c['mat'], c['faces']) for c in cubes]
    parts = [Part('h', None, (0, 0, 0), cubes=cs)]
    size, pos = pack(parts)
    name = el + '_dragon_helm'
    paint(parts, size, pos, pal, name, sub='item')
    elements = []
    for c, cc in zip(cubes, cs):
        u, v = pos[ckey(cc)]; w, h, d = cc['s']
        rect = lambda x0, y0, x1, y1: {'uv': [x0, y0, x1, y1], 'texture': '#0'}
        faces = {'north': rect(u + d, v + d, u + d + w, v + d + h), 'south': rect(u + 2 * d + w, v + d, u + 2 * d + 2 * w, v + d + h),
                 'east': rect(u + d + w, v + d, u + 2 * d + w, v + d + h), 'west': rect(u, v + d, u + d, v + d + h),
                 'up': rect(u + d, v, u + d + w, v + d), 'down': rect(u + d + w, v, u + 2 * d + w, v + d)}
        elements.append({'from': list(c['f']), 'to': list(c['t']), 'faces': faces})
    model = {'texture_size': [size, size], 'textures': {'0': 'emberwyrms:item/' + name, 'particle': 'emberwyrms:item/' + name},
             'elements': elements,
             'display': {'head': {'rotation': [0, 0, 0], 'translation': [0, 0, 0], 'scale': [1, 1, 1]},
                         'gui': {'rotation': [22, 195, 0], 'translation': [0, -1, 0], 'scale': [0.55, 0.55, 0.55]},
                         'fixed': {'rotation': [0, 180, 0], 'translation': [0, 0, 0], 'scale': [0.6, 0.6, 0.6]},
                         'ground': {'rotation': [0, 0, 0], 'translation': [0, 2, 0], 'scale': [0.45, 0.45, 0.45]},
                         'thirdperson_righthand': {'rotation': [0, 0, 0], 'translation': [0, 3, 1], 'scale': [0.4, 0.4, 0.4]},
                         'firstperson_righthand': {'rotation': [0, 0, 0], 'translation': [0, 4, 2], 'scale': [0.4, 0.4, 0.4]}}}
    d = os.path.join(TEX, '..', 'models', 'item'); os.makedirs(d, exist_ok=True)
    _json.dump(model, open(os.path.join(d, el + '_dragon_helmet.json'), 'w'), indent=1)

def wings_texture(el, pal):
    """Alas de dragon sobre el modelo del elytro (region 10x20 en u=22,v=0; se usa la cara frontal y trasera)."""
    img = Image.new('RGBA', (64, 32), (0, 0, 0, 0)); px = img.load(); rng = random.Random(el + 'wings')
    bone, mem = shade(pal.get('bone', (90, 90, 90)), 1.15), pal['membrane']
    fingers = {1: 19, 4: 17, 8: 19}
    def membrane_bottom(i):
        f = min(fingers, key=lambda k: abs(k - i))
        return fingers[f] - int(2.4 * abs(i - f))
    def wing(x0, y0):
        for j in range(20):
            for i in range(10):
                col = None
                if j <= 1: col = shade(bone, 1.0 - 0.1 * j)
                elif i in fingers and j <= fingers[i]: col = shade(bone, 0.85 + 0.25 * ((j + i) % 2))
                elif j <= membrane_bottom(i):
                    col = shade(mem, 0.75 + 0.5 * vnoise(i, j, 4, 3)) if abs(vnoise(i, j, 3, 9) - 0.5) > 0.06 else shade(mem, 0.5)
                if i in fingers and j == fingers[i]: col = shade(pal.get('claw', (30, 30, 30)), 1.4)
                if col: px[x0 + i, y0 + j] = col + (255,)
    wing(24, 2); wing(36, 2)
    for yy in range(2, 22):
        px[22, yy] = px[23, yy] = bone + (255,); px[34, yy] = px[35, yy] = bone + (255,)
    for xx in range(24, 34): px[xx, 0] = px[xx, 1] = bone + (255,)
    d = os.path.join(TEX, 'entity', 'equipment', 'wings'); os.makedirs(d, exist_ok=True)
    img.save(os.path.join(d, el + '_dragon.png'))

def food_icon(name, kind, c1, c2):
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); d = ImageDraw.Draw(img); rng = random.Random(name)
    dk = shade(c1, 0.45)
    if kind == 'steak':
        d.ellipse([1, 4, 13, 13], fill=dk + (255,)); d.ellipse([2, 5, 12, 12], fill=c1 + (255,)); d.ellipse([3, 6, 8, 9], fill=shade(c1, 1.25) + (255,))
        for _ in range(7): d.point((rng.randint(3, 11), rng.randint(6, 11)), fill=c2 + (255,))
        d.rectangle([11, 10, 14, 12], fill=(236, 226, 200, 255)); d.rectangle([13, 9, 14, 13], fill=(236, 226, 200, 255))
    elif kind == 'fish':
        d.polygon([(1, 8), (5, 4), (11, 5), (13, 8), (11, 11), (5, 12)], fill=c1 + (255,))
        d.polygon([(12, 8), (15, 4), (15, 12)], fill=shade(c1, 0.72) + (255,))
        d.polygon([(5, 4), (8, 1), (10, 5)], fill=shade(c1, 0.8) + (255,))
        d.line([(3, 10), (11, 10)], fill=c2 + (255,)); d.point((3, 7), fill=(10, 10, 14, 255))
        for k in range(4): d.point((6 + k * 1, 6 + (k % 2)), fill=shade(c1, 1.3) + (255,))
    else:
        d.polygon([(1, 12), (4, 9), (14, 4), (15, 7), (5, 14)], fill=c1 + (255,))
        d.line([(3, 11), (13, 6)], fill=shade(c1, 1.3) + (255,))
        for _ in range(6): d.point((rng.randint(2, 14), rng.randint(3, 13)), fill=c2 + (255,))
    img.save(os.path.join(TEX, 'item', name + '.png'))

def book_icon():
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); d = ImageDraw.Draw(img)
    d.rectangle([2, 1, 13, 14], fill=(96, 58, 34, 255)); d.rectangle([3, 2, 12, 13], fill=(138, 86, 48, 255))
    d.rectangle([2, 1, 3, 14], fill=(70, 42, 26, 255)); d.rectangle([12, 2, 13, 13], fill=(226, 206, 160, 255))
    d.polygon([(5, 9), (8, 4), (11, 9), (8, 7)], fill=(236, 196, 76, 255)); d.point((8, 11), fill=(236, 196, 76, 255))
    img.save(os.path.join(TEX, 'item', 'bestiary.png'))

# =================================================================== ICONOS
def egg(name, c1, c2):
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load(); rng = random.Random(name)
    for y in range(16):
        for x in range(16):
            e = ((x - 7.5) / 5.4) ** 2 + ((y - 8.2) / 6.8) ** 2
            if e <= 1:
                px[x, y] = shade(c1, 0.55) + (255,) if e > 0.78 else (c1 + (255,))
                if e <= 0.78 and rng.random() < 0.16: px[x, y] = c2 + (255,)
    img.save(os.path.join(TEX, 'item', name + '.png'))

def emberscale():
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    for y in range(16):
        for x in range(16):
            d = abs(x - 7.5) / 5.5 + abs(y - 7.5) / 7
            if d <= 1:
                c = (200, 70, 28) if d > 0.8 else (238, 118, 34) if d > 0.45 else (255, 190, 70)
                px[x, y] = c + (255,)
    img.save(os.path.join(TEX, 'item', 'emberscale.png'))

if __name__ == '__main__':
    _p, _sz, _pos = build('AshwingModel', 'AshwingRenderState', ashwing(), ASH_PAL, 'ashwing', ASH_ANIM)
    build('PhoenixModel', 'PhoenixRenderState', phoenix(), PHX_PAL, 'phoenix', PHX_ANIM)
    egg('ashwing_spawn_egg', (62, 56, 60), (236, 96, 26)); egg('phoenix_spawn_egg', (220, 70, 30), (255, 200, 60))
    egg('medusa_spawn_egg', (52, 122, 64), (96, 44, 118)); emberscale()
    for el in ('fire', 'ice', 'storm', 'tide'):
        pl = ELPAL[el]
        egg(el + '_dragon_spawn_egg', pl['scale'], pl['ember']); scale_icon(el + '_dragon_scale', pl['scale'])
        eggblock(el + '_dragon_egg', pl['scale'], pl['ember'])
        equipment_textures(el, pl); helm_model(el, pl); wings_texture(el, pl)
        for piece in ('helmet', 'chestplate', 'leggings', 'boots'):
            armor_icon('%s_dragon_%s' % (el, piece), piece, pl)
    eggblock('phoenix_egg', (222, 72, 30), (255, 210, 70)); feather_icon()
    book_icon(); horn_icon(); heart_icon(); egg('ash_dragon_spawn_egg', (30, 28, 32), (255, 112, 24))
    food_icon('cinder_steak', 'steak', (150, 52, 30), (255, 170, 40)); food_icon('frost_fish', 'fish', (140, 196, 232), (240, 250, 255))
    food_icon('storm_jerky', 'jerky', (96, 70, 120), (255, 232, 90)); food_icon('tide_catch', 'fish', (36, 150, 150), (200, 250, 230))
