package io.emberwyrms;

import java.util.function.Function;
import io.emberwyrms.item.DragonHornItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static final Item EMBERSCALE = reg("emberscale", Item::new);
    public static final Item FIRE_DRAGON_SCALE = reg("fire_dragon_scale", Item::new);
    public static final Item ICE_DRAGON_SCALE = reg("ice_dragon_scale", Item::new);
    public static final Item STORM_DRAGON_SCALE = reg("storm_dragon_scale", Item::new);
    public static final Item TIDE_DRAGON_SCALE = reg("tide_dragon_scale", Item::new);

    public static final Item CINDER_STEAK = reg("cinder_steak", Item::new);
    public static final Item FROST_FISH = reg("frost_fish", Item::new);
    public static final Item STORM_JERKY = reg("storm_jerky", Item::new);
    public static final Item TIDE_CATCH = reg("tide_catch", Item::new);
    public static final Item DRAGON_HORN = reg("dragon_horn", s -> new DragonHornItem(s.maxCount(1)));
    public static final Item ASH_HEART = reg("ash_heart", Item::new);
    public static final Item ASH_DRAGON_SPAWN_EGG = reg("ash_dragon_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.ASH_DRAGON)));
    public static final Item PHOENIX_FEATHER = reg("phoenix_feather", Item::new);
    public static final Item PHOENIX_EGG = regBlock("phoenix_egg", ModBlocks.PHOENIX_EGG);

    public static final Item FIRE_DRAGON_EGG = regBlock("fire_dragon_egg", ModBlocks.FIRE_DRAGON_EGG);
    public static final Item ICE_DRAGON_EGG = regBlock("ice_dragon_egg", ModBlocks.ICE_DRAGON_EGG);
    public static final Item STORM_DRAGON_EGG = regBlock("storm_dragon_egg", ModBlocks.STORM_DRAGON_EGG);
    public static final Item TIDE_DRAGON_EGG = regBlock("tide_dragon_egg", ModBlocks.TIDE_DRAGON_EGG);

    public static final Item ASHWING_SPAWN_EGG = reg("ashwing_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.ASHWING)));
    public static final Item PHOENIX_SPAWN_EGG = reg("phoenix_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.PHOENIX)));
    public static final Item MEDUSA_SPAWN_EGG = reg("medusa_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.MEDUSA)));
    public static final Item FIRE_DRAGON_SPAWN_EGG = reg("fire_dragon_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.FIRE_DRAGON)));
    public static final Item ICE_DRAGON_SPAWN_EGG = reg("ice_dragon_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.ICE_DRAGON)));
    public static final Item STORM_DRAGON_SPAWN_EGG = reg("storm_dragon_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.STORM_DRAGON)));
    public static final Item TIDE_DRAGON_SPAWN_EGG = reg("tide_dragon_spawn_egg", s -> new SpawnEggItem(s.spawnEgg(ModEntities.TIDE_DRAGON)));

    public static Item foodOf(io.emberwyrms.entity.DragonElement element) {
        return switch (element) {
            case FIRE -> CINDER_STEAK;
            case ICE -> FROST_FISH;
            case STORM -> STORM_JERKY;
            case TIDE -> TIDE_CATCH;
        };
    }

    public static Item eggOf(io.emberwyrms.entity.DragonElement element) {
        return switch (element) {
            case FIRE -> FIRE_DRAGON_EGG;
            case ICE -> ICE_DRAGON_EGG;
            case STORM -> STORM_DRAGON_EGG;
            case TIDE -> TIDE_DRAGON_EGG;
        };
    }

    static Item reg(String name, Function<Item.Settings, Item> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Emberwyrms.id(name));
        return Registry.register(Registries.ITEM, key, factory.apply(new Item.Settings().registryKey(key)));
    }

    private static Item regBlock(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Emberwyrms.id(name));
        return Registry.register(Registries.ITEM, key,
                new BlockItem(block, new Item.Settings().registryKey(key).useBlockPrefixedTranslationKey()));
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(e -> {
            e.add(ASHWING_SPAWN_EGG); e.add(PHOENIX_SPAWN_EGG); e.add(MEDUSA_SPAWN_EGG);
            e.add(FIRE_DRAGON_SPAWN_EGG); e.add(ICE_DRAGON_SPAWN_EGG);
            e.add(STORM_DRAGON_SPAWN_EGG); e.add(TIDE_DRAGON_SPAWN_EGG);
        });
    }
}
