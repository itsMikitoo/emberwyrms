package io.emberwyrms;

import io.emberwyrms.entity.PhoenixEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

/** Huevo de fenix: eclosiona con el tiempo (mucho mas rapido sobre fuego de campamento, magma o arena de almas). */
public class PhoenixEggBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0.25, 0.0, 0.25, 0.75, 0.875, 0.75);

    public PhoenixEggBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState below = world.getBlockState(pos.down());
        boolean hot = below.isOf(Blocks.CAMPFIRE) || below.isOf(Blocks.MAGMA_BLOCK) || below.isOf(Blocks.SOUL_SAND);
        if (random.nextInt(hot ? 1 : 8) != 0) return;

        PhoenixEntity phoenix = ModEntities.PHOENIX.create(world, SpawnReason.TRIGGERED);
        if (phoenix == null) return;
        world.removeBlock(pos, false);
        phoenix.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, random.nextFloat() * 360f, 0f);
        PlayerEntity near = world.getClosestPlayer(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 64.0, false);
        if (near != null) phoenix.setOwner(near);
        world.spawnEntity(phoenix);
        world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 1.0f, 1.3f);
    }
}
