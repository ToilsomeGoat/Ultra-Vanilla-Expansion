package net.toilgoat.ultvanillaexp.screen;

import net.minecraft.recipebook.ServerPlaceRecipe;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.FuelValues;
import net.toilgoat.ultvanillaexp.block.entity.FrosterFuelValues;
import net.toilgoat.ultvanillaexp.screen.custom.FrosterFuelSlot;

import java.util.List;

public class AbstractFrosterMenu extends RecipeBookMenu{
        public static final int INGREDIENT_SLOT = 0;
        public static final int FUEL_SLOT = 1;
        public static final int RESULT_SLOT = 2;
        public static final int SLOT_COUNT = 3;
        public static final int DATA_COUNT = 4;
        private static final int INV_SLOT_START = 3;
        private static final int INV_SLOT_END = 30;
        private static final int USE_ROW_SLOT_START = 30;
        private static final int USE_ROW_SLOT_END = 39;
        final Container container;
        private final ContainerData data;
        protected final Level level;
        private final RecipeType<? extends AbstractFrostingRecipe> recipeType;
        private final RecipePropertySet acceptedInputs;
        private final RecipeBookType recipeBookType;

    public FrosterFuelValues frosterFuelValues() {
        return null;
    }

    protected AbstractFrosterMenu(MenuType<?> menuType, RecipeType<? extends AbstractFrostingRecipe> recipeType, ResourceKey<RecipePropertySet> acceptedInputs, RecipeBookType recipeBookType, int containerId, Inventory inventory) {
            this(menuType, recipeType, acceptedInputs, recipeBookType, containerId, inventory, new SimpleContainer(3), new SimpleContainerData(4));
        }

        protected AbstractFrosterMenu(MenuType<?> menuType, RecipeType<? extends AbstractFrostingRecipe> recipeType, ResourceKey<RecipePropertySet> acceptedInputs, RecipeBookType recipeBookType, int containerId, Inventory inventory, Container container, ContainerData data) {
            super(menuType, containerId);
            this.recipeType = recipeType;
            this.recipeBookType = recipeBookType;
            checkContainerSize(container, 3);
            checkContainerDataCount(data, 4);
            this.container = container;
            this.data = data;
            this.level = inventory.player.level();
            this.acceptedInputs = this.level.recipeAccess().propertySet(acceptedInputs);
            this.addSlot(new Slot(container, 0, 56, 17));
            this.addSlot(new FrosterFuelSlot(this, container, 1, 56, 53));
            this.addSlot(new FurnaceResultSlot(inventory.player, container, 2, 116, 35));
            this.addStandardInventorySlots(inventory, 8, 84);
            this.addDataSlots(data);
        }

        public void fillCraftSlotsStackedContents(StackedItemContents p_363436_) {
            if (this.container instanceof StackedContentsCompatible) {
                ((StackedContentsCompatible)this.container).fillStackedContents(p_363436_);
            }

        }

        public Slot getResultSlot() {
            return (Slot)this.slots.get(2);
        }

        public boolean stillValid(Player player) {
            return this.container.stillValid(player);
        }

        public ItemStack quickMoveStack(Player player, int index) {
            ItemStack itemstack = ItemStack.EMPTY;
            Slot slot = (Slot)this.slots.get(index);
            if (slot != null && slot.hasItem()) {
                ItemStack itemstack1 = slot.getItem();
                itemstack = itemstack1.copy();
                if (index == 2) {
                    if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                        return ItemStack.EMPTY;
                    }

                    slot.onQuickCraft(itemstack1, itemstack);
                } else if (index != 1 && index != 0) {
                    if (this.canSmelt(itemstack1)) {
                        if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (this.isFrosterFuel(itemstack1)) {
                        if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (index >= 3 && index < 30) {
                        if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (index >= 30 && index < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }

                if (itemstack1.isEmpty()) {
                    slot.setByPlayer(ItemStack.EMPTY);
                } else {
                    slot.setChanged();
                }

                if (itemstack1.getCount() == itemstack.getCount()) {
                    return ItemStack.EMPTY;
                }

                slot.onTake(player, itemstack1);
            }

            return itemstack;
        }

        protected boolean canSmelt(ItemStack stack) {
            return this.acceptedInputs.test(stack);
        }

        public boolean isFrosterFuel(ItemStack stack) {
            return stack.getBurnTime(this.recipeType, this.level.fuelValues()) > 0;
        }

        public float getBurnProgress() {
            int i = this.data.get(2);
            int j = this.data.get(3);
            return j != 0 && i != 0 ? Mth.clamp((float)i / (float)j, 0.0F, 1.0F) : 0.0F;
        }

        public float getLitProgress() {
            int i = this.data.get(1);
            if (i == 0) {
                i = 200;
            }

            return Mth.clamp((float)this.data.get(0) / (float)i, 0.0F, 1.0F);
        }

        public boolean isLit() {
            return this.data.get(0) > 0;
        }

        public RecipeBookType getRecipeBookType() {
            return this.recipeBookType;
        }

        public RecipeBookMenu.PostPlaceAction handlePlacement(boolean p_361547_, boolean p_363944_, RecipeHolder<?> p_360938_, final ServerLevel p_379475_, Inventory p_361954_) {
            final List<Slot> list = List.of(this.getSlot(0), this.getSlot(2));
            return ServerPlaceRecipe.placeRecipe(new ServerPlaceRecipe.CraftingMenuAccess<AbstractFrostingRecipe>() {
                public void fillCraftSlotsStackedContents(StackedItemContents p_361824_) {
                    AbstractFrosterMenu.this.fillCraftSlotsStackedContents(p_361824_);
                }

                public void clearCraftingContent() {
                    list.forEach((p_362814_) -> p_362814_.set(ItemStack.EMPTY));
                }

                public boolean recipeMatches(RecipeHolder<AbstractFrostingRecipe> p_361040_) {
                    return ((AbstractFrostingRecipe)p_361040_.value()).matches(new SingleRecipeInput(AbstractFrosterMenu.this.container.getItem(0)), p_379475_);
                }
            }, 1, 1, List.of(this.getSlot(0)), list, p_361954_, (RecipeHolder<AbstractFrostingRecipe>) p_360938_, p_361547_, p_363944_);
        }

}
