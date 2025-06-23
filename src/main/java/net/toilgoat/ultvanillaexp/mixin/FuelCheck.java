package net.toilgoat.ultvanillaexp.mixin;

import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractFurnaceMenu.class)
public interface FuelCheck {
        @Invoker("isFuel")
        boolean callIsFuel(ItemStack stack);
}
