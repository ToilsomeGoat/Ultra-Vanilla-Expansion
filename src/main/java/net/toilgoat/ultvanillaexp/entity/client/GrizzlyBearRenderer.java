package net.toilgoat.ultvanillaexp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.custom.GrizzlyBearEntity;

public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, GrizzlyBearRenderState, GrizzlyBearModel> {
    private static final ResourceLocation GRIZZLY_BEAR_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/grizzly_bear.png");

    public GrizzlyBearRenderer(EntityRendererProvider.Context context) {
        super(context, new GrizzlyBearModel(context.bakeLayer(GrizzlyBearModel.LAYER_LOCATION)),0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(GrizzlyBearRenderState renderState) {
        return GRIZZLY_BEAR_LOCATION;
    }

    @Override
    public void render(GrizzlyBearRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(renderState.isBaby) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public GrizzlyBearRenderState createRenderState() {
        return new GrizzlyBearRenderState();
    }

    @Override
    public void extractRenderState(GrizzlyBearEntity entity, GrizzlyBearRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        reusedState.standScale = entity.getStandingAnimationScale(partialTick);
    }
}


