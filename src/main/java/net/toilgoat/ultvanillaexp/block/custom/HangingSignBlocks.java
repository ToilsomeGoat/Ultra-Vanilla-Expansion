package net.toilgoat.ultvanillaexp.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.toilgoat.ultvanillaexp.block.entity.HangingSignBlockEntities;

public class HangingSignBlocks extends CeilingHangingSignBlock {
    public HangingSignBlocks(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new HangingSignBlockEntities(pPos, pState);
    }
}
