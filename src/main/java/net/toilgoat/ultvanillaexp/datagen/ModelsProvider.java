package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.item.Items;

import java.util.stream.Stream;

public class ModelsProvider extends ModelProvider {

    public ModelsProvider(PackOutput output) {
        super(output, UltVanillaExp.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //ITEMS
        itemModels.generateFlatItem(Items.URANIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.GREEN_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.BEESWAX.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.CRYSTALLIZED_HONEY.get(), ModelTemplates.FLAT_ITEM);

        //BLOCKS
        blockModels.createTrivialCube(Blocks.POLISHED_CALCITE.get());
        blockModels.createTrivialCube(Blocks.POLISHED_ANDESITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.POLISHED_CALCITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.POLISHED_DIORITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.POLISHED_DRIPSTONE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.POLISHED_GRANITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CRACKED_POLISHED_ANDESITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CRACKED_POLISHED_CALCITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CRACKED_POLISHED_DIORITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CRACKED_POLISHED_DRIPSTONE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CRACKED_POLISHED_GRANITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CHISELED_POLISHED_ANDESITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CHISELED_POLISHED_CALCITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CHISELED_POLISHED_DIORITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CHISELED_POLISHED_DRIPSTONE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.CHISELED_POLISHED_GRANITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_DEEPSLATE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.WAX_BLOCK.get());

        blockModels.family(Blocks.POLISHED_DRIPSTONE.get())
                .stairs(Blocks.POLISHED_DRIPSTONE_STAIRS.get())
                .slab(Blocks.POLISHED_DRIPSTONE_SLAB.get());
    }
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return Items.ITEMS.getEntries().stream();
    }
}
