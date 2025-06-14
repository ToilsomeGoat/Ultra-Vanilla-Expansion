
package net.toilgoat.ultvanillaexp.entity.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class DuckRenderState extends LivingEntityRenderState {
    public final AnimationState swimAnimationState = new AnimationState();
    public boolean isSwimming;
    public float flap;
    public float flapSpeed;
}