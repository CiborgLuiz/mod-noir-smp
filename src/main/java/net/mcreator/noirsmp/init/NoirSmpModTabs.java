/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NoirSmpMod.MODID);
	public static final RegistryObject<CreativeModeTab> NOIR_SMP = REGISTRY.register("noir_smp",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.noir_smp.noir_smp")).icon(() -> new ItemStack(NoirSmpModItems.DADO_FEURAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(NoirSmpModItems.MANOPLA_DE_SLIME.get());
				tabData.accept(NoirSmpModItems.DADO_FEURAL.get());
				tabData.accept(NoirSmpModItems.LAMINA_DO_ARAUTO_PLUMIFERO.get());
			}).withSearchBar().build());
}