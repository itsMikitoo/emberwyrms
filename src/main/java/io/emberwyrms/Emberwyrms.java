package io.emberwyrms;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Emberwyrms implements ModInitializer {
    public static final String MOD_ID = "emberwyrms";

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModSounds.register();
        ModEntities.register();
        ModBlocks.register();
        ModItems.register();
        ModArmor.register();
        ArmorPerks.register();
        ModItemGroups.register();
        io.emberwyrms.world.ModFeatures.register();
    }
}
