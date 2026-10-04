#!/usr/bin/env python3
"""Convierte los modelos de Blockbench (tools/models/*/model.gltf) en clases de modelo Java + atlas de textura.
Cada modelo declara que huesos hacen de cabeza, mandibula, cuello, cola, patas y alas; la animacion se genera por roles."""
import os, sys, json, math
import numpy as np
HERE = os.path.dirname(os.path.abspath(__file__)); ROOT = os.path.dirname(HERE)
sys.path.insert(0, HERE)
import generate as G
import import_gltf as I

AN = G.fm
LEG_A = 'A'; LEG_B = 'B'

CFG = {
 'fire': dict(cls='FireDragonModel', tex='fire_dragon', state='AshwingRenderState', flags=True,
    head='head', jaw='jaw', neck=['neck', 'neck2', 'neck3', 'neck4', 'neck5'], tail=['tail', 'tail2', 'tail3', 'tail4', 'tail5'],
    wings=[['wing', 'wingtip'], ['wing1', 'wingtip1']],
    legs=[(['frontleg', 'frontlegtip', 'frontfoot'], 'A'), (['frontleg1', 'frontlegtip1', 'frontfoot1'], 'B'),
          (['rearleg', 'rearlegtip', 'rearfoot'], 'B'), (['rearleg1', 'rearlegtip1', 'rearfoot1'], 'A')],
    fold=[(1.25, -0.5), (0.9, -0.8)]),
 'tide': dict(cls='TideDragonModel', tex='tide_dragon', state='AshwingRenderState', flags=True,
    head='head', jaw=None, neck=[], tail=[], wings=[], legs=[], whole='corpo', fold=[]),
 'storm': dict(cls='StormDragonModel', tex='storm_dragon', state='AshwingRenderState', flags=True,
    head='head', jaw='jaw', neck=['neck'], tail=['tail1', 'tail2'],
    wings=[['lefthumerus', 'leftradiusulna'], ['righthumerus', 'rightradiusulna']],
    legs=[(['leftfemur', 'lefttibia'], 'A'), (['rightfemur', 'righttibia'], 'B')],
    fold=[(1.0, -0.6), (0.8, -0.8)]),
 'ash': dict(cls='AshBossModel', tex='ash_dragon', state='AshwingRenderState', flags=True,
    head='head', jaw=None, neck=['neck'], tail=['tail'],
    wings=[['wing_left'], ['wing_right']],
    legs=[(['leg'], 'A'), (['leg2'], 'B'), (['leg3'], 'B'), (['leg4'], 'A')],
    fold=[(0.9, -0.4)]),
 'ice': dict(cls='IceDragonModel', tex='ice_dragon', state='AshwingRenderState', flags=True,
    head='main_head', jaw='lowerjaw', neck=['neckhead'], tail=['tail', 'tail4', 'tail5'],
    wings=[['wing', 'left_wing'], ['right_wing']],
    legs=[(['rearleg2', 'rearlegtip2'], 'A'), (['rearleg3', 'rearlegtip3'], 'B')],
    fold=[(0.9, -0.4), (0.6, -0.6)]),
 'medusa': dict(cls='MedusaModel', tex='medusa', state='MedusaRenderState', flags=False,
    head='head', jaw=None, neck=[], tail=['tail'], wings=[], legs=[], snakes=['p1r', 'p2r', 'p3r', 'p4r', 'p5r', 'p1l', 'p2l', 'p3l', 'p4l', 'p5l'],
    fold=[]),
}

def J(n): return G.jname(n)

def anim_java(cfg, parts):
    by = {p.name: p for p in parts}
    use = {}   # parte -> {'pitch':[expr], 'yaw':[], 'roll':[]}
    def add(name, axis, expr):
        if name is None or name not in by: return
        use.setdefault(name, {'pitch': [], 'yaw': [], 'roll': []})[axis].append(expr)
    fl = cfg['flags']
    head, jaw = cfg.get('head'), cfg.get('jaw')
    add(head, 'yaw', 'yawLook * 0.6f'); add(head, 'pitch', 'pitchLook * 0.6f - breath * 0.25f')
    add(jaw, 'pitch', 'breath * 0.8f + 0.08f + (sin(t * 0.09f) + 1f) * 0.03f')
    for i, n in enumerate(cfg.get('neck', [])):
        add(n, 'yaw', 'sin(t * 0.05f - %df * 0.5f) * 0.05f + yawLook * 0.12f' % i)
        add(n, 'pitch', 'sin(t * 0.07f - %df * 0.6f) * 0.03f + (fly ? 0.04f : 0f)' % i)
    for i, n in enumerate(cfg.get('tail', [])):
        add(n, 'yaw', 'sin(t * 0.06f - %df * 0.6f) * %s + cos(f) * 0.05f * amp' % (i, AN(0.07 + 0.018 * i)))
    for chain, grp in cfg.get('legs', []):
        sw = 'swA' if grp == 'A' else 'swB'; lf = 'liftA' if grp == 'A' else 'liftB'
        if len(chain) >= 1: add(chain[0], 'pitch', '%s * 0.55f + (fly ? 0.6f : 0f)' % sw)
        if len(chain) >= 2: add(chain[1], 'pitch', '%s * 0.5f + (fly ? 0.6f : 0f)' % lf)
        if len(chain) >= 3: add(chain[2], 'pitch', '-%s * 0.3f' % lf)
    for chain in cfg.get('wings', []):
        root = by.get(chain[0]); sg = 1 if (root is not None and root.pivot[0] >= 0) else -1
        sgn = 'f' if sg > 0 else '-1f'
        sgs = '1f' if sg > 0 else '-1f'
        for k, n in enumerate(chain):
            fr, fy = (cfg['fold'][k] if k < len(cfg['fold']) else (0.0, 0.0))
            amp_fly = 0.8 if k == 0 else 0.4
            add(n, 'roll', '(fly ? -%s * flap * %s : %s * %s)' % (sgs, AN(amp_fly), sgs, AN(fr)))
            add(n, 'yaw', '(fly ? 0f : %s * %s)' % (sgs, AN(fy)))
    for i, n in enumerate(cfg.get('snakes', [])):
        add(n, 'roll', 'sin(t * 0.15f + %df * 1.3f) * 0.25f' % i); add(n, 'pitch', 'sin(t * 0.13f + %df) * 0.2f' % i)
    w = cfg.get('whole')
    if w:
        add(w, 'yaw', 'sin(t * 0.06f + f * 0.5f) * (0.04f + 0.08f * amp)'); add(w, 'roll', 'sin(t * 0.05f) * 0.02f')
    if cfg.get('tail') == ['tail'] and cfg['cls'] == 'MedusaModel':
        pass
    L = ['    // ---- posiciones de reposo de las piezas animadas']
    for n in use:
        r = by[n].rot
        L.append('    private static final float %s_P = %s, %s_Y = %s, %s_R = %s;' % (J(n), AN(r[0]), J(n), AN(r[1]), J(n), AN(r[2])))
    L += ['', '    @Override', '    public void setAngles(%s s) {' % cfg['state'], '        super.setAngles(s);',
          '        float t = s.age;', '        float f = s.walkPhase * 0.6662f;', '        float amp = Math.min(1f, s.walkSpeed * 1.6f);',
          '        float yawLook = s.relativeHeadYaw * 0.0174533f;', '        float pitchLook = s.pitch * 0.0174533f;',
          '        float swA = cos(f) * amp, swB = -swA;', '        float liftA = Math.max(0f, sin(f)) * amp, liftB = Math.max(0f, -sin(f)) * amp;']
    if fl:
        L += ['        boolean fly = s.flying;', '        float breath = s.breathing ? 1f : 0f;', '        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.03f;']
    else:
        L += ['        boolean fly = false;', '        float breath = 0f;', '        float flap = 0f;']
    for n, ax in use.items():
        for axis, key in (('pitch', 'P'), ('yaw', 'Y'), ('roll', 'R')):
            expr = ' + '.join('(%s)' % e for e in ax[axis]) if ax[axis] else '0f'
            L.append('        this.%s.%s = %s_%s + %s;' % (J(n), axis, J(n), key, expr))
    L.append('    }')
    return '\n'.join(L), list(use.keys())

def path_of(parts, name):
    by = {p.name: p for p in parts}; path = []
    n = name
    while n is not None:
        path.append(n); n = by[n].parent
    return list(reversed(path))

def emit_big(cfg, parts, size, pos, anim, animated):
    cls, state = cfg['cls'], cfg['state']
    L = ['package io.emberwyrms.client;', '', 'import java.util.HashMap;', 'import java.util.Map;']
    for imp in ('Dilation', 'ModelData', 'ModelPart', 'ModelPartBuilder', 'ModelPartData', 'ModelTransform', 'TexturedModelData'):
        L.append('import net.minecraft.client.model.%s;' % imp)
    L += ['import net.minecraft.client.render.entity.model.EntityModel;', '',
          '/** GENERADO por tools/gen_imports.py a partir de un modelo de Blockbench (ver CREDITS.md). No editar a mano. */',
          'public class %s extends EntityModel<%s> {' % (cls, state)]
    for n in animated: L.append('    private final ModelPart %s;' % J(n))
    L += ['', '    public %s(ModelPart root) {' % cls, '        super(root);']
    for n in animated:
        path = path_of(parts, n)
        L.append('        this.%s = root%s;' % (J(n), ''.join('.getChild("%s")' % p for p in path)))
    L += ['    }', '', '    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {',
          '        m.put(name, m.get(parent).addChild(name, b, t));', '    }', '',
          '    public static TexturedModelData getTexturedModelData() {', '        ModelData data = new ModelData();',
          '        Map<String, ModelPartData> m = new HashMap<>();', '        m.put("", data.getRoot());']
    chunks = [parts[i:i + 30] for i in range(0, len(parts), 30)]
    for k in range(len(chunks)): L.append('        part%d(m);' % k)
    L += ['        return TexturedModelData.of(data, %d, %d);' % (size, size), '    }', '']
    for k, ch in enumerate(chunks):
        L.append('    private static void part%d(Map<String, ModelPartData> m) {' % k)
        for p in ch:
            b = 'ModelPartBuilder.create()'
            for c in p.cubes:
                u, v = pos[G.ckey(c)]; o, s = c['o'], c['s']
                args = ', '.join(AN(x) for x in (*o, *s))
                if c['dil']: args += ', new Dilation(%s)' % ', '.join(AN(x) for x in c['dil'])
                b += '.uv(%d, %d).cuboid(%s)' % (u, v, args)
            t = 'ModelTransform.of(%s)' % ', '.join(AN(x) for x in (*p.pivot, *p.rot))
            L.append('        add(m, "%s", "%s", %s, %s);' % (p.parent or '', p.name, b, t))
        L.append('    }')
        L.append('')
    L += ['    private static float sin(float v) { return (float) Math.sin(v); }', '    private static float cos(float v) { return (float) Math.cos(v); }', '', anim, '}']
    open(os.path.join(G.JAVA, cls + '.java'), 'w').write('\n'.join(L) + '\n')

def generate(key, quiet=False):
    cfg = CFG[key]
    gl, parts, cubes, k = I.convert_auto(os.path.join(HERE, 'models', key, 'model.gltf'))
    names = {p.name for p in parts}
    missing = [n for n in ([cfg.get('head'), cfg.get('jaw'), cfg.get('whole')] + cfg.get('neck', []) + cfg.get('tail', []) + cfg.get('snakes', [])
               + [x for c in cfg.get('wings', []) for x in c] + [x for c, _ in cfg.get('legs', []) for x in c]) if n and n not in names]
    if missing: print('  AVISO %s: huesos que no existen: %s' % (key, missing))
    out_png = os.path.join(G.TEX, 'entity', cfg['tex'] + '.png')
    size, pos = I.build_atlas(gl, parts, cubes, out_png)
    anim, animated = anim_java(cfg, parts)
    emit_big(cfg, parts, size, pos, anim, animated)
    lo, hi = I.bbox(parts)
    info = dict(key=key, cls=cfg['cls'], tex=cfg['tex'], k=k, size=size, parts=len(parts), cubes=len(cubes),
                lo=[round(float(x), 2) for x in lo], hi=[round(float(x), 2) for x in hi])
    if not quiet: print('%-7s %-15s partes=%3d cubos=%3d atlas=%4d  bbox(bloques)=%.1f x %.1f x %.1f  animadas=%d' % (key, cfg['cls'], len(parts), len(cubes), size, *((hi - lo) / 16), len(animated)))
    return parts, info

def main():
    infos = {}
    for key in CFG:
        try:
            parts, info = generate(key); infos[key] = info
        except BaseException as e:
            print('IMPORT %s OMITIDO (%s: %s)' % (key, type(e).__name__, e))
    json.dump(infos, open(os.path.join(HERE, 'models', 'info.json'), 'w'), indent=1)

if __name__ == '__main__':
    main()
