package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class LitomorphSlabBlock extends SlabBlock {
	public LitomorphSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(2f, 10f));
	}
}