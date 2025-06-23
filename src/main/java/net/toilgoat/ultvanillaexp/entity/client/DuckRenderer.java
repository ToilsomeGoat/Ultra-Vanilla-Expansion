package net.toilgoat.ultvanillaexp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.toilgoat.ultvanillaexp.entity.custom.DuckEntity;

public class DuckRenderer extends MobRenderer<DuckEntity, DuckRenderState, DuckModel> {
    private static final ResourceLocation DUCK_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/duck.png");

    public DuckRenderer(EntityRendererProvider.Context context) {
        super(context, new DuckModel(context.bakeLayer(DuckModel.LAYER_LOCATION)),0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(DuckRenderState renderState) {
        return DUCK_LOCATION;
    }

    @Override
    public void render(DuckRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(renderState.isBaby) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public DuckRenderState createRenderState() {
        return new DuckRenderState();
    }

    @Override
    public void extractRenderState(DuckEntity entity, DuckRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        reusedState.flap = Mth.lerp(partialTick, entity.oFlap, entity.flap);
        reusedState.flapSpeed = Mth.lerp(partialTick, entity.oFlapSpeed, entity.flapSpeed);
        reusedState.isSwimming = entity.isInWater();
    }
}

