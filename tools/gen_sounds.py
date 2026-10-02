#!/usr/bin/env python3
"""Sintetiza los sonidos del mod (rugidos, siseos, aleteo, chillidos) y los escribe como .ogg + sounds.json.
Usa 'soundfile' (pip) o, si no esta, ffmpeg. Si no hay ninguno, no genera nada y el mod usa silencio."""
import os, sys, json, subprocess, tempfile, wave

def _ensure_deps():
    try:
        import numpy  # noqa: F401
        return True
    except ImportError:
        pass
    try:
        subprocess.run([sys.executable, '-m', 'pip', 'install', '--quiet', '--user', 'numpy', 'soundfile'], check=False)
        import importlib, site
        importlib.invalidate_caches()
        sys.path.append(site.getusersitepackages())
        import numpy  # noqa: F401
        return True
    except Exception as e:
        print('sonidos: no se pudo instalar numpy (%s)' % e)
        return False

if not _ensure_deps():
    print('sonidos: OMITIDOS. El mod usara sonidos de Minecraft.')
    sys.exit(0)
import numpy as np

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
OUT = os.path.join(ROOT, 'src/main/resources/assets/emberwyrms/')
SR = 22050
RNG = np.random.default_rng(1234)

def t_of(dur): return np.arange(int(dur * SR)) / SR

def noise(n): return RNG.standard_normal(n)

def fft_filter(x, shape):
    X = np.fft.rfft(x); f = np.fft.rfftfreq(len(x), 1 / SR)
    return np.fft.irfft(X * shape(f), len(x))

def bandpass(x, lo, hi):
    return fft_filter(x, lambda f: 1 / (1 + (np.maximum(lo - f, 0) / (lo * 0.35 + 1)) ** 4) / (1 + (np.maximum(f - hi, 0) / (hi * 0.35 + 1)) ** 4) * ((f >= lo * 0.5) & (f <= hi * 2)))

def lowpass(x, fc): return fft_filter(x, lambda f: 1 / (1 + (f / fc) ** 4))

def norm(x, peak=0.85):
    m = np.max(np.abs(x)) + 1e-9
    return x / m * peak

def fade(x, a=0.01, r=0.04):
    n = len(x); ia, ir = max(1, int(a * SR)), max(1, int(r * SR))
    x = x.copy(); x[:ia] *= np.linspace(0, 1, ia); x[-ir:] *= np.linspace(1, 0, ir); return x

def envelope(n, pts):
    xs = np.array([p[0] for p in pts]) * (n - 1); ys = np.array([p[1] for p in pts])
    return np.interp(np.arange(n), xs, ys)

def growl(dur, curve, rough=0.6, drive=2.0, vib=5.5, formants=((480, 1.0), (1000, 0.8), (2100, 0.4)), env=None, hiss=0.15):
    t = t_of(dur); n = len(t)
    f0 = np.interp(t / dur, [p[0] for p in curve], [p[1] for p in curve]) * (1 + 0.025 * np.sin(2 * np.pi * vib * t))
    ph = np.cumsum(2 * np.pi * f0 / SR)
    sig = sum(np.sin(h * ph + h * 0.4) / h ** 0.85 for h in range(1, 16))
    am = 1 - rough * 0.5 * (1 + norm(lowpass(noise(n), 55), 1.0))
    sig = sig * am + 0.3 * bandpass(noise(n), 200, 3500)
    out = 0.25 * sig
    for fc, g in formants: out = out + g * bandpass(sig, fc * 0.75, fc * 1.3)
    out = np.tanh(drive * norm(out, 1.0)) + hiss * bandpass(noise(n), 2500, 7000) * envelope(n, [(0, 0), (0.3, 1), (1, 0)])
    out = out * envelope(n, env or [(0, 0), (0.12, 1), (0.6, 0.8), (1, 0)])
    return fade(norm(out))

def hiss(dur, lo=2500, hi=9000, rattle=0.0, rate=24, env=None, low=0.0):
    t = t_of(dur); n = len(t)
    x = bandpass(noise(n), lo, hi)
    if rattle: x = x * (1 - rattle + rattle * (0.5 + 0.5 * np.sign(np.sin(2 * np.pi * rate * t))))
    if low: x = x + low * lowpass(noise(n), 160) * 3
    return fade(norm(x * envelope(n, env or [(0, 0), (0.15, 1), (0.7, 0.8), (1, 0)])))

def flap(dur=0.7):
    t = t_of(dur); n = len(t)
    x = lowpass(noise(n), 500) * np.exp(-t * 7) + 0.8 * np.sin(2 * np.pi * 42 * t) * np.exp(-t * 11)
    x += 0.4 * bandpass(noise(n), 800, 3000) * np.exp(-((t - 0.12) ** 2) / 0.004)
    return fade(norm(x), 0.002, 0.08)

def screech(dur, f_pts, vib=16, harm=3, noise_mix=0.1, env=None):
    t = t_of(dur); n = len(t)
    f = np.interp(t / dur, [p[0] for p in f_pts], [p[1] for p in f_pts]) * (1 + 0.04 * np.sin(2 * np.pi * vib * t))
    ph = np.cumsum(2 * np.pi * f / SR)
    x = sum(np.sin(h * ph) / h for h in range(1, harm + 1)) + noise_mix * bandpass(noise(n), 1500, 6000)
    return fade(norm(x * envelope(n, env or [(0, 0), (0.08, 1), (0.7, 0.8), (1, 0)])))

SOUNDS = {
    'dragon_ambient': lambda: growl(1.9, [(0, 70), (0.5, 92), (1, 66)], rough=0.55, drive=1.6, env=[(0, 0), (0.3, 0.8), (0.7, 0.7), (1, 0)]),
    'dragon_hurt': lambda: growl(0.8, [(0, 170), (0.3, 130), (1, 80)], rough=0.7, drive=2.8, env=[(0, 0), (0.05, 1), (1, 0)]),
    'dragon_death': lambda: growl(3.2, [(0, 120), (0.35, 90), (1, 32)], rough=0.8, drive=2.3, env=[(0, 0), (0.1, 1), (0.6, 0.7), (1, 0)]),
    'dragon_roar': lambda: growl(2.0, [(0, 85), (0.25, 250), (0.55, 150), (1, 90)], rough=0.65, drive=3.0, hiss=0.3, env=[(0, 0), (0.1, 1), (0.7, 0.9), (1, 0)]),
    'dragon_breath': lambda: hiss(1.7, 700, 6500, rattle=0.25, rate=38, low=0.9, env=[(0, 0), (0.2, 0.7), (0.5, 1), (1, 0)]),
    'dragon_flap': flap,
    'phoenix_ambient': lambda: np.concatenate([screech(0.35, [(0, 1500), (0.5, 2700), (1, 2000)], 20), np.zeros(int(0.08 * SR)), screech(0.4, [(0, 1700), (0.5, 3000), (1, 2300)], 22)]),
    'phoenix_hurt': lambda: screech(0.5, [(0, 3300), (1, 1900)], 26, 3, 0.18, [(0, 0), (0.04, 1), (1, 0)]),
    'phoenix_death': lambda: screech(1.7, [(0, 3300), (0.3, 2800), (1, 380)], 14, 4, 0.12, [(0, 0), (0.05, 1), (0.8, 0.6), (1, 0)]),
    'medusa_ambient': lambda: hiss(1.7, 3000, 9500, rattle=0.5, rate=22, low=0.2, env=[(0, 0), (0.3, 0.6), (0.6, 1), (1, 0)]),
    'medusa_hurt': lambda: hiss(0.55, 2500, 9000, rattle=0.3, rate=30, env=[(0, 0), (0.05, 1), (1, 0)]),
    'medusa_death': lambda: hiss(2.2, 1800, 8500, rattle=0.6, rate=18, low=0.5, env=[(0, 0), (0.1, 1), (1, 0)]),
}

def write_ogg(name, x):
    path = os.path.join(OUT, 'sounds', 'entity', name + '.ogg'); os.makedirs(os.path.dirname(path), exist_ok=True)
    x = x.astype(np.float32)
    try:
        import soundfile as sf
        sf.write(path, x, SR, format='OGG', subtype='VORBIS'); return True
    except Exception:
        pass
    try:
        with tempfile.TemporaryDirectory() as d:
            wav = os.path.join(d, name + '.wav')
            with wave.open(wav, 'wb') as w:
                w.setnchannels(1); w.setsampwidth(2); w.setframerate(SR); w.writeframes((np.clip(x, -1, 1) * 32767).astype('<i2').tobytes())
            subprocess.run(['ffmpeg', '-y', '-loglevel', 'error', '-i', wav, '-c:a', 'libvorbis', '-q:a', '4', path], check=True)
        return True
    except Exception as e:
        print('  no se pudo codificar %s: %s' % (name, e)); return False

def main():
    done = {}
    for name, fn in SOUNDS.items():
        if write_ogg(name, fn()): done[name] = True
    if not done:
        print('sonidos: OMITIDOS (sin soundfile ni ffmpeg). El mod usara sonidos de Minecraft.'); return
    sj = {}
    for name in done:
        sj['entity.' + name.replace('_', '.', 1)] = {'sounds': ['emberwyrms:entity/' + name]}
    json.dump(sj, open(OUT + 'sounds.json', 'w'), indent=2)
    print('sonidos: %d generados (%s)' % (len(done), ', '.join(sj)))

try:
    main()
except Exception as e:
    print('sonidos: OMITIDOS por un error (%s: %s)' % (type(e).__name__, e))
    sys.exit(0)
