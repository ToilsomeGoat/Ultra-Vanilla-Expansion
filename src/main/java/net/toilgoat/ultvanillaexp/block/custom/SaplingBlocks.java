package net.toilgoat.ultvanillaexp.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Properties;
import java.util.function.Supplier;

public class SaplingBlocks extends SaplingBlock{
    private final Supplier<Block> blockToSurviveOn;

    public SaplingBlocks(TreeGrower treeGrower, Properties properties, Supplier<Block> block) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return blockToSurviveOn.get() == state.getBlock();
    }
}
