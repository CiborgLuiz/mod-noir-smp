package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;

public class BuracoNegroDistortionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {

		if (!(world instanceof ServerLevel level))
			return;

		double raio = 25;

		List<? extends Player> players = level.players();

		for (Player player : players) {

			double dx = x - player.getX();
			double dy = y - player.getY();
			double dz = z - player.getZ();

			double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

			if (dist < raio) {

				double intensidade = (raio - dist) / raio;

				for (int i = 0; i < 6; i++) {
					level.sendParticles(
							ParticleTypes.PORTAL,
							player.getX() + (Math.random() - 0.5) * 2,
							player.getY() + 1 + (Math.random() - 0.5) * 2,
							player.getZ() + (Math.random() - 0.5) * 2,
							1,
							0, 0, 0,
							0
					);
				}

				Vec3 movimento = new Vec3(dx, dy, dz)
						.normalize()
						.scale(0.04 * intensidade);

				player.setDeltaMovement(player.getDeltaMovement().add(movimento));
			}
		}
	}
}