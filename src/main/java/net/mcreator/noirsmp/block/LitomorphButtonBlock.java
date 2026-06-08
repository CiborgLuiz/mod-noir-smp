package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class LitomorphButtonBlock extends ButtonBlock {
	public LitomorphButtonBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(2f, 10f), BlockSetType.STONE, 20, false);
	}
}