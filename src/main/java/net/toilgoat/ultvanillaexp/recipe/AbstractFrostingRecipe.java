package net.toilgoat.ultvanillaexp.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.FurnaceRecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import java.util.List;

public abstract class AbstractFrostingRecipe extends SingleItemRecipe{
        private final CookingBookCategory category;
        private final float experience;
        private final int cookingTime;
        public ItemStack getResultStack() {
        return this.result();
    }

        public AbstractFrostingRecipe(String group, CookingBookCategory category, Ingredient input, ItemStack result, float experience, int cookingTime) {
            super(group, input, result);
            this.category = category;
            this.experience = experience;
            this.cookingTime = cookingTime;
        }

        @Override
        public abstract RecipeSerializer<? extends AbstractFrostingRecipe> getSerializer();

        @Override
        public abstract RecipeType<? extends AbstractFrostingRecipe> getType();

        public float experience() {
            return this.experience;
        }

        public int cookingTime() {
            return this.cookingTime;
        }

        public CookingBookCategory category() {
            return this.category;
        }

        protected abstract Item furnaceIcon();

        @Override
        public List<RecipeDisplay> display() {
            return List.of(
                    new FrosterRecipeDisplay(
                            this.input().display(),
                            SlotDisplay.AnyFuel.INSTANCE,
                            new SlotDisplay.ItemStackSlotDisplay(this.result()),
                            new SlotDisplay.ItemSlotDisplay(this.furnaceIcon()),
                            this.cookingTime,
                            this.experience
                    )
            );
        }

        @FunctionalInterface
        public interface Factory<T extends AbstractFrostingRecipe> {
            T create(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime);
        }

        public static class Serializer<T extends AbstractFrostingRecipe> implements RecipeSerializer<T> {
            private final MapCodec<T> codec;
            private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

            public Serializer(AbstractFrostingRecipe.Factory<T> factory, int defaultCookingTime) {
                this.codec = RecordCodecBuilder.mapCodec(
                        p_379881_ -> p_379881_.group(
                                        Codec.STRING.optionalFieldOf("group", "").forGetter(SingleItemRecipe::group),
                                        CookingBookCategory.CODEC.fieldOf("category").orElse(CookingBookCategory.MISC).forGetter(AbstractFrostingRecipe::category),
                                        Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleItemRecipe::input),
                                        ItemStack.CODEC.fieldOf("result").forGetter(AbstractFrostingRecipe::getResultStack),
                                        Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(AbstractFrostingRecipe::experience),
                                        Codec.INT.fieldOf("cookingtime").orElse(defaultCookingTime).forGetter(AbstractFrostingRecipe::cookingTime)
                                )
                                .apply(p_379881_, factory::create)
                );
                this.streamCodec = StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8,
                        SingleItemRecipe::group,
                        CookingBookCategory.STREAM_CODEC,
                        AbstractFrostingRecipe::category,
                        Ingredient.CONTENTS_STREAM_CODEC,
                        SingleItemRecipe::input,
                        ItemStack.STREAM_CODEC,
                        AbstractFrostingRecipe::getResultStack,
                        ByteBufCodecs.FLOAT,
                        AbstractFrostingRecipe::experience,
                        ByteBufCodecs.INT,
                        AbstractFrostingRecipe::cookingTime,
                        factory::create
                );
            }

            @Override
            public MapCodec<T> codec() {
                return this.codec;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
                return this.streamCodec;
            }
        }

}
