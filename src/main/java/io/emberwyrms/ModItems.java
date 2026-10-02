package io.emberwyrms;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static final Item EMBERSCALE = reg("emberscale", Item::new);
    public static final Item ASHWING_SPAWN_EGG = reg("ashwing_spawn_egg",
            s -> new SpawnEggItem(s.spawnEgg(ModEntities.ASHWING)));
    public static final Item PHOENIX_SPAWN_EGG = reg("phoenix_spawn_egg",
            s -> new SpawnEggItem(s.spawnEgg(ModEntities.PHOENIX)));
    public static final Item MEDUSA_SPAWN_EGG = reg("medusa_spawn_egg",
            s -> new SpawnEggItem(s.spawnEgg(ModEntities.MEDUSA)));

    private static Item reg(String name, Function<Item.Settings, Item> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Emberwyrms.id(name));
        return Registry.register(Registries.ITEM, key, factory.apply(new Item.Settings().registryKey(key)));
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(e -> {
            e.add(ASHWING_SPAWN_EGG);
            e.add(PHOENIX_SPAWN_EGG);
            e.add(MEDUSA_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(e -> e.add(EMBERSCALE));
    }
}
