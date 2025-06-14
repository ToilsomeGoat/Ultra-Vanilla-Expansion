package net.toilgoat.ultvanillaexp.datagen;

import com.ibm.icu.util.Output;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.entity.custom.DuckEntity;

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
        List<ItemLike> RUBY_ORES = List.of(Blocks.RUBY_ORE, Blocks.DEEPSLATE_RUBY_ORE);
        List<ItemLike> ONION = List.of(net.toilgoat.ultvanillaexp.item.Items.ONION);
        List<ItemLike> RAW_DUCK = List.of(net.toilgoat.ultvanillaexp.item.Items.RAW_DUCK);

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

        //Stairs
        stairBuilder(Blocks.CALCITE_STAIRS.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.CALCITE)).group("calcite")
                .unlockedBy("has_calcite", has(net.minecraft.world.level.block.Blocks.CALCITE)).save(output);
        stairBuilder(Blocks.DRIPSTONE_STAIRS.get(), Ingredient.of(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK)).group("dripstone")
                .unlockedBy("has_dripstone", has(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK)).save(output);
        stairBuilder(Blocks.POLISHED_CALCITE_STAIRS.get(), Ingredient.of(Blocks.POLISHED_CALCITE)).group("calcite")
                .unlockedBy("has_polished_calcite", has(Blocks.POLISHED_CALCITE)).save(output);
        stairBuilder(Blocks.POLISHED_DRIPSTONE_STAIRS.get(), Ingredient.of(Blocks.POLISHED_DRIPSTONE)).group("dripstone")
                .unlockedBy("has_polished_dripstone", has(Blocks.POLISHED_DRIPSTONE)).save(output);
        stairBuilder(Blocks.POLISHED_ANDESITE_BRICKS_STAIRS.get(), Ingredient.of(Blocks.POLISHED_ANDESITE_BRICKS)).group("andesite_bricks")
                .unlockedBy("has_polished_andesite_bricks", has(Blocks.POLISHED_ANDESITE_BRICKS)).save(output);
        stairBuilder(Blocks.POLISHED_CALCITE_BRICKS_STAIRS.get(), Ingredient.of(Blocks.POLISHED_CALCITE_BRICKS)).group("calcite_bricks")
                .unlockedBy("has_polished_calcite_bricks", has(Blocks.POLISHED_CALCITE_BRICKS)).save(output);
        stairBuilder(Blocks.POLISHED_DIORITE_BRICKS_STAIRS.get(), Ingredient.of(Blocks.POLISHED_DIORITE_BRICKS)).group("diorite_bricks")
                .unlockedBy("has_polished_diorite_bricks", has(Blocks.POLISHED_DIORITE_BRICKS)).save(output);
        stairBuilder(Blocks.POLISHED_DRIPSTONE_BRICKS_STAIRS.get(), Ingredient.of(Blocks.POLISHED_DRIPSTONE_BRICKS)).group("dripstone_bricks")
                .unlockedBy("has_polished_dripstone_bricks", has(Blocks.POLISHED_DRIPSTONE_BRICKS)).save(output);
        stairBuilder(Blocks.POLISHED_GRANITE_BRICKS_STAIRS.get(), Ingredient.of(Blocks.POLISHED_GRANITE_BRICKS)).group("granite_bricks")
                .unlockedBy("has_polished_granite_bricks", has(Blocks.POLISHED_GRANITE_BRICKS)).save(output);
        //Slab
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE_SLAB.get(), net.minecraft.world.level.block.Blocks.CALCITE);
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_SLAB.get(), net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK);
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE_SLAB.get(), Blocks.POLISHED_CALCITE.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_SLAB.get(), Blocks.POLISHED_DRIPSTONE.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get(), Blocks.POLISHED_ANDESITE_BRICKS.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE_BRICKS_SLAB.get(), Blocks.POLISHED_CALCITE_BRICKS.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE_BRICKS_SLAB.get(), Blocks.POLISHED_DIORITE_BRICKS.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get(), Blocks.POLISHED_DRIPSTONE_BRICKS.get());
        slab(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE_BRICKS_SLAB.get(), Blocks.POLISHED_GRANITE_BRICKS.get());

        //Wall
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE_WALL.get(), net.minecraft.world.level.block.Blocks.CALCITE);
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_WALL.get(), net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK);
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE_WALL.get(), net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE);
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE_WALL.get(), Blocks.POLISHED_CALCITE.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE_WALL.get(), net.minecraft.world.level.block.Blocks.POLISHED_DIORITE);
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_WALL.get(), Blocks.POLISHED_DRIPSTONE.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE_WALL.get(), net.minecraft.world.level.block.Blocks.POLISHED_GRANITE);
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE_BRICKS_WALL.get(), Blocks.POLISHED_ANDESITE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_CALCITE_BRICKS_WALL.get(), Blocks.POLISHED_CALCITE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE_BRICKS_WALL.get(), Blocks.POLISHED_DIORITE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DRIPSTONE_BRICKS_WALL.get(), Blocks.POLISHED_DRIPSTONE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE_BRICKS_WALL.get(), Blocks.POLISHED_GRANITE_BRICKS.get());




        //Chiseled
        chiseled(RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_POLISHED_ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE_BRICKS_SLAB.get());
        chiseled(RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_POLISHED_CALCITE_BRICKS.get(), Blocks.POLISHED_CALCITE_BRICKS_SLAB.get());
        chiseled(RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_POLISHED_DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE_BRICKS_SLAB.get());
        chiseled(RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_POLISHED_DRIPSTONE_BRICKS.get(), Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB.get());
        chiseled(RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_POLISHED_GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE_BRICKS_SLAB.get());

        //Cracked

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

        //Mossy

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_DEEPSLATE_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.DEEPSLATE_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_DEEPSLATE_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.DEEPSLATE_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_deepslate_bricks_2");

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_TUFF_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.TUFF_BRICKS)
                .requires(Items.VINE)
                .unlockedBy("has_vine", has(Items.VINE)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_TUFF_BRICKS.get())
                .requires(net.minecraft.world.level.block.Blocks.TUFF_BRICKS)
                .requires(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(net.minecraft.world.level.block.Blocks.MOSS_BLOCK)).save(output, "ultvanillaexp:mossy_tuff_bricks_2");

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

        shapeless(RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.BARLEY_STEW.get())
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.CARROT)
                .requires(net.toilgoat.ultvanillaexp.item.Items.ONION)
                .requires(net.toilgoat.ultvanillaexp.item.Items.BARLEY)
                .requires(Items.BOWL)
                .unlockedBy("has_barley", has(net.toilgoat.ultvanillaexp.item.Items.BARLEY)).save(output, "ultvanillaexp:barley_stew_from_brown_mushroom");

        shapeless(RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.BARLEY_STEW.get())
                .requires(Items.RED_MUSHROOM)
                .requires(Items.CARROT)
                .requires(net.toilgoat.ultvanillaexp.item.Items.ONION)
                .requires(net.toilgoat.ultvanillaexp.item.Items.BARLEY)
                .requires(Items.BOWL)
                .unlockedBy("has_barley", has(net.toilgoat.ultvanillaexp.item.Items.BARLEY)).save(output, "ultvanillaexp:barley_stew_from_red_mushroom");

        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.WAX_BLOCK.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', net.toilgoat.ultvanillaexp.item.Items.BEESWAX.get())
                .unlockedBy("has_beeswax", has(net.toilgoat.ultvanillaexp.item.Items.BEESWAX)).save(output);

        shaped(RecipeCategory.FOOD, Items.BREAD)
                .pattern("SSS")
                .define('S', net.toilgoat.ultvanillaexp.item.Items.BARLEY.get())
                .unlockedBy("has_barley", has(net.toilgoat.ultvanillaexp.item.Items.BARLEY)).save(output);

        shaped(RecipeCategory.MISC, Blocks.FROSTER)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .define('S', net.minecraft.world.level.block.Blocks.IRON_BLOCK)
                .unlockedBy("has_iron_block", has(net.minecraft.world.level.block.Blocks.IRON_BLOCK)).save(output);

        smelting(output, ONION, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.BAKED_ONION.get(), 0.35f, 200, "onion");
        smoking(output, ONION, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.BAKED_ONION.get(), 0.35f, 100, "onion");
        campfireCooking(output, ONION, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.BAKED_ONION.get(), 0.35f, 600, "onion");

        smelting(output, RAW_DUCK, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.ROASTED_DUCK.get(), 0.35f, 200, "raw_duck");
        smoking(output, RAW_DUCK, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.ROASTED_DUCK.get(), 0.35f, 100, "raw_duck");
        campfireCooking(output, RAW_DUCK, RecipeCategory.FOOD, net.toilgoat.ultvanillaexp.item.Items.ROASTED_DUCK.get(), 0.35f, 600, "raw_duck");

        smelting(output, RUBY_ORES, RecipeCategory.MISC, net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 1.0f, 200, "ruby");
        blasting(output, RUBY_ORES, RecipeCategory.MISC, net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 1.0f, 100, "ruby");




    }
    protected void smelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }
    protected void blasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected void smoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                            float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }
    protected void campfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                           float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
    }
    protected <T extends AbstractCookingRecipe> void Cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, UltVanillaExp.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
