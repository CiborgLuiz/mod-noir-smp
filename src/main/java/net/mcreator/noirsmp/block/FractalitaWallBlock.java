package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;

public class FractalitaWallBlock extends WallBlock {
	public FractalitaWallBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).requiresCorrectToolForDrops().forceSolidOn());
	}
}