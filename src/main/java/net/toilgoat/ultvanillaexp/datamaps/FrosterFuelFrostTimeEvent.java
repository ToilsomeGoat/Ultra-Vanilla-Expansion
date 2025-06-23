package net.toilgoat.ultvanillaexp.datamaps;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.toilgoat.ultvanillaexp.block.entity.FrosterFuelValues;
import org.jetbrains.annotations.Nullable;

public class FrosterFuelFrostTimeEvent extends Event implements ICancellableEvent{
        private final ItemStack itemStack;
        @Nullable
        private final RecipeType<?> recipeType;
        private final FrosterFuelValues frosterFuelValues;
        private int frostTime;

        public FrosterFuelFrostTimeEvent(ItemStack itemStack, int frostTime, @Nullable RecipeType<?> recipeType, FrosterFuelValues frosterFuelValues) {
            this.itemStack = itemStack;
            this.frostTime = frostTime;
            this.recipeType = recipeType;
            this.frosterFuelValues = frosterFuelValues;
        }

        /**
         * Get the ItemStack "fuel" in question.
         */
        public ItemStack getItemStack() {
            return itemStack;
        }

        /**
         *
         * Get the recipe type for which to obtain the burn time, if known.
         */
        @Nullable
        public RecipeType<?> getRecipeType() {
            return recipeType;
        }

        /**
         * Get the {@link FuelValues} populated from the {@link net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps#FURNACE_FUELS data map}
         */
        public FrosterFuelValues getFrosterFuelValues() {
            return this.frosterFuelValues;
        }

        /**
         * Set the burn time for the given ItemStack.
         * Setting it to 0 will prevent the item from being used as fuel, overriding vanilla's decision.
         */
        public void setBurnTime(int frostTime) {
            if (frostTime >= 0) {
                this.frostTime = frostTime;
                setCanceled(true);
            }
        }

        /**
         * The resulting value of this event, the burn time for the ItemStack.
         * A value of 0 will prevent the item from being used as fuel, overriding vanilla's decision.
         * <p>
         * The initial burn time can come from either the {@link net.neoforged.neoforge.common.extensions.IItemExtension#getBurnTime(ItemStack, RecipeType, FuelValues) extension method}
         * or the {@link net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps#FURNACE_FUELS data map} through {@link FuelValues}.
         */
        public int getFrostTime() {
            return frostTime;
        }
    }
