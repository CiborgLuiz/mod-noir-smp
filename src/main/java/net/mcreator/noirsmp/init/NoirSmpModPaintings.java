/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, NoirSmpMod.MODID);
	public static final RegistryObject<PaintingVariant> LOGO = REGISTRY.register("logo", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> LOGO_LONGA = REGISTRY.register("logo_longa", () -> new PaintingVariant(101, 32));
}