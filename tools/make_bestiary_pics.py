#!/usr/bin/env python3
"""Genera las fotos del bestiario (256x160) renderizando cada modelo convertido sobre un fondo de pergamino.
Uso: python3 tools/make_bestiary_pics.py <carpeta_con_los_modelos>"""
import os, sys, math
import numpy as np
from PIL import Image, ImageDraw, ImageFilter
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import build_models as BM, render_model as RM

W, H = 256, 160
SS = 3   # supersampling

def parchment(size):
    w, h = size
    rng = np.random.default_rng(7)
    base = np.zeros((h, w, 3)); base[:] = (226, 206, 160)
    yy, xx = np.mgrid[0:h, 0:w]
    vign = 1 - 0.35 * (((xx - w / 2) / (w / 2)) ** 2 + ((yy - h / 2) / (h / 2)) ** 2)
    noise = rng.normal(0, 4, (h, w, 1))
    img = np.clip(base * vign[..., None] + noise, 0, 255).astype(np.uint8)
    im = Image.fromarray(img, 'RGB')
    d = ImageDraw.Draw(im); d.rectangle([0, 0, w - 1, h - 1], outline=(110, 80, 40), width=max(2, w // 128))
    return im

def fit_scale(cv, yaw, pitch, size, margin=0.86):
    ya, pa = math.radians(yaw), math.radians(pitch)
    Ry = np.array([[math.cos(ya), 0, math.sin(ya)], [0, 1, 0], [-math.sin(ya), 0, math.cos(ya)]])
    Rx = np.array([[1, 0, 0], [0, math.cos(pa), -math.sin(pa)], [0, math.sin(pa), math.cos(pa)]])
    V = Rx @ Ry; Wt = RM.world_transforms(cv); pts = []
    for p, (R, t) in Wt.items():
        if p.cube is not None:
            c = p.cube
            for a in (0, 1):
                for b in (0, 1):
                    for d in (0, 1): pts.append(V @ (R @ (c['off'] + np.array([a, b, d]) * c['ext']) + t))
    pts = np.array(pts); ext = pts.max(0) - pts.min(0)
    return margin * min(size[0] / max(ext[0], 1e-6), size[1] / max(ext[1], 1e-6))

VIEW = {'fire': (-38, 16), 'ice': (-38, 16), 'storm': (-38, 16), 'tide': (-52, 10), 'boss': (-38, 12), 'medusa': (-25, 6)}

def main(base):
    out_dir = BM.PIC; os.makedirs(out_dir, exist_ok=True)
    for key, cfg in BM.MODELS.items():
        cv = BM.load(cfg, base)
        yaw, pitch = VIEW.get(key, (-38, 14))
        big = (W * SS, H * SS)
        S = fit_scale(cv, yaw, pitch, big)
        RM.render(cv, '/tmp/_pic_%s.png' % key, pose={}, yaw=yaw, pitch=pitch, S=S, size=big)
        art = Image.open('/tmp/_pic_%s.png' % key).convert('RGBA').resize((W, H), Image.LANCZOS)
        # sombra suave bajo la criatura
        sh = Image.new('RGBA', (W, H), (0, 0, 0, 0)); a = art.split()[3].point(lambda v: int(v * 0.35))
        sh.putalpha(a); sh = sh.filter(ImageFilter.GaussianBlur(2)).transform(sh.size, Image.AFFINE, (1, 0, -2, 0, 1, -3))
        bg = parchment((W, H)).convert('RGBA'); bg.alpha_composite(sh); bg.alpha_composite(art)
        d = ImageDraw.Draw(bg); d.rectangle([0, 0, W - 1, H - 1], outline=(110, 80, 40), width=2)
        bg.convert('RGB').save(os.path.join(out_dir, key + '.png'))
        print('foto', key, '-> %s.png' % key)

if __name__ == '__main__':
    main(sys.argv[1])
