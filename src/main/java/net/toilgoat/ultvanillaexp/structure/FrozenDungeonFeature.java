package net.toilgoat.ultvanillaexp.structure;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.Entities;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class FrozenDungeonFeature extends Feature<NoneFeatureConfiguration> {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final BlockState AIR = Blocks.CAVE_AIR.defaultBlockState();
    private static final List<BlockState> WALL_BLOCKS = List.of(
            Blocks.PACKED_ICE.defaultBlockState(),
            Blocks.PACKED_ICE.defaultBlockState(),
            Blocks.PACKED_ICE.defaultBlockState(),
            Blocks.ICE.defaultBlockState(),
            Blocks.ICE.defaultBlockState(),
            Blocks.BLUE_ICE.defaultBlockState()
    );

    public FrozenDungeonFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        Predicate<BlockState> predicate = Feature.isReplaceable(net.minecraft.tags.BlockTags.FEATURES_CANNOT_REPLACE);
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        WorldGenLevel level = context.level();


        int radiusX = random.nextInt(2) + 2;
        int radiusZ = random.nextInt(2) + 2;
        int xStart = -radiusX - 1;
        int xEnd = radiusX + 1;
        int zStart = -radiusZ - 1;
        int zEnd = radiusZ + 1;

        int doorwayCount = 0;

        // Check area
        for (int x = xStart; x <= xEnd; ++x) {
            for (int y = -1; y <= 4; ++y) {
                for (int z = zStart; z <= zEnd; ++z) {
                    BlockPos checkPos = origin.offset(x, y, z);
                    boolean solid = level.getBlockState(checkPos).isSolid();
                    if (y == -1 && !solid) return false;
                    if (y == 4 && !solid) return false;

                    if ((x == xStart || x == xEnd || z == zStart || z == zEnd) && y == 0
                            && level.isEmptyBlock(checkPos) && level.isEmptyBlock(checkPos.above())) {
                        doorwayCount++;
                    }
                }
            }
        }

        if (doorwayCount < 1 || doorwayCount > 5) return false;

        for (int x = xStart; x <= xEnd; ++x) {
            for (int y = 3; y >= -1; --y) {
                for (int z = zStart; z <= zEnd; ++z) {
                    BlockPos pos = origin.offset(x, y, z);
                    BlockState state = level.getBlockState(pos);
                    if (x != xStart && y != -1 && z != zStart && x != xEnd && y != 4 && z != zEnd) {
                        if (!state.is(Blocks.CHEST) && !state.is(Blocks.SPAWNER)) {
                            this.safeSetBlock(level, pos, AIR, predicate);
                        }
                    } else if (pos.getY() >= level.getMinY() && !level.getBlockState(pos.below()).isSolid()) {
                        level.setBlock(pos, AIR, 2);
                    } else if (state.isSolid() && !state.is(Blocks.CHEST)) {
                    BlockState chosenBlock = WALL_BLOCKS.get(random.nextInt(WALL_BLOCKS.size()));

                    if (y == -1 && random.nextInt(4) != 0) {
                        chosenBlock = Blocks.PACKED_ICE.defaultBlockState();
                    }

                    this.safeSetBlock(level, pos, chosenBlock, predicate);
                    }
                }
            }
        }

        // Place loot chests
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                int x = origin.getX() + random.nextInt(radiusX * 2 + 1) - radiusX;
                int y = origin.getY();
                int z = origin.getZ() + random.nextInt(radiusZ * 2 + 1) - radiusZ;
                BlockPos chestPos = new BlockPos(x, y, z);
                if (level.isEmptyBlock(chestPos)) {
                    int solidSides = 0;
                    for (Direction dir : Plane.HORIZONTAL) {
                        if (level.getBlockState(chestPos.relative(dir)).isSolid()) {
                            solidSides++;
                        }
                    }

                    if (solidSides == 1) {
                        this.safeSetBlock(level, chestPos, StructurePiece.reorient(level, chestPos, Blocks.CHEST.defaultBlockState()), predicate);
                        RandomizableContainer.setBlockEntityLootTable(
                                level,
                                random,
                                chestPos,
                                ResourceKey.create(net.minecraft.core.registries.Registries.LOOT_TABLE,
                                        ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "chests/frozen_dungeon"))
                        );
                        break;
                    }
                }
            }
        }

        this.safeSetBlock(level, origin, Blocks.SPAWNER.defaultBlockState(), predicate);
        BlockEntity be = level.getBlockEntity(origin);
        if (be instanceof SpawnerBlockEntity spawner) {
            EntityType<?>[] possibleMobs = new EntityType<?>[] {
                    Entities.FROSTBITTEN.get(),
                    Entities.FROSTBITTEN.get(),
                    EntityType.STRAY
            };

            EntityType<?> chosenMob = possibleMobs[random.nextInt(possibleMobs.length)];
            spawner.setEntityId(chosenMob, random);
        } else {
            LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", origin.getX(), origin.getY(), origin.getZ());
        }
        LOGGER.info("Successfully placed Frozen Dungeon at {}", origin);
        return true;
    }
}
