/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.noirsmp.potion.SangramentoMobEffect;
import net.mcreator.noirsmp.potion.EspagetificacaoMobEffect;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NoirSmpMod.MODID);
	public static final RegistryObject<MobEffect> SANGRAMENTO = REGISTRY.register("sangramento", () -> new SangramentoMobEffect());
	public static final RegistryObject<MobEffect> ESPAGETIFICACAO = REGISTRY.register("espagetificacao", () -> new EspagetificacaoMobEffect());
}