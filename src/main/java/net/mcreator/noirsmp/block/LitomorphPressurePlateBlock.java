package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class LitomorphPressurePlateBlock extends PressurePlateBlock {
	public LitomorphPressurePlateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(2f, 10f).forceSolidOn(), BlockSetType.STONE);
	}
}