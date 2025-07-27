package net.toilgoat.ultvanillaexp.entity.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class FrostbittenRenderer extends ZombieRenderer {
    private static final ResourceLocation FROSTBITTEN_LOCATION = ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, "textures/entity/frostbitten.png");

    public FrostbittenRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(ZombieRenderState state) {
        return FROSTBITTEN_LOCATION;
    }
}

