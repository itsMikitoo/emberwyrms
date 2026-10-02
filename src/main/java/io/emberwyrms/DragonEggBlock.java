package io.emberwyrms;

import io.emberwyrms.entity.DragonElement;
import io.emberwyrms.entity.DragonEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

/** Huevo de dragon: eclosiona solo con el tiempo (mas rapido sobre su bloque "nido"). */
public class DragonEggBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0.25, 0.0, 0.25, 0.75, 0.875, 0.75);
    private final DragonElement element;

    public DragonEggBlock(Settings settings, DragonElement element) {
        super(settings);
        this.element = element;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    private boolean onNest(ServerWorld world, BlockPos pos) {
        BlockState below = world.getBlockState(pos.down());
        return switch (this.element) {
            case FIRE -> below.isOf(Blocks.MAGMA_BLOCK) || below.isOf(Blocks.CAMPFIRE) || below.isOf(Blocks.SOUL_SAND);
            case ICE -> below.isIn(BlockTags.ICE) || below.isOf(Blocks.SNOW_BLOCK);
            case STORM -> below.isOf(Blocks.LIGHTNING_ROD) || below.isOf(Blocks.COPPER_BLOCK);
            case TIDE -> below.isOf(Blocks.PRISMARINE) || below.isOf(Blocks.CLAY) || below.isOf(Blocks.MUD);
        };
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int chance = this.onNest(world, pos) ? 1 : 8;
        if (random.nextInt(chance) != 0) return;

        DragonEntity dragon = ModEntities.of(this.element).create(world, SpawnReason.TRIGGERED);
        if (dragon == null) return;
        world.removeBlock(pos, false);
        dragon.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, random.nextFloat() * 360f, 0f);
        dragon.addCommandTag(DragonEntity.INIT_TAG);
        dragon.setAgeDays(0f);
        PlayerEntity near = world.getClosestPlayer(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 64.0, false);
        if (near != null) dragon.setOwner(near);
        world.spawnEntity(dragon);
        world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 1.0f, 0.8f);
    }
}
