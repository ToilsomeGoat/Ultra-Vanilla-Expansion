package net.toilgoat.ultvanillaexp.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.util.Tags;

import javax.annotation.Nullable;
import java.util.UUID;

public class GrizzlyBearEntity extends Animal implements NeutralMob{
        private static final EntityDataAccessor<Boolean> DATA_STANDING_ID;
        private static final float STAND_ANIMATION_TICKS = 6.0F;
        private float clientSideStandAnimationO;
        private float clientSideStandAnimation;
        private int warningSoundTicks;
        private static final UniformInt PERSISTENT_ANGER_TIME;
        private int remainingPersistentAngerTime;
        @Nullable
        private UUID persistentAngerTarget;

        public GrizzlyBearEntity(EntityType<? extends GrizzlyBearEntity> p_29519_, Level p_29520_) {
            super(p_29519_, p_29520_);
        }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return Entities.GRIZZLY_BEAR.get().create(level, EntitySpawnReason.BREEDING);

    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Tags.Items.GRIZZLY_BEAR_FOOD);
    }

        protected void registerGoals() {
            super.registerGoals();
            this.goalSelector.addGoal(0, new FloatGoal(this));
            this.goalSelector.addGoal(1, new GrizzlyBearEntity.GrizzlyBearMeleeAttackGoal());
            this.goalSelector.addGoal(1, new PanicGoal(this, (double)2.0F, (p_375811_) -> p_375811_.isBaby() ? DamageTypeTags.PANIC_CAUSES : DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
            this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
            this.goalSelector.addGoal(3, new TemptGoal(this, 1.0, stack -> stack.is(Tags.Items.GRIZZLY_BEAR_FOOD), false));
            this.goalSelector.addGoal(4, new FollowParentGoal(this, (double)1.25F));
            this.goalSelector.addGoal(5, new RandomStrollGoal(this, (double)1.0F));
            this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
            this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
            this.targetSelector.addGoal(1, new GrizzlyBearEntity.GrizzlyBearHurtByTargetGoal());
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, 10, true, false, this::isAngryAt));
            this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal(this, false));
        }

        public static AttributeSupplier.Builder createAttributes() {
            return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, (double)30.0F).add(Attributes.FOLLOW_RANGE, (double)20.0F).add(Attributes.MOVEMENT_SPEED, (double)0.25F).add(Attributes.ATTACK_DAMAGE, (double)6.0F);
        }

        public void readAdditionalSaveData(CompoundTag compound) {
            super.readAdditionalSaveData(compound);
            this.readPersistentAngerSaveData(this.level(), compound);
        }

        public void addAdditionalSaveData(CompoundTag compound) {
            super.addAdditionalSaveData(compound);
            this.addPersistentAngerSaveData(compound);
        }

        public void startPersistentAngerTimer() {
            this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
        }

        public void setRemainingPersistentAngerTime(int time) {
            this.remainingPersistentAngerTime = time;
        }

        public int getRemainingPersistentAngerTime() {
            return this.remainingPersistentAngerTime;
        }

        public void setPersistentAngerTarget(@Nullable UUID target) {
            this.persistentAngerTarget = target;
        }

        @Nullable
        public UUID getPersistentAngerTarget() {
            return this.persistentAngerTarget;
        }

        protected SoundEvent getAmbientSound() {
            return this.isBaby() ? SoundEvents.POLAR_BEAR_AMBIENT_BABY : SoundEvents.POLAR_BEAR_AMBIENT;
        }

        protected SoundEvent getHurtSound(DamageSource damageSource) {
            return SoundEvents.POLAR_BEAR_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.POLAR_BEAR_DEATH;
        }

        protected void playStepSound(BlockPos pos, BlockState block) {
            this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
        }

        protected void playWarningSound() {
            if (this.warningSoundTicks <= 0) {
                this.makeSound(SoundEvents.POLAR_BEAR_WARNING);
                this.warningSoundTicks = 40;
            }

        }

        protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
            super.defineSynchedData(p_326229_);
            p_326229_.define(DATA_STANDING_ID, false);
        }

        public void tick() {
            super.tick();
            if (this.level().isClientSide) {
                if (this.clientSideStandAnimation != this.clientSideStandAnimationO) {
                    this.refreshDimensions();
                }

                this.clientSideStandAnimationO = this.clientSideStandAnimation;
                if (this.isStanding()) {
                    this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
                } else {
                    this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
                }
            }

            if (this.warningSoundTicks > 0) {
                --this.warningSoundTicks;
            }

            if (!this.level().isClientSide) {
                this.updatePersistentAnger((ServerLevel)this.level(), true);
            }

        }

        public EntityDimensions getDefaultDimensions(Pose p_316644_) {
            if (this.clientSideStandAnimation > 0.0F) {
                float f = this.clientSideStandAnimation / 6.0F;
                float f1 = 1.0F + f;
                return super.getDefaultDimensions(p_316644_).scale(1.0F, f1);
            } else {
                return super.getDefaultDimensions(p_316644_);
            }
        }

        public boolean isStanding() {
            return (Boolean)this.entityData.get(DATA_STANDING_ID);
        }

        public void setStanding(boolean standing) {
            this.entityData.set(DATA_STANDING_ID, standing);
        }

        public float getStandingAnimationScale(float partialTick) {
            return Mth.lerp(partialTick, this.clientSideStandAnimationO, this.clientSideStandAnimation) / 6.0F;
        }

        protected float getWaterSlowDown() {
            return 0.98F;
        }


        public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29533_, DifficultyInstance p_29534_, EntitySpawnReason p_361358_, @Nullable SpawnGroupData p_29536_) {
            if (p_29536_ == null) {
                p_29536_ = new AgeableMob.AgeableMobGroupData(0.75F);
            }

            return super.finalizeSpawn(p_29533_, p_29534_, p_361358_, p_29536_);
        }

        static {
            DATA_STANDING_ID = SynchedEntityData.defineId(GrizzlyBearEntity.class, EntityDataSerializers.BOOLEAN);
            PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
        }

        class GrizzlyBearHurtByTargetGoal extends HurtByTargetGoal {
            public GrizzlyBearHurtByTargetGoal() {
                super(GrizzlyBearEntity.this, new Class[0]);
            }

            public void start() {
                super.start();
                if (GrizzlyBearEntity.this.isBaby()) {
                    this.alertOthers();
                    this.stop();
                }

            }

            protected void alertOther(Mob mob, LivingEntity target) {
                if (mob instanceof GrizzlyBearEntity && !mob.isBaby()) {
                    super.alertOther(mob, target);
                }

            }
        }

        class GrizzlyBearMeleeAttackGoal extends MeleeAttackGoal {
            public GrizzlyBearMeleeAttackGoal() {
                super(GrizzlyBearEntity.this, (double)1.25F, true);
            }

            protected void checkAndPerformAttack(LivingEntity p_29589_) {
                if (this.canPerformAttack(p_29589_)) {
                    this.resetAttackCooldown();
                    this.mob.doHurtTarget(getServerLevel(this.mob), p_29589_);
                    GrizzlyBearEntity.this.setStanding(false);
                } else if (this.mob.distanceToSqr(p_29589_) < (double)((p_29589_.getBbWidth() + 3.0F) * (p_29589_.getBbWidth() + 3.0F))) {
                    if (this.isTimeToAttack()) {
                        GrizzlyBearEntity.this.setStanding(false);
                        this.resetAttackCooldown();
                    }

                    if (this.getTicksUntilNextAttack() <= 10) {
                        GrizzlyBearEntity.this.setStanding(true);
                        GrizzlyBearEntity.this.playWarningSound();
                    }
                } else {
                    this.resetAttackCooldown();
                    GrizzlyBearEntity.this.setStanding(false);
                }

            }

            public void stop() {
                GrizzlyBearEntity.this.setStanding(false);
                super.stop();
            }
        }

}
