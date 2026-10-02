package io.emberwyrms.client;

import io.emberwyrms.Emberwyrms;
import io.emberwyrms.entity.DragonEntity;
import java.util.function.Function;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

/** Renderizador compartido por los 4 dragones elementales (cada uno con su modelo y textura). */
public class DragonRenderer extends MobEntityRenderer<DragonEntity, AshwingRenderState, EntityModel<AshwingRenderState>> {
    private final Identifier texture;

    public DragonRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer,
                          Function<ModelPart, EntityModel<AshwingRenderState>> factory, String textureName) {
        super(ctx, factory.apply(ctx.getPart(layer)), 1.1f);
        this.texture = Emberwyrms.id("textures/entity/" + textureName + ".png");
    }

    @Override
    public AshwingRenderState createRenderState() {
        return new AshwingRenderState();
    }

    @Override
    public void updateRenderState(DragonEntity entity, AshwingRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkSpeed = entity.anim.speed;
        state.walkPhase = entity.anim.phaseAt(tickDelta);
        state.sitting = entity.isSitting();
        state.breathing = entity.isBreathing();
    }

    @Override
    public Identifier getTexture(AshwingRenderState state) {
        return this.texture;
    }
}
