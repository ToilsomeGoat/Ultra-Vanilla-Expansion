package net.toilgoat.ultvanillaexp.block.entity;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.toilgoat.ultvanillaexp.recipe.AbstractFrostingRecipe;

import javax.annotation.Nullable;
import java.util.List;


public abstract class AbstractFrosterBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
        protected static final int SLOT_INPUT = 0;
        protected static final int SLOT_FUEL = 1;
        protected static final int SLOT_RESULT = 2;
        public static final int DATA_LIT_TIME = 0;
        private static final int[] SLOTS_FOR_UP = new int[]{0};
        private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
        private static final int[] SLOTS_FOR_SIDES = new int[]{1};
        public static final int DATA_LIT_DURATION = 1;
        public static final int DATA_COOKING_PROGRESS = 2;
        public static final int DATA_COOKING_TOTAL_TIME = 3;
        public static final int NUM_DATA_VALUES = 4;
        public static final int BURN_TIME_STANDARD = 200;
        public static final int BURN_COOL_SPEED = 2;
        private final RecipeType<? extends AbstractFrostingRecipe> recipeType;
        protected NonNullList<ItemStack> items;
        int litTimeRemaining;
        int litTotalTime;
        int cookingTimer;
        int cookingTotalTime;
        protected final ContainerData dataAccess;
        private final Reference2IntOpenHashMap<ResourceKey<Recipe<?>>> recipesUsed;
        private final RecipeManager.CachedCheck<SingleRecipeInput, ? extends AbstractFrostingRecipe> quickCheck;

        protected AbstractFrosterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState, RecipeType<? extends AbstractFrostingRecipe> recipeType) {
            super(type, pos, blockState);
            this.items = NonNullList.withSize(3, ItemStack.EMPTY);
            this.dataAccess = new ContainerData() {
                public int get(int p_58431_) {
                    switch (p_58431_) {
                        case 0:
                            if (AbstractFrosterBlockEntity.this.litTotalTime > 32767) {
                                return Mth.floor((double) AbstractFrosterBlockEntity.this.litTimeRemaining / (double) AbstractFrosterBlockEntity.this.litTotalTime * (double)32767.0F);
                            }

                            return AbstractFrosterBlockEntity.this.litTimeRemaining;
                        case 1:
                            return Math.min(AbstractFrosterBlockEntity.this.litTotalTime, 32767);
                        case 2:
                            return AbstractFrosterBlockEntity.this.cookingTimer;
                        case 3:
                            return AbstractFrosterBlockEntity.this.cookingTotalTime;
                        default:
                            return 0;
                    }
                }

                public void set(int p_58433_, int p_58434_) {
                    switch (p_58433_) {
                        case 0 -> AbstractFrosterBlockEntity.this.litTimeRemaining = p_58434_;
                        case 1 -> AbstractFrosterBlockEntity.this.litTotalTime = p_58434_;
                        case 2 -> AbstractFrosterBlockEntity.this.cookingTimer = p_58434_;
                        case 3 -> AbstractFrosterBlockEntity.this.cookingTotalTime = p_58434_;
                    }

                }

                public int getCount() {
                    return 4;
                }
            };
            this.recipesUsed = new Reference2IntOpenHashMap();
            this.quickCheck = RecipeManager.createCheck(recipeType);
            this.recipeType = recipeType;
        }

        private boolean isLit() {
            return this.litTimeRemaining > 0;
        }

        protected void loadAdditional(CompoundTag p_155025_, HolderLookup.Provider p_323468_) {
            super.loadAdditional(p_155025_, p_323468_);
            this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
            ContainerHelper.loadAllItems(p_155025_, this.items, p_323468_);
            this.cookingTimer = p_155025_.getInt("cooking_time_spent");
            this.cookingTotalTime = p_155025_.getInt("cooking_total_time");
            this.litTimeRemaining = p_155025_.getInt("lit_time_remaining");
            this.litTotalTime = p_155025_.getInt("lit_total_time");
            CompoundTag compoundtag = p_155025_.getCompound("RecipesUsed");

            for(String s : compoundtag.getAllKeys()) {
                this.recipesUsed.put(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(s)), compoundtag.getInt(s));
            }

        }

        protected void saveAdditional(CompoundTag p_187452_, HolderLookup.Provider p_323656_) {
            super.saveAdditional(p_187452_, p_323656_);
            p_187452_.putInt("cooking_time_spent", this.cookingTimer);
            p_187452_.putInt("cooking_total_time", this.cookingTotalTime);
            p_187452_.putInt("lit_time_remaining", this.litTimeRemaining);
            p_187452_.putInt("lit_total_time", this.litTotalTime);
            ContainerHelper.saveAllItems(p_187452_, this.items, p_323656_);
            CompoundTag compoundtag = new CompoundTag();
            this.recipesUsed.forEach((p_380898_, p_380899_) -> compoundtag.putInt(p_380898_.location().toString(), p_380899_));
            p_187452_.put("RecipesUsed", compoundtag);
        }

        public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, AbstractFrosterBlockEntity furnace) {
            boolean flag = furnace.isLit();
            boolean flag1 = false;
            if (furnace.isLit()) {
                --furnace.litTimeRemaining;
            }

            ItemStack itemstack = (ItemStack)furnace.items.get(1);
            ItemStack itemstack1 = (ItemStack)furnace.items.get(0);
            boolean flag2 = !itemstack1.isEmpty();
            boolean flag3 = !itemstack.isEmpty();
            if (furnace.isLit() || flag3 && flag2) {
                SingleRecipeInput singlerecipeinput = new SingleRecipeInput(itemstack1);
                RecipeHolder<? extends AbstractFrostingRecipe> recipeholder;
                if (flag2) {
                    recipeholder = furnace.quickCheck.getRecipeFor(singlerecipeinput, level).orElse( null);
                } else {
                    recipeholder = null;
                }

                int i = furnace.getMaxStackSize();
                if (!furnace.isLit() && canBurn(level.registryAccess(), recipeholder, singlerecipeinput, furnace.items, i)) {
                    furnace.litTimeRemaining = furnace.getBurnDuration(level.fuelValues(), itemstack);
                    furnace.litTotalTime = furnace.litTimeRemaining;
                    if (furnace.isLit()) {
                        flag1 = true;
                        ItemStack remainder = itemstack.getCraftingRemainder();
                        if (!remainder.isEmpty()) {
                            furnace.items.set(1, remainder);
                        } else if (flag3) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                furnace.items.set(1, item.getCraftingRemainder());
                            }
                        }
                    }
                }

                if (furnace.isLit() && canBurn(level.registryAccess(), recipeholder, singlerecipeinput, furnace.items, i)) {
                    ++furnace.cookingTimer;
                    if (furnace.cookingTimer == furnace.cookingTotalTime) {
                        furnace.cookingTimer = 0;
                        furnace.cookingTotalTime = getTotalCookTime(level, furnace);
                        if (burn(level.registryAccess(), recipeholder, singlerecipeinput, furnace.items, i, level, pos)) {
                            furnace.setRecipeUsed(recipeholder);
                        }

                        flag1 = true;
                    }
                } else {
                    furnace.cookingTimer = 0;
                }
            } else if (!furnace.isLit() && furnace.cookingTimer > 0) {
                furnace.cookingTimer = Mth.clamp(furnace.cookingTimer - 2, 0, furnace.cookingTotalTime);
            }

            if (flag != furnace.isLit()) {
                flag1 = true;
                state = (BlockState)state.setValue(AbstractFurnaceBlock.LIT, furnace.isLit());
                level.setBlock(pos, state, 3);
            }

            if (flag1) {
                setChanged(level, pos, state);
            }

        }

        private static boolean canBurn(RegistryAccess registryAccess, @Nullable RecipeHolder<? extends AbstractFrostingRecipe> recipe, SingleRecipeInput recipeInput, NonNullList<ItemStack> items, int maxStackSize) {
            if (!((ItemStack)items.get(0)).isEmpty() && recipe != null) {
                ItemStack itemstack = ((AbstractFrostingRecipe)recipe.value()).assemble(recipeInput, registryAccess);
                if (itemstack.isEmpty()) {
                    return false;
                } else {
                    ItemStack itemstack1 = (ItemStack)items.get(2);
                    if (itemstack1.isEmpty()) {
                        return true;
                    } else if (!ItemStack.isSameItemSameComponents(itemstack1, itemstack)) {
                        return false;
                    } else {
                        return itemstack1.getCount() + itemstack.getCount() <= maxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize() ? true : itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
                    }
                }
            } else {
                return false;
            }
        }

        private static boolean burn(RegistryAccess registryAccess, @Nullable RecipeHolder<? extends AbstractFrostingRecipe> recipe, SingleRecipeInput recipeInput, NonNullList<ItemStack> items, int maxStackSize, Level level, BlockPos pos) {
            if (recipe != null && canBurn(registryAccess, recipe, recipeInput, items, maxStackSize)) {
                ItemStack itemstack = (ItemStack)items.get(0);
                ItemStack itemstack1 = ((AbstractFrostingRecipe)recipe.value()).assemble(recipeInput, registryAccess);
                ItemStack itemstack2 = (ItemStack)items.get(2);
                if (itemstack2.isEmpty()) {
                    items.set(2, itemstack1.copy());
                } else if (ItemStack.isSameItemSameComponents(itemstack2, itemstack1)) {
                    itemstack2.grow(itemstack1.getCount());
                }

                if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !((ItemStack)items.get(1)).isEmpty() && ((ItemStack)items.get(1)).is(Items.BUCKET)) {
                    items.set(1, new ItemStack(Items.WATER_BUCKET));
                }

                ItemStack inputStack = items.get(0);  // Input slot
                ItemStack remainder = inputStack.getCraftingRemainder(); // The container item

                inputStack.shrink(1);

                if (inputStack.isEmpty()) {
                    if (!remainder.isEmpty()) {
                        items.set(0, remainder.copy());
                    } else {
                        items.set(0, ItemStack.EMPTY);
                    }
                } else {
                    if (!remainder.isEmpty()) {
                        ItemStack currentInput = items.get(0);
                        if (currentInput.isEmpty()) {
                            items.set(0, remainder.copy());
                        } else if (!ItemStack.isSameItem(currentInput, remainder) || currentInput.getCount() + remainder.getCount() > currentInput.getMaxStackSize()) {
                            dropItemStackInWorld(level, pos, remainder.copy());
                        } else {
                            currentInput.grow(remainder.getCount());
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        }

    private static void dropItemStackInWorld(Level level, BlockPos pos, ItemStack stack) {
        if (!level.isClientSide) {
            ItemEntity entity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, stack);
            entity.setDefaultPickUpDelay();
            level.addFreshEntity(entity);
        }
    }

        protected int getBurnDuration(FuelValues frosterFuelValues, ItemStack stack) {
            return stack.getBurnTime(this.recipeType, frosterFuelValues);
        }

        private static int getTotalCookTime(ServerLevel level, AbstractFrosterBlockEntity furnace) {
            SingleRecipeInput singlerecipeinput = new SingleRecipeInput(furnace.getItem(0));
            return (Integer)furnace.quickCheck.getRecipeFor(singlerecipeinput, level).map((p_379263_) -> ((AbstractFrostingRecipe)p_379263_.value()).cookingTime()).orElse(200);
        }

        public int[] getSlotsForFace(Direction side) {
            if (side == Direction.DOWN) {
                return SLOTS_FOR_DOWN;
            } else {
                return side == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
            }
        }

        public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
            return this.canPlaceItem(index, itemStack);
        }

        public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
            return direction == Direction.DOWN && index == 1 ? stack.is(Items.WATER_BUCKET) || stack.is(Items.BUCKET) : true;
        }

        public int getContainerSize() {
            return this.items.size();
        }

        protected NonNullList<ItemStack> getItems() {
            return this.items;
        }

        protected void setItems(NonNullList<ItemStack> p_332808_) {
            this.items = p_332808_;
        }

        public void setItem(int index, ItemStack stack) {
            ItemStack itemstack = (ItemStack)this.items.get(index);
            boolean flag = !stack.isEmpty() && ItemStack.isSameItemSameComponents(itemstack, stack);
            this.items.set(index, stack);
            stack.limitSize(this.getMaxStackSize(stack));
            if (index == 0 && !flag) {
                Level var6 = this.level;
                if (var6 instanceof ServerLevel) {
                    ServerLevel serverlevel = (ServerLevel)var6;
                    this.cookingTotalTime = getTotalCookTime(serverlevel, this);
                    this.cookingTimer = 0;
                    this.setChanged();
                }
            }

        }

        public boolean canPlaceItem(int index, ItemStack stack) {
            if (index == 2) {
                return false;
            } else if (index != 1) {
                return true;
            } else {
                ItemStack itemstack = (ItemStack)this.items.get(1);
                return stack.getBurnTime(this.recipeType, this.level.fuelValues()) > 0 || stack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
            }
        }

        public void setRecipeUsed(@Nullable RecipeHolder<?> p_301245_) {
            if (p_301245_ != null) {
                ResourceKey<Recipe<?>> resourcekey = p_301245_.id();
                this.recipesUsed.addTo(resourcekey, 1);
            }

        }

        @Nullable
        public RecipeHolder<?> getRecipeUsed() {
            return null;
        }

        public void awardUsedRecipes(Player p_58396_, List<ItemStack> p_282202_) {
        }

        public void awardUsedRecipesAndPopExperience(ServerPlayer player) {
            List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
            player.awardRecipes(list);

            for(RecipeHolder<?> recipeholder : list) {
                if (recipeholder != null) {
                    player.triggerRecipeCrafted(recipeholder, this.items);
                }
            }

            this.recipesUsed.clear();
        }

        public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel level, Vec3 popVec) {
            List<RecipeHolder<?>> list = Lists.newArrayList();
            ObjectIterator var4 = this.recipesUsed.reference2IntEntrySet().iterator();

            while(var4.hasNext()) {
                Reference2IntMap.Entry<ResourceKey<Recipe<?>>> entry = (Reference2IntMap.Entry)var4.next();
                level.recipeAccess().byKey((ResourceKey)entry.getKey()).ifPresent((p_379268_) -> {
                    list.add((RecipeHolder<? extends AbstractFrostingRecipe>) p_379268_);
                    createExperience(level, popVec, entry.getIntValue(), ((AbstractFrostingRecipe) ((RecipeHolder<? extends AbstractFrostingRecipe>) p_379268_).value()).experience());
                });
            }

            return list;
        }

        private static void createExperience(ServerLevel level, Vec3 popVec, int recipeIndex, float experience) {
            int i = Mth.floor((float)recipeIndex * experience);
            float f = Mth.frac((float)recipeIndex * experience);
            if (f != 0.0F && Math.random() < (double)f) {
                ++i;
            }

            ExperienceOrb.award(level, popVec, i);
        }

        public void fillStackedContents(StackedItemContents p_363281_) {
            for(ItemStack itemstack : this.items) {
                p_363281_.accountStack(itemstack);
            }

        }

}
