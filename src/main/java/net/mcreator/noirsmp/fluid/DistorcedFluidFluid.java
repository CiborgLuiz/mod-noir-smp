package net.mcreator.noirsmp.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModFluids;
import net.mcreator.noirsmp.init.NoirSmpModFluidTypes;
import net.mcreator.noirsmp.init.NoirSmpModBlocks;

public abstract class DistorcedFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> NoirSmpModFluidTypes.CRIOGER_TYPE.get(), () -> NoirSmpModFluids.CRIOGER.get(), () -> NoirSmpModFluids.FLOWING_CRIOGER.get())
			.explosionResistance(100f).bucket(() -> NoirSmpModItems.CRIOGER_BUCKET.get()).block(() -> (LiquidBlock) NoirSmpModBlocks.CRIOGER.get());

	private DistorcedFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DistorcedFluidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DistorcedFluidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}