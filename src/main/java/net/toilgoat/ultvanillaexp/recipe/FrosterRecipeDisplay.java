package net.toilgoat.ultvanillaexp.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

    public record FrosterRecipeDisplay(SlotDisplay ingredient, SlotDisplay fuel, SlotDisplay result, SlotDisplay craftingStation, int duration, float experience) implements RecipeDisplay {
        public static final MapCodec<FrosterRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec((p_380853_) -> p_380853_.group(SlotDisplay.CODEC.fieldOf("ingredient").forGetter(FrosterRecipeDisplay::ingredient), SlotDisplay.CODEC.fieldOf("fuel").forGetter(FrosterRecipeDisplay::fuel), SlotDisplay.CODEC.fieldOf("result").forGetter(FrosterRecipeDisplay::result), SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(FrosterRecipeDisplay::craftingStation), Codec.INT.fieldOf("duration").forGetter(FrosterRecipeDisplay::duration), Codec.FLOAT.fieldOf("experience").forGetter(FrosterRecipeDisplay::experience)).apply(p_380853_, FrosterRecipeDisplay::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, FrosterRecipeDisplay> STREAM_CODEC;
        public static final RecipeDisplay.Type<FrosterRecipeDisplay> TYPE;
        public static RecipeDisplay.Type<FrosterRecipeDisplay> getType() {
            return Recipes.FROSTER_RECIPE_DISPLAY.value();
        }

        @Override
        public RecipeDisplay.Type<FrosterRecipeDisplay> type() {
            return getType();
        }

        public boolean isEnabled(FeatureFlagSet p_379749_) {
            return this.ingredient.isEnabled(p_379749_) && this.fuel().isEnabled(p_379749_) && RecipeDisplay.super.isEnabled(p_379749_);
        }

        static {
            STREAM_CODEC = StreamCodec.composite(SlotDisplay.STREAM_CODEC, FrosterRecipeDisplay::ingredient, SlotDisplay.STREAM_CODEC, FrosterRecipeDisplay::fuel, SlotDisplay.STREAM_CODEC, FrosterRecipeDisplay::result, SlotDisplay.STREAM_CODEC, FrosterRecipeDisplay::craftingStation, ByteBufCodecs.VAR_INT, FrosterRecipeDisplay::duration, ByteBufCodecs.FLOAT, FrosterRecipeDisplay::experience, FrosterRecipeDisplay::new);
            TYPE = new RecipeDisplay.Type(MAP_CODEC, STREAM_CODEC);

        }
    }