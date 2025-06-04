package net.toilgoat.ultvanillaexp.datagen;

import com.ibm.icu.util.Output;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends RecipeProvider {
    protected RecipesProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new RecipesProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }
    @Override
    protected void buildRecipes() {
        List<ItemLike> POLISHED_STONE_BRICKS = List.of(Blocks.POLISHED_ANDESITE_BRICKS,
                Blocks.POLISHED_CALCITE, Blocks.POLISHED_DIORITE_BRICKS, Blocks.POLISHED_DRIPSTONE_BRICKS, Blocks.POLISHED_GRANITE_BRICKS);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.CALCITE))
                .unlockedBy("has_calcite", has(net.minecraft.world.level.block.Blocks.CALCITE)).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK))
                .unlockedBy("has_dripstone_block", has(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK)).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE_BRICKS.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_polished_andesite", has(net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE)).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE_BRICKS.get(), Ingredient.of(Blocks.POLISHED_CALCITE.get()))
                .unlockedBy("has_polished_calcite", has(Blocks.POLISHED_CALCITE.get())).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE_BRICKS.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.POLISHED_DIORITE))
                .unlockedBy("has_polished_diorite", has(net.minecraft.world.level.block.Blocks.POLISHED_DIORITE)).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_BRICKS.get(), Ingredient.of(Blocks.POLISHED_DRIPSTONE.get()))
                .unlockedBy("has_polished_dripstone", has(Blocks.POLISHED_DRIPSTONE.get())).save(output);

        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE_BRICKS.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.POLISHED_GRANITE))
                .unlockedBy("has_polished_granite", has(net.minecraft.world.level.block.Blocks.POLISHED_GRANITE)).save(output);

        stairBuilder(Blocks.POLISHED_DRIPSTONE_STAIRS.get(), Ingredient.of(Blocks.POLISHED_DRIPSTONE)).group("dripstone")
                .unlockedBy("has_polished_dripstone", has(Blocks.POLISHED_DRIPSTONE)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_SLAB.get(), Blocks.POLISHED_DRIPSTONE.get());

        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.WAX_BLOCK.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', net.toilgoat.ultvanillaexp.item.Items.BEESWAX.get())
                .unlockedBy("has_beeswax", has(net.toilgoat.ultvanillaexp.item.Items.BEESWAX)).save(output);

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Blocks.POLISHED_ANDESITE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_ANDESITE_BRICKS,
                        0.1f,
                        200
                )
                .unlockedBy("has_polished_andesite_bricks", this.has(Blocks.POLISHED_ANDESITE_BRICKS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "cracked_polished_andesite_bricks_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Blocks.POLISHED_CALCITE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_CALCITE_BRICKS,
                        0.1f,
                        200
                )
                .unlockedBy("has_polished_calcite_bricks", this.has(Blocks.POLISHED_CALCITE_BRICKS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "cracked_polished_calcite_bricks_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Blocks.POLISHED_DIORITE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_DIORITE_BRICKS,
                        0.1f,
                        200
                )
                .unlockedBy("has_polished_diorite_bricks", this.has(Blocks.POLISHED_DIORITE_BRICKS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "cracked_polished_diorite_bricks_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Blocks.POLISHED_DRIPSTONE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_DRIPSTONE_BRICKS,
                        0.1f,
                        200
                )
                .unlockedBy("has_polished_dripstone_bricks", this.has(Blocks.POLISHED_DRIPSTONE_BRICKS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "cracked_polished_dripstone_bricks_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Blocks.POLISHED_GRANITE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_GRANITE_BRICKS,
                        0.1f,
                        200
                )
                .unlockedBy("has_polished_granite_bricks", this.has(Blocks.POLISHED_GRANITE_BRICKS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "cracked_polished_granite_bricks_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.HONEYCOMB),
                        RecipeCategory.MISC,
                        net.toilgoat.ultvanillaexp.item.Items.BEESWAX,
                        0.1f,
                        200
                )
                .unlockedBy("has_honeycomb", this.has(Items.HONEYCOMB))
                // This overload of #save allows us to specify a name.
                .save(this.output, "beeswax_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(net.minecraft.world.level.block.Blocks.HONEYCOMB_BLOCK),
                        RecipeCategory.MISC,
                        Blocks.WAX_BLOCK,
                        0.1f,
                        200
                )
                .unlockedBy("has_honeycomb", this.has(net.minecraft.world.level.block.Blocks.HONEYCOMB_BLOCK))
                // This overload of #save allows us to specify a name.
                .save(this.output, "wax_block_smelting");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_DEEPSLATE_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.DEEPSLATE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_DEEPSLATE_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.DEEPSLATE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_deepslate_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get())
                .requires(Blocks.POLISHED_ANDESITE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_ANDESITE_BRICKS.get())
                .requires(Blocks.POLISHED_ANDESITE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_polished_andesite_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get())
                .requires(Blocks.POLISHED_CALCITE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_CALCITE_BRICKS.get())
                .requires(Blocks.POLISHED_CALCITE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_polished_calcite_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get())
                .requires(Blocks.POLISHED_DIORITE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_DIORITE_BRICKS.get())
                .requires(Blocks.POLISHED_DIORITE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_polished_diorite_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get())
                .requires(Blocks.POLISHED_DRIPSTONE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS.get())
                .requires(Blocks.POLISHED_DRIPSTONE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_polished_dripstone_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get())
                .requires(Blocks.POLISHED_GRANITE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_POLISHED_GRANITE_BRICKS.get())
                .requires(Blocks.POLISHED_GRANITE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_polished_granite_bricks_2");

        shapeless(RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.CRYSTALLIZED_HONEY.get())
                .requires(Items.HONEY_BOTTLE)
                .requires(net.minecraft.world.level.block.Blocks.ICE)
                .unlockedBy("has_ice", has(net.minecraft.world.level.block.Blocks.ICE)).save(output);






    }
}
