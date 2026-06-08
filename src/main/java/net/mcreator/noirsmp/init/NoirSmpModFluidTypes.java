/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.noirsmp.fluid.types.DistorcedFluidFluidType;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, NoirSmpMod.MODID);
	public static final RegistryObject<FluidType> CRIOGER_TYPE = REGISTRY.register("crioger", () -> new DistorcedFluidFluidType());
}