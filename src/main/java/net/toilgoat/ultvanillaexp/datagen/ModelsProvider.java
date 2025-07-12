package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.block.custom.BarleyCrop;
import net.toilgoat.ultvanillaexp.block.custom.OnionCrop;
import net.toilgoat.ultvanillaexp.item.Items;

import java.util.Map;
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
        itemModels.generateFlatItem(Items.BAKED_ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.BARLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.BARLEY_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.DUCK_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.GRIZZLY_BEAR_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.SCORCHED_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.DESERTED_TRADER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.RAW_DUCK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.ROASTED_DUCK.get(), ModelTemplates.FLAT_ITEM);

        //BLOCKS
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
        blockModels.createTrivialCube(Blocks.MOSSY_TUFF_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get());
        blockModels.createTrivialCube(Blocks.WAX_BLOCK.get());

        blockModels.family(net.minecraft.world.level.block.Blocks.CALCITE)
                .stairs(Blocks.CALCITE_STAIRS.get())
                .slab(Blocks.CALCITE_SLAB.get())
                .wall(Blocks.CALCITE_WALL.get());

        blockModels.family(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK)
                .stairs(Blocks.DRIPSTONE_STAIRS.get())
                .slab(Blocks.DRIPSTONE_SLAB.get())
                .wall(Blocks.DRIPSTONE_WALL.get());

        blockModels.family(net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE)
                .wall(Blocks.POLISHED_ANDESITE_WALL.get());

        blockModels.family(Blocks.POLISHED_CALCITE.get())
                .stairs(Blocks.POLISHED_CALCITE_STAIRS.get())
                .slab(Blocks.POLISHED_CALCITE_SLAB.get())
                .wall(Blocks.POLISHED_CALCITE_WALL.get());

        blockModels.family(net.minecraft.world.level.block.Blocks.POLISHED_DIORITE)
                .wall(Blocks.POLISHED_DIORITE_WALL.get());

        blockModels.family(Blocks.POLISHED_DRIPSTONE.get())
                .stairs(Blocks.POLISHED_DRIPSTONE_STAIRS.get())
                .slab(Blocks.POLISHED_DRIPSTONE_SLAB.get())
                .wall(Blocks.POLISHED_DRIPSTONE_WALL.get());

        blockModels.family(net.minecraft.world.level.block.Blocks.POLISHED_GRANITE)
                .wall(Blocks.POLISHED_GRANITE_WALL.get());

        blockModels.family(Blocks.POLISHED_ANDESITE_BRICKS.get())
                .stairs(Blocks.POLISHED_ANDESITE_BRICKS_STAIRS.get())
                .slab(Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get())
                .wall(Blocks.POLISHED_ANDESITE_BRICKS_WALL.get());

        blockModels.family(Blocks.POLISHED_CALCITE_BRICKS.get())
                .stairs(Blocks.POLISHED_CALCITE_BRICKS_STAIRS.get())
                .slab(Blocks.POLISHED_CALCITE_BRICKS_SLAB.get()).wall(Blocks
                        .POLISHED_CALCITE_BRICKS_WALL.get());

        blockModels.family(Blocks.POLISHED_DIORITE_BRICKS.get())
                .stairs(Blocks.POLISHED_DIORITE_BRICKS_STAIRS.get())
                .slab(Blocks.POLISHED_DIORITE_BRICKS_SLAB.get())
                .wall(Blocks.POLISHED_DIORITE_BRICKS_WALL.get());

        blockModels.family(Blocks.POLISHED_DRIPSTONE_BRICKS.get())
                .stairs(Blocks.POLISHED_DRIPSTONE_BRICKS_STAIRS.get())
                .slab(Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get())
                .wall(Blocks.POLISHED_DRIPSTONE_BRICKS_WALL.get());

        blockModels.family(Blocks.POLISHED_GRANITE_BRICKS.get())
                .stairs(Blocks.POLISHED_GRANITE_BRICKS_STAIRS.get())
                .slab(Blocks.POLISHED_GRANITE_BRICKS_SLAB.get())
                .wall(Blocks.POLISHED_GRANITE_BRICKS_WALL.get());

        blockModels.createCropBlock(Blocks.ONION_CROP.get(), OnionCrop.AGE,  0, 1, 2, 3);
        blockModels.createCropBlock(Blocks.BARLEY_CROP.get(), BarleyCrop.AGE,  0, 1, 2, 3);

        blockModels.createTrivialCube(Blocks.RUBY_ORE.get());
        blockModels.createTrivialCube(Blocks.DEEPSLATE_RUBY_ORE.get());
        blockModels.createFurnace(Blocks.FROSTER.get(), TexturedModel.ORIENTABLE);

        blockModels.createTrivialBlock(Blocks.HIEROGLYPH_BASKET.get(), TexturedModel.COLUMN);
        blockModels.createTrivialBlock(Blocks.HIEROGLYPH_FOOT.get(), TexturedModel.COLUMN);
        blockModels.createTrivialBlock(Blocks.HIEROGLYPH_REEDS.get(), TexturedModel.COLUMN);
        blockModels.createTrivialBlock(Blocks.HIEROGLYPH_SNAKE.get(), TexturedModel.COLUMN);
        blockModels.createTrivialBlock(Blocks.HIEROGLYPH_VULTURE.get(), TexturedModel.COLUMN);



        blockModels.woodProvider(Blocks.PALM_LOG.get()).logWithHorizontal(Blocks.PALM_LOG.get()).wood(Blocks.PALM_WOOD.get());
        blockModels.woodProvider(Blocks.STRIPPED_PALM_LOG.get()).logWithHorizontal(Blocks.STRIPPED_PALM_LOG.get()).wood(Blocks.STRIPPED_PALM_WOOD.get());

        BlockFamily family = new BlockFamily.Builder(Blocks.PALM_PLANKS.get())
                .sign(Blocks.PALM_SIGN.get(), Blocks.PALM_WALL_SIGN.get())
                .stairs(Blocks.PALM_STAIRS.get())
                .slab(Blocks.PALM_SLAB.get())
                .fence(Blocks.PALM_FENCE.get())
                .fenceGate(Blocks.PALM_FENCE_GATE.get())
                .button(Blocks.PALM_BUTTON.get())
                .pressurePlate(Blocks.PALM_PRESSURE_PLATE.get())
                .door(Blocks.PALM_DOOR.get())
                .trapdoor(Blocks.PALM_TRAPDOOR.get())
                .getFamily();

        blockModels.family(Blocks.PALM_PLANKS.get()).generateFor(family);


        blockModels.createHangingSign(Blocks.STRIPPED_PALM_LOG.get(), Blocks.PALM_HANGING_SIGN.get(), Blocks.PALM_WALL_HANGING_SIGN.get());

        blockModels.createTintedLeaves(Blocks.PALM_LEAVES.get(), TexturedModel.LEAVES,-12012264);

        blockModels.createPlantWithDefaultItem(Blocks.PALM_SAPLING.get(), Blocks.POTTED_PALM_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);

        blockModels.createPlantWithDefaultItem(Blocks.BLUE_ROSE.get(), Blocks.POTTED_BLUE_ROSE.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        blockModels.createPlantWithDefaultItem(Blocks.PAEONIA.get(), Blocks.POTTED_PAEONIA.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        blockModels.createPlantWithDefaultItem(Blocks.HIBISCUS.get(), Blocks.POTTED_HIBISCUS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    }
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return Items.ITEMS.getEntries().stream();
    }

    private static final ModelTemplate CROP_CUTOUT = ModelTemplates.CROP.extend().renderType("cutout").build();
}
