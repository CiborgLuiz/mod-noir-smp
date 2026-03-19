package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class MolotovProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sz = 0;
		double sx = 0;
		double sy = 0;
		for (int index0 = 0; index0 < 64; index0++) {
			sx = x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 4;
			sy = y + 1;
			sz = z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 4;
			if (!((world.getBlockState(BlockPos.containing(sx, sy - 1, sz))).getBlock() == Blocks.AIR)) {
				if ((world.getBlockState(BlockPos.containing(sx, sy, sz))).getBlock() == Blocks.AIR) {
					{
						BlockPos _bp = BlockPos.containing(sx, sy, sz);
						BlockState _bs = Blocks.FIRE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
			}
		}
	}
}