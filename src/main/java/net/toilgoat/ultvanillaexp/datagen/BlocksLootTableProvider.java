package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.block.Blocks;

import java.util.Set;

public class BlocksLootTableProvider extends BlockLootSubProvider {

    protected BlocksLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(Blocks.POLISHED_CALCITE.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE.get());
        dropSelf(Blocks.POLISHED_ANDESITE_BRICKS.get());
        dropSelf(Blocks.POLISHED_CALCITE_BRICKS.get());
        dropSelf(Blocks.POLISHED_DIORITE_BRICKS.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE_BRICKS.get());
        dropSelf(Blocks.POLISHED_GRANITE_BRICKS.get());
        dropSelf(Blocks.CRACKED_POLISHED_ANDESITE_BRICKS.get());
        dropSelf(Blocks.CRACKED_POLISHED_CALCITE_BRICKS.get());
        dropSelf(Blocks.CRACKED_POLISHED_DIORITE_BRICKS.get());
        dropSelf(Blocks.CRACKED_POLISHED_DRIPSTONE_BRICKS.get());
        dropSelf(Blocks.CRACKED_POLISHED_GRANITE_BRICKS.get());
        dropSelf(Blocks.CHISELED_POLISHED_ANDESITE_BRICKS.get());
        dropSelf(Blocks.CHISELED_POLISHED_CALCITE_BRICKS.get());
        dropSelf(Blocks.CHISELED_POLISHED_DIORITE_BRICKS.get());
        dropSelf(Blocks.CHISELED_POLISHED_DRIPSTONE_BRICKS.get());
        dropSelf(Blocks.CHISELED_POLISHED_GRANITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_DEEPSLATE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get());
        dropSelf(Blocks.WAX_BLOCK.get());
        // Stairs
        dropSelf(Blocks.POLISHED_DRIPSTONE_STAIRS.get());
        //Slab
        add(Blocks.POLISHED_DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_DRIPSTONE_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
