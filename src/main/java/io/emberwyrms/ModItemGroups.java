package io.emberwyrms;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

/** Pestana propia del mod en el modo creativo. */
public class ModItemGroups {
    public static final ItemGroup EMBERWYRMS = Registry.register(Registries.ITEM_GROUP,
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Emberwyrms.id("main")),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.FIRE_DRAGON_EGG))
                    .displayName(Text.translatable("itemGroup.emberwyrms"))
                    .entries((context, entries) -> {
                        entries.add(ModItems.BESTIARY);
                        entries.add(ModItems.DRAGON_HORN);
                        entries.add(ModItems.ASH_DRAGON_SPAWN_EGG);
                        entries.add(ModItems.ASH_HEART);
                        entries.add(ModItems.ASHWING_SPAWN_EGG);
                        entries.add(ModItems.FIRE_DRAGON_SPAWN_EGG);
                        entries.add(ModItems.ICE_DRAGON_SPAWN_EGG);
                        entries.add(ModItems.STORM_DRAGON_SPAWN_EGG);
                        entries.add(ModItems.TIDE_DRAGON_SPAWN_EGG);
                        entries.add(ModItems.PHOENIX_SPAWN_EGG);
                        entries.add(ModItems.MEDUSA_SPAWN_EGG);
                        entries.add(ModItems.FIRE_DRAGON_EGG);
                        entries.add(ModItems.ICE_DRAGON_EGG);
                        entries.add(ModItems.STORM_DRAGON_EGG);
                        entries.add(ModItems.TIDE_DRAGON_EGG);
                        entries.add(ModItems.PHOENIX_EGG);
                        entries.add(ModItems.PHOENIX_FEATHER);
                        entries.add(ModItems.CINDER_STEAK);
                        entries.add(ModItems.FROST_FISH);
                        entries.add(ModItems.STORM_JERKY);
                        entries.add(ModItems.TIDE_CATCH);
                        entries.add(ModItems.EMBERSCALE);
                        entries.add(ModItems.FIRE_DRAGON_SCALE);
                        entries.add(ModItems.ICE_DRAGON_SCALE);
                        entries.add(ModItems.STORM_DRAGON_SCALE);
                        entries.add(ModItems.TIDE_DRAGON_SCALE);
                        for (net.minecraft.item.Item[] set : ModArmor.PIECES) {
                            for (net.minecraft.item.Item piece : set) entries.add(piece);
                        }
                    })
                    .build());

    public static void register() {
    }
}
