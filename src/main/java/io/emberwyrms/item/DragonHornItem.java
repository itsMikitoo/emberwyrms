package io.emberwyrms.item;

import io.emberwyrms.Emberwyrms;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

/** Cuerno del Dragon: viaja entre el Overworld y la Tierra de Dragones (usalo para ir y para volver). */
public class DragonHornItem extends Item {
    public static final RegistryKey<World> DRAGONLANDS = RegistryKey.of(RegistryKeys.WORLD, Emberwyrms.id("dragonlands"));

    public DragonHornItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && user instanceof ServerPlayerEntity player && world.getServer() != null) {
            MinecraftServer server = world.getServer();
            RegistryKey<World> destKey = world.getRegistryKey().equals(DRAGONLANDS) ? World.OVERWORLD : DRAGONLANDS;
            ServerWorld dest = server.getWorld(destKey);
            if (dest == null) {
                player.sendMessage(Text.translatable("item.emberwyrms.dragon_horn.unavailable"), true);
                return ActionResult.FAIL;
            }
            int x = player.getBlockX();
            int z = player.getBlockZ();
            dest.getChunk(x >> 4, z >> 4);
            int y = dest.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z) + 1;
            player.teleportTo(new TeleportTarget(dest, new Vec3d(x + 0.5, y, z + 0.5), Vec3d.ZERO,
                    player.getYaw(), player.getPitch(), TeleportTarget.NO_OP));
        }
        return ActionResult.SUCCESS;
    }
}
