package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.AshwingEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class AshwingRenderer extends MobEntityRenderer<AshwingEntity, AshwingRenderState, AshwingModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/ashwing.png");

    public AshwingRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AshwingModel(ctx.getPart(ModModelLayers.ASHWING)), 1.1f);
    }

    @Override
    public AshwingRenderState createRenderState() {
        return new AshwingRenderState();
    }

    @Override
    public void updateRenderState(AshwingEntity entity, AshwingRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.sitting = entity.isSitting();
    }

    @Override
    public Identifier getTexture(AshwingRenderState state) {
        return TEXTURE;
    }
}
