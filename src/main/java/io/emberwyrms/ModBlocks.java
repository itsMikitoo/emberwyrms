package io.emberwyrms;

import io.emberwyrms.entity.DragonElement;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final Block FIRE_DRAGON_EGG = egg("fire_dragon_egg", DragonElement.FIRE);
    public static final Block ICE_DRAGON_EGG = egg("ice_dragon_egg", DragonElement.ICE);
    public static final Block STORM_DRAGON_EGG = egg("storm_dragon_egg", DragonElement.STORM);
    public static final Block TIDE_DRAGON_EGG = egg("tide_dragon_egg", DragonElement.TIDE);

    public static final Block PHOENIX_EGG = make("phoenix_egg", settings -> new PhoenixEggBlock(settings));

    private static Block make(String name, java.util.function.Function<AbstractBlock.Settings, Block> factory) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Emberwyrms.id(name));
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .registryKey(key).strength(1.5f).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.STONE);
        return Registry.register(Registries.BLOCK, key, factory.apply(settings));
    }

    private static Block egg(String name, DragonElement element) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Emberwyrms.id(name));
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .registryKey(key).strength(1.5f).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.STONE);
        return Registry.register(Registries.BLOCK, key, new DragonEggBlock(settings, element));
    }

    public static void register() {
    }
}
