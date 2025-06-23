package net.toilgoat.ultvanillaexp.recipe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.item.Items;

public class FrosterRecipe extends AbstractFrostingRecipe {
    public FrosterRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item furnaceIcon() {
        return Blocks.FROSTER.get().asItem();
    }

    @Override
    public RecipeType<FrosterRecipe> getType() {
        return Recipes.FROSTER_TYPE.get();
    }

    @Override
    public RecipeSerializer<FrosterRecipe> getSerializer() {
        return Recipes.FROSTER_SERIALIZER.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return Recipes.FROSTER_ITEMS.get();
    }
}
