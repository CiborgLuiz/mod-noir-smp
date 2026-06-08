package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class LitomorphWallBlock extends WallBlock {
	public LitomorphWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(2f, 10f).forceSolidOn());
	}
}