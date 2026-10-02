#!/usr/bin/env python3
"""Generador de modelos (Java) + texturas (PNG) de Emberwyrms.
Una sola fuente de verdad: las piezas se definen aqui, el UV se empaqueta
automaticamente y la textura se pinta con exactamente ese UV.
Uso:  python3 tools/generate.py      (desde la raiz del proyecto)"""
import os, zlib, math, random
from PIL import Image

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
    for size in (64, 128, 256):
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

def pixel(mat, i, j, w, h, face, pal, rng, seed):
    base = pal.get(mat, (0, 0, 0)); n = rng.uniform(-0.05, 0.05)
    if mat == 'scale':
        row = j // 3; xx = i + (row % 2) * 2
        lx, ly = xx % 4, j % 3
        cell = ((xx // 4) * 31 + row * 17 + seed) % 101
        c = shade(base, 0.86 + (cell % 9) * 0.03 + n)
        if face in ('front', 'back', 'left', 'right'):
            c = shade(c, 0.84 + 0.3 * j / max(1, h - 1))
        if lx == 3 or ly == 2:
            c = shade(c, 0.6)
            if 'ember' in pal and cell % 29 == 0: c = mix(c, pal['ember'], 0.8)
        elif lx == 0 and ly == 0: c = shade(c, 1.28)
        elif ly == 0: c = shade(c, 1.1)
        return c
    if mat == 'plate':
        c = shade(base, 0.97 + n); return shade(c, 0.7) if j % 3 == 2 else c
    if mat == 'horn':
        t = j / max(1, h - 1); c = mix(base, shade(base, 0.5), t * 0.85)
        return shade(c, 0.88) if i % 3 == 0 else c
    if mat == 'membrane':
        c = shade(base, 0.93 + n * 2)
        if i % 6 == 0 or j % 7 == 0: c = shade(c, 0.6)
        if 'ember' in pal and j % 5 == 0: c = mix(c, pal['ember'], 0.18)
        return c
    if mat in ('bone', 'claw', 'teeth', 'beak', 'leg', 'gold', 'skin'):
        c = shade(base, 1 + n)
        return shade(c, 0.85) if (mat == 'gold' and (i + j) % 4 == 0) else c
    if mat == 'spike':
        return shade(base, 1.15 - 0.5 * j / max(1, h - 1) + n)
    if mat == 'eye': return base
    if mat == 'crystal':
        facet = (i * 3 + j * 2) % 5
        return shade(base, 0.82 + facet * 0.08 + n)
    if mat == 'feather':
        t = (i + j) / max(1, w + h); c = mix(pal['f_a'], pal['f_b'], t)
        return shade(c, 0.9 + n) if i % 2 == 0 else shade(c, 1.04 + n)
    if mat == 'feather_tail':
        t = (i + j) / max(1, w + h)
        c = mix(pal['f_a'], pal['f_b'], t * 2) if t < .5 else mix(pal['f_b'], pal['f_c'], (t - .5) * 2)
        return shade(c, 0.9 + n) if i % 2 == 0 else shade(c, 1.05 + n)
    if mat == 'flame':
        t = (i * 0.5 + j) / max(1, w * 0.5 + h); return shade(mix(pal['f_c'], pal['f_a'], t), 1 + n * 2)
    if mat == 'snake':
        c = shade(base, 1 + n)
        if (i + j) % 4 == 0 or (i - j) % 4 == 0: c = shade(c, 0.65)
        return c
    if mat == 'snake_head':
        c = shade(pal['snake'], 1.1 + n)
        if face == 'front' and j == 1 and i in (1, w - 2): return pal['eye']
        return c
    if mat == 'cloth':
        c = shade(base, 1 + n); return shade(c, 0.8) if (i % 2 == 0) ^ (j % 2 == 0) else c
    if mat == 'face':
        if face != 'front': return shade(pal['skin'], 1 + n)
        c = shade(pal['skin'], 1 + n * 2)
        if j == 2 and (1 <= i <= 2 or 5 <= i <= 6): return shade(pal['hair_dark'], 1)
        if j in (3, 4) and i in (1, 2, 5, 6): return pal['eye']
        if j == 5 and i in (3, 4): return shade(c, 0.8)
        if j == 6 and 2 <= i <= 5: return pal['hair_dark']
        if j == 6 and i in (2, 5): return pal['teeth']
        return c
    return (255, 0, 255)

def paint(parts, size, pos, pal, name):
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
    img.save(os.path.join(TEX, 'entity', name + '.png'))

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

# =================================================================== DRAGON V2 (realista)
HIND_L, HIND_A = (5.5, 6.5, 4.0), (-0.65, 0.55, -0.15)   # muslo, espinilla, metatarso / angulos absolutos
FORE_L, FORE_A = (5.0, 5.0, 3.0), (0.40, -0.45, 0.10)
HIP_REL_Y = 3.5
NECK_REL = (-0.45, -0.25, -0.05, 0.1, 0.2, 0.2)
FING_ANG = (0.30, 0.75, 1.15, 1.5)

def chain_drop(Ls, As, foot=1.0): return sum(L * math.cos(a) for L, a in zip(Ls, As)) + foot

def ashwing():
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    sides = (('l', 1), ('r', -1))
    body_abs = 24 - chain_drop(HIND_L, HIND_A) - HIP_REL_Y
    fore_hip = (24 - chain_drop(FORE_L, FORE_A)) - body_abs
    part('frame', None, (0, 24, 0))
    spikes = []
    for z, h in ((-10, 3), (-6, 2), (-2, 2), (2, 2), (6, 2), (10, 3)):
        top = 6.5 if z < -4 else 5.5
        spikes.append(C(-0.5, -top - h, z, 1, h, 2, 'spike'))
    part('body', 'frame', (0, body_abs - 24, 0), cubes=[
        C(-6, -6.5, -13, 12, 13, 9, 'scale', {'bottom': 'plate'}),
        C(-5, -5.5, -4, 10, 11, 8, 'scale', {'bottom': 'plate'}),
        C(-5.5, -5.5, 4, 11, 11, 8, 'scale', {'bottom': 'plate'})] + spikes)
    # cuello en S: 6 segmentos
    nw = (6, 6, 5, 5, 4, 4); prev = 'body'
    for k in range(6):
        w = nw[k]
        part('neck%d' % (k + 1), prev, (0, -4.5, -11) if k == 0 else (0, 0, -6), (NECK_REL[k], 0, 0), [
            C(-w / 2, -w / 2, -6, w, w, 6, 'scale', {'bottom': 'plate'}), C(-0.5, -w / 2 - 2, -5, 1, 2, 2, 'spike')])
        prev = 'neck%d' % (k + 1)
    # cabeza
    teeth = [C(x, 2.5, z, 1, 1, 1, 'teeth') for x in (-2.5, 1.5) for z in (-11, -8)] + \
            [C(x, 2, z, 1, 1, 1, 'teeth') for x in (-2, 1) for z in (-15, -13)]
    part('head', 'neck6', (0, 0, -6), (0.4, 0, 0), [
        C(-3.5, -3, -7, 7, 6, 7, 'scale'), C(-4, -4, -5, 8, 1, 3, 'scale'),
        C(-2.5, -1.5, -12, 5, 4, 5, 'scale', {'bottom': 'plate'}), C(-2, -1, -16, 4, 3, 4, 'scale'),
        C(-1.5, -1.5, -16.5, 1, 1, 1, 'claw'), C(0.5, -1.5, -16.5, 1, 1, 1, 'claw'),
        C(3.4, -2, -5, 1, 1, 2, 'eye'), C(-4.4, -2, -5, 1, 1, 2, 'eye'),
        C(3.5, -1, -2, 1, 2, 3, 'spike'), C(-4.5, -1, -2, 1, 2, 3, 'spike'),
        C(-0.5, -5, -5, 1, 2, 4, 'spike')] + teeth)
    part('jaw', 'head', (0, 2, -0.5), cubes=[C(-2.5, 0, -14, 5, 2, 13, 'scale', {'top': 'plate'}),
        C(-2, -1, -14, 1, 1, 1, 'teeth'), C(1, -1, -14, 1, 1, 1, 'teeth'), C(-2, -1, -10, 1, 1, 1, 'teeth'),
        C(1, -1, -10, 1, 1, 1, 'teeth'), C(-0.5, 2, -13, 1, 2, 1, 'spike')])
    for lr, sg in sides:
        part('horn_' + lr, 'head', (2.5 * sg, -3, -1), (0.2, 0.28 * sg, 0), [C(-1, -1, 0, 2, 2, 6, 'horn')])
        part('horn_%s_2' % lr, 'horn_' + lr, (0, 0, 6), (0.1, 0.12 * sg, 0), [C(-1, -0.5, 0, 2, 1, 6, 'horn')])
        part('horn_%s_3' % lr, 'horn_%s_2' % lr, (0, 0, 6), (0.2, 0.05 * sg, 0), [C(-0.5, -0.5, 0, 1, 1, 5, 'horn')])
        part('brow_' + lr, 'head', (3 * sg, -4, -4), (0.25, -0.35 * sg, 0), [C(-0.5, -0.5, -4, 1, 1, 4, 'horn')])
    # cola: 9 segmentos + punta
    tw = (8, 7, 7, 6, 6, 5, 4, 3, 2); th = (8, 7, 6, 6, 5, 4, 3, 3, 2); prev = 'body'
    for k in range(9):
        cubes = [C(-tw[k] / 2, -th[k] / 2, 0, tw[k], th[k], 6, 'scale', {'bottom': 'plate'})]
        if k < 8: cubes.append(C(-0.5, -th[k] / 2 - 2, 1, 1, 2, 3, 'spike'))
        part('tail%d' % (k + 1), prev, (0, -0.5, 11) if k == 0 else (0, 0, 6), cubes=cubes)
        prev = 'tail%d' % (k + 1)
    part('tail_tip', 'tail9', (0, 0, 6), cubes=[C(-0.5, -4, 0, 1, 8, 6, 'horn'), C(-4, -0.5, 1, 8, 1, 4, 'horn')])
    # alas enormes con 4 dedos y membrana en paneles
    lens, gaps = (22, 20, 16, 12), (0.45, 0.4, 0.35, 0.3)
    for lr, sg in sides:
        ox = lambda x0, ln: x0 if sg > 0 else -(x0 + ln)
        part('wing_' + lr, 'body', (5.5 * sg, -5.5, -8), cubes=[C(ox(0, 5), -2.5, -2.5, 5, 5, 5, 'scale')])
        part('arm_' + lr, 'wing_' + lr, (4 * sg, 0, 0), cubes=[C(ox(0, 9), -2, -2, 9, 4, 4, 'scale'),
             C(ox(0, 9), -0.5, 2, 9, 1, 16, 'membrane', dil=(0, -0.25, 0))])
        part('fore_' + lr, 'arm_' + lr, (9 * sg, 0, 0), cubes=[C(ox(0, 12), -1.5, -1.5, 12, 3, 3, 'scale'),
             C(ox(0, 12), -0.5, 1.5, 12, 1, 10, 'membrane', dil=(0, -0.25, 0)), C(ox(0, 1), -1, -4, 1, 1, 4, 'claw')])
        for k in range(4):
            L = lens[k]; seg = L // 3; x0 = 0
            cubes = [C(ox(0, L), -0.5, -0.5, L, 1, 1, 'bone')]
            for q in range(3):
                ln = seg if q < 2 else L - 2 * seg
                wd = max(2, int((x0 + ln / 2) * gaps[k]))
                cubes.append(C(ox(x0, ln), -0.5, 0.5, ln, 1, wd, 'membrane', dil=(0, -0.25, 0)))
                x0 += ln
            part('f%d_%s' % (k + 1, lr), 'fore_' + lr, (12 * sg, 0, 0), (0, -FING_ANG[k] * sg, 0), cubes)
    # patas digitigradas (4 tramos: muslo, espinilla, metatarso, pie)
    for n, sx, z, hind in (('fl', 1, -9, False), ('fr', -1, -9, False), ('bl', 1, 8, True), ('br', -1, 8, True)):
        Ls, As = (HIND_L, HIND_A) if hind else (FORE_L, FORE_A)
        hy = HIP_REL_Y if hind else fore_hip
        up = [C(-2.5, -1.5, -2.5, 5, math.ceil(Ls[0]) + 2, 5, 'scale'), C(-3, -3, -3.5, 6, 6, 7, 'scale')] if hind else \
             [C(-2, -1.5, -2, 4, math.ceil(Ls[0]) + 2, 4, 'scale'), C(-2.5, -2.5, -3, 5, 5, 6, 'scale')]
        part('leg_' + n, 'body', ((5 if hind else 5.5) * sx, hy, z), (As[0], 0, 0), up)
        part('shin_' + n, 'leg_' + n, (0, Ls[0], 0), (As[1] - As[0], 0, 0), [C(-1.5, -1, -1.5, 3, math.ceil(Ls[1]) + 1, 3, 'scale')])
        part('meta_' + n, 'shin_' + n, (0, Ls[1], 0), (As[2] - As[1], 0, 0), [C(-1, -0.5, -1, 2, math.ceil(Ls[2]) + 1, 2, 'scale')])
        part('foot_' + n, 'meta_' + n, (0, Ls[2], 0), (-As[2], 0, 0), [C(-2, -1, -6, 4, 2, 7, 'scale'),
             C(-2, -0.5, -8, 1, 1, 2, 'claw'), C(-0.5, -0.5, -8, 1, 1, 2, 'claw'), C(1, -0.5, -8, 1, 1, 2, 'claw')])
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
        this.jaw.pitch = s.breathing ? 0.85f : 0.05f + (breathe + 1f) * 0.04f;

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

ASH_PAL = dict(scale=(62, 56, 60), plate=(152, 122, 96), horn=(196, 180, 154), membrane=(104, 40, 34),
               bone=(74, 66, 64), claw=(30, 28, 30), eye=(255, 176, 40), teeth=(228, 218, 196),
               spike=(96, 78, 76), ember=(236, 96, 26))

# =================================================================== PHOENIX
def phoenix():
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    part('body', None, (0, 16, 0), cubes=[C(-3, -3, -6, 6, 6, 10, 'feather'), C(-2.5, -2, -8, 5, 5, 2, 'feather')])
    part('neck', 'body', (0, -1, -6), (-0.5, 0, 0), [C(-1.5, -1.5, -5, 3, 3, 6, 'feather')])
    part('head', 'neck', (0, 0, -5), (0.5, 0, 0), [C(-2, -2, -4, 4, 4, 4, 'feather'),
         C(-1, -0.5, -7, 2, 1, 3, 'beak'), C(-1, 0.5, -6, 2, 1, 2, 'beak'),
         C(1.7, -1.2, -3, 1, 1, 1, 'eye'), C(-2.7, -1.2, -3, 1, 1, 1, 'eye')])
    for k, (pt, yw, ln) in enumerate(((0.9, 0, 7), (0.7, 0.35, 5), (0.7, -0.35, 5))):
        part('crest_%d' % k, 'head', (0, -2, -1), (pt, yw, 0), [C(-0.5, -0.5, 0, 1, 1, ln, 'flame')])
    for lr, s in (('l', 1), ('r', -1)):
        ox = lambda L: 0 if s > 0 else -L
        part('wing_' + lr, 'body', (3 * s, -2, -2), cubes=[C(ox(6), -0.5, -1.5, 6, 1, 3, 'feather'), C(ox(6), -0.5, 1.5, 6, 1, 6, 'feather')])
        part('wing_out_' + lr, 'wing_' + lr, (6 * s, 0, 0), cubes=[C(ox(6), -0.5, -1.5, 6, 1, 3, 'feather'), C(ox(6), -0.5, 1.5, 6, 1, 5, 'feather')])
        for k, ln in enumerate((12, 11, 9, 7)):
            part('prim_%d_%s' % (k, lr), 'wing_out_' + lr, (0, 0, 0), (0, -(0.05 + 0.2 * k) * s, 0), [C(ox(ln), -0.5, -1 + k * 0.5, ln, 1, 3, 'feather')])
        part('leg_' + lr, 'body', (1.5 * s, 3, 0), cubes=[C(-1, 0, -1, 2, 3, 2, 'leg')])
        part('shin_' + lr, 'leg_' + lr, (0, 3, 0), cubes=[C(-0.5, 0, -0.5, 1, 2, 1, 'leg')])
        part('foot_' + lr, 'shin_' + lr, (0, 2, 0), cubes=[C(-1.5, -1, -3, 1, 1, 3, 'leg'), C(-0.5, -1, -3, 1, 1, 3, 'leg'),
             C(0.5, -1, -3, 1, 1, 3, 'leg'), C(-0.5, -1, 0, 1, 1, 2, 'leg')])
    part('tail', 'body', (0, -1, 4))
    for k, ln in enumerate((12, 15, 18, 15, 12)):
        part('tail_%d' % k, 'tail', (0, 0, 0), (-0.12, (k - 2) * 0.28, 0), [C(-1, -0.5, 0, 2, 1, ln, 'feather_tail')])
    return P

PHX_ANIM = '''    @Override
    public void setAngles(PhoenixRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.5f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.neck.pitch = -0.5f;
        this.head.pitch = 0.5f + pitchLook * 0.5f;
        this.head.yaw = yawLook * 0.6f;
        float[] crestYaw = {0f, 0.35f, -0.35f};
        ModelPart[] crest = {crest0, crest1, crest2};
        for (int i = 0; i < 3; i++) {
            crest[i].pitch = 0.7f + sin(t * 0.2f + i) * 0.12f;
            crest[i].yaw = crestYaw[i] + sin(t * 0.17f + i * 2f) * 0.08f;
        }

        ModelPart[] primL = {prim0L, prim1L, prim2L, prim3L};
        ModelPart[] primR = {prim0R, prim1R, prim2R, prim3R};
        float[] py = {-0.05f, -0.25f, -0.45f, -0.65f};
        float spread;
        if (s.flying) {
            float flap = sin(t * 0.9f);
            spread = 1f;
            this.body.pitch = 0.1f;
            this.wingL.yaw = 0f; this.wingR.yaw = 0f; this.wingOutL.yaw = 0f; this.wingOutR.yaw = 0f;
            this.wingL.roll = -flap * 0.9f;  this.wingR.roll = flap * 0.9f;
            this.wingOutL.roll = -flap * 0.5f - 0.1f;  this.wingOutR.roll = flap * 0.5f + 0.1f;
            this.legL.pitch = 0.9f; this.legR.pitch = 0.9f;
            this.shinL.pitch = 0.7f; this.shinR.pitch = 0.7f;
        } else {
            spread = 0.3f;
            this.body.pitch = 0f;
            this.wingL.yaw = -0.7f;  this.wingR.yaw = 0.7f;
            this.wingL.roll = 0.5f;  this.wingR.roll = -0.5f;
            this.wingOutL.yaw = -1.1f; this.wingOutR.yaw = 1.1f;
            this.wingOutL.roll = 0f; this.wingOutR.roll = 0f;
            float sw = cos(f) * 0.9f * amp;
            this.legL.pitch = sw; this.legR.pitch = -sw;
            this.shinL.pitch = 0f; this.shinR.pitch = 0f;
        }
        for (int i = 0; i < 4; i++) {
            primL[i].yaw = py[i] * spread;
            primR[i].yaw = -py[i] * spread;
        }
        ModelPart[] tf = {tail0, tail1, tail2, tail3, tail4};
        for (int i = 0; i < 5; i++) {
            tf[i].yaw = (i - 2) * 0.28f * (s.flying ? 1.15f : 0.8f) + sin(t * 0.12f + i) * 0.05f;
            tf[i].pitch = -0.12f + (s.flying ? sin(t * 0.9f) * 0.08f : 0f);
        }
    }'''

PHX_PAL = dict(feather=(0, 0, 0), f_a=(206, 40, 24), f_b=(255, 150, 30), f_c=(255, 232, 140),
               beak=(240, 176, 48), eye=(255, 250, 170), leg=(196, 138, 46))
PHX_PAL['feather'] = (220, 70, 30)
PHX_PAL.update(flame=(255, 200, 60))

# =================================================================== MEDUSA
def medusa():
    P = []
    def part(*a, **k): P.append(Part(*a, **k))
    part('coil1', None, (0, 20, 2), cubes=[C(-5, -4, -5, 10, 8, 10, 'scale')])
    part('coil2', 'coil1', (0, 0, 5), (0, 0.25, 0), [C(-4, -3.5, 0, 8, 7, 7, 'scale')])
    part('coil3', 'coil2', (0, 0, 7), (0, 0.25, 0), [C(-3, -3, 0, 6, 6, 7, 'scale')])
    part('coil4', 'coil3', (0, 0, 7), (0, 0.25, 0), [C(-2.5, -2.5, 0, 5, 5, 7, 'scale')])
    part('coil5', 'coil4', (0, 0, 7), (0, 0.25, 0), [C(-1.5, -1.5, 0, 3, 3, 7, 'scale')])
    part('coil6', 'coil5', (0, 0, 7), (0, 0.25, 0), [C(-1, -1, 0, 2, 2, 6, 'scale')])
    part('torso', None, (0, 16, -1), cubes=[C(-4, -12, -2.5, 8, 12, 5, 'skin'),
         C(-4.5, -11, -3, 9, 4, 6, 'cloth'), C(-4.5, -2, -3, 9, 2, 6, 'gold')])
    part('head', 'torso', (0, -12, 0), cubes=[C(-4, -8, -4, 8, 8, 8, 'face'), C(-4.5, -7, -4.5, 9, 1, 9, 'gold')])
    for lr, s in (('l', 1), ('r', -1)):
        part('arm_' + lr, 'torso', (5.5 * s, -11, 0), cubes=[C(-1.5, -1, -1.5, 3, 10, 3, 'skin'), C(-2, 5, -2, 4, 2, 4, 'gold'),
             C(-1.5, 9, -1.5, 3, 2, 3, 'skin'), C(-1.5, 11, -1.5, 1, 2, 1, 'claw'), C(-0.5, 11, -1.5, 1, 2, 1, 'claw'), C(0.5, 11, -1.5, 1, 2, 1, 'claw')])
    dirs = []
    for k in range(8):
        a = k * math.pi / 4; dx, dz = math.cos(a), math.sin(a); dirs.append((dx, dz))
        part('snake%d' % k, 'head', (3 * dx, -7.5, 3 * dz), (-0.6 * dz, 0, 0.6 * dx), [C(-0.5, -4, -0.5, 1, 4, 1, 'snake')])
        part('snake%d_b' % k, 'snake%d' % k, (0, -4, 0), (-0.4 * dz, 0, 0.4 * dx), [C(-0.5, -4, -0.5, 1, 4, 1, 'snake')])
        part('snake%d_h' % k, 'snake%d_b' % k, (0, -4, 0), cubes=[C(-1, -2, -1.5, 2, 2, 3, 'snake_head')])
    global MED_DIRS; MED_DIRS = dirs
    return P

def med_anim():
    bx = ', '.join(fm(d[0]) for d in MED_DIRS); bz = ', '.join(fm(d[1]) for d in MED_DIRS)
    return '''    private static final float[] SNAKE_DX = {%s};
    private static final float[] SNAKE_DZ = {%s};

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
        this.torso.yaw = sin(t * 0.06f) * 0.05f + cos(f) * 0.15f * amp;

        float sw = 0.1f + 0.25f * amp;
        float sp = t * 0.07f + f * 0.5f;
        this.coil1.yaw = sin(sp) * sw;
        ModelPart[] coil = {coil2, coil3, coil4, coil5, coil6};
        for (int i = 0; i < coil.length; i++) {
            coil[i].yaw = 0.25f + sin(sp - 0.7f * (i + 1)) * (sw + 0.08f * i);
        }

        this.armL.pitch = -0.2f + cos(f) * 0.5f * amp;
        this.armR.pitch = -0.2f - cos(f) * 0.5f * amp;
        this.armL.roll = -0.12f + sin(t * 0.05f) * 0.03f;
        this.armR.roll = 0.12f - sin(t * 0.05f) * 0.03f;

        ModelPart[] a = {snake0, snake1, snake2, snake3, snake4, snake5, snake6, snake7};
        ModelPart[] b = {snake0B, snake1B, snake2B, snake3B, snake4B, snake5B, snake6B, snake7B};
        for (int i = 0; i < 8; i++) {
            float w = sin(t * 0.15f + i * 1.3f);
            a[i].roll = 0.6f * SNAKE_DX[i] + w * 0.22f;
            a[i].pitch = -0.6f * SNAKE_DZ[i] + sin(t * 0.13f + i) * 0.18f;
            b[i].roll = 0.4f * SNAKE_DX[i] + sin(t * 0.17f + i * 0.9f) * 0.3f;
            b[i].pitch = -0.4f * SNAKE_DZ[i] + cos(t * 0.15f + i) * 0.25f;
        }
    }''' % (bx, bz)

MED_PAL = dict(scale=(52, 122, 64), skin=(112, 164, 92), cloth=(96, 44, 118), gold=(224, 184, 64),
               snake=(66, 140, 62), eye=(232, 255, 70), hair_dark=(30, 60, 34), teeth=(240, 240, 220), claw=(40, 34, 40),
               ember=(0, 0, 0))


# =================================================================== DRAGONES ELEMENTALES
def elemental(el):
    P = ashwing()
    def part(*a, **k): P.append(Part(*a, **k))
    sides = (('l', 1), ('r', -1))
    ox = lambda sg, L: 0 if sg > 0 else -L
    if el == 'fire':
        for lr, sg in sides:
            part('fbrow_' + lr, 'head', (2.5 * sg, -4, -6), (0.15, -0.35 * sg, 0), [C(-0.5, -0.5, -6, 1, 1, 6, 'horn')])
        part('tail_flame', 'tail_tip', (0, 0, 6), cubes=[C(-0.5, -3, 0, 1, 6, 6, 'flame'), C(-2.5, -0.5, 0, 5, 1, 4, 'flame')])
        for k in range(3):
            part('ember_%d' % k, 'body', (0, -6, -8 + k * 8), cubes=[C(-1, -5, -1, 2, 4, 2, 'flame')])
    elif el == 'ice':
        for k, z in enumerate((-10, -5, 0, 5, 10)):
            part('crystal_%d' % k, 'body', (0, -6, z), cubes=[C(-1, -7 - (k % 2) * 2, -1, 2, 7 + (k % 2) * 2, 2, 'crystal')])
        for lr, sg in sides:
            part('crown_' + lr, 'head', (2 * sg, -3, -2), (-0.3, 0, 0.3 * sg), [C(-0.5, -6, -0.5, 1, 6, 1, 'crystal')])
        part('tail_crystal', 'tail_tip', (0, 0, 6), cubes=[C(-1, -5, 0, 2, 10, 2, 'crystal'), C(-4, -1, 0, 8, 2, 2, 'crystal')])
    elif el == 'storm':
        for lr, sg in sides:
            part('antler_' + lr, 'head', (2.5 * sg, -3, -2), (0.9, 0.35 * sg, 0), [C(-0.5, -0.5, 0, 1, 1, 6, 'horn')])
            part('antler_%s_a' % lr, 'antler_' + lr, (0, 0, 6), (-0.5, 0, 0), [C(-0.5, -0.5, 0, 1, 1, 5, 'horn')])
            part('antler_%s_b' % lr, 'antler_' + lr, (0, 0, 3), (0.2, 0.7 * sg, 0), [C(-0.5, -0.5, 0, 1, 1, 5, 'horn')])
        part('bolt_a', 'tail_tip', (0, 0, 6), (0, 0.6, 0), [C(-0.5, -0.5, 0, 1, 1, 6, 'spike')])
        part('bolt_b', 'bolt_a', (0, 0, 6), (0, -1.2, 0), [C(-0.5, -0.5, 0, 1, 1, 6, 'spike')])
        for k, z in enumerate((-10, -4, 3, 9)):
            part('spark_%d' % k, 'body', (0, -6, z), cubes=[C(-1, -6, -1, 2, 6, 2, 'spike')])
    else:
        for lr, sg in sides:
            part('ear_fin_' + lr, 'head', (3.5 * sg, -1, -2), (0, -0.6 * sg, 0), [C(ox(sg, 6), -3, -0.5, 6, 5, 1, 'membrane', dil=(0, 0, -0.25))])
        part('dorsal_fin', 'body', (0, -6, -8), cubes=[C(-0.5, -8, 0, 1, 8, 14, 'membrane', dil=(-0.25, 0, 0))])
        part('tail_fin', 'tail5', (0, 0, 2), cubes=[C(-0.5, -6, 0, 1, 12, 8, 'membrane', dil=(-0.25, 0, 0))])
    return P

def pal(**kw):
    d = dict(ASH_PAL); d.update(kw); return d
ELPAL = {
    'fire': pal(scale=(140, 34, 26), plate=(224, 140, 52), horn=(52, 38, 36), membrane=(176, 58, 26), bone=(66, 40, 36), claw=(28, 24, 26),
                eye=(255, 236, 90), teeth=(240, 226, 200), spike=(60, 44, 40), ember=(255, 170, 40), f_a=(226, 66, 22), f_c=(255, 222, 90)),
    'ice': pal(scale=(120, 168, 204), plate=(226, 240, 250), horn=(205, 232, 247), membrane=(96, 150, 200), bone=(110, 150, 180), claw=(60, 80, 100),
               eye=(130, 245, 255), teeth=(245, 250, 255), spike=(190, 230, 250), ember=(230, 250, 255), crystal=(170, 225, 250)),
    'storm': pal(scale=(64, 72, 122), plate=(196, 198, 232), horn=(232, 214, 96), membrane=(52, 58, 108), bone=(60, 66, 100), claw=(36, 36, 60),
                 eye=(255, 250, 120), teeth=(240, 240, 230), spike=(250, 226, 84), ember=(255, 244, 120)),
    'tide': pal(scale=(34, 116, 146), plate=(188, 226, 210), horn=(232, 226, 200), membrane=(44, 156, 176), bone=(50, 110, 130), claw=(30, 60, 70),
                eye=(190, 255, 230), teeth=(240, 248, 240), spike=(58, 168, 190), ember=(150, 240, 230)),
}
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

def armor_icon(name, piece, pal):
    rows = [r.ljust(16, '.') for r in MASKS[piece]] + ['.' * 16] * (16 - len(MASKS[piece]))
    img = Image.new('RGBA', (16, 16), (0, 0, 0, 0)); px = img.load()
    on = lambda x, y: 0 <= x < 16 and 0 <= y < 16 and rows[y][x] == '#'
    for y in range(16):
        for x in range(16):
            if not on(x, y): continue
            edge = not (on(x - 1, y) and on(x + 1, y) and on(x, y - 1) and on(x, y + 1))
            c = pal['scale']
            if edge: c = shade(c, 0.45)
            elif not on(x, y - 1) or not on(x - 1, y): c = shade(c, 1.3)
            elif (x + y) % 4 == 0: c = shade(c, 0.8)
            elif (x * 3 + y) % 9 == 0: c = pal['ember']
            px[x, y] = c + (255,)
    img.save(os.path.join(TEX, 'item', name + '.png'))

def equipment_textures(el, pal):
    for layer in ('humanoid', 'humanoid_leggings'):
        d = os.path.join(TEX, 'entity', 'equipment', layer); os.makedirs(d, exist_ok=True)
        img = Image.new('RGBA', (64, 32)); px = img.load(); rng = random.Random(el + layer)
        for y in range(32):
            for x in range(64):
                px[x, y] = pixel('scale', x, y, 64, 32, 'front', pal, rng, 7) + (255,)
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
    build('AshwingModel', 'AshwingRenderState', ashwing(), ASH_PAL, 'ashwing', ASH_ANIM)
    build('PhoenixModel', 'PhoenixRenderState', phoenix(), PHX_PAL, 'phoenix', PHX_ANIM)
    mp = medusa()
    build('MedusaModel', 'MedusaRenderState', mp, MED_PAL, 'medusa', med_anim())
    egg('ashwing_spawn_egg', (62, 56, 60), (236, 96, 26)); egg('phoenix_spawn_egg', (220, 70, 30), (255, 200, 60))
    egg('medusa_spawn_egg', (52, 122, 64), (96, 44, 118)); emberscale()
    for el in ('fire', 'ice', 'storm', 'tide'):
        build(CAP[el] + 'DragonModel', 'AshwingRenderState', elemental(el), ELPAL[el], el + '_dragon', ASH_ANIM)
        pl = ELPAL[el]
        egg(el + '_dragon_spawn_egg', pl['scale'], pl['ember']); scale_icon(el + '_dragon_scale', pl['scale'])
        eggblock(el + '_dragon_egg', pl['scale'], pl['ember'])
        equipment_textures(el, pl)
        for piece in ('helmet', 'chestplate', 'leggings', 'boots'):
            armor_icon('%s_dragon_%s' % (el, piece), piece, pl)
    eggblock('phoenix_egg', (222, 72, 30), (255, 210, 70)); feather_icon()
