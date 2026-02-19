/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.noirsmp.item.*;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NoirSmpMod.MODID);
	public static final RegistryObject<Item> MANOPLA_DE_SLIME;
	public static final RegistryObject<Item> DADO_FEURAL;
	public static final RegistryObject<Item> LAMINA_DO_ARAUTO_PLUMIFERO;
	public static final RegistryObject<Item> SINO_DE_MARFIM_SPEED;
	public static final RegistryObject<Item> SINO_DE_MARFIM_REGEN;
	public static final RegistryObject<Item> SINO_DE_MARFIM_STRENGTH;
	public static final RegistryObject<Item> SINO_DE_MARFIM_SLOW_FALLING;
	public static final RegistryObject<Item> SINO_DE_MARFIM_NIGHT_VISION;
	public static final RegistryObject<Item> SINO_DE_MARFIM_JUMP_BOOST;
	public static final RegistryObject<Item> SINO_DE_MARFIM_INVISIBILITY;
	public static final RegistryObject<Item> SINO_DE_MARFIM_RESISTENCE;
	public static final RegistryObject<Item> SINO_DE_MARFIM_AQUATIC_RESPIRATION;
	public static final RegistryObject<Item> MANOPLA_DA_CALAMIDADE;
	public static final RegistryObject<Item> PASSOS_ETERIOS_BOOTS;
	public static final RegistryObject<Item> TIJOLO;
	public static final RegistryObject<Item> ESPADA;
	public static final RegistryObject<Item> LEVIATAN;
	static {
		MANOPLA_DE_SLIME = REGISTRY.register("manopla_de_slime", ManoplaDeSlimeItem::new);
		DADO_FEURAL = REGISTRY.register("dado_feural", DadoFeuralItem::new);
		LAMINA_DO_ARAUTO_PLUMIFERO = REGISTRY.register("lamina_do_arauto_plumifero", LaminaDoArautoPlumiferoItem::new);
		SINO_DE_MARFIM_SPEED = REGISTRY.register("sino_de_marfim_speed", SinoDeMarfimSpeedItem::new);
		SINO_DE_MARFIM_REGEN = REGISTRY.register("sino_de_marfim_regen", SinoDeMarfimRegenItem::new);
		SINO_DE_MARFIM_STRENGTH = REGISTRY.register("sino_de_marfim_strength", SinoDeMarfimStrengthItem::new);
		SINO_DE_MARFIM_SLOW_FALLING = REGISTRY.register("sino_de_marfim_slow_falling", SinoDeMarfimSlowFallingItem::new);
		SINO_DE_MARFIM_NIGHT_VISION = REGISTRY.register("sino_de_marfim_night_vision", SinoDeMarfimNightVisionItem::new);
		SINO_DE_MARFIM_JUMP_BOOST = REGISTRY.register("sino_de_marfim_jump_boost", SinoDeMarfimJumpBoostItem::new);
		SINO_DE_MARFIM_INVISIBILITY = REGISTRY.register("sino_de_marfim_invisibility", SinoDeMarfimInvisibilityItem::new);
		SINO_DE_MARFIM_RESISTENCE = REGISTRY.register("sino_de_marfim_resistence", SinoDeMarfimResistenceItem::new);
		SINO_DE_MARFIM_AQUATIC_RESPIRATION = REGISTRY.register("sino_de_marfim_aquatic_respiration", SinoDeMarfimAquaticRespirationItem::new);
		MANOPLA_DA_CALAMIDADE = REGISTRY.register("manopla_da_calamidade", ManoplaDaCalamidadeItem::new);
		PASSOS_ETERIOS_BOOTS = REGISTRY.register("passos_eterios_boots", PassosEteriosItem.Boots::new);
		TIJOLO = REGISTRY.register("tijolo", TIJOLOItem::new);
		ESPADA = REGISTRY.register("espada", ESPADAItem::new);
		LEVIATAN = REGISTRY.register("leviatan", LeviatanItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}