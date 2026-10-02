package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.AshDragonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/** Dragon de Ceniza: usa el modelo del dragon base (escalado x1.7 por atributo) con textura de grietas de lava. */
public class AshBossRenderer extends MobEntityRenderer<AshDragonEntity, AshwingRenderState, AshwingModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/ash_dragon.png");

    public AshBossRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AshwingModel(ctx.getPart(ModModelLayers.ASHWING)), 1.4f);
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
        state.breathing = entity.isBreathing();
    }

    @Override
    public Identifier getTexture(AshwingRenderState state) {
        return TEXTURE;
    }
}
