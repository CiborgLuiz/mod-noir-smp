/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, NoirSmpMod.MODID);
	public static final RegistryObject<SimpleParticleType> SANGUE = REGISTRY.register("sangue", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PULSO = REGISTRY.register("pulso", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PARTICULA_FLORESTA_DE_ECO = REGISTRY.register("particula_floresta_de_eco", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CORDILHEIRA_NULL_PARTICULA = REGISTRY.register("cordilheira_null_particula", () -> new SimpleParticleType(false));
}