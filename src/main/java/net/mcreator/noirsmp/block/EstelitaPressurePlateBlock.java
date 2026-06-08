package net.mcreator.noirsmp.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.PressurePlateBlock;

public class EstelitaPressurePlateBlock extends PressurePlateBlock {
	public EstelitaPressurePlateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().strength(1f, 10f).requiresCorrectToolForDrops().forceSolidOn(), BlockSetType.STONE);
	}
}