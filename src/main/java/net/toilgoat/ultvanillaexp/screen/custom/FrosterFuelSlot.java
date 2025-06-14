package net.toilgoat.ultvanillaexp.screen.custom;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.toilgoat.ultvanillaexp.screen.AbstractFrosterMenu;

public class FrosterFuelSlot extends Slot{
        private final AbstractFrosterMenu menu;

        public FrosterFuelSlot(AbstractFrosterMenu frosterMenu, Container frosterContainer, int slot, int xPosition, int yPosition) {
            super(frosterContainer, slot, xPosition, yPosition);
            this.menu = frosterMenu;
        }

        public boolean mayPlace(ItemStack stack) {
            return this.menu.isFrosterFuel(stack) || isBucket(stack);
        }

        public int getMaxStackSize(ItemStack stack) {
            return isBucket(stack) ? 1 : super.getMaxStackSize(stack);
        }

        public static boolean isBucket(ItemStack stack) {
            return stack.is(Items.BUCKET);
        }
}
