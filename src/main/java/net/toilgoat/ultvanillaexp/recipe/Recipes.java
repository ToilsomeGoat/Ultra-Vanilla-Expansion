package net.toilgoat.ultvanillaexp.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Recipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipeBookCategory> CATEGORIES =
            DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipePropertySet> PROPERTY_SETS =
            DeferredRegister.create(RecipePropertySet.TYPE_KEY, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipeDisplay.Type<?>> DISPLAY_TYPES =
            DeferredRegister.create(Registries.RECIPE_DISPLAY, UltVanillaExp.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FrosterRecipe>> FROSTER_SERIALIZER =
            SERIALIZERS.register("frosting", () ->
                    new AbstractFrostingRecipe.Serializer<>(FrosterRecipe::new, 300));

    public static final DeferredHolder<RecipeType<?>, RecipeType<FrosterRecipe>> FROSTER_TYPE =
            TYPES.register("froster", () -> new RecipeType<FrosterRecipe>() {
                @Override
                public String toString() {
                    return "froster";
                }
            });

    public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FROSTER_ITEMS =
            CATEGORIES.register("froster_items", RecipeBookCategory::new);

    public static final DeferredHolder<RecipePropertySet, RecipePropertySet> FROSTER_INPUT =
            PROPERTY_SETS.register("froster_input", () -> RecipePropertySet.EMPTY);

    public static final DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<FrosterRecipeDisplay>> FROSTER_RECIPE_DISPLAY =
            DISPLAY_TYPES.register("froster", () -> new RecipeDisplay.Type<>(FrosterRecipeDisplay.MAP_CODEC, FrosterRecipeDisplay.STREAM_CODEC));


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
        CATEGORIES.register(eventBus);
        PROPERTY_SETS.register(eventBus);
        DISPLAY_TYPES.register(eventBus);
    }
}
