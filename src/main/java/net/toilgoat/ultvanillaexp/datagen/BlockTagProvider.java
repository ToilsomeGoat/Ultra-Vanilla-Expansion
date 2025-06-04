package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, UltVanillaExp.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.POLISHED_CALCITE.get())
                .add(Blocks.POLISHED_DRIPSTONE.get())
                .add(Blocks.POLISHED_ANDESITE_BRICKS.get())
                .add(Blocks.POLISHED_CALCITE_BRICKS.get())
                .add(Blocks.POLISHED_DIORITE_BRICKS.get())
                .add(Blocks.POLISHED_DRIPSTONE_BRICKS.get())
                .add(Blocks.POLISHED_GRANITE_BRICKS.get())
                .add(Blocks.CRACKED_POLISHED_ANDESITE_BRICKS.get())
                .add(Blocks.CRACKED_POLISHED_CALCITE_BRICKS.get())
                .add(Blocks.CRACKED_POLISHED_DIORITE_BRICKS.get())
                .add(Blocks.CRACKED_POLISHED_DRIPSTONE_BRICKS.get())
                .add(Blocks.CRACKED_POLISHED_GRANITE_BRICKS.get())
                .add(Blocks.CHISELED_POLISHED_ANDESITE_BRICKS.get())
                .add(Blocks.CHISELED_POLISHED_CALCITE_BRICKS.get())
                .add(Blocks.CHISELED_POLISHED_DIORITE_BRICKS.get())
                .add(Blocks.CHISELED_POLISHED_DRIPSTONE_BRICKS.get())
                .add(Blocks.CHISELED_POLISHED_GRANITE_BRICKS.get())
                .add(Blocks.MOSSY_DEEPSLATE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get())
                .add(Blocks.POLISHED_DRIPSTONE_STAIRS.get())
                .add(Blocks.POLISHED_DRIPSTONE_SLAB.get());

        tag(BlockTags.NEEDS_IRON_TOOL);

    }
}
