package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.PhoenixEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class PhoenixRenderer extends MobEntityRenderer<PhoenixEntity, PhoenixRenderState, PhoenixModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/phoenix.png");

    public PhoenixRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PhoenixModel(ctx.getPart(ModModelLayers.PHOENIX)), 0.4f);
    }

    @Override
    public PhoenixRenderState createRenderState() {
        return new PhoenixRenderState();
    }

    @Override
    public void updateRenderState(PhoenixEntity entity, PhoenixRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.flying = !entity.isOnGround();
    }

    @Override
    public Identifier getTexture(PhoenixRenderState state) {
        return TEXTURE;
    }
}
