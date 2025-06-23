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
                .add(Blocks.POLISHED_GRANITE_BRICKS_WALL.get())
                .add(Blocks.HIEROGLYPH_BASKET.get())
                .add(Blocks.HIEROGLYPH_FOOT.get())
                .add(Blocks.HIEROGLYPH_REEDS.get())
                .add(Blocks.HIEROGLYPH_SNAKE.get())
                .add(Blocks.HIEROGLYPH_VULTURE.get())

                .add(Blocks.FROSTER.get());

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

        tag(BlockTags.LOGS_THAT_BURN)
                .add(Blocks.PALM_LOG.get())
                .add(Blocks.STRIPPED_PALM_LOG.get())
                .add(Blocks.PALM_WOOD.get())
                .add(Blocks.STRIPPED_PALM_WOOD.get());

        tag(BlockTags.PLANKS)
                .add(Blocks.PALM_PLANKS.get());

        tag(BlockTags.WOODEN_STAIRS)
                .add(Blocks.PALM_STAIRS.get());

        tag(BlockTags.WOODEN_SLABS)
                .add(Blocks.PALM_SLAB.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(Blocks.PALM_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(Blocks.PALM_FENCE_GATE.get());

        tag(BlockTags.WOODEN_DOORS)
                .add(Blocks.PALM_DOOR.get());

        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(Blocks.PALM_TRAPDOOR.get());

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(Blocks.PALM_PRESSURE_PLATE.get());

        tag(BlockTags.WOODEN_BUTTONS)
                .add(Blocks.PALM_BUTTON.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.FROSTER.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.RUBY_ORE.get())
                .add(Blocks.DEEPSLATE_RUBY_ORE.get());

        tag(BlockTags.SAPLINGS)
                .add(Blocks.PALM_SAPLING.get());

        tag(BlockTags.LEAVES)
                .add(Blocks.PALM_LEAVES.get());

        tag(BlockTags.FLOWERS)
                .add(Blocks.BLUE_ROSE.get())
                .add(Blocks.PAEONIA.get())
                .add(Blocks.HIBISCUS.get());
    }
}
