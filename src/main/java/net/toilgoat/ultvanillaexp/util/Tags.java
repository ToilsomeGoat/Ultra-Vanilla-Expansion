package net.toilgoat.ultvanillaexp.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Tags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> GRIZZLY_BEAR_FOOD = createTag("grizzly_bear_food");
        public static final TagKey<Item> PALM_LOGS = createTag("palm_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
        }
    }
}
