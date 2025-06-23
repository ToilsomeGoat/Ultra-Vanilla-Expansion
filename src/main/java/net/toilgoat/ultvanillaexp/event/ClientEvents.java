package net.toilgoat.ultvanillaexp.event;

import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.toilgoat.ultvanillaexp.block.entity.BlockEntities;

public class ClientEvents {
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(BlockEntities.SIGNS.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(BlockEntities.HANGING_SIGNS.get(), HangingSignRenderer::new);
    }
}
