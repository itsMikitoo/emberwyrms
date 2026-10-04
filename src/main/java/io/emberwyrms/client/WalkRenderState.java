package io.emberwyrms.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;

/** Estado comun: velocidad y fase de caminata calculadas por el propio mod. */
public class WalkRenderState extends LivingEntityRenderState {
    public float walkSpeed;
    public float walkPhase;
    /** 0 = vivo, 1 = muerte completa (se rellena desde LivingEntity.deathTime). */
    public float death;
}
