
package net.toilgoat.ultvanillaexp.entity.custom;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class ScorchedMonster extends AbstractSkeleton {
    public ScorchedMonster(EntityType<? extends ScorchedMonster> p_33836_, Level p_33837_) {
        super(p_33836_, p_33837_);
    }

    public static boolean checkScorchedSpawnRules(EntityType<ScorchedMonster> entityType, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        {
            if (!Monster.checkMonsterSpawnRules(entityType, level, spawnReason, pos, random)) {
                return false;
            }
            return EntitySpawnReason.isSpawner(spawnReason) || level.canSeeSky(pos);
        }
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.STRAY_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.STRAY_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.STRAY_STEP;
    }

    protected AbstractArrow getArrow(ItemStack p_33846_, float p_33847_, @Nullable ItemStack p_345505_) {
        AbstractArrow abstractarrow = super.getArrow(p_33846_, p_33847_, p_345505_);
        if (abstractarrow instanceof Arrow) {
            ((Arrow)abstractarrow).addEffect(new MobEffectInstance(MobEffects.HUNGER, 140));
        }

        return abstractarrow;
    }
}
