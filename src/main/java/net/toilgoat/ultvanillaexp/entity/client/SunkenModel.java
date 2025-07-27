package net.toilgoat.ultvanillaexp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class SunkenModel extends HumanoidModel<SunkenRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "sunken"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart rightItem;
    private final ModelPart leftArm;
    private final ModelPart leftItem;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart hat;

    public SunkenModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.rightItem = this.rightArm.getChild("rightItem");
        this.leftArm = root.getChild("left_arm");
        this.leftItem = this.leftArm.getChild("leftItem");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.hat = this.head.getChild("hat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 16).addBox(-1.0F, 6.0F, -7.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_r1 = root.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -2.0F, 0.0F, -0.5672F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(17, 0).addBox(-2.0F, 0.0F, -1.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(32, 10).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, -4.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 32).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition rightArm_r1 = rightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(19, 22).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition rightItem = rightArm.addOrReplaceChild("rightItem", CubeListBuilder.create(), PartPose.offset(-1.0F, 7.0F, 1.0F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 32).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition leftArm_r1 = leftArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -1.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -1.0F, 0.0F, -0.48F, 0.0F));

        PartDefinition leftItem = leftArm.addOrReplaceChild("leftItem", CubeListBuilder.create(), PartPose.offset(1.0F, 7.0F, 1.0F));

        PartDefinition rightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(29, 7).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition leftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SunkenRenderState state) {
        super.setupAnim(state);

        if (state.isAggressive && !state.isHoldingTrident) {
            float f = state.attackTime;
            float f1 = Mth.sin(f * (float)Math.PI);
            float f2 = Mth.sin((1.0F - (1.0F - f) * (1.0F - f)) * (float)Math.PI);
            this.rightArm.zRot = 0.0F;
            this.leftArm.zRot = 0.0F;
            this.rightArm.yRot = -(0.1F - f1 * 0.6F);
            this.leftArm.yRot = 0.1F - f1 * 0.6F;
            this.rightArm.xRot = (-(float)Math.PI / 2F);
            this.leftArm.xRot = (-(float)Math.PI / 2F);
            ModelPart var10000 = this.rightArm;
            var10000.xRot -= f1 * 1.2F - f2 * 0.4F;
            var10000 = this.leftArm;
            var10000.xRot -= f1 * 1.2F - f2 * 0.4F;
            AnimationUtils.bobArms(this.rightArm, this.leftArm, state.ageInTicks);
        }
        if (state.leftArmPose == ArmPose.THROW_SPEAR) {
            this.leftArm.xRot = this.leftArm.xRot * 0.5F - (float)Math.PI;
            this.leftArm.yRot = 0.0F;
        }

        if (state.rightArmPose == ArmPose.THROW_SPEAR) {
            this.rightArm.xRot = this.rightArm.xRot * 0.5F - (float)Math.PI;
            this.rightArm.yRot = 0.0F;
        }

        float swimAmt = state.swimAmount;
        if (swimAmt > 0.0F) {
            this.rightArm.xRot = Mth.rotLerpRad(swimAmt, this.rightArm.xRot, -2.5132742F)
                    + swimAmt * 0.35F * Mth.sin(0.1F * state.ageInTicks);
            this.leftArm.xRot = Mth.rotLerpRad(swimAmt, this.leftArm.xRot, -2.5132742F)
                    - swimAmt * 0.35F * Mth.sin(0.1F * state.ageInTicks);
            this.rightArm.zRot = Mth.rotLerpRad(swimAmt, this.rightArm.zRot, -0.15F);
            this.leftArm.zRot = Mth.rotLerpRad(swimAmt, this.leftArm.zRot, 0.15F);
            this.leftLeg.xRot -= swimAmt * 0.55F * Mth.sin(0.1F * state.ageInTicks);
            this.rightLeg.xRot += swimAmt * 0.55F * Mth.sin(0.1F * state.ageInTicks);
            this.head.xRot = 0.0F;
        }
    }
    public void translateToHand(HumanoidArm side, PoseStack poseStack) {
        this.root().translateAndRotate(poseStack);
        float f = side == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        ModelPart modelpart = this.getArm(side);
        modelpart.x += f;
        modelpart.translateAndRotate(poseStack);
        modelpart.x -= f;
    }

}
