package net.toilgoat.ultvanillaexp.entity.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SkeletonClothingLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.custom.ScorchedMonster;

public class ScorchedRenderer extends AbstractSkeletonRenderer<ScorchedMonster, SkeletonRenderState> {
    private static final ResourceLocation SCORCHED_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/scorched.png");
    private static final ResourceLocation SCORCHED_CLOTHES_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/scorched_overlay.png");

    public ScorchedRenderer(EntityRendererProvider.Context context) {
        super(context, ModelLayers.SKELETON, ModelLayers.SKELETON_INNER_ARMOR, ModelLayers.SKELETON_OUTER_ARMOR);
        this.addLayer(new SkeletonClothingLayer<>(this, context.getModelSet(), ModelLayers.STRAY_OUTER_LAYER, SCORCHED_CLOTHES_LOCATION));
    }

    public ResourceLocation getTextureLocation(SkeletonRenderState p_365297_) {
        return SCORCHED_LOCATION;
    }

    public SkeletonRenderState createRenderState() {
        return new SkeletonRenderState();
    }
}
