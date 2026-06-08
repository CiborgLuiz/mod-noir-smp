package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.ButtonBlock;

public class TesseractitaButtonBlock extends ButtonBlock {
	public TesseractitaButtonBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).requiresCorrectToolForDrops(), BlockSetType.STONE, 20, false);
	}
}