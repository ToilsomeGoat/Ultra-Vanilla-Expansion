package net.toilgoat.ultvanillaexp.item.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Potion {
    public static final DeferredRegister<net.minecraft.world.item.alchemy.Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, UltVanillaExp.MODID);

    public static final Holder<net.minecraft.world.item.alchemy.Potion> BLINDNESS = POTIONS.register("blindness",
            () -> new net.minecraft.world.item.alchemy.Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 1800, 0)));

    public static final Holder<net.minecraft.world.item.alchemy.Potion> HUNGER = POTIONS.register("hunger",
            () -> new net.minecraft.world.item.alchemy.Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 1800, 0)));

    public static final Holder<net.minecraft.world.item.alchemy.Potion> NAUSEA = POTIONS.register("nausea",
            () -> new net.minecraft.world.item.alchemy.Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 1800, 0)));

    public static final Holder<net.minecraft.world.item.alchemy.Potion> WITHER = POTIONS.register("wither",
            () -> new net.minecraft.world.item.alchemy.Potion("wither", new MobEffectInstance(MobEffects.WITHER, 1800, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
