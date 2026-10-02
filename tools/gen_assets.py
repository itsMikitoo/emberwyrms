#!/usr/bin/env python3
"""Genera los JSON del mod (modelos de objetos, huevos, armaduras, recetas, drops y traducciones).
Se ejecuta automaticamente al compilar en GitHub, junto con generate.py."""
import json, os
R = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), 'src/main/resources/')
A = R + 'assets/emberwyrms/'; D = R + 'data/emberwyrms/'
for d in ('blockstates', 'models/block', 'models/item', 'items', 'lang', 'equipment'): os.makedirs(A + d, exist_ok=True)
for d in ('loot_table/blocks', 'loot_table/entities', 'recipe', 'tags/item'): os.makedirs(D + d, exist_ok=True)
def w(path, obj): json.dump(obj, open(path, 'w'), indent=2, ensure_ascii=False)
def item_def(n, model=None): w(A + 'items/%s.json' % n, {'model': {'type': 'minecraft:model', 'model': model or 'emberwyrms:item/' + n}})
def flat(n): w(A + 'models/item/%s.json' % n, {'parent': 'minecraft:item/generated', 'textures': {'layer0': 'emberwyrms:item/' + n}})
def count(lo, hi): return [{'function': 'minecraft:set_count', 'count': {'type': 'minecraft:uniform', 'min': lo, 'max': hi}}]

EL = {'fire': ('fuego', 'Fire'), 'ice': ('hielo', 'Ice'), 'storm': ('rayo', 'Lightning'), 'tide': ('agua', 'Water')}
PIECES = {'helmet': (['SSS', 'S S'], 'Helmet', 'Casco'), 'chestplate': (['S S', 'SSS', 'SSS'], 'Chestplate', 'Pechera'),
          'leggings': (['SSS', 'S S', 'S S'], 'Leggings', 'Pantalones'), 'boots': (['S S', 'S S'], 'Boots', 'Botas')}
boxes = [((5, 0, 5), (11, 3, 11)), ((4, 3, 4), (12, 9, 12)), ((5, 9, 5), (11, 12, 11)), ((6, 12, 6), (10, 14, 10))]
face = lambda: {'uv': [4, 4, 12, 12], 'texture': '#all'}

def egg_block(n):
    w(A + 'blockstates/%s.json' % n, {'variants': {'': {'model': 'emberwyrms:block/' + n}}})
    w(A + 'models/block/%s.json' % n, {'textures': {'all': 'emberwyrms:block/' + n, 'particle': 'emberwyrms:block/' + n},
      'elements': [{'from': list(a), 'to': list(b), 'faces': {f: face() for f in ('north', 'south', 'east', 'west', 'up', 'down')}} for a, b in boxes]})
    item_def(n, 'emberwyrms:block/' + n)
    w(D + 'loot_table/blocks/%s.json' % n, {'type': 'minecraft:block', 'pools': [{'rolls': 1, 'conditions': [{'condition': 'minecraft:survives_explosion'}],
      'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:' + n}]}]})

en = {"itemGroup.emberwyrms": "Emberwyrms", "entity.emberwyrms.ashwing": "Ashwing", "entity.emberwyrms.phoenix": "Phoenix", "entity.emberwyrms.medusa": "Medusa",
      "entity.emberwyrms.medusa.gaze": "Medusa's gaze petrifies you", "item.emberwyrms.emberscale": "Ember Scale",
      "item.emberwyrms.ashwing_spawn_egg": "Ashwing Spawn Egg", "item.emberwyrms.phoenix_spawn_egg": "Phoenix Spawn Egg", "item.emberwyrms.medusa_spawn_egg": "Medusa Spawn Egg",
      "block.emberwyrms.phoenix_egg": "Phoenix Egg", "item.emberwyrms.phoenix_feather": "Phoenix Feather"}
es = {"itemGroup.emberwyrms": "Emberwyrms", "entity.emberwyrms.ashwing": "Alascua", "entity.emberwyrms.phoenix": "Fénix", "entity.emberwyrms.medusa": "Medusa",
      "entity.emberwyrms.medusa.gaze": "La mirada de Medusa te petrifica", "item.emberwyrms.emberscale": "Escama de brasa",
      "item.emberwyrms.ashwing_spawn_egg": "Huevo generador de alascua", "item.emberwyrms.phoenix_spawn_egg": "Huevo generador de Fénix", "item.emberwyrms.medusa_spawn_egg": "Huevo generador de Medusa",
      "block.emberwyrms.phoenix_egg": "Huevo de Fénix", "item.emberwyrms.phoenix_feather": "Pluma de Fénix"}

egg_block('phoenix_egg'); item_def('phoenix_feather'); flat('phoenix_feather')
w(D + 'loot_table/entities/phoenix.json', {'type': 'minecraft:entity', 'pools': [
  {'rolls': 1, 'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:phoenix_feather', 'functions': count(0, 2)}]},
  {'rolls': 1, 'conditions': [{'condition': 'minecraft:random_chance', 'chance': 0.08}],
   'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:phoenix_egg'}]}]})

for el, (e_es, e_en) in EL.items():
    egg_block(el + '_dragon_egg')
    for it in (el + '_dragon_scale', el + '_dragon_spawn_egg'): item_def(it); flat(it)
    w(D + 'loot_table/entities/%s_dragon.json' % el, {'type': 'minecraft:entity', 'pools': [{'rolls': 1, 'entries': [
      {'type': 'minecraft:item', 'name': 'emberwyrms:%s_dragon_scale' % el, 'functions': count(1, 3)}]}]})
    w(D + 'tags/item/repairs_%s_dragon_armor.json' % el, {'values': ['emberwyrms:%s_dragon_scale' % el]})
    w(A + 'equipment/%s_dragon.json' % el, {'layers': {'humanoid': [{'texture': 'emberwyrms:%s_dragon' % el}],
      'humanoid_leggings': [{'texture': 'emberwyrms:%s_dragon' % el}],
      'wings': [{'texture': 'emberwyrms:%s_dragon' % el}]}})
    en.update({f"entity.emberwyrms.{el}_dragon": f"{e_en} Dragon", f"item.emberwyrms.{el}_dragon_scale": f"{e_en} Dragon Scale",
               f"block.emberwyrms.{el}_dragon_egg": f"{e_en} Dragon Egg", f"item.emberwyrms.{el}_dragon_spawn_egg": f"{e_en} Dragon Spawn Egg"})
    es.update({f"entity.emberwyrms.{el}_dragon": f"Dragón de {e_es}", f"item.emberwyrms.{el}_dragon_scale": f"Escama de dragón de {e_es}",
               f"block.emberwyrms.{el}_dragon_egg": f"Huevo de dragón de {e_es}", f"item.emberwyrms.{el}_dragon_spawn_egg": f"Huevo generador de dragón de {e_es}"})
    for piece, (pattern, p_en, p_es) in PIECES.items():
        n = f'{el}_dragon_{piece}'
        item_def(n)
        if piece != 'helmet': flat(n)
        w(D + 'recipe/%s.json' % n, {'type': 'minecraft:crafting_shaped', 'category': 'equipment',
          'key': {'S': 'emberwyrms:%s_dragon_scale' % el}, 'pattern': pattern, 'result': {'id': 'emberwyrms:' + n, 'count': 1}})
        en['item.emberwyrms.' + n] = f'{e_en} Dragon {p_en}'
        es['item.emberwyrms.' + n] = f'{p_es} de dragón de {e_es}'
# ---- Fase 4: cuerno, corazon de ceniza, jefe, biomas
for it in ('dragon_horn', 'ash_heart', 'ash_dragon_spawn_egg'): item_def(it); flat(it)
w(D + 'recipe/dragon_horn.json', {'type': 'minecraft:crafting_shapeless', 'category': 'misc',
  'ingredients': ['emberwyrms:%s_dragon_scale' % e for e in EL], 'result': {'id': 'emberwyrms:dragon_horn', 'count': 1}})
w(D + 'loot_table/entities/ash_dragon.json', {'type': 'minecraft:entity', 'pools': [
  {'rolls': 1, 'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:ash_heart'}]},
  {'rolls': 1, 'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:emberscale', 'functions': count(6, 12)}]},
  {'rolls': 1, 'entries': [{'type': 'minecraft:item', 'name': 'emberwyrms:fire_dragon_scale', 'functions': count(2, 5)}]}]})
en.update({"entity.emberwyrms.dragon.info": "Stage %1$s - day %2$s - %3$s", "entity.emberwyrms.dragon.male": "Male", "entity.emberwyrms.dragon.female": "Female",
           "entity.emberwyrms.ash_dragon": "Ash Dragon", "item.emberwyrms.ash_dragon_spawn_egg": "Ash Dragon Spawn Egg",
           "item.emberwyrms.ash_heart": "Ashen Heart", "item.emberwyrms.dragon_horn": "Dragon Horn",
           "item.emberwyrms.dragon_horn.unavailable": "The Dragonlands are not available",
           "biome.emberwyrms.volcanic_peaks": "Volcanic Peaks", "biome.emberwyrms.glacial_spires": "Glacial Spires",
           "biome.emberwyrms.storm_plateau": "Storm Plateau", "biome.emberwyrms.tide_marsh": "Tide Marsh"})
es.update({"entity.emberwyrms.dragon.info": "Etapa %1$s - día %2$s - %3$s", "entity.emberwyrms.dragon.male": "Macho", "entity.emberwyrms.dragon.female": "Hembra",
           "entity.emberwyrms.ash_dragon": "Dragón de Ceniza", "item.emberwyrms.ash_dragon_spawn_egg": "Huevo generador de Dragón de Ceniza",
           "item.emberwyrms.ash_heart": "Corazón ceniciento", "item.emberwyrms.dragon_horn": "Cuerno del Dragón",
           "item.emberwyrms.dragon_horn.unavailable": "La Tierra de Dragones no está disponible",
           "biome.emberwyrms.volcanic_peaks": "Picos Volcánicos", "biome.emberwyrms.glacial_spires": "Agujas Glaciales",
           "biome.emberwyrms.storm_plateau": "Meseta de la Tormenta", "biome.emberwyrms.tide_marsh": "Marisma de la Marea"})

# ---- Fase 6: comida de dragon, aldea de dragones, tablas de botin
FOODS = {'fire': ('cinder_steak', 'Cinder Steak', 'Filete de ceniza', ['minecraft:cooked_beef', 'minecraft:blaze_powder']),
         'ice': ('frost_fish', 'Frost Fish', 'Pescado glacial', ['minecraft:cod', 'minecraft:packed_ice']),
         'storm': ('storm_jerky', 'Storm Jerky', 'Cecina de tormenta', ['minecraft:cooked_mutton', 'minecraft:redstone']),
         'tide': ('tide_catch', 'Tide Catch', 'Captura de marea', ['minecraft:salmon', 'minecraft:kelp'])}
for el, (fid, f_en, f_es, ing) in FOODS.items():
    item_def(fid); flat(fid)
    w(D + 'recipe/%s.json' % fid, {'type': 'minecraft:crafting_shapeless', 'category': 'misc', 'ingredients': ing,
      'result': {'id': 'emberwyrms:' + fid, 'count': 2}})
    en['item.emberwyrms.' + fid] = f_en; es['item.emberwyrms.' + fid] = f_es
os.makedirs(D + 'loot_table/chests', exist_ok=True); os.makedirs(D + 'worldgen/configured_feature', exist_ok=True); os.makedirs(D + 'worldgen/placed_feature', exist_ok=True)
def entry(name, weight, lo=1, hi=1): return {'type': 'minecraft:item', 'name': name, 'weight': weight, 'functions': count(lo, hi)}
w(D + 'loot_table/chests/dragon_village.json', {'type': 'minecraft:chest', 'pools': [{'rolls': {'type': 'minecraft:uniform', 'min': 4, 'max': 7}, 'entries':
  [entry('emberwyrms:emberscale', 20, 1, 4), entry('emberwyrms:phoenix_feather', 6, 1, 2), entry('minecraft:gold_ingot', 16, 2, 6),
   entry('minecraft:iron_ingot', 16, 2, 7), entry('minecraft:diamond', 4, 1, 2), entry('minecraft:emerald', 6, 1, 4), entry('minecraft:golden_apple', 3)] +
  [entry('emberwyrms:%s_dragon_scale' % e, 10, 1, 3) for e in EL] + [entry('emberwyrms:%s' % FOODS[e][0], 10, 2, 5) for e in EL]}]})
w(D + 'worldgen/configured_feature/dragon_village.json', {'type': 'emberwyrms:dragon_village', 'config': {}})
w(D + 'worldgen/placed_feature/dragon_village.json', {'feature': 'emberwyrms:dragon_village', 'placement': [
  {'type': 'minecraft:rarity_filter', 'chance': 160}, {'type': 'minecraft:in_square'},
  {'type': 'minecraft:heightmap', 'heightmap': 'WORLD_SURFACE_WG'}, {'type': 'minecraft:biome'}]})

w(A + 'lang/en_us.json', en); w(A + 'lang/es_es.json', es)
print('assets ok:', len(en), 'textos')
