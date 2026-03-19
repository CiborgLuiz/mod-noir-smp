/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.noirsmp.client.renderer.TijoloProjectileRenderer;
import net.mcreator.noirsmp.client.renderer.MolotovProjectileRenderer;
import net.mcreator.noirsmp.client.renderer.MiniBuracoNegroRenderer;
import net.mcreator.noirsmp.client.renderer.BuracoNegroRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoirSmpModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(NoirSmpModEntities.MOLOTOV_PROJECTILE.get(), MolotovProjectileRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.TIJOLO_PROJECTILE.get(), TijoloProjectileRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.BURACO_NEGRO.get(), BuracoNegroRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.MINI_BURACO_NEGRO.get(), MiniBuracoNegroRenderer::new);
	}
}