package net.toilgoat.ultvanillaexp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.custom.GrizzlyBearEntity;

public class GrizzlyBearModel extends EntityModel<GrizzlyBearRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "grizzly_bear"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg0;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;

    public GrizzlyBearModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leg0 = root.getChild("leg0");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -7.0F, 12.0F, 13.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-4.0F, -24.0F, -7.0F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, 12.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 18).addBox(-4.5F, -3.0F, -2.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(44, 31).addBox(-2.5F, 1.0F, -5.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-5.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -16.0F));

        PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 14.0F, 6.0F));

        PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(38, 40).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 14.0F, 6.0F));

        PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(20, 46).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 14.0F, -8.0F));

        PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(46, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 14.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(GrizzlyBearRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        super.setupAnim(state);
        this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
        this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
        this.animateWalk(GrizzlyBearAnimation.GRIZZLY_BEAR_WALK, state.walkAnimationPos, state.walkAnimationSpeed, 2.0f, 2.5f);
        float f = state.standScale * state.standScale;
        float f1 = state.ageScale;
        float f2 = state.isBaby ? 0.5F : 1.0F;
        ModelPart var10000 = this.body;
        var10000.xRot -= f * (float) Math.PI * 0.35F;
        var10000 = this.body;
        var10000.y += f * f1 * 2.0F;
        var10000 = this.leg2;
        var10000.y -= f * f1 * 20.0F;
        var10000 = this.leg2;
        var10000.z += f * f1 * 4.0F;
        var10000 = this.leg2;
        var10000.xRot -= f * (float) Math.PI * 0.45F;
        this.leg3.y = this.leg2.y;
        this.leg3.z = this.leg2.z;
        var10000 = this.leg3;
        var10000.xRot -= f * (float) Math.PI * 0.45F;
        var10000 = this.head;
        var10000.y -= f * f2 * 24.0F;
        var10000 = this.head;
        var10000.z += f * f2 * 13.0F;
        var10000 = this.head;
        var10000.xRot += f * (float) Math.PI * 0.15F;
    }
}
