package net.toilgoat.ultvanillaexp.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.screen.AbstractFrostingRecipe;

public class Recipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipeBookCategory> CATEGORIES =
            DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, UltVanillaExp.MODID);
    public static final DeferredRegister<RecipePropertySet> PROPERTY_SETS =
            DeferredRegister.create(RecipePropertySet.TYPE_KEY, UltVanillaExp.MODID);

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


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
        CATEGORIES.register(eventBus);
        PROPERTY_SETS.register(eventBus);
    }
}
