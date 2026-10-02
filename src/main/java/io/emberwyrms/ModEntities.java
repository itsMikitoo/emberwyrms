package io.emberwyrms;

import io.emberwyrms.entity.AshDragonEntity;
import io.emberwyrms.entity.AshwingEntity;
import io.emberwyrms.entity.DragonElement;
import io.emberwyrms.entity.DragonEntity;
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
import net.minecraft.world.biome.BiomeKeys;

public class ModEntities {
    public static final EntityType<AshwingEntity> ASHWING = build("ashwing",
            EntityType.Builder.create(AshwingEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2.4f, 3.4f).maxTrackingRange(10).makeFireImmune());
    public static final EntityType<PhoenixEntity> PHOENIX = build("phoenix",
            EntityType.Builder.create(PhoenixEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.0f, 1.0f).maxTrackingRange(10).makeFireImmune());
    public static final EntityType<MedusaEntity> MEDUSA = build("medusa",
            EntityType.Builder.create(MedusaEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.9f, 1.8f).maxTrackingRange(8));

    public static final EntityType<AshDragonEntity> ASH_DRAGON = build("ash_dragon",
            EntityType.Builder.create(AshDragonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.4f, 3.2f).maxTrackingRange(16).makeFireImmune());

    public static final EntityType<DragonEntity> FIRE_DRAGON = dragon("fire_dragon", DragonElement.FIRE);
    public static final EntityType<DragonEntity> ICE_DRAGON = dragon("ice_dragon", DragonElement.ICE);
    public static final EntityType<DragonEntity> STORM_DRAGON = dragon("storm_dragon", DragonElement.STORM);
    public static final EntityType<DragonEntity> TIDE_DRAGON = dragon("tide_dragon", DragonElement.TIDE);

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Emberwyrms.id(name));
        return Registry.register(Registries.ENTITY_TYPE, key, builder.build(key));
    }

    private static EntityType<DragonEntity> dragon(String name, DragonElement element) {
        EntityType.Builder<DragonEntity> b = EntityType.Builder.<DragonEntity>create(
                (type, world) -> new DragonEntity(type, world, element), SpawnGroup.CREATURE)
                .dimensions(2.8f, 3.6f).passengerAttachments(2.5f).maxTrackingRange(10);
        if (element == DragonElement.FIRE) b = b.makeFireImmune();
        return build(name, b);
    }

    public static EntityType<DragonEntity> of(DragonElement element) {
        return switch (element) {
            case FIRE -> FIRE_DRAGON;
            case ICE -> ICE_DRAGON;
            case STORM -> STORM_DRAGON;
            case TIDE -> TIDE_DRAGON;
        };
    }

    public static void register() {
        FabricDefaultAttributeRegistry.register(ASHWING, AshwingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PHOENIX, PhoenixEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(MEDUSA, MedusaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ASH_DRAGON, AshDragonEntity.createAttributes());
        SpawnRestriction.register(ASH_DRAGON, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
        for (DragonElement el : DragonElement.values()) {
            FabricDefaultAttributeRegistry.register(of(el), DragonEntity.createAttributes());
            SpawnRestriction.register(of(el), SpawnLocationTypes.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
        }

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

        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), SpawnGroup.CREATURE, FIRE_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.CREATURE, FIRE_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS,
                BiomeKeys.SNOWY_SLOPES, BiomeKeys.SNOWY_PLAINS, BiomeKeys.ICE_SPIKES, BiomeKeys.GROVE),
                SpawnGroup.CREATURE, ICE_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS,
                BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.STONY_PEAKS),
                SpawnGroup.CREATURE, STORM_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_RIVER), SpawnGroup.CREATURE, TIDE_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_BEACH), SpawnGroup.CREATURE, TIDE_DRAGON, 4, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP),
                SpawnGroup.CREATURE, TIDE_DRAGON, 4, 1, 1);

        // Tierra de Dragones (biomas definidos en data/ al compilar)
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VOLCANIC_PEAKS), SpawnGroup.CREATURE, FIRE_DRAGON, 12, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VOLCANIC_PEAKS), SpawnGroup.CREATURE, ASHWING, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VOLCANIC_PEAKS), SpawnGroup.CREATURE, PHOENIX, 6, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VOLCANIC_PEAKS), SpawnGroup.MONSTER, ASH_DRAGON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.GLACIAL_SPIRES), SpawnGroup.CREATURE, ICE_DRAGON, 12, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.STORM_PLATEAU), SpawnGroup.CREATURE, STORM_DRAGON, 12, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.STORM_PLATEAU), SpawnGroup.CREATURE, PHOENIX, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.TIDE_MARSH), SpawnGroup.CREATURE, TIDE_DRAGON, 12, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.TIDE_MARSH), SpawnGroup.MONSTER, MEDUSA, 4, 1, 1);
    }
}
