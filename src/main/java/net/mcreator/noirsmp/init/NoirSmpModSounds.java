/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NoirSmpMod.MODID);
	public static final RegistryObject<SoundEvent> SININHO = REGISTRY.register("sininho", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("noir_smp", "sininho")));
	public static final RegistryObject<SoundEvent> KOKUSEN = REGISTRY.register("kokusen", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("noir_smp", "kokusen")));
	public static final RegistryObject<SoundEvent> TIJOLOARREMESSO = REGISTRY.register("tijoloarremesso", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("noir_smp", "tijoloarremesso")));
	public static final RegistryObject<SoundEvent> TIJOLOACERTO = REGISTRY.register("tijoloacerto", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("noir_smp", "tijoloacerto")));
}