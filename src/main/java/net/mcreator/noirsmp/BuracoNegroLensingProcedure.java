package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;

public class BuracoNegroLensingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double raio) {

		if (!(world instanceof ServerLevel level))
			return;

		for (Player player : level.players()) {

			double dx = x - player.getX();
			double dy = y - player.getY();
			double dz = z - player.getZ();

			double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);

			if (dist < raio) {

				double intensidade = (raio - dist) / raio;

				for (int i = 0; i < 8; i++) {
					level.sendParticles(
							ParticleTypes.PORTAL,
							player.getX() + (Math.random()-0.5)*2,
							player.getY()+1,
							player.getZ() + (Math.random()-0.5)*2,
							1,0,0,0,0
					);
				}
			}
		}
	}
}