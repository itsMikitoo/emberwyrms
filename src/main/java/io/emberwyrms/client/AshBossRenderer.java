package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.AshDragonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/** Dragon de Ceniza: modelo propio convertido de "The Warrior" (ver CREDITS.md). */
public class AshBossRenderer extends MobEntityRenderer<AshDragonEntity, AshwingRenderState, AshBossModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/ash_dragon.png");

    public AshBossRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AshBossModel(ctx.getPart(ModModelLayers.ASH_BOSS)), 2.5f);
    }

    @Override
    public AshwingRenderState createRenderState() {
        return new AshwingRenderState();
    }

    @Override
    public void updateRenderState(AshDragonEntity entity, AshwingRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkSpeed = entity.anim.speed;
        state.walkPhase = entity.anim.phaseAt(tickDelta);
        state.death = entity.deathTime > 0 ? Math.min(1f, (entity.deathTime + tickDelta) / 20f) : 0f;
        state.breathing = entity.isBreathing();
    }

    @Override
    public Identifier getTexture(AshwingRenderState state) {
        return TEXTURE;
    }
}
