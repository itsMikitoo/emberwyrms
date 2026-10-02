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
    }
}
