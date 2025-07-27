package net.toilgoat.ultvanillaexp.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.neoforge.event.EventHooks;

public class FrostbittenMonster extends Zombie {
    public FrostbittenMonster(EntityType<? extends FrostbittenMonster> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    public static boolean checkHuskSpawnRules(EntityType<Husk> entityType, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return checkMonsterSpawnRules(entityType, level, spawnReason, pos, random) && (EntitySpawnReason.isSpawner(spawnReason) || level.canSeeSky(pos));
    }

    public boolean doHurtTarget(ServerLevel p_376715_, Entity p_32892_) {
        boolean flag = super.doHurtTarget(p_376715_, p_32892_);
        if (flag && this.getMainHandItem().isEmpty() && p_32892_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)p_32892_).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 140 * (int)f), this);
        }

        return flag;
    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }
}
