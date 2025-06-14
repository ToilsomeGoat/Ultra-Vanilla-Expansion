package net.toilgoat.ultvanillaexp.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.toilgoat.ultvanillaexp.recipe.Recipes;
import net.toilgoat.ultvanillaexp.screen.custom.FrosterMenu;

public class FrosterBlockEntity extends AbstractFrosterBlockEntity {
    public FrosterBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntities.FROSTER_BLOCK_ENTITY.get(), pos, blockState, Recipes.FROSTER_TYPE.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.ultvanillaexp.froster");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new FrosterMenu(id, player, this, this.dataAccess);
    }
}
