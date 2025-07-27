package net.toilgoat.ultvanillaexp.entity.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class SunkenRenderState extends HumanoidRenderState {
    public float limbSwing;
    public float limbSwingAmount;
    public float ageInTicks;
    public float swimAmount;
    public float headYaw;
    public float headPitch;
    public float netHeadYaw;
    public float xRot;
    public float yRot;
    public boolean isAggressive;
    public boolean isHoldingTrident;
    public boolean inWater;
    public HumanoidModel.ArmPose leftArmPose = HumanoidModel.ArmPose.EMPTY;
    public HumanoidModel.ArmPose rightArmPose = HumanoidModel.ArmPose.EMPTY;
}
