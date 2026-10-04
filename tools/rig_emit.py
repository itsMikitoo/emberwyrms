"""Rig generico + generador de la clase Java de un modelo convertido."""
import math, numpy as np
import convert_model as CM
import render_model as RM

def fm(v):
    t = ('%.4f' % v).rstrip('0').rstrip('.')
    if t in ('-0', ''): t = '0'
    return t + 'f'

def resolve(cv, spec):
    if spec is None: return None
    if isinstance(spec, tuple):
        under = CM.find(cv.parts, spec[1]); return CM.find(cv.parts, spec[0], under)
    return CM.find(cv.parts, spec)

def rig_bones(cv, rig):
    """Lista ordenada de huesos animados + indices por rol."""
    bones, idx = [], {}
    def add(spec):
        p = resolve(cv, spec)
        if p is None: return -1
        if p not in idx: idx[p] = len(bones); bones.append(p)
        return idx[p]
    R = dict(
        HEAD=add(rig.get('head')), JAW=add(rig.get('jaw')),
        NECK=[add(x) for x in rig.get('neck', [])], TAIL=[add(x) for x in rig.get('tail', [])],
        HAIR=[add(x) for x in rig.get('hair', [])],
        WING=[[add(x) for x in [w[0]] + list(w[1])] for w in rig.get('wings', [])],
        LEG=[[add(x) for x in l[0]] for l in rig.get('legs', [])],
        LPHASE=[l[1] for l in rig.get('legs', [])])
    W = RM.world_transforms(cv)
    R['WSIGN'] = [1.0 if W[bones[w[0]]][1][0] > 0 else -1.0 for w in R['WING']]
    return bones, R

def pose_deltas(cv, rig, bones, R, t=0.0, walk=0.0, amp=0.0, fly=False, breath=False, look=(0.0, 0.0)):
    """Espejo en Python de setAngles() de Java (para revisar poses con el renderizador)."""
    d = {p.name: [0.0, 0.0, 0.0] for p in bones}
    f = walk * 0.6662; yawL, pitL = look
    def add(i, dp=0, dy=0, dr=0):
        v = d[bones[i].name]; v[0] += dp; v[1] += dy; v[2] += dr
    for i, b in enumerate(R['NECK']):
        add(b, math.sin(t * 0.05 - i * 0.5) * 0.03 + (0.05 if fly else 0) + (-0.05 if breath else 0), yawL * 0.12)
    if R['HEAD'] >= 0: add(R['HEAD'], pitL * 0.5 + math.sin(t * 0.09) * 0.02 - (0.3 if breath else 0), yawL * 0.4)
    if R['JAW'] >= 0: add(R['JAW'], 0.8 if breath else 0.05 + (math.sin(t * 0.09) + 1) * 0.03)
    ta = rig.get('tail_amp', 1.0)
    for j, b in enumerate(R['TAIL']):
        add(b, 0, (math.sin(t * 0.06 - j * 0.55) * (0.05 + 0.01 * j) + math.cos(f) * 0.05 * amp) * ta)
    for j, b in enumerate(R['HAIR']):
        add(b, math.cos(t * 0.13 + j) * 0.1, 0, math.sin(t * 0.15 + j * 1.7) * 0.12)
    fold = 0.0 if fly else rig.get('fold', 0.9)
    flap = math.sin(t * 0.3) if fly else math.sin(t * 0.1) * 0.04
    for w, row in enumerate(R['WING']):
        sg = R['WSIGN'][w]
        add(row[0], 0, -sg * rig.get('fold_yaw', 0.8) * fold, -sg * flap * rig.get('flap', 0.75) + sg * rig.get('fold_roll', 0.3) * fold)
        for k in row[1:]: add(k, 0, -sg * rig.get('fold_tip', 1.2) * fold, -sg * flap * 0.35)
    for l, chain in enumerate(R['LEG']):
        sw = math.cos(f + R['LPHASE'][l] * math.pi) * amp * rig.get('leg_amp', 0.6)
        add(chain[0], sw)
        for k in range(1, len(chain)): add(chain[k], -sw * 0.5 * k)
    return {n: tuple(v) for n, v in d.items()}

JAVA_TEMPLATE = r'''package io.emberwyrms.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;

/**
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (@CREDIT@).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class @CLS@ extends EntityModel<@STATE@> {
    private final ModelPart[] bones;
@CONSTS@

    public @CLS@(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
@BONEPATHS@
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        Map<String, ModelPartData> m = new HashMap<>();
        m.put("", data.getRoot());
@CALLS@
        return TexturedModelData.of(data, @TEX@, @TEX@);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

@CHUNKS@
    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    @Override
    public void setAngles(@STATE@ s) {
        super.setAngles(s);
        for (int i = 0; i < bones.length; i++) {
            bones[i].pitch = REST[i][0];
            bones[i].yaw = REST[i][1];
            bones[i].roll = REST[i][2];
        }
        float t = s.age;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float f = s.walkPhase * 0.6662f;
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;
        boolean fly = @FLY@;
        boolean breath = @BREATH@;
        for (int i = 0; i < NECK.length; i++) {
            bones[NECK[i]].pitch += sin(t * 0.05f - i * 0.5f) * 0.03f + (fly ? 0.05f : 0f) + (breath ? -0.05f : 0f);
            bones[NECK[i]].yaw += yawLook * 0.12f;
        }
        if (HEAD >= 0) {
            bones[HEAD].yaw += yawLook * 0.4f;
            bones[HEAD].pitch += pitchLook * 0.5f + sin(t * 0.09f) * 0.02f - (breath ? 0.3f : 0f);
        }
        if (JAW >= 0) bones[JAW].pitch += breath ? 0.8f : 0.05f + (sin(t * 0.09f) + 1f) * 0.03f;
        for (int j = 0; j < TAIL.length; j++) {
            bones[TAIL[j]].yaw += (sin(t * 0.06f - j * 0.55f) * (0.05f + 0.01f * j) + cos(f) * 0.05f * amp) * TAIL_AMP;
        }
        for (int j = 0; j < HAIR.length; j++) {
            bones[HAIR[j]].roll += sin(t * 0.15f + j * 1.7f) * 0.12f;
            bones[HAIR[j]].pitch += cos(t * 0.13f + j) * 0.1f;
        }
        float fold = fly ? 0f : FOLD;
        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.04f;
        for (int w = 0; w < WING.length; w++) {
            float sg = WSIGN[w];
            ModelPart root = bones[WING[w][0]];
            root.roll += -sg * flap * FLAP + sg * FOLD_ROLL * fold;
            root.yaw += -sg * FOLD_YAW * fold;
            for (int k = 1; k < WING[w].length; k++) {
                ModelPart tip = bones[WING[w][k]];
                tip.yaw += -sg * FOLD_TIP * fold;
                tip.roll += -sg * flap * 0.35f;
            }
        }
        for (int l = 0; l < LEG.length; l++) {
            float sw = cos(f + LPHASE[l] * 3.14159f) * amp * LEG_AMP;
            bones[LEG[l][0]].pitch += sw;
            for (int k = 1; k < LEG[l].length; k++) bones[LEG[l][k]].pitch += -sw * 0.5f * k;
        }
    }
}
'''

def emit_java(cv, rig, cls, state_cls, out_path, has_flags=True, credit='ver CREDITS.md'):
    bones, R = rig_bones(cv, rig)
    parts = []
    def dfs(p):
        parts.append(p)
        for c in p.children: dfs(c)
    for p in cv.parts:
        if p.parent is None: dfs(p)
    # un metodo por cada 60 piezas (limite de tamano de metodo de Java)
    chunks, calls = [], []
    for k in range(0, len(parts), 60):
        lines = []
        for p in parts[k:k + 60]:
            par = '' if p.parent is None else p.parent.name
            if p.cube is None:
                b = 'ModelPartBuilder.create()'
            else:
                c = p.cube; o = c['off']; sz = c['sz']; dl = c['dil']
                b = 'ModelPartBuilder.create().uv(%d, %d).cuboid(%s, %s, %s, %d, %d, %d, new Dilation(%s, %s, %s))' % (
                    c['u'], c['v'], fm(o[0]), fm(o[1]), fm(o[2]), sz[0], sz[1], sz[2], fm(dl[0]), fm(dl[1]), fm(dl[2]))
            t = 'ModelTransform.of(%s, %s, %s, %s, %s, %s)' % tuple(fm(float(v)) for v in (*p.pivot, *p.rot))
            lines.append('        add(m, "%s", "%s", %s, %s);' % (par, p.name, b, t))
        n = k // 60
        chunks.append('    private static void p%d(Map<String, ModelPartData> m) {\n%s\n    }\n' % (n, '\n'.join(lines)))
        calls.append('        p%d(m);' % n)
    def path(p):
        chain = []
        while p is not None: chain.append(p.name); p = p.parent
        return 'root' + ''.join('.getChild("%s")' % n for n in reversed(chain))
    rows = ['            ' + path(b) for b in bones]
    consts = []
    consts.append('    private static final float[][] REST = {' + ', '.join('{%s, %s, %s}' % tuple(fm(float(v)) for v in b.rot) for b in bones) + '};')
    consts.append('    private static final int HEAD = %d, JAW = %d;' % (R['HEAD'], R['JAW']))
    ia = lambda a: '{' + ', '.join(str(x) for x in a) + '}'
    consts.append('    private static final int[] NECK = %s, TAIL = %s, HAIR = %s;' % (ia(R['NECK']), ia(R['TAIL']), ia(R['HAIR'])))
    consts.append('    private static final int[][] WING = {%s};' % ', '.join(ia(w) for w in R['WING']))
    consts.append('    private static final float[] WSIGN = {%s};' % ', '.join(fm(x) for x in R['WSIGN']))
    consts.append('    private static final int[][] LEG = {%s};' % ', '.join(ia(l) for l in R['LEG']))
    consts.append('    private static final float[] LPHASE = {%s};' % ', '.join(fm(x) for x in R['LPHASE']))
    consts.append('    private static final float FOLD = %s, FOLD_YAW = %s, FOLD_TIP = %s, FOLD_ROLL = %s, FLAP = %s, TAIL_AMP = %s, LEG_AMP = %s;' % tuple(
        fm(x) for x in (rig.get('fold', 0.9), rig.get('fold_yaw', 0.8), rig.get('fold_tip', 1.2), rig.get('fold_roll', 0.3),
                        rig.get('flap', 0.75), rig.get('tail_amp', 1.0), rig.get('leg_amp', 0.6))))
    src = (JAVA_TEMPLATE.replace('@CLS@', cls).replace('@STATE@', state_cls).replace('@CREDIT@', credit)
           .replace('@CONSTS@', '\n'.join(consts)).replace('@BONEPATHS@', ',\n'.join(rows))
           .replace('@CALLS@', '\n'.join(calls)).replace('@CHUNKS@', '\n'.join(chunks)).replace('@TEX@', str(cv.size))
           .replace('@FLY@', 's.flying' if has_flags else 'false').replace('@BREATH@', 's.breathing' if has_flags else 'false'))
    open(out_path, 'w').write(src)
    return bones, R
