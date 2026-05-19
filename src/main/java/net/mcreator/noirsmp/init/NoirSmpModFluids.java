/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.noirsmp.fluid.DistorcedFluidFluid;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, NoirSmpMod.MODID);
	public static final RegistryObject<FlowingFluid> DISTORCED_FLUID = REGISTRY.register("distorced_fluid", () -> new DistorcedFluidFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_DISTORCED_FLUID = REGISTRY.register("flowing_distorced_fluid", () -> new DistorcedFluidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(DISTORCED_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DISTORCED_FLUID.get(), RenderType.translucent());
		}
	}
}