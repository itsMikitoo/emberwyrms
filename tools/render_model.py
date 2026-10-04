"""Renderizador de software (ortografico, z-buffer, textura del atlas) para revisar modelos convertidos y generar las fotos del bestiario."""
import math
import numpy as np
from PIL import Image, ImageDraw
import convert_model as CM

def rmat(pitch, yaw, roll):
    cx, sx = math.cos(pitch), math.sin(pitch); cy, sy = math.cos(yaw), math.sin(yaw); cz, sz = math.cos(roll), math.sin(roll)
    Rx = np.array([[1, 0, 0], [0, cx, -sx], [0, sx, cx]]); Ry = np.array([[cy, 0, sy], [0, 1, 0], [-sy, 0, cy]])
    Rz = np.array([[cz, -sz, 0], [sz, cz, 0], [0, 0, 1]])
    return Rz @ Ry @ Rx

def world_transforms(cv, pose=None):
    """pose: {nombre_glTF_o_parte: (dpitch, dyaw, droll)} se suma al reposo. Devuelve {parte: (R, t)} en espacio de ModelPart."""
    pose = pose or {}
    W = {}
    def rec(p, Rp, tp):
        d = pose.get(p.name) or pose.get(p.gname) or (0, 0, 0)
        R = rmat(p.rot[0] + d[0], p.rot[1] + d[1], p.rot[2] + d[2])
        Rw = Rp @ R; tw = tp + Rp @ p.pivot
        W[p] = (Rw, tw)
        for c in p.children: rec(c, Rw, tw)
    for p in cv.parts:
        if p.parent is None: rec(p, np.eye(3), np.zeros(3))
    return W

def render(cv, out, pose=None, yaw=-35, pitch=18, S=3.0, size=(900, 640), bg=None, center=None, light=(-0.4, -0.8, -0.5)):
    W = world_transforms(cv, pose)
    ya, pa = math.radians(yaw), math.radians(pitch)
    Ry = np.array([[math.cos(ya), 0, math.sin(ya)], [0, 1, 0], [-math.sin(ya), 0, math.cos(ya)]])
    Rx = np.array([[1, 0, 0], [0, math.cos(pa), -math.sin(pa)], [0, math.sin(pa), math.cos(pa)]])
    V = Rx @ Ry
    L = np.array(light, float); L /= np.linalg.norm(L)
    atlas = np.array(cv.atlas).astype(float)
    Wd, Hd = size
    zbuf = np.full((Hd, Wd), 1e9); img = np.zeros((Hd, Wd, 4))
    allp = []
    for p, (R, t) in W.items():
        if p.cube is not None:
            c = p.cube
            for corner in ((0, 0, 0), (1, 1, 1)):
                allp.append(R @ (c['off'] + np.array(corner) * c['ext']) + t)
    allp = np.array(allp); 
    if isinstance(center, str):
        tgt = [q for q in W if q.gname == center][0]
        cen = V @ W[tgt][1]
    else:
        cen = V @ ((allp.min(0) + allp.max(0)) / 2) if center is None else center
    ox, oy = Wd / 2 - cen[0] * S, Hd / 2 - cen[1] * S
    for p, (R, t) in W.items():
        c = p.cube
        if c is None: continue
        w, h, d = c['sz']; u0, v0 = c['u'], c['v']
        regions = {'top': (u0 + d, v0, w, d), 'bottom': (u0 + d + w, v0, w, d), 'right': (u0, v0 + d, d, h),
                   'front': (u0 + d, v0 + d, w, h), 'left': (u0 + d + w, v0 + d, d, h), 'back': (u0 + 2 * d + w, v0 + d, w, h)}
        e = c['ext']; off = c['off']
        for fname, (ax, sign, e_r, e_u) in CM.FACES.items():
            rx, ry, rw, rh = regions[fname]
            Rl = CM.B @ e_r; Ul = CM.B @ e_u; Nl = CM.B @ CM.AX[ax] * sign
            ai = 'xyz'.index(ax)
            # centro de la cara en mp-local
            ctr = off + e / 2.0
            nvec = CM.B @ (CM.AX[ax] * sign)
            ctr = ctr + nvec * (e[int(np.argmax(np.abs(nvec)))] / 2.0)
            r_axis = int(np.argmax(np.abs(Rl))); u_axis = int(np.argmax(np.abs(Ul)))
            er = e[r_axis]; eu = e[u_axis]
            P00 = ctr - Rl * er / 2 + Ul * eu / 2          # esquina arriba-izquierda de la imagen
            Vr, Vu = Rl * er, -Ul * eu                     # s derecha, t abajo
            Pw = R @ P00 + t; Vrw = R @ Vr; Vuw = R @ Vu; Nw = V @ (R @ nvec)
            if Nw[2] > 0.0: continue                       # de espaldas
            q0 = V @ Pw; qr = V @ Vrw; qu = V @ Vuw
            M2 = np.array([[qr[0], qu[0]], [qr[1], qu[1]]])
            det = np.linalg.det(M2)
            if abs(det) < 1e-4: continue
            corners = [q0, q0 + qr, q0 + qu, q0 + qr + qu]
            xs = [ox + k[0] * S for k in corners]; ys = [oy + k[1] * S for k in corners]
            x0, x1 = int(max(0, math.floor(min(xs)))), int(min(Wd - 1, math.ceil(max(xs))))
            y0, y1 = int(max(0, math.floor(min(ys)))), int(min(Hd - 1, math.ceil(max(ys))))
            if x1 < x0 or y1 < y0: continue
            gx, gy = np.meshgrid(np.arange(x0, x1 + 1) + 0.5, np.arange(y0, y1 + 1) + 0.5)
            sx = (gx - ox) / S - q0[0]; sy = (gy - oy) / S - q0[1]
            inv = np.linalg.inv(M2)
            s = inv[0, 0] * sx + inv[0, 1] * sy; tt = inv[1, 0] * sx + inv[1, 1] * sy
            m = (s >= 0) & (s < 1) & (tt >= 0) & (tt < 1)
            if not m.any(): continue
            z = q0[2] + s * qr[2] + tt * qu[2]
            ax_ = (rx + s * rw).astype(int).clip(0, atlas.shape[1] - 1); ay_ = (ry + tt * rh).astype(int).clip(0, atlas.shape[0] - 1)
            col = atlas[ay_, ax_]
            ok = m & (col[..., 3] > 127) & (z < zbuf[y0:y1 + 1, x0:x1 + 1])
            lit = 0.62 + 0.38 * max(0.0, float(np.dot(-Nw, L)))
            sub = img[y0:y1 + 1, x0:x1 + 1]; zs = zbuf[y0:y1 + 1, x0:x1 + 1]
            sub[ok] = np.concatenate([col[ok][:, :3] * lit, np.full((ok.sum(), 1), 255.0)], 1)
            zs[ok] = z[ok]
    res = Image.fromarray(np.clip(img, 0, 255).astype(np.uint8), 'RGBA')
    if bg is not None:
        base = Image.new('RGBA', size, bg + (255,) if len(bg) == 3 else bg); base.alpha_composite(res); res = base
    res.save(out)
    return res
