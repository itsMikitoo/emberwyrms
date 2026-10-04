#!/usr/bin/env python3
"""Convierte los modelos de Blockbench (carpeta SRC) y genera: clases Java, atlas de textura y fotos para el bestiario.
Uso: python3 tools/build_models.py <carpeta_con_los_modelos> [nombre ...]"""
import os, sys, json
import numpy as np
from PIL import Image
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import convert_model as CM, render_model as RM, rig_emit as RE

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
JAVA = os.path.join(ROOT, 'src/main/java/io/emberwyrms/client')
TEX = os.path.join(ROOT, 'src/main/resources/assets/emberwyrms/textures/entity')
PIC = os.path.join(ROOT, 'src/main/resources/assets/emberwyrms/textures/gui/bestiary')

LEGS4 = lambda r1, r2, f1, f2: [(r1, 0), (r2, 1), (f1, 1), (f2, 0)]

MODELS = {
 'fire': dict(kind='gltf', src='minecraft-netherrack-dragon/source/model.gltf', f=1.0, cls='FireDragonModel', tex='fire_dragon',
              credit='Netherrack Dragon (Sketchfab)', S=2.0, yaw=-40,
              rig=dict(head='head', neck=['neck', 'neck2', 'neck3', 'neck4', 'neck5'], tail=['tail', 'tail2', 'tail3', 'tail4', 'tail5', 'tail6'],
                       wings=[('wing', ['wingtip']), ('wing1', ['wingtip1'])],
                       legs=LEGS4(['rearleg', 'rearlegtip', 'rearfoot'], ['rearleg1', 'rearlegtip1', 'rearfoot1'],
                                  ['frontleg', 'frontlegtip', 'frontfoot'], ['frontleg1', 'frontlegtip1', 'frontfoot1']))),
 'ice': dict(kind='bedrock', src='ice_wyvern/ice_wyverngeo.json', texsrc='ice_wyvern/wyvern_texture.png', f=1.0, cls='IceDragonModel',
             tex='ice_dragon', credit='Ice Wyvern (Sketchfab)', S=0.78, yaw=-40, ops=[('recenter', 'Main_head', 'head')],
             rig=dict(head='Main_head', jaw='bone', neck=['Neckhead'], tail=['tail', 'tail4', 'tail5', 'tail6', 'tail7'],
                      wings=[('left_wing', ['wing3', 'bone5']), ('right_wing', ['wing4', 'bone15'])],
                      legs=[(['rearleg3', 'rearlegtip3'], 0), (['rearleg2', 'rearlegtip2'], 1)])),
 'storm': dict(kind='gltf', src='skeleton-drgaon/source/model.gltf', f=1.0, cls='StormDragonModel', tex='storm_dragon',
               credit='Skeleton Dragon (Sketchfab)', S=3.4, yaw=-40,
               rig=dict(head='head', jaw='jaw', neck=['neck'], tail=['tail1', 'tail2'],
                        wings=[('leftWing', ['leftRadiusulna2', 'leftPhanlange1']), ('rightWing', ['rightRadiusulna3', 'rightPhanlange4'])],
                        legs=LEGS4(['leftFemur', 'leftTibia'], ['rightFemur', 'rightTibia'], ['leftHumerus', 'leftRadiusulna', 'Foot1'], ['rightHumerus', 'rightRadiusulna', 'Foot2']))),
 'tide': dict(kind='gltf', src='serpent-blue-dragon/source/model.gltf', f=1.0, cls='TideDragonModel', tex='tide_dragon',
              credit='Serpent Blue Dragon (Sketchfab)', S=2.6, yaw=-40, ops=[('slice', 'Corpo', 10, 'z'), ('recenter', 'Head', 'head')],
              rig=dict(head='Head', tail=['Corpo_s%d' % k for k in range(10)], tail_amp=2.2)),
 'boss': dict(kind='gltf', src='the-warrior/source/model.gltf', f=0.4, cls='AshBossModel', tex='ash_dragon',
              credit='The Warrior (Sketchfab)', S=0.62, yaw=-40, ops=[('recenter', 'bone8', 'head'), ('recenter', 'bone9', 'head')],
              rig=dict(head='bone9', neck=['bone8'], tail=['bone7', 'Tail'], wings=[('Wing_left', []), ('Wing_right', [])],
                       legs=LEGS4([('Leg', 'Leg')], [('Leg2', 'Leg2')], [('Leg3', 'Leg3')], [('Leg4', 'Leg4')]))),
 'medusa': dict(kind='gltf', src='gorgon/source/model.gltf', f=2.0, pre_yaw=90, cls='MedusaModel', tex='medusa', state='MedusaRenderState',
                has_flags=False, credit='Gorgon (Sketchfab, CC BY)', S=9.0, yaw=-30, ops=[('slice', 'Tail', 7, 'z'), ('recenter', 'Head', 'base'), ('recenter', 'R', 'base'), ('recenter', 'L', 'base')],
                rig=dict(head='Head', hair=['R', 'L'], tail=['Tail_s%d' % k for k in range(7)], tail_amp=1.6)),
}

MOTION = {
    'fire': dict(leg_amp=0.9, knee=0.9, bob=3.5, crouch=16, fly_bob=3, flap=0.8, flap_speed=0.22, sit_leg=(0.9, -1.3, 0.7), fly_leg=(0.9, 0.8, 0.3), death_leg=(0.7, -1.0, 0.3), death_neck=0.7, death_tail=-0.12, death_wing=1.0, death_dy=10, head_sway=0.08, wave=0.05),
    'ice': dict(leg_amp=1.5, knee=1.2, bob=4.5, crouch=18, flap=0.8, flap_speed=0.2, sit_leg=(1.2, -1.8, 0.9), fly_leg=(0.9, 0.9, 0.3), death_leg=(0.9, -1.4, 0.4), death_neck=0.7, death_tail=-0.1, death_wing=1.0, death_dy=12, sit_neck=-0.25, head_sway=0.1),
    'storm': dict(leg_amp=1.1, knee=0.6, bob=2.0, crouch=6, flap=0.8, flap_speed=0.32, snap=1, jitter=0.012, jaw_clack=0.18, sit_leg=(0.7, -1.0, 0.5), fly_leg=(0.8, 0.6, 0.3), death_leg=(0.8, -1.1, 0.4), death_neck=0.9, death_tail=-0.4, death_wing=1.1, death_dy=5, head_sway=0.2),
    'tide': dict(wave=0.2, wavep=0.07, tail_amp=2.2, sit_coil=0.5, fly_bob=4, bob=1.5, crouch=4, death_tail=-0.06, death_dy=4, head_sway=0.22),
    'boss': dict(leg_amp=0.85, knee=0.8, bob=7, crouch=0, death_leg=(0.9, -1.5, 0.5), death_neck=0.8, death_tail=-0.12, death_wing=0.9, death_dy=14, head_sway=0.05, wave=0.04),
    'medusa': dict(wave=0.2, wavep=0.05, tail_amp=1.6, head_sway=0.1, bob=0.8, death_dy=4, death_tail=-0.08)
}
for _k, _v in MOTION.items():
    MODELS[_k]['rig'].update(_v)

def load(cfg, base):
    if cfg['kind'] == 'bedrock':
        return CM.convert_bedrock(os.path.join(base, cfg['src']), os.path.join(base, cfg['texsrc']), f=cfg['f'], ops=cfg.get('ops'))
    return CM.convert2(os.path.join(base, cfg['src']), f=cfg['f'], pre_yaw=cfg.get('pre_yaw', 0), ops=cfg.get('ops'))

def fix_legs(rig):
    """Permite nombres sueltos o (nombre, bajo_el_hueso) dentro de las cadenas de patas."""
    return rig

def main(base, only=None):
    os.makedirs(TEX, exist_ok=True); os.makedirs(PIC, exist_ok=True)
    stats = {}
    for key, cfg in MODELS.items():
        if only and key not in only: continue
        cv = load(cfg, base)
        cv.atlas.save(os.path.join(TEX, cfg['tex'] + '.png'))
        state = cfg.get('state', 'AshwingRenderState')
        bones, R = RE.emit_java(cv, cfg['rig'], cfg['cls'], state, os.path.join(JAVA, cfg['cls'] + '.java'), cfg.get('has_flags', True), cfg['credit'])
        # medidas para el juego (a escala 1 del modelo)
        W = RM.world_transforms(cv); pts = []
        for p, (Rm, t) in W.items():
            if p.cube is not None:
                c = p.cube
                for a in (0, 1):
                    for b in (0, 1):
                        for d in (0, 1): pts.append(Rm @ (c['off'] + np.array([a, b, d]) * c['ext']) + t)
        pts = np.array(pts); ext = (pts.max(0) - pts.min(0)) / 16.0
        stats[key] = dict(cls=cfg['cls'], atlas=cv.size, parts=len(cv.parts), cubes=len(cv.cubes), blocks_xyz=[round(float(x), 2) for x in ext],
                          top_blocks=round(float((24 - pts[:, 1].min()) / 16.0), 2), bones=len(bones))
        print('%-7s %-18s piezas %3d cubos %3d atlas %4d huesos animados %2d | tamano (bloques x,y,z): %s' % (
            key, cfg['cls'], len(cv.parts), len(cv.cubes), cv.size, len(bones), stats[key]['blocks_xyz']))
        # poses de revision: caminar (2 fases), volar (arriba/abajo), agachado, muerte
        rig = cfg['rig']
        P = lambda **k: RE.pose_deltas(cv, rig, bones, R, **k)
        yaw = cfg.get('yaw', -40); S = cfg['S']; fs = rig.get('flap_speed', 0.3)
        poses = {'walkA': P(t=3, walk=2.358, amp=1.0), 'walkB': P(t=3, walk=7.07, amp=1.0),
                 'flyUp': P(t=1.5708 / fs, fly=True), 'flyDown': P(t=4.712 / fs, fly=True),
                 'sit': P(t=3, sit=True), 'death': P(t=3, death=1.0)}
        for name, pose in poses.items():
            RM.render(cv, os.path.join(ROOT, 'tools', '_pose_%s_%s.png' % (key, name)), pose=pose, yaw=yaw, pitch=14, S=S, size=(900, 600), bg=(205, 210, 220))
    json.dump(stats, open(os.path.join(ROOT, 'tools', 'model_stats.json'), 'w'), indent=1)

if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2:] or None)
