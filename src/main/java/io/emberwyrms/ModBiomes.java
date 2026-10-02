package io.emberwyrms;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

/** Biomas de la dimension Tierra de Dragones (se definen en data/ al compilar). */
public class ModBiomes {
    public static final RegistryKey<Biome> VOLCANIC_PEAKS = key("volcanic_peaks");
    public static final RegistryKey<Biome> GLACIAL_SPIRES = key("glacial_spires");
    public static final RegistryKey<Biome> STORM_PLATEAU = key("storm_plateau");
    public static final RegistryKey<Biome> TIDE_MARSH = key("tide_marsh");

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Emberwyrms.id(name));
    }
}
