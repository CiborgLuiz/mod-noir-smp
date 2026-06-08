/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.noirsmp.client.renderer.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoirSmpModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(NoirSmpModEntities.MOLOTOV_PROJECTILE.get(), MolotovProjectileRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.TIJOLO_PROJECTILE.get(), TijoloProjectileRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.MINI_BURACO_NEGRO.get(), MiniBuracoNegroRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.BLACK_HOLE_OF_CALAMITY.get(), BlackHoleOfCalamityRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.LEVIATAN_PROJECTILE.get(), LeviatanProjectileRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.DOPPEL.get(), DoppelRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.SINGULARIS.get(), SingularisRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.GALINHA_INVERTIDA.get(), GalinhaInvertidaRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.VACA_INVERTIDA.get(), VacaInvertidaRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.RAPOSA_INVERTIDA.get(), RaposaInvertidaRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.CABRA_INVERTIDA.get(), CabraInvertidaRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.PORCO_INVERTIDO.get(), PorcoInvertidoRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.ZUMBI_INVERTIDO.get(), ZumbiInvertidoRenderer::new);
		event.registerEntityRenderer(NoirSmpModEntities.ESQUELETO_INVERTIDO.get(), EsqueletoInvertidoRenderer::new);
	}
}