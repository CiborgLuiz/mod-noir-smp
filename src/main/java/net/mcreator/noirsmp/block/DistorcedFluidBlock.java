package net.mcreator.noirsmp.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.noirsmp.init.NoirSmpModFluids;

public class DistorcedFluidBlock extends LiquidBlock {
	public DistorcedFluidBlock() {
		super(() -> NoirSmpModFluids.CRIOGER.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid()
				.pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}