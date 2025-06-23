package net.toilgoat.ultvanillaexp.screen.custom;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)

import java.util.List;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.recipe.Recipes;
import net.toilgoat.ultvanillaexp.screen.AbstractFrosterScreen;

public class FrosterScreen extends AbstractFrosterScreen<FrosterMenu> {
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID,"container/froster/frost_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID,"container/froster/frosting_progress");
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID,"textures/gui/sprites/container/froster/gui.png");
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.frostable");
    private static final List<RecipeBookComponent.TabInfo> TABS;

    public FrosterScreen(FrosterMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, FILTER_NAME, GUI_TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE, TABS);
    }

    static {
        TABS = List.of(new RecipeBookComponent.TabInfo(SearchRecipeBookCategory.BLAST_FURNACE), new RecipeBookComponent.TabInfo(Items.REDSTONE_ORE, RecipeBookCategories.BLAST_FURNACE_BLOCKS), new RecipeBookComponent.TabInfo(Items.IRON_SHOVEL, Items.GOLDEN_LEGGINGS, RecipeBookCategories.BLAST_FURNACE_MISC));
    }
}
