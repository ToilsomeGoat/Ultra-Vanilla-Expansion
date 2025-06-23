package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.block.custom.OnionCrop;
import net.toilgoat.ultvanillaexp.item.Items;

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
        dropSelf(Blocks.MOSSY_TUFF_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get());
        dropSelf(Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get());
        dropSelf(Blocks.WAX_BLOCK.get());
        // Stairs
        dropSelf(Blocks.CALCITE_STAIRS.get());
        dropSelf(Blocks.DRIPSTONE_STAIRS.get());
        dropSelf(Blocks.POLISHED_CALCITE_STAIRS.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE_STAIRS.get());
        dropSelf(Blocks.POLISHED_ANDESITE_BRICKS_STAIRS.get());
        dropSelf(Blocks.POLISHED_CALCITE_BRICKS_STAIRS.get());
        dropSelf(Blocks.POLISHED_DIORITE_BRICKS_STAIRS.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE_BRICKS_STAIRS.get());
        dropSelf(Blocks.POLISHED_GRANITE_BRICKS_STAIRS.get());
        //Slab
        add(Blocks.CALCITE_SLAB.get(),
                block -> createSlabItemTable(Blocks.CALCITE_SLAB.get()));
        add(Blocks.DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(Blocks.DRIPSTONE_SLAB.get()));
        add(Blocks.POLISHED_CALCITE_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_CALCITE_SLAB.get()));
        add(Blocks.POLISHED_DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_DRIPSTONE_SLAB.get()));
        add(Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get()));
        add(Blocks.POLISHED_CALCITE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_CALCITE_BRICKS_SLAB.get()));
        add(Blocks.POLISHED_DIORITE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_DIORITE_BRICKS_SLAB.get()));
        add(Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get()));
        add(Blocks.POLISHED_GRANITE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(Blocks.POLISHED_GRANITE_BRICKS_SLAB.get()));
        //Wall
        dropSelf(Blocks.CALCITE_WALL.get());
        dropSelf(Blocks.DRIPSTONE_WALL.get());
        dropSelf(Blocks.POLISHED_ANDESITE_WALL.get());
        dropSelf(Blocks.POLISHED_CALCITE_WALL.get());
        dropSelf(Blocks.POLISHED_DIORITE_WALL.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE_WALL.get());
        dropSelf(Blocks.POLISHED_GRANITE_WALL.get());
        dropSelf(Blocks.POLISHED_ANDESITE_BRICKS_WALL.get());
        dropSelf(Blocks.POLISHED_CALCITE_BRICKS_WALL.get());
        dropSelf(Blocks.POLISHED_DIORITE_BRICKS_WALL.get());
        dropSelf(Blocks.POLISHED_DRIPSTONE_BRICKS_WALL.get());
        dropSelf(Blocks.POLISHED_GRANITE_BRICKS_WALL.get());
        dropSelf(Blocks.HIEROGLYPH_BASKET.get());
        dropSelf(Blocks.HIEROGLYPH_FOOT.get());
        dropSelf(Blocks.HIEROGLYPH_REEDS.get());
        dropSelf(Blocks.HIEROGLYPH_SNAKE.get());
        dropSelf(Blocks.HIEROGLYPH_VULTURE.get());
        dropSelf(Blocks.FROSTER.get());
        dropSelf(Blocks.PALM_LOG.get());
        dropSelf(Blocks.PALM_WOOD.get());
        dropSelf(Blocks.STRIPPED_PALM_LOG.get());
        dropSelf(Blocks.STRIPPED_PALM_WOOD.get());
        dropSelf(Blocks.PALM_PLANKS.get());
        dropSelf(Blocks.PALM_STAIRS.get());
        dropSelf(Blocks.PALM_SLAB.get());
        dropSelf(Blocks.PALM_FENCE.get());
        dropSelf(Blocks.PALM_FENCE_GATE.get());
        add(Blocks.PALM_DOOR.get(),
                block -> createDoorTable(Blocks.PALM_DOOR.get()));
        dropSelf(Blocks.PALM_TRAPDOOR.get());
        dropSelf(Blocks.PALM_PRESSURE_PLATE.get());
        dropSelf(Blocks.PALM_BUTTON.get());
        add(Blocks.PALM_SIGN.get(),
                block -> createSingleItemTable(Items.PALM_SIGN.get()));
        add(Blocks.PALM_WALL_SIGN.get(),
                block -> createSingleItemTable(Items.PALM_SIGN.get()));
        add(Blocks.PALM_HANGING_SIGN.get(),
                block -> createSingleItemTable(Items.PALM_HANGING_SIGN.get()));
        add(Blocks.PALM_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(Items.PALM_HANGING_SIGN.get()));
        dropSelf(Blocks.PALM_SAPLING.get());
        add(Blocks.POTTED_PALM_SAPLING.get(),
                block -> createPotFlowerItemTable(Blocks.PALM_SAPLING.get()));
        add(Blocks.PALM_LEAVES.get(),
        block -> createLeavesDrops(block, Blocks.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        LootItemCondition.Builder onionCropCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCrop.AGE, 3));

        this.add(Blocks.ONION_CROP.get(), this.createCropDrops(Blocks.ONION_CROP.get(),
                Items.ONION.get(), Items.ONION.get(), onionCropCondition));

        LootItemCondition.Builder barleyCropCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BARLEY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCrop.AGE, 3));

        this.add(Blocks.BARLEY_CROP.get(), this.createCropDrops(Blocks.BARLEY_CROP.get(),
                Items.BARLEY.get(), Items.BARLEY_SEEDS.get(), barleyCropCondition));

        add(Blocks.RUBY_ORE.get(),
                block -> createOreDrop(Blocks.RUBY_ORE.get(), Items.RUBY.get()));

        add(Blocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createOreDrop(Blocks.DEEPSLATE_RUBY_ORE.get(), Items.RUBY.get()));

        dropSelf(Blocks.BLUE_ROSE.get());
        add(Blocks.POTTED_BLUE_ROSE.get(),
                block -> createPotFlowerItemTable(Blocks.BLUE_ROSE.get()));
        dropSelf(Blocks.PAEONIA.get());
        add(Blocks.POTTED_PAEONIA.get(),
                block -> createPotFlowerItemTable(Blocks.PAEONIA.get()));
        dropSelf(Blocks.HIBISCUS.get());
        add(Blocks.POTTED_HIBISCUS.get(),
                block -> createPotFlowerItemTable(Blocks.HIBISCUS.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
