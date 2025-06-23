package net.toilgoat.ultvanillaexp.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.toilgoat.ultvanillaexp.entity.move_control.DuckMoveControl;
import net.toilgoat.ultvanillaexp.entity.Entities;

import javax.annotation.Nullable;

public class DuckEntity extends Animal {
    public final AnimationState swimAnimationState = new AnimationState();
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private float nextFlap = 1.0F;
    @Nullable
    BlockPos travelPos;

    public DuckEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.lookControl = new LookControl(this);
        this.setPathfindingMalus(PathType.WATER, 1.0F);
        this.moveControl = new DuckMoveControl(this, 85, 10,  0.45F, 1F, true);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
            ServerLevelAccessor p_30153_, DifficultyInstance p_30154_, EntitySpawnReason p_361581_, @Nullable SpawnGroupData p_30156_
    ) {
        return super.finalizeSpawn(p_30153_, p_30154_, p_361581_, p_30156_);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 10.0));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0, stack -> stack.is(ItemTags.CHICKEN_FOOD), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new DuckTravelGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new DuckGoToLandGoal(this, 1.0));
        this.goalSelector.addGoal(9, new DuckGoToWaterGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.TEMPT_RANGE, 12d)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    public void travel(Vec3 p_218530_) {
        if (this.isInWater()) {
            this.moveRelative(this.getSpeed(), p_218530_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(p_218530_);
        }

    }

    public void aiStep() {
        super.aiStep();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (this.onGround() ? -1.0F : 4.0F) * 0.3F;
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && !this.isInWater() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && !this.isInWater() && vec3.y < (double)0.0F) {
            this.setDeltaMovement(vec3.multiply((double)1.0F, 0.6, (double)1.0F));
        }

        this.flap += this.flapping * 2.0F;
    }

    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    protected void onFlap() {
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }

    @Override
    protected float getBlockJumpFactor() {
        return super.getBlockJumpFactor();
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.swimAnimationState.animateWhen(this.isInWater() && !this.walkAnimation.isMoving(), this.tickCount);
        }

        super.tick();
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    static class DuckGoToWaterGoal extends MoveToBlockGoal {
        private final DuckEntity Duck;

        DuckGoToWaterGoal(DuckEntity duck, double speedModifier) {
            super(duck, duck.isBaby() ? 1.5 : speedModifier, 2);
            this.Duck = duck;
            this.verticalSearchStart = -1;
        }

        @Override
        public boolean canContinueToUse() {
            return !this.Duck.isInWater() && this.tryTicks <= 500 && this.isValidTarget(this.Duck.level(), this.blockPos);
        }

        @Override
        public boolean canUse() {
            if (this.Duck.isBaby() && !this.Duck.isInWater()) {
                return super.canUse();
            } else {
                return !this.Duck.isInWater() ? super.canUse() : false;
            }
        }


        @Override
        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        /**
         * Return {@code true} to set given position as destination
         */
        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            return level.getBlockState(pos).is(Blocks.WATER);
        }
    }

    static class DuckGoToLandGoal extends MoveToBlockGoal {
        private final DuckEntity Duck;

        DuckGoToLandGoal(DuckEntity duck, double speedModifier) {
            super(duck, duck.isBaby() ? 1.5 : speedModifier, 8);
            this.Duck = duck;
            this.verticalSearchStart = -1;
        }

        @Override
        public boolean canContinueToUse() {
            return this.Duck.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.Duck.level(), this.blockPos);
        }

        @Override
        public boolean canUse() {
            if (this.Duck.isBaby() && this.Duck.isInWater()) {
                return super.canUse();
            } else {
                return this.Duck.isInWater() ? super.canUse() : false;
            }
        }


        @Override
        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        /**
         * Return {@code true} to set given position as destination
         */
        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            return !level.getBlockState(pos).is(Blocks.WATER)&&!level.getBlockState(pos).is(Blocks.LILY_PAD);
        }
    }

    static class DuckTravelGoal extends Goal {
        private final DuckEntity duck;
        private final double speedModifier;
        private boolean stuck;

        DuckTravelGoal(DuckEntity duck, double speedModifier) {
            this.duck = duck;
            this.speedModifier = speedModifier;
        }

        @Override
        public boolean canUse() {
            return this.duck.isInWater();
        }

        @Override
        public void start() {
            int i = 512;
            int j = 4;
            RandomSource randomsource = this.duck.random;
            int k = randomsource.nextInt(1025) - 512;
            int l = randomsource.nextInt(9) - 4;
            int i1 = randomsource.nextInt(1025) - 512;
            if ((double)l + this.duck.getY() > (double)(this.duck.level().getSeaLevel() - 1)) {
                l = 0;
            }
            this.duck.travelPos = BlockPos.containing((double)k + this.duck.getX(), (double)l + this.duck.getY(), (double)i1 + this.duck.getZ());
            this.stuck = false;
        }

        @Override
        public void tick() {
            BlockPos target = this.duck.travelPos;
            if (target == null) {
                this.stuck = true;
                return;
            }
            else if (this.duck.getNavigation().isDone()) {
                Vec3 vec3 = Vec3.atBottomCenterOf(target);
                Vec3 vec31 = DefaultRandomPos.getPosTowards(this.duck, 16, 3, vec3, (float) (Math.PI / 10));
                if (vec31 == null) {
                    vec31 = DefaultRandomPos.getPosTowards(this.duck, 8, 7, vec3, (float) (Math.PI / 2));
                }
                if (vec31 == null) {
                    this.stuck = true;
                    return;
                }

                int i = Mth.floor(vec31.x);
                int j = Mth.floor(vec31.z);

                if (!this.duck.level().hasChunksAt(i - 34, j - 34, i + 34, j + 34)) {
                        this.stuck = true;
                        return;
                    }


                this.duck.getNavigation().moveTo(vec31.x, vec31.y, vec31.z, this.speedModifier);
            }
        }

        @Override
        public boolean canContinueToUse() {
            return !this.duck.getNavigation().isDone() && !this.stuck;
        }

        @Override
        public void stop() {
            this.duck.travelPos = null;
            super.stop();
        }
    }


    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ItemTags.CHICKEN_FOOD);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new AmphibiousPathNavigation(this, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return Entities.DUCK.get().create(level, EntitySpawnReason.BREEDING);

    }

    @Override
    public void jumpFromGround() {
        super.jumpFromGround();
    }
}
