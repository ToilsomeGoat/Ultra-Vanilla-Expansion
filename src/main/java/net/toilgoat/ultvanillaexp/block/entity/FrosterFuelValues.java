package net.toilgoat.ultvanillaexp.block.entity;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntSortedMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.SequencedSet;

public class FrosterFuelValues {

        private final Object2IntSortedMap<Item> values;

        FrosterFuelValues(Object2IntSortedMap<Item> values) {
            this.values = values;
        }

        public boolean isFrosterFuel(ItemStack stack) {
            return this.values.containsKey(stack.getItem());
        }

        public SequencedSet<Item> frosterFuelItems() {
            return Collections.unmodifiableSequencedSet(this.values.keySet());
        }



        /** @deprecated */
        @Deprecated
        public int frostDuration(ItemStack stack) {
            return stack.isEmpty() ? 0 : this.values.getInt(stack.getItem());
        }

        public static FrosterFuelValues frostTimes(HolderLookup.Provider registries, FeatureFlagSet enabledFeatures) {
            return frostTimes(registries, enabledFeatures, 300);
        }

        public static FrosterFuelValues frostTimes(HolderLookup.Provider registries, FeatureFlagSet enabledFeatures, int frostingTime) {
            return frostTimes(new FrosterFuelValues.Builder(registries, enabledFeatures), frostingTime);
        }

        public static FrosterFuelValues frostTimes(FrosterFuelValues.Builder builder, int p_363365_) {
            return builder.add(Blocks.ICE, p_363365_ * 3).add(Blocks.PACKED_ICE, p_363365_ * 30).add(Blocks.BLUE_ICE, p_363365_ * 300).build();
        }

        public static class Builder {
            private final HolderLookup<Item> items;
            private final FeatureFlagSet enabledFeatures;
            private final Object2IntSortedMap<Item> values = new Object2IntLinkedOpenHashMap();

            public Builder(HolderLookup.Provider registries, FeatureFlagSet enabledFeatures) {
                this.items = registries.lookupOrThrow(Registries.ITEM);
                this.enabledFeatures = enabledFeatures;
            }

            public FrosterFuelValues build() {
                return new FrosterFuelValues(this.values);
            }

            public FrosterFuelValues.Builder remove(TagKey<Item> tag) {
                this.values.keySet().removeIf((p_363176_) -> p_363176_.builtInRegistryHolder().is(tag));
                return this;
            }

            public FrosterFuelValues.Builder add(TagKey<Item> tag, int value) {
                this.items.get(tag).ifPresent((p_364314_) -> {
                    for(Holder<Item> holder : p_364314_) {
                        this.putInternal(value, (Item)holder.value());
                    }

                });
                return this;
            }

            public FrosterFuelValues.Builder add(ItemLike p_item, int value) {
                Item item = p_item.asItem();
                this.putInternal(value, item);
                return this;
            }

            private void putInternal(int value, Item item) {
                if (item.isEnabled(this.enabledFeatures)) {
                    this.values.put(item, value);
                }

            }
        }

}
