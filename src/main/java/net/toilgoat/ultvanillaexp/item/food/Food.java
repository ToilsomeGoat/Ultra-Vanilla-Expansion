package net.toilgoat.ultvanillaexp.item.food;

import net.minecraft.world.food.FoodProperties;

public class Food {
    public static final FoodProperties GREEN_APPLE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).build();
    public static final FoodProperties CRYSTALLIZED_HONEY = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).build();
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodProperties BAKED_ONION = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build();
    public static final FoodProperties BARLEY_STEW = new FoodProperties.Builder().nutrition(8).saturationModifier(1.5f).build();
    public static final FoodProperties RAW_DUCK = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodProperties ROASTED_DUCK = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f).build();
}
