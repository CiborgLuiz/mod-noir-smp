/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.noirsmp.client.model.Modelburaconegro;
import net.mcreator.noirsmp.client.model.ModelTijoloProjetil;
import net.mcreator.noirsmp.client.model.ModelGarrafa;
import net.mcreator.noirsmp.client.model.ModelBotas_Etereas_Model;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoirSmpModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelBotas_Etereas_Model.LAYER_LOCATION, ModelBotas_Etereas_Model::createBodyLayer);
		event.registerLayerDefinition(ModelGarrafa.LAYER_LOCATION, ModelGarrafa::createBodyLayer);
		event.registerLayerDefinition(Modelburaconegro.LAYER_LOCATION, Modelburaconegro::createBodyLayer);
		event.registerLayerDefinition(ModelTijoloProjetil.LAYER_LOCATION, ModelTijoloProjetil::createBodyLayer);
	}
}