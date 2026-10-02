package io.emberwyrms.world;

import io.emberwyrms.Emberwyrms;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> DRAGON_VILLAGE =
            Registry.register(Registries.FEATURE, Emberwyrms.id("dragon_village"), new DragonVillageFeature());
    public static final RegistryKey<PlacedFeature> DRAGON_VILLAGE_PLACED =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Emberwyrms.id("dragon_village"));

    public static void register() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.SURFACE_STRUCTURES, DRAGON_VILLAGE_PLACED);
    }
}
