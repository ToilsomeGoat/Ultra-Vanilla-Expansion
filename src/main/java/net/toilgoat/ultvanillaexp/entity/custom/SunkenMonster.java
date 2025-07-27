
package net.toilgoat.ultvanillaexp.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class SunkenMonster extends Monster implements RangedAttackMob {

    protected final WaterBoundPathNavigation waterNavigation;
    protected final GroundPathNavigation landNavigation;
    boolean searchingForLand;
    public float animationPosition;
    public float animationSpeed;

    public SunkenMonster(EntityType<? extends SunkenMonster> type, Level level) {
        super(type, level);
        this.moveControl = new SunkenMoveControl(this);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.waterNavigation = new WaterBoundPathNavigation(this, level);
        this.landNavigation = new GroundPathNavigation(this, level);

        this.animationPosition = 0.0f;
        this.animationSpeed = 0.0f;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SunkenGoToWaterGoal(this, 1.0));
        this.goalSelector.addGoal(2, new SunkenTridentAttackGoal(this, 1.0, 40, 10.0F));
        this.goalSelector.addGoal(2, new SunkenAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new SunkenGoToBeachGoal(this, 1.0));
        this.goalSelector.addGoal(6, new SunkenSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, SunkenMonster.class).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    protected boolean isSunSensitive() {
        return true;
    }

    public void aiStep() {
        super.aiStep();

        this.updateSwimming();

        if (this.isAlive()) {
            boolean flag = this.isSunSensitive() && this.isSunBurnTick();
            if (flag) {
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageableItem()) {
                        Item item = itemstack.getItem();
                        itemstack.setDamageValue(itemstack.getDamageValue() + this.random.nextInt(2));
                        if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                            this.onEquippedItemBroken(item, EquipmentSlot.HEAD);
                            this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.igniteForSeconds(8.0F);
                }
            }
        }
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader level) {
        return level.isUnobstructed(this);
    }

    public void setSearchingForLand(boolean searchingForLand) {
        this.searchingForLand = searchingForLand;
    }

    public static boolean checkSunkenSpawnRules(
            EntityType<SunkenMonster> entityType, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random
    ) {
        if (!level.getFluidState(pos.below()).is(FluidTags.WATER) && !EntitySpawnReason.isSpawner(spawnReason)) {
            return false;
        } else {
            Holder<Biome> holder = level.getBiome(pos);
            boolean flag = level.getDifficulty() != Difficulty.PEACEFUL
                    && (EntitySpawnReason.ignoresLightRequirements(spawnReason) || isDarkEnoughToSpawn(level, pos, random))
                    && (EntitySpawnReason.isSpawner(spawnReason) || level.getFluidState(pos).is(FluidTags.WATER));
            if (!flag || !EntitySpawnReason.isSpawner(spawnReason) && spawnReason != EntitySpawnReason.REINFORCEMENT) {
                return holder.is(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS)
                        ? random.nextInt(15) == 0 && flag
                        : random.nextInt(40) == 0 && isDeepEnoughToSpawn(level, pos) && flag;
            } else {
                return true;
            }
        }
    }

    private static boolean isDeepEnoughToSpawn(LevelAccessor level, BlockPos pos) {
        return pos.getY() < level.getSeaLevel() - 5;
    }

    public boolean okTarget(@Nullable LivingEntity target) {
        return target != null ? !this.level().isBrightOutside() || target.isInWater() : false;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack itemstack = this.getMainHandItem();
        ItemStack itemstack1 = itemstack.is(Items.TRIDENT) ? itemstack : new ItemStack(Items.TRIDENT);
        ThrownTrident throwntrident = new ThrownTrident(this.level(), this, itemstack1);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333) - throwntrident.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        if (this.level() instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileUsingShoot(
                    throwntrident, serverlevel, itemstack1, d0, d1 + d3 * 0.2F, d2, 1.6F, 14 - this.level().getDifficulty().getId() * 4
            );
        }

        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        if (random.nextFloat() > 0.9) {
            int i = random.nextInt(16);
            if (i < 10) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TRIDENT));
            } else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BRUSH));
            }
        }
    }

    @Override
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason,
                                        @Nullable SpawnGroupData data) {
        this.populateDefaultEquipmentSlots(world.getRandom(), difficulty);
        this.populateDefaultEquipmentEnchantments(world, world.getRandom(), difficulty);
        if (this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty() && world.getRandom().nextFloat() < 0.03F) {
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.NAUTILUS_SHELL));
            this.setGuaranteedDrop(EquipmentSlot.OFFHAND);
        }
        return super.finalizeSpawn(world, difficulty, reason, data);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 35.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.DROWNED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.DROWNED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DROWNED_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
        this.playSound(SoundEvents.DROWNED_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }


    @Override
    public void updateSwimming() {
        if (!this.level().isClientSide) {
            if (this.isEffectiveAi() && this.isUnderWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.landNavigation;
                this.setSwimming(false);
            }
        }
    }

    @Override
    public boolean isVisuallySwimming() {
        return this.isSwimming();
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    static class SunkenMoveControl extends MoveControl {
        private final SunkenMonster entity;

        public SunkenMoveControl(SunkenMonster entity) {
            super(entity);
            this.entity = entity;
        }

        @Override
        public void tick() {
            LivingEntity livingentity = this.entity.getTarget();
            if (this.entity.wantsToSwim() && this.entity.isInWater()) {
                if (livingentity != null && livingentity.getY() > this.entity.getY() || this.entity.searchingForLand) {
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, 0.002, 0.0));
                }

                if (this.operation != MoveControl.Operation.MOVE_TO || this.entity.getNavigation().isDone()) {
                    this.entity.setSpeed(0.0F);
                    return;
                }

                double d0 = this.wantedX - this.entity.getX();
                double d1 = this.wantedY - this.entity.getY();
                double d2 = this.wantedZ - this.entity.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 /= d3;
                float f = (float) (Mth.atan2(d2, d0) * 180.0F / (float) Math.PI) - 90.0F;
                this.entity.setYRot(this.rotlerp(this.entity.getYRot(), f, 90.0F));
                this.entity.yBodyRot = this.entity.getYRot();
                float swimBoost = 1.5F;
                float f1 = (float) (this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                if (this.entity.isInWater()) {
                    f1 *= swimBoost;
                }
                float f2 = Mth.lerp(0.125F, this.entity.getSpeed(), f1);
                this.entity.setSpeed(f2);
                this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(f2 * d0 * 0.005, f2 * d1 * 0.1, f2 * d2 * 0.005));
            } else {
                if (!this.entity.onGround()) {
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, -0.008, 0.0));
                }

                super.tick();
            }
        }
    }

    static class SunkenGoToBeachGoal extends MoveToBlockGoal {
        private final SunkenMonster sunken;

        public SunkenGoToBeachGoal(SunkenMonster sunken, double speedModifier) {
            super(sunken, speedModifier, 8, 2);
            this.sunken = sunken;
        }

        @Override
        public boolean canUse() {
            return super.canUse()
                    && !this.sunken.level().isBrightOutside()
                    && this.sunken.isInWater()
                    && this.sunken.getY() >= this.sunken.level().getSeaLevel() - 3;
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        /**
         * Return {@code true} to set given position as destination
         */
        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            BlockPos blockpos = pos.above();
            return level.isEmptyBlock(blockpos) && level.isEmptyBlock(blockpos.above())
                    ? level.getBlockState(pos).entityCanStandOn(level, pos, this.sunken)
                    : false;
        }

        @Override
        public void start() {
            this.sunken.setSearchingForLand(false);
            this.sunken.navigation = this.sunken.landNavigation;
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
        }
    }

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            if (blockpos != null) {
                double d0 = this.distanceToSqr(blockpos.getX(), blockpos.getY(), blockpos.getZ());
                if (d0 < 4.0) {
                    return true;
                }
            }
        }

        return false;
    }

    static class SunkenSwimUpGoal extends Goal {
        private final SunkenMonster sunken;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public SunkenSwimUpGoal(SunkenMonster sunken, double speedModifier, int seaLevel) {
            this.sunken = sunken;
            this.speedModifier = speedModifier;
            this.seaLevel = seaLevel;
        }

        @Override
        public boolean canUse() {
            return !this.sunken.level().isBrightOutside() && this.sunken.isInWater() && this.sunken.getY() < this.seaLevel - 2;
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        @Override
        public void tick() {
            if (this.sunken.getY() < this.seaLevel - 1 && (this.sunken.getNavigation().isDone() || this.sunken.closeToNextPos())) {
                Vec3 vec3 = DefaultRandomPos.getPosTowards(
                        this.sunken, 4, 8, new Vec3(this.sunken.getX(), this.seaLevel - 1, this.sunken.getZ()), (float) (Math.PI / 2)
                );
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }

                this.sunken.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }
        }

        @Override
        public void start() {
            this.sunken.setSearchingForLand(true);
            this.stuck = false;
        }

        @Override
        public void stop() {
            this.sunken.setSearchingForLand(false);
        }
    }

    static class SunkenGoToWaterGoal extends Goal {
        private final PathfinderMob mob;
        private double wantedX;
        private double wantedY;
        private double wantedZ;
        private final double speedModifier;
        private final Level level;

        public SunkenGoToWaterGoal(PathfinderMob mob, double speedModifier) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.level = mob.level();
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!this.level.isBrightOutside()) {
                return false;
            } else if (this.mob.isInWater()) {
                return false;
            } else {
                Vec3 vec3 = this.getWaterPos();
                if (vec3 == null) {
                    return false;
                } else {
                    this.wantedX = vec3.x;
                    this.wantedY = vec3.y;
                    this.wantedZ = vec3.z;
                    return true;
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone();
        }

        @Override
        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        @Nullable
        private Vec3 getWaterPos() {
            RandomSource randomsource = this.mob.getRandom();
            BlockPos blockpos = this.mob.blockPosition();

            for (int i = 0; i < 10; i++) {
                BlockPos blockpos1 = blockpos.offset(randomsource.nextInt(20) - 10, 2 - randomsource.nextInt(8), randomsource.nextInt(20) - 10);
                if (this.level.getBlockState(blockpos1).is(Blocks.WATER)) {
                    return Vec3.atBottomCenterOf(blockpos1);
                }
            }

            return null;
        }
    }

    static class SunkenTridentAttackGoal extends RangedAttackGoal {
        private final SunkenMonster sunken;

        public SunkenTridentAttackGoal(RangedAttackMob p_32450_, double p_32451_, int p_32452_, float p_32453_) {
            super(p_32450_, p_32451_, p_32452_, p_32453_);
            this.sunken = (SunkenMonster) p_32450_;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.sunken.getMainHandItem().is(Items.TRIDENT);
        }

        @Override
        public void start() {
            super.start();
            this.sunken.setAggressive(true);
            this.sunken.startUsingItem(InteractionHand.MAIN_HAND);
        }

        @Override
        public void stop() {
            super.stop();
            this.sunken.stopUsingItem();
            this.sunken.setAggressive(false);
        }
    }

    static class SunkenAttackGoal extends MeleeAttackGoal{
        private final SunkenMonster entity;
        private int raiseArmTicks;

        public SunkenAttackGoal(SunkenMonster entity, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(entity, speedModifier, followingTargetEvenIfNotSeen);
            this.entity = entity;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.entity.okTarget(this.entity.getTarget());
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.entity.okTarget(this.entity.getTarget());
        }

        public void start() {
            super.start();
            this.raiseArmTicks = 0;
        }

        public void stop() {
            super.stop();
            this.entity.setAggressive(false);
        }

        public void tick() {
            super.tick();
            ++this.raiseArmTicks;
            if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
                this.entity.setAggressive(true);
            } else {
                this.entity.setAggressive(false);
            }

        }
    }
}