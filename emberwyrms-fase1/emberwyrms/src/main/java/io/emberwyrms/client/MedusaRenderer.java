package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.MedusaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class MedusaRenderer extends MobEntityRenderer<MedusaEntity, LivingEntityRenderState, MedusaModel> {
    private static final Identifier TEXTURE = Emberwyrms.id("textures/entity/medusa.png");

    public MedusaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MedusaModel(ctx.getPart(ModModelLayers.MEDUSA)), 0.6f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public void updateRenderState(MedusaEntity entity, LivingEntityRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        // sin estado extra
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
