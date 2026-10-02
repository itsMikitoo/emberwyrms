package io.emberwyrms;

import io.emberwyrms.entity.AshwingEntity;
import io.emberwyrms.entity.MedusaEntity;
import io.emberwyrms.entity.PhoenixEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.Heightmap;

public class ModEntities {
    public static final EntityType<AshwingEntity> ASHWING = build("ashwing",
            EntityType.Builder.create(AshwingEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2.0f, 1.9f).maxTrackingRange(10).makeFireImmune());
    public static final EntityType<PhoenixEntity> PHOENIX = build("phoenix",
            EntityType.Builder.create(PhoenixEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.0f, 1.0f).maxTrackingRange(10).makeFireImmune());
    public static final EntityType<MedusaEntity> MEDUSA = build("medusa",
            EntityType.Builder.create(MedusaEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.9f, 1.8f).maxTrackingRange(8));

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Emberwyrms.id(name));
        return Registry.register(Registries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void register() {
        FabricDefaultAttributeRegistry.register(ASHWING, AshwingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PHOENIX, PhoenixEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(MEDUSA, MedusaEntity.createAttributes());

        SpawnRestriction.register(ASHWING, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
        SpawnRestriction.register(PHOENIX, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
        SpawnRestriction.register(MEDUSA, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), SpawnGroup.CREATURE, ASHWING, 6, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), SpawnGroup.CREATURE, ASHWING, 6, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.CREATURE, PHOENIX, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), SpawnGroup.CREATURE, PHOENIX, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, MEDUSA, 2, 1, 1);
    }
}
