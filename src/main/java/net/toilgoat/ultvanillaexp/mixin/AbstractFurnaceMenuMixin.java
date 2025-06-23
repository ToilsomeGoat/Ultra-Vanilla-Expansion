package net.toilgoat.ultvanillaexp.mixin;

import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(AbstractFurnaceMenu.class)
public abstract class AbstractFurnaceMenuMixin implements FuelCheck {
    @Shadow protected abstract boolean isFuel(ItemStack stack);

    @Override
    public boolean callIsFuel(ItemStack stack) {
        return isFuel(stack);
    }
}