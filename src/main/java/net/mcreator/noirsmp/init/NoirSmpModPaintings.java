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
	public static final RegistryObject<PaintingVariant> NOIR_LOGO_LONGA = REGISTRY.register("noir_logo_longa", () -> new PaintingVariant(101, 32));
	public static final RegistryObject<PaintingVariant> NOIR_LOGO = REGISTRY.register("noir_logo", () -> new PaintingVariant(32, 32));
}