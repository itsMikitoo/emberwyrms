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
             tex='ice_dragon', credit='Ice Wyvern (Sketchfab)', S=0.78, yaw=-40,
             rig=dict(head='Main_head', jaw='bone', neck=['Neckhead'], tail=['tail', 'tail4', 'tail5', 'tail6', 'tail7'],
                      wings=[('left_wing', ['wing3', 'bone5']), ('right_wing', ['wing4', 'bone15'])],
                      legs=[(['rearleg3', 'rearlegtip3'], 0), (['rearleg2', 'rearlegtip2'], 1)])),
 'storm': dict(kind='gltf', src='skeleton-drgaon/source/model.gltf', f=1.0, cls='StormDragonModel', tex='storm_dragon',
               credit='Skeleton Dragon (Sketchfab)', S=3.4, yaw=-40,
               rig=dict(head='head', jaw='jaw', neck=['neck'], tail=['tail1', 'tail2'],
                        wings=[('leftWing', ['leftRadiusulna2', 'leftPhanlange1']), ('rightWing', ['rightRadiusulna3', 'rightPhanlange4'])],
                        legs=LEGS4(['leftFemur', 'leftTibia'], ['rightFemur', 'rightTibia'], ['leftHumerus', 'leftRadiusulna', 'Foot1'], ['rightHumerus', 'rightRadiusulna', 'Foot2']))),
 'tide': dict(kind='gltf', src='serpent-blue-dragon/source/model.gltf', f=1.0, cls='TideDragonModel', tex='tide_dragon',
              credit='Serpent Blue Dragon (Sketchfab)', S=2.6, yaw=-40, ops=[('slice', 'Corpo', 10, 'z')],
              rig=dict(head='Head', tail=['Corpo_s%d' % k for k in range(10)], tail_amp=2.2)),
 'boss': dict(kind='gltf', src='the-warrior/source/model.gltf', f=0.4, cls='AshBossModel', tex='ash_dragon',
              credit='The Warrior (Sketchfab)', S=0.62, yaw=-40,
              rig=dict(head='bone9', neck=['bone8'], tail=['bone7', 'Tail'], wings=[('Wing_left', []), ('Wing_right', [])],
                       legs=LEGS4([('Leg', 'Leg')], [('Leg2', 'Leg2')], [('Leg3', 'Leg3')], [('Leg4', 'Leg4')]))),
 'medusa': dict(kind='gltf', src='gorgon/source/model.gltf', f=2.0, pre_yaw=90, cls='MedusaModel', tex='medusa', state='MedusaRenderState',
                has_flags=False, credit='Gorgon (Sketchfab, CC BY)', S=9.0, yaw=-30, ops=[('slice', 'Tail', 7, 'z')],
                rig=dict(head='Head', hair=['R', 'L'], tail=['Tail_s%d' % k for k in range(7)], tail_amp=1.6)),
}

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
        # poses de revision y foto del bestiario
        rig = cfg['rig']
        P = lambda **k: RE.pose_deltas(cv, rig, bones, R, **k)
        yaw = cfg.get('yaw', -40); S = cfg['S']
        RM.render(cv, os.path.join(ROOT, 'tools', '_pose_%s_fold.png' % key), pose=P(t=0, walk=0, amp=0), yaw=yaw, pitch=14, S=S, size=(900, 600), bg=(205, 210, 220))
        RM.render(cv, os.path.join(ROOT, 'tools', '_pose_%s_fly.png' % key), pose=P(t=5.24, fly=True), yaw=yaw, pitch=14, S=S, size=(900, 600), bg=(205, 210, 220))
        RM.render(cv, os.path.join(ROOT, 'tools', '_pose_%s_walk.png' % key), pose=P(t=3, walk=2.5, amp=1.0), yaw=yaw, pitch=14, S=S, size=(900, 600), bg=(205, 210, 220))
    json.dump(stats, open(os.path.join(ROOT, 'tools', 'model_stats.json'), 'w'), indent=1)

if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2:] or None)
