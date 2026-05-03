package net.mcreator.noirsmp.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.noirsmp.entity.DoppelEntity;

import java.util.UUID;

public class DoppelRenderer extends HumanoidMobRenderer<DoppelEntity, HumanoidModel<DoppelEntity>> {
    public DoppelRenderer(EntityRendererProvider.Context context) {
        // Usa o modelo base do Player para renderizar braços/pernas no formato correto
        super(context, new HumanoidModel<DoppelEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, 
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), 
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), 
            context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(DoppelEntity entity) {
        // Como a entidade é domável (age como um cachorro), podemos pegar o UUID do dono
        UUID ownerUUID = entity.getOwnerUUID();
        
        if (ownerUUID != null && Minecraft.getInstance().getConnection() != null) {
            // Busca as informações do jogador carregadas no client
            PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(ownerUUID);
            if (playerInfo != null) {
                // Retorna a textura exata da skin do jogador
                return playerInfo.getSkinLocation();
            }
        }
        
        // Retorna a skin padrão (Steve/Alex) caso o dono não esteja renderizado ou não exista
        return DefaultPlayerSkin.getDefaultSkin(entity.getUUID());
    }
}