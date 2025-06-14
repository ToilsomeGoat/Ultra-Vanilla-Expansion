package net.toilgoat.ultvanillaexp.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.FurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.toilgoat.ultvanillaexp.recipe.FrosterRecipeBookComponent;

import java.util.List;

public class AbstractFrosterScreen<T extends AbstractFrosterMenu> extends AbstractRecipeBookScreen<T> {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
        private final ResourceLocation texture;
        private final ResourceLocation litProgressSprite;
        private final ResourceLocation burnProgressSprite;

        public AbstractFrosterScreen(T menu, Inventory playerInventory, Component title, Component recipeFilterName, ResourceLocation texture, ResourceLocation litProgressSprite, ResourceLocation burnProgressSprite, List<RecipeBookComponent.TabInfo> tabInfos) {
            super(menu, new FrosterRecipeBookComponent(menu, recipeFilterName, tabInfos), playerInventory, title);
            this.texture = texture;
            this.litProgressSprite = litProgressSprite;
            this.burnProgressSprite = burnProgressSprite;
        }

        public void init() {
            super.init();
            this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        }

        protected ScreenPosition getRecipeBookButtonPosition() {
            return new ScreenPosition(this.leftPos + 20, this.height / 2 - 49);
        }

        protected void renderBg(GuiGraphics p_282928_, float p_281631_, int p_281252_, int p_281891_) {
            int i = this.leftPos;
            int j = this.topPos;
            p_282928_.blit(RenderType::guiTextured, this.texture, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
            if (((AbstractFrosterMenu)this.menu).isLit()) {
                int k = 14;
                int l = Mth.ceil(((AbstractFrosterMenu)this.menu).getLitProgress() * 13.0F) + 1;
                p_282928_.blitSprite(RenderType::guiTextured, this.litProgressSprite, 14, 14, 0, 14 - l, i + 56, j + 36 + 14 - l, 14, l);
            }

            int i1 = 24;
            int j1 = Mth.ceil(((AbstractFrosterMenu)this.menu).getBurnProgress() * 24.0F);
            p_282928_.blitSprite(RenderType::guiTextured, this.burnProgressSprite, 24, 16, 0, 0, i + 79, j + 34, j1, 16);
        }

}
