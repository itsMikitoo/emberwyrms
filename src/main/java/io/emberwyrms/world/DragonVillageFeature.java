package io.emberwyrms.world;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.ModBlocks;
import io.emberwyrms.ModEntities;
import io.emberwyrms.entity.DragonElement;
import io.emberwyrms.entity.DragonEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.entity.SpawnReason;
import net.minecraft.inventory.LootableInventory;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/** Aldea de dragones: explanada, nido con huevo en el centro, 4 cabañas con botin, torre de vigilancia y dragones salvajes hostiles. */
public class DragonVillageFeature extends Feature<DefaultFeatureConfig> {
    public static final RegistryKey<LootTable> LOOT = RegistryKey.of(RegistryKeys.LOOT_TABLE, Emberwyrms.id("chests/dragon_village"));

    public DragonVillageFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    private static void set(StructureWorldAccess w, int x, int y, int z, Block b) {
        w.setBlockState(new BlockPos(x, y, z), b.getDefaultState(), Block.NOTIFY_LISTENERS);
    }

    private static void set(StructureWorldAccess w, int x, int y, int z, BlockState s) {
        w.setBlockState(new BlockPos(x, y, z), s, Block.NOTIFY_LISTENERS);
    }

    private static void chest(StructureWorldAccess w, Random r, int x, int y, int z) {
        set(w, x, y, z, Blocks.CHEST);
        LootableInventory.setLootTable(w, r, new BlockPos(x, y, z), LOOT);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> ctx) {
        StructureWorldAccess w = ctx.getWorld();
        BlockPos o = ctx.getOrigin();
        Random r = ctx.getRandom();
        if (!w.getFluidState(o).isEmpty() || !w.getFluidState(o.down()).isEmpty()) return false;
        int base = o.getY();
        int cx = o.getX();
        int cz = o.getZ();

        // 1) explanada circular: limpia el relieve, pone suelo y cimientos
        for (int dx = -14; dx <= 14; dx++) {
            for (int dz = -14; dz <= 14; dz++) {
                int d2 = dx * dx + dz * dz;
                if (d2 > 14 * 14) continue;
                int x = cx + dx;
                int z = cz + dz;
                for (int y = base + 12; y >= base; y--) set(w, x, y, z, Blocks.AIR);
                Block floor = d2 > 11 * 11 ? Blocks.COARSE_DIRT : (r.nextInt(3) == 0 ? Blocks.COBBLESTONE : Blocks.GRAVEL);
                set(w, x, base - 1, z, floor);
                for (int y = base - 2; y > base - 14; y--) {
                    if (!w.getBlockState(new BlockPos(x, y, z)).isAir()) break;
                    set(w, x, y, z, Blocks.COBBLESTONE);
                }
            }
        }

        // 2) nido central con un huevo de dragon sobre su bloque "nido"
        DragonElement el = DragonElement.values()[r.nextInt(4)];
        for (int dx = -4; dx <= 4; dx++) {
            for (int dz = -4; dz <= 4; dz++) {
                int d2 = dx * dx + dz * dz;
                if (d2 > 16) continue;
                set(w, cx + dx, base - 1, cz + dz, d2 >= 9 ? Blocks.HAY_BLOCK : Blocks.SOUL_SAND);
                if (d2 >= 9) set(w, cx + dx, base, cz + dz, Blocks.HAY_BLOCK);
            }
        }
        Block nest = switch (el) {
            case FIRE -> Blocks.MAGMA_BLOCK;
            case ICE -> Blocks.PACKED_ICE;
            case STORM -> Blocks.COPPER_BLOCK;
            case TIDE -> Blocks.PRISMARINE;
        };
        set(w, cx, base - 1, cz, nest);
        set(w, cx, base, cz, ModBlocks.eggOf(el));

        // 3) cuatro cabañas
        for (int sx = -1; sx <= 1; sx += 2) {
            for (int sz = -1; sz <= 1; sz += 2) hut(w, r, cx + sx * 9 - 3, cz + sz * 9 - 3, base, sz);
        }

        // 4) torre de vigilancia con escalera y botin arriba
        int tz = cz - 12;
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                boolean wall = Math.abs(dx) == 2 || Math.abs(dz) == 2;
                for (int y = base - 1; y <= base + 11; y++) {
                    if (y == base - 1) set(w, cx + dx, y, tz + dz, Blocks.DEEPSLATE_BRICKS);
                    else if (wall) set(w, cx + dx, y, tz + dz, (Math.abs(dx) == 2 && Math.abs(dz) == 2) ? Blocks.POLISHED_BLACKSTONE_BRICKS : Blocks.DEEPSLATE_BRICKS);
                }
                set(w, cx + dx, base + 12, tz + dz, Blocks.DARK_OAK_PLANKS);
                if (wall && (dx + dz) % 2 == 0) set(w, cx + dx, base + 13, tz + dz, Blocks.DEEPSLATE_BRICKS);
            }
        }
        set(w, cx, base, tz + 2, Blocks.AIR);
        set(w, cx, base + 1, tz + 2, Blocks.AIR);
        for (int y = base; y <= base + 12; y++) set(w, cx, y, tz - 1, Blocks.LADDER.getDefaultState().with(LadderBlock.FACING, Direction.SOUTH));
        chest(w, r, cx + 1, base + 13, tz + 1);
        set(w, cx - 1, base + 13, tz + 1, Blocks.TORCH);

        // 5) pilares de hueso con antorchas alrededor de la plaza
        for (int k = 0; k < 12; k++) {
            double a = k * Math.PI / 6.0;
            int px = cx + (int) Math.round(13 * Math.cos(a));
            int pz = cz + (int) Math.round(13 * Math.sin(a));
            for (int y = base; y < base + 4; y++) set(w, px, y, pz, Blocks.BONE_BLOCK);
            set(w, px, base + 4, pz, Blocks.TORCH);
        }

        // 6) dragones salvajes (hostiles) que vigilan la aldea
        try {
            ServerWorld sw = w.toServerWorld();
            for (int k = 0; k < 2; k++) {
                DragonElement e2 = DragonElement.values()[r.nextInt(4)];
                DragonEntity d = ModEntities.of(e2).create(sw, SpawnReason.STRUCTURE);
                if (d == null) continue;
                d.refreshPositionAndAngles(cx + 0.5 + (r.nextInt(9) - 4), base, cz + 0.5 + (r.nextInt(9) - 4), r.nextFloat() * 360f, 0f);
                d.addCommandTag(DragonEntity.INIT_TAG);
                d.setAgeDays(85f + r.nextFloat() * 40f);
                d.setPersistent();
                w.spawnEntityAndPassengers(d);
            }
        } catch (Exception ignored) {
            // si el mundo no permite spawnear ahora, la aldea se queda sin guardianes
        }
        return true;
    }

    private static void hut(StructureWorldAccess w, Random r, int x0, int z0, int base, int sz) {
        int doorZ = sz > 0 ? 0 : 6;
        for (int dx = 0; dx <= 6; dx++) {
            for (int dz = 0; dz <= 6; dz++) {
                int x = x0 + dx;
                int z = z0 + dz;
                set(w, x, base - 1, z, Blocks.STONE_BRICKS);
                boolean wall = dx == 0 || dx == 6 || dz == 0 || dz == 6;
                if (wall) {
                    boolean corner = (dx == 0 || dx == 6) && (dz == 0 || dz == 6);
                    for (int y = base; y <= base + 3; y++) set(w, x, y, z, corner ? Blocks.DARK_OAK_LOG : Blocks.DEEPSLATE_BRICKS);
                    if (!corner && y2(dx, dz)) set(w, x, base + 2, z, Blocks.GLASS_PANE);
                }
            }
        }
        set(w, x0 + 3, base, z0 + doorZ, Blocks.AIR);
        set(w, x0 + 3, base + 1, z0 + doorZ, Blocks.AIR);
        for (int dx = -1; dx <= 7; dx++) {
            for (int dz = -1; dz <= 7; dz++) set(w, x0 + dx, base + 4, z0 + dz, Blocks.DARK_OAK_PLANKS);
        }
        for (int dx = 0; dx <= 6; dx++) {
            for (int dz = 0; dz <= 6; dz++) set(w, x0 + dx, base + 5, z0 + dz, Blocks.DARK_OAK_SLAB);
        }
        for (int dx = 2; dx <= 4; dx++) {
            for (int dz = 2; dz <= 4; dz++) set(w, x0 + dx, base + 5, z0 + dz, Blocks.DARK_OAK_PLANKS);
        }
        set(w, x0 + 3, base + 3, z0 + 3, Blocks.LANTERN.getDefaultState().with(LanternBlock.HANGING, true));
        chest(w, r, x0 + 1, base, z0 + (doorZ == 0 ? 5 : 1));
    }

    private static boolean y2(int dx, int dz) {
        return (dx == 3 || dz == 3);
    }
}
