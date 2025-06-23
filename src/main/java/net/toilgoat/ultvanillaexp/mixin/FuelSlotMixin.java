package net.toilgoat.ultvanillaexp.mixin;

import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.FurnaceFuelSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FurnaceFuelSlot.class)
public class FuelSlotMixin {

    @Inject(method = "mayPlace", at=@At("HEAD"), cancellable = true)

    private void modifyMayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("Mixin called! stack: " + stack);
        AbstractFurnaceMenu menu = ((MenuAccessor)(Object)this).getMenu();
        boolean isFuel = ((FuelCheck) menu).callIsFuel(stack);
        cir.setReturnValue(
                !customIsIce(stack) && (isFuel || customIsBucket(stack))
        );
    }

    private static boolean customIsBucket(ItemStack stack) {
        return stack.is(Items.BUCKET);
    }

    private static boolean customIsIce(ItemStack stack) {
        return stack.is(Items.ICE) || stack.is(Items.PACKED_ICE) || stack.is(Items.BLUE_ICE);
    }


}
