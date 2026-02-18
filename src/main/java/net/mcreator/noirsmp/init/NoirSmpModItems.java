/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.noirsmp.item.ManoplaDeSlimeItem;
import net.mcreator.noirsmp.item.LaminaDoArautoPlumiferoItem;
import net.mcreator.noirsmp.item.DadoFeuralItem;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NoirSmpMod.MODID);
	public static final RegistryObject<Item> MANOPLA_DE_SLIME;
	public static final RegistryObject<Item> DADO_FEURAL;
	public static final RegistryObject<Item> LAMINA_DO_ARAUTO_PLUMIFERO;
	static {
		MANOPLA_DE_SLIME = REGISTRY.register("manopla_de_slime", ManoplaDeSlimeItem::new);
		DADO_FEURAL = REGISTRY.register("dado_feural", DadoFeuralItem::new);
		LAMINA_DO_ARAUTO_PLUMIFERO = REGISTRY.register("lamina_do_arauto_plumifero", LaminaDoArautoPlumiferoItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}