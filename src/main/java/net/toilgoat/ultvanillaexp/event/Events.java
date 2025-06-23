package net.toilgoat.ultvanillaexp.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.toilgoat.ultvanillaexp.item.potion.Potion;

public class Events {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, Items.INK_SAC, Potion.BLINDNESS);
        builder.addMix(Potions.AWKWARD, Items.ROTTEN_FLESH, Potion.HUNGER);
        builder.addMix(Potions.MUNDANE, Items.PUFFERFISH, Potion.NAUSEA);
        builder.addMix(Potions.AWKWARD, Items.WITHER_ROSE, Potion.WITHER);
    }
}
