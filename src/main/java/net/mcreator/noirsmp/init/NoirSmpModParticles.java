/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.noirsmp.client.particle.SangueParticle;
import net.mcreator.noirsmp.client.particle.PulsoParticle;
import net.mcreator.noirsmp.client.particle.ParticulaFlorestaDeEcoParticle;
import net.mcreator.noirsmp.client.particle.CordilheiraNullParticulaParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoirSmpModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(NoirSmpModParticleTypes.SANGUE.get(), SangueParticle::provider);
		event.registerSpriteSet(NoirSmpModParticleTypes.PULSO.get(), PulsoParticle::provider);
		event.registerSpriteSet(NoirSmpModParticleTypes.PARTICULA_FLORESTA_DE_ECO.get(), ParticulaFlorestaDeEcoParticle::provider);
		event.registerSpriteSet(NoirSmpModParticleTypes.CORDILHEIRA_NULL_PARTICULA.get(), CordilheiraNullParticulaParticle::provider);
	}
}