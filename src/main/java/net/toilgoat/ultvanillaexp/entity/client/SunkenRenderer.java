package net.toilgoat.ultvanillaexp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.custom.GrizzlyBearEntity;
import net.toilgoat.ultvanillaexp.entity.custom.SunkenMonster;

public class SunkenRenderer extends HumanoidMobRenderer<SunkenMonster, SunkenRenderState, SunkenModel> {
    private static final ResourceLocation SUNKEN_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/sunken.png");

    public SunkenRenderer(EntityRendererProvider.Context context) {
        super(context, new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)), new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this,
                new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)),
                new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)),
                new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)),
                new SunkenModel(context.bakeLayer(SunkenModel.LAYER_LOCATION)),
                context.getEquipmentRenderer()
        ));
    }

    @Override
    public SunkenRenderState createRenderState() {
        return new SunkenRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(SunkenRenderState state) {
        return SUNKEN_LOCATION;
    }

    @Override
    public void extractRenderState(SunkenMonster entity, SunkenRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.isAggressive = entity.isAggressive(); // your custom method
        state.isHoldingTrident = entity.getMainHandItem().is(Items.TRIDENT);
        state.inWater = entity.isInWater();
        state.boundingBoxHeight = entity.getBbHeight();
    }

    @Override
    public HumanoidModel.ArmPose getArmPose(SunkenMonster entity, HumanoidArm arm) {
        ItemStack item = entity.getItemHeldByArm(arm);
        return entity.getMainArm() == arm && entity.isAggressive() && item.is(Items.TRIDENT)
                ? HumanoidModel.ArmPose.THROW_SPEAR
                : HumanoidModel.ArmPose.EMPTY;
    }

    @Override
    protected void setupRotations(SunkenRenderState renderState, PoseStack poseStack, float bodyRot, float scale) {
        super.setupRotations(renderState, poseStack, bodyRot, scale);

        if (renderState.swimAmount > 0.0F) {
            float f1 = -10.0F - renderState.xRot;
            float f2 = Mth.lerp(renderState.swimAmount, 0.0F, f1);
            poseStack.rotateAround(Axis.XP.rotationDegrees(f2), 0.0F, renderState.boundingBoxHeight / 2.0F /scale, 0.0F);
        }
    }
}

