package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.item.Items;
import net.toilgoat.ultvanillaexp.util.Tags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, UltVanillaExp.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.CHICKEN_FOOD)
                .add(Items.BARLEY_SEEDS.get());

        tag(Tags.Items.GRIZZLY_BEAR_FOOD)
                .add(Items.CRYSTALLIZED_HONEY.get())
                .add(net.minecraft.world.item.Items.SWEET_BERRIES)
                .add(Items.BEESWAX.get())
                .add(net.minecraft.world.item.Items.HONEYCOMB)
                .add(net.minecraft.world.item.Items.SALMON);

        tag(Tags.Items.PALM_LOGS)
                .add(Blocks.PALM_LOG.get().asItem())
                .add(Blocks.STRIPPED_PALM_LOG.get().asItem())
                .add(Blocks.PALM_WOOD.get().asItem())
                .add(Blocks.STRIPPED_PALM_WOOD.get().asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(Blocks.PALM_LOG.get().asItem())
                .add(Blocks.STRIPPED_PALM_LOG.get().asItem())
                .add(Blocks.PALM_WOOD.get().asItem())
                .add(Blocks.STRIPPED_PALM_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(Blocks.PALM_PLANKS.get().asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(Blocks.PALM_STAIRS.get().asItem());

        tag(ItemTags.WOODEN_SLABS)
                .add(Blocks.PALM_SLAB.get().asItem());

        tag(ItemTags.WOODEN_FENCES)
                .add(Blocks.PALM_FENCE.get().asItem());

        tag(ItemTags.FENCE_GATES)
                .add(Blocks.PALM_FENCE_GATE.get().asItem());

        tag(ItemTags.WOODEN_DOORS)
                .add(Blocks.PALM_DOOR.get().asItem());

        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(Blocks.PALM_TRAPDOOR.get().asItem());

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(Blocks.PALM_PRESSURE_PLATE.get().asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(Blocks.PALM_BUTTON.get().asItem());

        tag(ItemTags.SAPLINGS)
                .add(Blocks.PALM_SAPLING.get().asItem());

        tag(ItemTags.LEAVES)
                .add(Blocks.PALM_LEAVES.get().asItem());

        tag(ItemTags.SMALL_FLOWERS)
                .add(Blocks.BLUE_ROSE.get().asItem())
                .add(Blocks.PAEONIA.get().asItem())
                .add(Blocks.HIBISCUS.get().asItem());
    }
}
