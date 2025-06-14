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
                .add(Blocks.MOSSY_TUFF_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get())
                .add(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get())
                //Stairs
                .add(Blocks.DRIPSTONE_STAIRS.get())
                .add(Blocks.CALCITE_STAIRS.get())
                .add(Blocks.POLISHED_DRIPSTONE_STAIRS.get())
                .add(Blocks.POLISHED_CALCITE_STAIRS.get())
                .add(Blocks.POLISHED_ANDESITE_BRICKS_STAIRS.get())
                .add(Blocks.POLISHED_CALCITE_BRICKS_STAIRS.get())
                .add(Blocks.POLISHED_DIORITE_BRICKS_STAIRS.get())
                .add(Blocks.POLISHED_DRIPSTONE_BRICKS_STAIRS.get())
                .add(Blocks.POLISHED_GRANITE_BRICKS_STAIRS.get())
                //Slab
                .add(Blocks.DRIPSTONE_SLAB.get())
                .add(Blocks.CALCITE_SLAB.get())
                .add(Blocks.POLISHED_DRIPSTONE_SLAB.get())
                .add(Blocks.POLISHED_CALCITE_SLAB.get())
                .add(Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get())
                .add(Blocks.POLISHED_CALCITE_BRICKS_SLAB.get())
                .add(Blocks.POLISHED_DIORITE_BRICKS_SLAB.get())
                .add(Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get())
                .add(Blocks.POLISHED_GRANITE_BRICKS_SLAB.get())
                //Wall
                .add(Blocks.DRIPSTONE_WALL.get())
                .add(Blocks.CALCITE_WALL.get())
                .add(Blocks.POLISHED_ANDESITE_WALL.get())
                .add(Blocks.POLISHED_CALCITE_WALL.get())
                .add(Blocks.POLISHED_DIORITE_WALL.get())
                .add(Blocks.POLISHED_DRIPSTONE_WALL.get())
                .add(Blocks.POLISHED_GRANITE_WALL.get())
                .add(Blocks.POLISHED_ANDESITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_CALCITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_DIORITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_DRIPSTONE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_GRANITE_BRICKS_WALL.get());

        tag(BlockTags.WALLS)
                .add(Blocks.DRIPSTONE_WALL.get())
                .add(Blocks.CALCITE_WALL.get())
                .add(Blocks.POLISHED_ANDESITE_WALL.get())
                .add(Blocks.POLISHED_CALCITE_WALL.get())
                .add(Blocks.POLISHED_DIORITE_WALL.get())
                .add(Blocks.POLISHED_DRIPSTONE_WALL.get())
                .add(Blocks.POLISHED_GRANITE_WALL.get())
                .add(Blocks.POLISHED_ANDESITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_CALCITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_DIORITE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_DRIPSTONE_BRICKS_WALL.get())
                .add(Blocks.POLISHED_GRANITE_BRICKS_WALL.get())
                .add(Blocks.RUBY_ORE.get())
                .add(Blocks.DEEPSLATE_RUBY_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.RUBY_ORE.get())
                .add(Blocks.DEEPSLATE_RUBY_ORE.get());

    }
}
