# Emberwyrms 0.2.0 (Fase 1) - Fabric 1.21.11

Proyecto nuevo reescrito desde cero. Incluye Ashwing (dragon), Fenix y Medusa con modelos 3D
mucho mas detallados (38 / 30 / 34 piezas), texturas nuevas y animaciones.

## Compilar
1. Entra en https://fabricmc.net/develop , elige Minecraft 1.21.11, mod id `emberwyrms`, y descarga la plantilla.
2. Copia de esta carpeta a la plantilla: `src/` y `tools/`. Si el `gradle.properties` de la plantilla
   difiere (yarn_mappings, loom, fabric_version), usa SIEMPRE los valores de la plantilla.
3. `./gradlew build` -> jar en `build/libs/`.
4. Prueba: `./gradlew runClient`, modo creativo, pestana "Huevos generadores".

## Modelos/texturas
Todo sale de `tools/generate.py`. Para cambiar un modelo, editalo ahi y ejecuta
`python3 tools/generate.py` (necesita Pillow). Regenera los .java y los .png con el UV sincronizado.

## Controles (fase 1)
- Alascua: carne cruda para domesticar (1/3 de probabilidad), mano vacia = sentar/levantar.
- Fenix: polvo de blaze para domesticar. Medusa: hostil, su mirada ralentiza.
