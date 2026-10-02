package io.emberwyrms.client;

import io.emberwyrms.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class EmberwyrmsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ASHWING, AshwingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PHOENIX, PhoenixModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MEDUSA, MedusaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ASHWING, AshwingRenderer::new);
        EntityRendererRegistry.register(ModEntities.PHOENIX, PhoenixRenderer::new);
        EntityRendererRegistry.register(ModEntities.MEDUSA, MedusaRenderer::new);
        EntityRendererRegistry.register(ModEntities.ASH_DRAGON, AshBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIRE_DRAGON, FireDragonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FIRE_DRAGON, ctx -> new DragonRenderer(ctx, ModModelLayers.FIRE_DRAGON, FireDragonModel::new, "fire_dragon"));
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ICE_DRAGON, IceDragonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ICE_DRAGON, ctx -> new DragonRenderer(ctx, ModModelLayers.ICE_DRAGON, IceDragonModel::new, "ice_dragon"));
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STORM_DRAGON, StormDragonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.STORM_DRAGON, ctx -> new DragonRenderer(ctx, ModModelLayers.STORM_DRAGON, StormDragonModel::new, "storm_dragon"));
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIDE_DRAGON, TideDragonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIDE_DRAGON, ctx -> new DragonRenderer(ctx, ModModelLayers.TIDE_DRAGON, TideDragonModel::new, "tide_dragon"));
    }
}
