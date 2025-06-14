package net.toilgoat.ultvanillaexp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.toilgoat.ultvanillaexp.block.entity.AbstractFrosterBlockEntity;

import javax.annotation.Nullable;

public abstract class AbstractFrosterBlock extends BaseEntityBlock{

        public static final EnumProperty<Direction> FACING;
        public static final BooleanProperty LIT;

        public AbstractFrosterBlock(BlockBehaviour.Properties p_48687_) {
            super(p_48687_);
            this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(LIT, false));
        }

        protected abstract MapCodec<? extends AbstractFrosterBlock> codec();

        protected InteractionResult useWithoutItem(BlockState p_48706_, Level p_48707_, BlockPos p_48708_, Player p_48709_, BlockHitResult p_48711_) {
            if (!p_48707_.isClientSide) {
                this.openContainer(p_48707_, p_48708_, p_48709_);
            }

            return InteractionResult.SUCCESS;
        }

        protected abstract void openContainer(Level var1, BlockPos var2, Player var3);

        public BlockState getStateForPlacement(BlockPlaceContext context) {
            return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        }

        protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
            if (!state.is(newState.getBlock())) {
                BlockEntity blockentity = level.getBlockEntity(pos);
                if (blockentity instanceof AbstractFrosterBlockEntity) {
                    if (level instanceof ServerLevel) {
                        Containers.dropContents(level, pos, (AbstractFrosterBlockEntity)blockentity);
                        ((AbstractFrosterBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)level, Vec3.atCenterOf(pos));
                    }

                    super.onRemove(state, level, pos, newState, isMoving);
                    level.updateNeighbourForOutputSignal(pos, this);
                } else {
                    super.onRemove(state, level, pos, newState, isMoving);
                }
            }

        }

        protected boolean hasAnalogOutputSignal(BlockState state) {
            return true;
        }

        protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
            return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
        }

        protected BlockState rotate(BlockState state, Rotation rotation) {
            return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
        }

        protected BlockState mirror(BlockState state, Mirror mirror) {
            return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
        }

        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(new Property[]{FACING, LIT});
        }

        @Nullable
        protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level, BlockEntityType<T> serverType, BlockEntityType<? extends AbstractFrosterBlockEntity> clientType) {
            BlockEntityTicker var10000;
            if (level instanceof ServerLevel serverlevel) {
                var10000 = createTickerHelper(serverType, clientType, (p_380330_, p_379922_, p_379493_, p_380329_) -> AbstractFrosterBlockEntity.serverTick(serverlevel, p_379922_, p_379493_, p_380329_));
            } else {
                var10000 = null;
            }

            return var10000;
        }

        static {
            FACING = HorizontalDirectionalBlock.FACING;
            LIT = BlockStateProperties.LIT;
        }

}
