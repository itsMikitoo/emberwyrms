package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.MedusaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MedusaRenderer extends MobEntityRenderer<MedusaEntity, MedusaRenderState, MedusaModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/medusa.png");

    public MedusaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MedusaModel(ctx.getPart(ModModelLayers.MEDUSA)), 0.6f);
    }

    @Override
    public MedusaRenderState createRenderState() {
        return new MedusaRenderState();
    }

    @Override
    public void updateRenderState(MedusaEntity entity, MedusaRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkSpeed = entity.anim.speed;
        state.walkPhase = entity.anim.phaseAt(tickDelta);

    }

    @Override
    public Identifier getTexture(MedusaRenderState state) {
        return TEXTURE;
    }
}
