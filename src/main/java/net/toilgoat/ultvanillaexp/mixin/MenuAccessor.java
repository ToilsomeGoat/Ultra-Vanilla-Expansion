package net.toilgoat.ultvanillaexp.mixin;

import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.FurnaceFuelSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FurnaceFuelSlot.class)
public interface MenuAccessor {
        @Accessor("menu")
        AbstractFurnaceMenu getMenu();
    }
