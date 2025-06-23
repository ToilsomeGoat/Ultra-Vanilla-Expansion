package net.toilgoat.ultvanillaexp.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.IShearable;

public class PalmLeavesBlock extends Block implements SimpleWaterloggedBlock, IShearable {
        public static final int MAX_DECAY_DISTANCE = 9;

        public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, MAX_DECAY_DISTANCE);
        public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        public PalmLeavesBlock(Properties properties) {
            super(properties);
            this.registerDefaultState(this.stateDefinition.any()
                    .setValue(DISTANCE, MAX_DECAY_DISTANCE)
                    .setValue(PERSISTENT, false)
                    .setValue(WATERLOGGED, false));
        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(DISTANCE, PERSISTENT, WATERLOGGED);
        }

        @Override
        public boolean isRandomlyTicking(BlockState state) {
            return !state.getValue(PERSISTENT) && state.getValue(DISTANCE) == MAX_DECAY_DISTANCE;
        }

        @Override
        public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == MAX_DECAY_DISTANCE) {
                dropResources(state, level, pos);
                level.removeBlock(pos, false);
            }
        }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelReader,
                                     ScheduledTickAccess scheduledTicks,
                                     BlockPos pos, Direction dir,
                                     BlockPos neighborPos, BlockState neighborState,
                                     RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTicks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        int newDistance = getDistanceAt(neighborState) + 1;
        if (newDistance != 1 || state.getValue(DISTANCE) != newDistance) {
            scheduledTicks.scheduleTick(pos, this, 1);
        }

        return state;
    }

        @Override
        public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            level.setBlock(pos, updateDistance(state, level, pos), 3);
        }

        private BlockState updateDistance(BlockState state, LevelAccessor level, BlockPos pos) {
            int minDistance = MAX_DECAY_DISTANCE;
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (Direction direction : Direction.values()) {
                mutablePos.setWithOffset(pos, direction);
                int neighborDistance = getDistanceAt(level.getBlockState(mutablePos)) + 1;
                minDistance = Math.min(minDistance, neighborDistance);
                if (minDistance == 1) break;
            }

            return state.setValue(DISTANCE, minDistance);
        }

        private int getDistanceAt(BlockState neighbor) {
            if (neighbor.is(BlockTags.LOGS)) {
                return 0;
            }
            if (neighbor.getBlock() instanceof PalmLeavesBlock) {
                return neighbor.getValue(DISTANCE);
            }
            return MAX_DECAY_DISTANCE;
        }

        @Override
        public FluidState getFluidState(BlockState state) {
            return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
        }
    }