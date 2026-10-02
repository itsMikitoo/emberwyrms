#!/usr/bin/env python3
"""Genera la dimension 'Tierra de Dragones' y sus 4 biomas COPIANDO los archivos reales de Minecraft 1.21.11
(asi el formato siempre es el correcto) y modificandolos. Si no hay internet, no genera nada y el mod funciona igual."""
import io, json, os, sys, urllib.request, zipfile

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
D = os.path.join(ROOT, 'src/main/resources/data/emberwyrms/')
VERSION = '1.21.11'

def fetch(url):
    return urllib.request.urlopen(url, timeout=90).read()

def open_vanilla():
    local = os.environ.get('VANILLA_JAR')
    if local: return zipfile.ZipFile(local)
    man = json.loads(fetch('https://piston-meta.mojang.com/mc/game/version_manifest_v2.json'))
    ver = next(v for v in man['versions'] if v['id'] == VERSION)
    meta = json.loads(fetch(ver['url']))
    return zipfile.ZipFile(io.BytesIO(fetch(meta['downloads']['client']['url'])))

def set_key(obj, names, value):
    """Cambia (recursivamente) cualquier clave cuyo nombre final sea uno de 'names'. Devuelve cuantas cambio."""
    n = 0
    if isinstance(obj, dict):
        for k in list(obj):
            short = k.split('/')[-1].split(':')[-1]
            if short in names:
                old = obj[k]
                if isinstance(old, bool): pass
                elif isinstance(old, int): obj[k] = value; n += 1
                elif isinstance(old, str) and old.startswith('#'): obj[k] = '#%06x' % value; n += 1
                elif isinstance(old, dict) and isinstance(old.get('value'), int): old['value'] = value; n += 1
            else:
                n += set_key(obj[k], names, value)
    elif isinstance(obj, list):
        for x in obj: n += set_key(x, names, value)
    return n

BIOMES = {
    # nombre: (plantilla vanilla, sky, fog, water, water_fog, grass, foliage, superficie, relleno, clima temp, humedad)
    'volcanic_peaks': ('stony_peaks', 0x5a2a22, 0x3a1a16, 0xb0502a, 0x502010, 0x6b5a3a, 0x5a4a30, 'minecraft:blackstone', 'minecraft:basalt', (0.25, 2.0), (-2.0, 0.15)),
    'glacial_spires': ('frozen_peaks', 0xa8d4ff, 0xdcefff, 0x4aa8ff, 0x1e6fb8, 0xb8e0d8, 0x9fd0c8, 'minecraft:snow_block', 'minecraft:packed_ice', (-2.0, -0.3), (-2.0, 2.0)),
    'storm_plateau': ('windswept_hills', 0x4a4f78, 0x6a6f98, 0x4a5a9a, 0x20284a, 0x7a8a5a, 0x6a7a4a, 'minecraft:calcite', 'minecraft:tuff', (-0.3, 0.25), (-2.0, 2.0)),
    'tide_marsh': ('mangrove_swamp', 0x4fb3a8, 0x7ad0c4, 0x1fb5b0, 0x0a5f66, 0x2f9a6a, 0x238a5a, 'minecraft:mud', 'minecraft:clay', (0.25, 2.0), (0.15, 2.0)),
}

def surface_rule(biome, top, filler):
    floor = lambda add: {'type': 'minecraft:stone_depth', 'offset': 0, 'surface_type': 'floor', 'add_surface_depth': add, 'secondary_depth_range': 0}
    block = lambda b: {'type': 'minecraft:block', 'result_state': {'Name': b}}
    return {'type': 'minecraft:condition', 'if_true': {'type': 'minecraft:biome', 'biome_is': ['emberwyrms:' + biome]},
            'then_run': {'type': 'minecraft:sequence', 'sequence': [
                {'type': 'minecraft:condition', 'if_true': floor(False), 'then_run': block(top)},
                {'type': 'minecraft:condition', 'if_true': floor(True), 'then_run': block(filler)}]}}

def main():
    try:
        jar = open_vanilla()
        load = lambda path: json.loads(jar.read('data/minecraft/' + path))
        templates = {n: load('worldgen/biome/%s.json' % v[0]) for n, v in BIOMES.items()}
        noise = load('worldgen/noise_settings/overworld.json')
        dim_type = load('dimension_type/overworld.json')
    except Exception as e:
        print('worldgen: OMITIDO (%s: %s). El mod funciona igual, sin la Tierra de Dragones.' % (type(e).__name__, e))
        return
    os.makedirs(D + 'worldgen/biome', exist_ok=True); os.makedirs(D + 'worldgen/noise_settings', exist_ok=True)
    os.makedirs(D + 'dimension_type', exist_ok=True); os.makedirs(D + 'dimension', exist_ok=True)

    rules = []
    entries = []
    for name, (tpl, sky, fog, water, wfog, grass, foliage, top, filler, temp, hum) in BIOMES.items():
        b = templates[name]
        wanted = (('sky_color', sky), ('fog_color', fog), ('water_color', water), ('water_fog_color', wfog), ('grass_color', grass), ('foliage_color', foliage))
        got = []
        for key, val in wanted:
            n = set_key(b, {key}, val)
            if n == 0 and isinstance(b.get('effects'), dict):      # el bioma plantilla no la traia: se añade
                b['effects'][key] = val; n = -1
            got.append(n)
        print('biome %-15s (sky,fog,water,wfog,grass,foliage; -1 = anadido): %s | claves: %s | effects: %s' % (
            name, got, sorted(b.keys()), sorted(b['effects'].keys()) if isinstance(b.get('effects'), dict) else None))
        json.dump(b, open(D + 'worldgen/biome/%s.json' % name, 'w'), indent=1)
        rules.append(surface_rule(name, top, filler))
        entries.append({'biome': 'emberwyrms:' + name, 'parameters': {'temperature': list(temp), 'humidity': list(hum),
                        'continentalness': [-2.0, 2.0], 'erosion': [-2.0, 2.0], 'weirdness': [-2.0, 2.0], 'depth': 0.0, 'offset': 0.0}})

    sr = noise.get('surface_rule')
    if isinstance(sr, dict) and sr.get('type') == 'minecraft:sequence':
        sr['sequence'] = rules + sr['sequence']
    else:
        noise['surface_rule'] = {'type': 'minecraft:sequence', 'sequence': rules + ([sr] if sr else [])}
    json.dump(noise, open(D + 'worldgen/noise_settings/dragonlands.json', 'w'), indent=1)
    json.dump(dim_type, open(D + 'dimension_type/dragonlands.json', 'w'), indent=1)
    json.dump({'type': 'emberwyrms:dragonlands', 'generator': {'type': 'minecraft:noise', 'settings': 'emberwyrms:dragonlands',
              'biome_source': {'type': 'minecraft:multi_noise', 'biomes': entries}}}, open(D + 'dimension/dragonlands.json', 'w'), indent=1)
    print('worldgen: dimension Tierra de Dragones generada con %d biomas' % len(entries))

main()
