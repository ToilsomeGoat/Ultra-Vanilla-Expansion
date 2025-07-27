package net.toilgoat.ultvanillaexp.item.food;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;


public class Consumables {
    public static final Consumable RAW_DUCK = defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.2F)).build();;
    public static final Consumable CRYSTALLIZED_HONEY = defaultFood().sound(SoundEvents.HONEY_DRINK).onConsume(new RemoveStatusEffectsConsumeEffect(MobEffects.POISON)).build();
    public static final Consumable DARK_CHOCOLATE = defaultFood().onConsume(new RemoveStatusEffectsConsumeEffect(MobEffects.POISON)).build();
    public static final Consumable MILK_CHOCOLATE = defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 300, 0), 0.25F)).build();;

    public static Consumable.Builder defaultFood() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
    }

    public static Consumable.Builder defaultDrink() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).hasConsumeParticles(false);
    }
}
