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

def pose_deltas(cv, rig, bones, R, t=0.0, walk=0.0, amp=0.0, fly=False, sit=False, breath=False, death=0.0, look=(0.0, 0.0)):
    """Espejo en Python de setAngles() de Java (para revisar poses con el renderizador). Devuelve {parte: (dp,dy,dr)} y '__dy__' (px)."""
    d = {p.name: [0.0, 0.0, 0.0] for p in bones}
    g = lambda k, dflt: rig.get(k, dflt)
    f = walk * 0.6662; yawL, pitL = look
    if death > 0: fly = False; sit = False; amp *= (1 - death)
    moving = 0.0 if (fly or sit or death > 0) else amp
    def add(i, dp=0, dy=0, dr=0):
        v = d[bones[i].name]; v[0] += dp; v[1] += dy; v[2] += dr
    alive = 1 - death
    # cuello / cabeza / mandibula
    for i, b in enumerate(R['NECK']):
        add(b, math.sin(t * 0.05 - i * 0.5) * 0.03 + (g('fly_neck', 0.05) if fly else 0) + (-0.05 if breath else 0) + math.sin(2 * f) * 0.03 * moving
               + (g('sit_neck', -0.2) / len(R['NECK']) if sit else 0) + g('death_neck', 0.6) / len(R['NECK']) * death, yawL * 0.12)
    if R['HEAD'] >= 0:
        add(R['HEAD'], pitL * 0.5 + math.sin(t * 0.09) * 0.02 - (0.3 if breath else 0) + math.sin(2 * f) * 0.04 * moving + (-0.1 if sit else 0) + 0.4 * death,
            yawL * 0.4 - math.sin(f * 1.5) * g('head_sway', 0.1) * moving)
    if R['JAW'] >= 0:
        add(R['JAW'], (0.8 if breath else 0.05 + (math.sin(t * 0.09) + 1) * 0.03) + max(0, math.sin(f * 3)) * g('jaw_clack', 0.0) * moving + 0.5 * death)
    # cola / cuerpo serpiente
    ta = g('tail_amp', 1.0); wave = g('wave', 0.04); nT = len(R['TAIL'])
    for j, b in enumerate(R['TAIL']):
        yaw = (math.sin(t * 0.06 - j * 0.55) * (0.05 + 0.01 * j) + math.cos(f) * 0.05 * amp) * ta * alive
        yaw += math.sin(f * 1.5 - j * 0.7) * wave * moving
        pit = (math.sin(t * g('flap_speed', 0.3) - j * 0.5) * 0.05 - 0.05 * math.sin(t * g('flap_speed', 0.3)) * (1 if j == 0 else 0)) if fly else 0
        if sit: yaw += g('sit_coil', 0.3)
        pit += g('death_tail', -0.1) * death + math.sin(f * 1.5 - j * 0.7 + 1.5) * g('wavep', 0.0) * moving
        add(b, pit, yaw)
    for j, b in enumerate(R['HAIR']):
        k = 1 + 1.5 * amp
        add(b, math.cos(t * 0.13 + j) * 0.1 * k + 0.7 * death, 0, math.sin(t * 0.15 + j * 1.7) * 0.12 * k)
    # alas
    fold = 0.0 if fly else (1.0 if sit else g('fold', 0.9))
    fs = g('flap_speed', 0.3)
    sn = lambda x: math.copysign(math.sqrt(abs(x)), x) if g('snap', 0) else x
    flap = sn(math.sin(t * fs)) if fly else math.sin(t * 0.1) * 0.04
    lag = sn(math.sin(t * fs - 0.9))
    for w, row in enumerate(R['WING']):
        sg = R['WSIGN'][w]
        add(row[0], 0, -sg * g('fold_yaw', 0.8) * fold - (sg * 0.12 * flap if fly else 0),
            -sg * flap * g('flap', 0.75) + sg * g('fold_roll', 0.3) * fold - sg * math.sin(2 * f) * 0.05 * moving + sg * g('death_wing', 0.9) * death)
        for k in row[1:]:
            add(k, 0, -sg * g('fold_tip', 1.2) * fold, -sg * (lag * 0.45 if fly else flap * 0.35) + sg * g('death_wing', 0.9) * 0.5 * death)
    # patas
    for l, chain in enumerate(R['LEG']):
        a = f + R['LPHASE'][l] * math.pi
        sgn = 1 if l % 2 == 0 else -1
        for k, bi in enumerate(chain):
            kk = min(k, 2)
            dp = 0.0
            if k == 0: dp += math.sin(a) * g('leg_amp', 0.9) * moving
            elif k == 1: dp += max(0, math.sin(a + 1.0)) * g('knee', 0.8) * moving
            else: dp += -max(0, math.sin(a + 1.0)) * g('knee', 0.8) * 0.5 * moving
            if fly: dp += g('fly_leg', (0.9, 0.7, 0.3))[kk]
            if sit: dp += g('sit_leg', (0.8, -1.2, 0.6))[kk]
            dp += sgn * g('death_leg', (0.6, -0.9, 0.3))[kk] * death
            add(bi, dp)
    # vibracion de huesos (esqueleto)
    jit = g('jitter', 0.0)
    if jit > 0:
        for i, b in enumerate(bones):
            v = d[b.name]; v[0] += math.sin(t * 2.7 + i * 1.9) * jit * (1 + moving); v[2] += math.cos(t * 2.3 + i * 1.3) * jit * 0.7
    # desplazamiento vertical de todo el modelo (px; negativo = arriba)
    dy = -abs(math.cos(f)) * g('bob', 2.0) * moving
    if sit: dy += g('crouch', 8.0)
    if fly: dy += math.sin(t * 0.2) * g('fly_bob', 2.0)
    dy += g('death_dy', 6.0) * death
    out = {n: tuple(v) for n, v in d.items()}; out['__dy__'] = dy
    return out

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
    private final ModelPart[] roots;
@CONSTS@

    public @CLS@(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
@BONEPATHS@
        };
        this.roots = new ModelPart[] {
@ROOTPATHS@
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

    private static float snap(float x) { return SNAP > 0f ? Math.signum(x) * (float) Math.sqrt(Math.abs(x)) : x; }

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
        boolean sit = @SIT@;
        float death = s.death;
        if (death > 0f) { fly = false; sit = false; amp *= 1f - death; }
        if (fly) sit = false;
        float moving = (fly || sit || death > 0f) ? 0f : amp;
        float alive = 1f - death;
        // ---- cuello, cabeza, mandibula
        for (int i = 0; i < NECK.length; i++) {
            bones[NECK[i]].pitch += sin(t * 0.05f - i * 0.5f) * 0.03f + (fly ? FLY_NECK : 0f) + (breath ? -0.05f : 0f)
                    + sin(2f * f) * 0.03f * moving + (sit ? SIT_NECK / NECK.length : 0f) + DEATH_NECK / NECK.length * death;
            bones[NECK[i]].yaw += yawLook * 0.12f;
        }
        if (HEAD >= 0) {
            bones[HEAD].pitch += pitchLook * 0.5f + sin(t * 0.09f) * 0.02f - (breath ? 0.3f : 0f) + sin(2f * f) * 0.04f * moving
                    + (sit ? -0.1f : 0f) + 0.4f * death;
            bones[HEAD].yaw += yawLook * 0.4f - sin(f * 1.5f) * HEAD_SWAY * moving;
        }
        if (JAW >= 0) {
            bones[JAW].pitch += (breath ? 0.8f : 0.05f + (sin(t * 0.09f) + 1f) * 0.03f) + Math.max(0f, sin(f * 3f)) * JAW_CLACK * moving + 0.5f * death;
        }
        // ---- cola / cuerpo de serpiente
        for (int j = 0; j < TAIL.length; j++) {
            float yaw = (sin(t * 0.06f - j * 0.55f) * (0.05f + 0.01f * j) + cos(f) * 0.05f * amp) * TAIL_AMP * alive;
            yaw += sin(f * 1.5f - j * 0.7f) * WAVE * moving;
            float pit = fly ? sin(t * FLAP_SPEED - j * 0.5f) * 0.05f - (j == 0 ? 0.05f * sin(t * FLAP_SPEED) : 0f) : 0f;
            if (sit) yaw += SIT_COIL;
            pit += DEATH_TAIL * death + sin(f * 1.5f - j * 0.7f + 1.5f) * WAVEP * moving;
            bones[TAIL[j]].yaw += yaw;
            bones[TAIL[j]].pitch += pit;
        }
        float hk = 1f + 1.5f * amp;
        for (int j = 0; j < HAIR.length; j++) {
            bones[HAIR[j]].roll += sin(t * 0.15f + j * 1.7f) * 0.12f * hk;
            bones[HAIR[j]].pitch += cos(t * 0.13f + j) * 0.1f * hk + 0.7f * death;
        }
        // ---- alas
        float fold = fly ? 0f : (sit ? 1f : FOLD);
        float flap = fly ? snap(sin(t * FLAP_SPEED)) : sin(t * 0.1f) * 0.04f;
        float lag = snap(sin(t * FLAP_SPEED - 0.9f));
        for (int w = 0; w < WING.length; w++) {
            float sg = WSIGN[w];
            ModelPart root = bones[WING[w][0]];
            root.roll += -sg * flap * FLAP + sg * FOLD_ROLL * fold - sg * sin(2f * f) * 0.05f * moving + sg * DEATH_WING * death;
            root.yaw += -sg * FOLD_YAW * fold - (fly ? sg * 0.12f * flap : 0f);
            for (int k = 1; k < WING[w].length; k++) {
                ModelPart tip = bones[WING[w][k]];
                tip.yaw += -sg * FOLD_TIP * fold;
                tip.roll += -sg * (fly ? lag * 0.45f : flap * 0.35f) + sg * DEATH_WING * 0.5f * death;
            }
        }
        // ---- patas
        for (int l = 0; l < LEG.length; l++) {
            float a = f + LPHASE[l] * 3.14159f;
            float sgn = (l % 2 == 0) ? 1f : -1f;
            for (int k = 0; k < LEG[l].length; k++) {
                int kk = Math.min(k, 2);
                float dp;
                if (k == 0) dp = sin(a) * LEG_AMP * moving;
                else if (k == 1) dp = Math.max(0f, sin(a + 1f)) * KNEE * moving;
                else dp = -Math.max(0f, sin(a + 1f)) * KNEE * 0.5f * moving;
                if (fly) dp += FLY_LEG[kk];
                if (sit) dp += SIT_LEG[kk];
                dp += sgn * DEATH_LEG[kk] * death;
                bones[LEG[l][k]].pitch += dp;
            }
        }
        // ---- vibracion de huesos (solo esqueleto)
        if (JITTER > 0f) {
            for (int i = 0; i < bones.length; i++) {
                bones[i].pitch += sin(t * 2.7f + i * 1.9f) * JITTER * (1f + moving);
                bones[i].roll += cos(t * 2.3f + i * 1.3f) * JITTER * 0.7f;
            }
        }
        // ---- desplazamiento vertical de todo el modelo (subida al andar, agacharse, flotar al volar, hundirse al morir)
        float dy = -Math.abs(cos(f)) * BOB * moving;
        if (sit) dy += CROUCH;
        if (fly) dy += sin(t * 0.2f) * FLY_BOB;
        dy += DEATH_DY * death;
        for (int i = 0; i < roots.length; i++) roots[i].originY = ROOT_Y[i] + dy;
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
    rootrows = ['            root.getChild("%s")' % r.name for r in cv.parts if r.parent is None]
    consts = []
    consts.append('    private static final float[][] REST = {' + ', '.join('{%s, %s, %s}' % tuple(fm(float(v)) for v in b.rot) for b in bones) + '};')
    consts.append('    private static final int HEAD = %d, JAW = %d;' % (R['HEAD'], R['JAW']))
    ia = lambda a: '{' + ', '.join(str(x) for x in a) + '}'
    consts.append('    private static final int[] NECK = %s, TAIL = %s, HAIR = %s;' % (ia(R['NECK']), ia(R['TAIL']), ia(R['HAIR'])))
    consts.append('    private static final int[][] WING = {%s};' % ', '.join(ia(w) for w in R['WING']))
    consts.append('    private static final float[] WSIGN = {%s};' % ', '.join(fm(x) for x in R['WSIGN']))
    consts.append('    private static final int[][] LEG = {%s};' % ', '.join(ia(l) for l in R['LEG']))
    consts.append('    private static final float[] LPHASE = {%s};' % ', '.join(fm(x) for x in R['LPHASE']))
    g = lambda k, d: rig.get(k, d)
    roots = [p for p in cv.parts if p.parent is None]
    consts.append('    private static final float[] ROOT_Y = {%s};' % ', '.join(fm(float(r.pivot[1])) for r in roots))
    consts.append('    private static final float[] SIT_LEG = {%s}, FLY_LEG = {%s}, DEATH_LEG = {%s};' % tuple(', '.join(fm(x) for x in g(k, d)) for k, d in (
        ('sit_leg', (0.8, -1.2, 0.6)), ('fly_leg', (0.9, 0.7, 0.3)), ('death_leg', (0.6, -0.9, 0.3)))))
    consts.append('    private static final float LEG_AMP = %s, KNEE = %s, BOB = %s, CROUCH = %s, FLY_BOB = %s, DEATH_DY = %s;' % tuple(fm(x) for x in (
        g('leg_amp', 0.9), g('knee', 0.8), g('bob', 2.0), g('crouch', 8.0), g('fly_bob', 2.0), g('death_dy', 6.0))))
    consts.append('    private static final float FLY_NECK = %s, SIT_NECK = %s, DEATH_NECK = %s, SIT_COIL = %s, DEATH_TAIL = %s, DEATH_WING = %s;' % tuple(fm(x) for x in (
        g('fly_neck', 0.05), g('sit_neck', -0.2), g('death_neck', 0.6), g('sit_coil', 0.3), g('death_tail', -0.1), g('death_wing', 0.9))))
    consts.append('    private static final float FLAP_SPEED = %s, SNAP = %s, JITTER = %s, JAW_CLACK = %s, WAVE = %s, WAVEP = %s, HEAD_SWAY = %s;' % tuple(fm(x) for x in (
        g('flap_speed', 0.3), g('snap', 0), g('jitter', 0.0), g('jaw_clack', 0.0), g('wave', 0.04), g('wavep', 0.0), g('head_sway', 0.1))))
    consts.append('    private static final float FOLD = %s, FOLD_YAW = %s, FOLD_TIP = %s, FOLD_ROLL = %s, FLAP = %s, TAIL_AMP = %s;' % tuple(
        fm(x) for x in (rig.get('fold', 0.9), rig.get('fold_yaw', 0.8), rig.get('fold_tip', 1.2), rig.get('fold_roll', 0.3),
                        rig.get('flap', 0.75), rig.get('tail_amp', 1.0))))
    src = (JAVA_TEMPLATE.replace('@CLS@', cls).replace('@STATE@', state_cls).replace('@CREDIT@', credit)
           .replace('@CONSTS@', '\n'.join(consts)).replace('@BONEPATHS@', ',\n'.join(rows)).replace('@ROOTPATHS@', ',\n'.join(rootrows))
           .replace('@CALLS@', '\n'.join(calls)).replace('@CHUNKS@', '\n'.join(chunks)).replace('@TEX@', str(cv.size))
           .replace('@FLY@', 's.flying' if has_flags else 'false').replace('@BREATH@', 's.breathing' if has_flags else 'false')
           .replace('@SIT@', 's.sitting' if has_flags else 'false'))
    open(out_path, 'w').write(src)
    return bones, R
