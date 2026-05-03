package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.phys.Vec3;

import org.joml.Vector3f;

public class BuracoNegroEventHorizonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {

		if (!(world instanceof ServerLevel level))
			return;

		double raio = 3.5;
		int pontos = 80;

		for (int i = 0; i < pontos; i++) {

			double angulo = (2 * Math.PI * i) / pontos;

			double tempo = System.currentTimeMillis() / 300.0;
			double rot = angulo + tempo;

			double px = x + Math.cos(rot) * raio;
			double pz = z + Math.sin(rot) * raio;
			double py = y + Math.sin(rot * 2) * 0.2; 
			
			level.sendParticles(
					new DustParticleOptions(new Vector3f(0.6f, 0f, 1f), 1.5f),
					px, py, pz,
					1,
					0, 0, 0,
					0
			);
		}
	}
}