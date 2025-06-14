package net.toilgoat.ultvanillaexp.entity.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class DuckModel extends EntityModel<DuckRenderState>{
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "duck"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart beak;
    private final ModelPart wing0;
    private final ModelPart wing1;
    private final ModelPart leg1;
    private final ModelPart leg0;

    public DuckModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.beak = this.head.getChild("beak");
        this.wing0 = root.getChild("wing0");
        this.wing1 = root.getChild("wing1");
        this.leg1 = root.getChild("leg1");
        this.leg0 = root.getChild("leg0");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 21).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-2.0F, -8.0F, -5.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -4.0F));

        PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -3.0F));

        PartDefinition wing0 = partdefinition.addOrReplaceChild("wing0", CubeListBuilder.create().texOffs(15, 7).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, 0.0F));

        PartDefinition wing1 = partdefinition.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(15, 7).mirror().addBox(0.0F, 0.0F, -3.0F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 14.0F, 0.0F));

        PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(26, 6).mirror().addBox(-2.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 20.0F, 2.0F));

        PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(26, 6).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 20.0F, 2.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(DuckRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        super.setupAnim(state);
        float f = (Mth.sin(state.flap) + 1.0F) * state.flapSpeed;
        this.wing0.zRot = f;
        this.wing1.zRot = -f;
        this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
        this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
        if (state.isSwimming) {
            this.animateWalk(DuckAnimation.DUCK_SWIM, state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2f);
        } else {
            this.animateWalk(DuckAnimation.DUCK_WALK, state.walkAnimationPos, state.walkAnimationSpeed, 1.5f, 1.5f);
        }
    }


}