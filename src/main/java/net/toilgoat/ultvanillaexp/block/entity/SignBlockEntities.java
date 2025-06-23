package net.toilgoat.ultvanillaexp.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SignBlockEntities extends SignBlockEntity {
    public SignBlockEntities(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntities.SIGNS.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntities.SIGNS.get();
    }
}
