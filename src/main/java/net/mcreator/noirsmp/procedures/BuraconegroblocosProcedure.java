package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BuraconegroblocosProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sphereRadius = 0;
		double ct2 = 0;
		double ct = 0;
		double ct3 = 0;
		double cx = 0;
		double cy = 0;
		double cz = 0;
		double shiftAmt = 0;
		double squareOfDistance = 0;
		BlockState blockToInhall = Blocks.AIR.defaultBlockState();
		sphereRadius = 16;
		shiftAmt = sphereRadius / 2 == Math.round(sphereRadius) / 2 ? 1 : 0;
		for (int index0 = 0; index0 < (int) Math.round(sphereRadius); index0++) {
			for (int index1 = 0; index1 < (int) Math.round(sphereRadius); index1++) {
				for (int index2 = 0; index2 < (int) Math.round(sphereRadius); index2++) {
					squareOfDistance = ct * ct + ct2 * ct2 + ct3 * ct3;
					if (squareOfDistance < sphereRadius * sphereRadius) {
						if (Mth.nextInt(RandomSource.create(), 0, (int) (sphereRadius * sphereRadius)) == 0) {
							cx = x + (Mth.nextInt(RandomSource.create(), 1, (int) (sphereRadius * 2)) - Math.round(sphereRadius)) - shiftAmt;
							cy = y + (Mth.nextInt(RandomSource.create(), 1, (int) (sphereRadius * 2)) - Math.round(sphereRadius)) - shiftAmt;
							cz = z + (Mth.nextInt(RandomSource.create(), 1, (int) (sphereRadius * 2)) - Math.round(sphereRadius)) - shiftAmt;
							blockToInhall = (world.getBlockState(BlockPos.containing(cx, cy, cz)));
							world.setBlock(BlockPos.containing(cx, cy, cz), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(cx + 0.5, cy + 0.75, cz + 0.5), blockToInhall);
						}
						world.setBlock(BlockPos.containing(x - (ct + shiftAmt), y - (ct2 + shiftAmt), z - (ct3 + shiftAmt)), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + ct, y - (ct2 + shiftAmt), z - (ct3 + shiftAmt)), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + ct, y + ct2, z - (ct3 + shiftAmt)), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x - (ct + shiftAmt), y + ct2, z - (ct3 + shiftAmt)), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x - (ct + shiftAmt), y + ct2, z + ct3), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x - (ct + shiftAmt), y - (ct2 + shiftAmt), z + ct3), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + ct, y - (ct2 + shiftAmt), z + ct3), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + ct, y + ct2, z + ct3), Blocks.AIR.defaultBlockState(), 3);
					}
					ct3 = ct3 + 1;
				}
				ct3 = 0;
				ct2 = ct2 + 1;
			}
			ct2 = 0;
			ct = ct + 1;
		}
		ct = 0;
	}
}