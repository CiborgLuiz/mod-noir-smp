package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class EstelitaSlabBlock extends SlabBlock {
	public EstelitaSlabBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).requiresCorrectToolForDrops());
	}
}