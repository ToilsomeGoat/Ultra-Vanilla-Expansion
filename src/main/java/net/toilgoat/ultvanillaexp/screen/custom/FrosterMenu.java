package net.toilgoat.ultvanillaexp.screen.custom;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.toilgoat.ultvanillaexp.recipe.Recipes;
import net.toilgoat.ultvanillaexp.screen.AbstractFrosterMenu;
import net.toilgoat.ultvanillaexp.screen.MenuTypes;

public class FrosterMenu extends AbstractFrosterMenu {

    public FrosterMenu(int containerId, Inventory playerInventory) {
        super(MenuTypes.FROSTER_MENU.get(), Recipes.FROSTER_TYPE.get(), Recipes.FROSTER_INPUT.getKey(), RecipeBookType.BLAST_FURNACE, containerId, playerInventory);
    }

    public FrosterMenu(int containerId, Inventory playerInventory, Container frosterContainer, ContainerData frosterData) {
        super(MenuTypes.FROSTER_MENU.get(), Recipes.FROSTER_TYPE.get(), Recipes.FROSTER_INPUT.getKey(), RecipeBookType.BLAST_FURNACE, containerId, playerInventory, frosterContainer, frosterData);
    }

}

