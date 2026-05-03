package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

public class BuraconegroblocosProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity buracoNegro) {

		if (!(world instanceof ServerLevel level))
			return;


		boolean spawnFeito = buracoNegro.getPersistentData().getBoolean("spawn_limpeza");

		if (!spawnFeito) {

			int raio = 25;
			BlockPos centro = BlockPos.containing(x, y, z);

			for (int dx = -raio; dx <= raio; dx++) {
				for (int dy = -raio; dy <= raio; dy++) {
					for (int dz = -raio; dz <= raio; dz++) {

						if (dx * dx + dy * dy + dz * dz <= raio * raio) {

							BlockPos pos = centro.offset(dx, dy, dz);
							BlockState estado = world.getBlockState(pos);

							if (!estado.isAir()) {
								world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				}
			}

			buracoNegro.getPersistentData().putBoolean("spawn_limpeza", true);
			return;
		}


		double raioAtual = Math.max(10, buracoNegro.getPersistentData().getDouble("raio"));

		int tentativas = (int) (raioAtual * 1.5);

		for (int i = 0; i < tentativas; i++) {

			double bx = x + (Math.random() * raioAtual * 2 - raioAtual);
			double by = y + (Math.random() * raioAtual * 2 - raioAtual);
			double bz = z + (Math.random() * raioAtual * 2 - raioAtual);

			BlockPos pos = BlockPos.containing(bx, by, bz);
			BlockState estado = world.getBlockState(pos);

			if (!estado.isAir()) {
				world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

				buracoNegro.getPersistentData().putDouble("raio", raioAtual + 0.01);
			}
		}
	}
}