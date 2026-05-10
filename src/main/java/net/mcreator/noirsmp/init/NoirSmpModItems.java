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
	public static final RegistryObject<Item> LEVIATAN;
	public static final RegistryObject<Item> DOPPEL_MASK;
	public static final RegistryObject<Item> AGULHA_DOS_PESADELOS_PROFUNDOS;
	public static final RegistryObject<Item> BENGALA;
	public static final RegistryObject<Item> CANO_DE_METAL;
	public static final RegistryObject<Item> ESPETO;
	public static final RegistryObject<Item> MARRETA;
	public static final RegistryObject<Item> NINJATO;
	public static final RegistryObject<Item> ESPADA;
	public static final RegistryObject<Item> PEDRA;
	public static final RegistryObject<Item> SLIME_MACE;
	public static final RegistryObject<Item> RIPA;
	public static final RegistryObject<Item> ROLO;
	public static final RegistryObject<Item> TACO_COM_ARAME;
	public static final RegistryObject<Item> MOLOTOV;
	public static final RegistryObject<Item> TIJOLO;
	public static final RegistryObject<Item> MARRETA_GRAVITACIONAL;
	public static final RegistryObject<Item> ARMA_DE_BURACO_NEGRO;
	public static final RegistryObject<Item> UMBRAVEU;
	public static final RegistryObject<Item> SINGULARIS_ITEM;
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
		LEVIATAN = REGISTRY.register("leviatan", LeviatanItem::new);
		DOPPEL_MASK = REGISTRY.register("doppel_mask", DoppelMaskItem::new);
		AGULHA_DOS_PESADELOS_PROFUNDOS = REGISTRY.register("agulha_dos_pesadelos_profundos", AgulhaDosPesadelosProfundosItem::new);
		BENGALA = REGISTRY.register("bengala", BengalaItem::new);
		CANO_DE_METAL = REGISTRY.register("cano_de_metal", CanoDeMetalItem::new);
		ESPETO = REGISTRY.register("espeto", EspetoItem::new);
		MARRETA = REGISTRY.register("marreta", MarretaItem::new);
		NINJATO = REGISTRY.register("ninjato", NinjatoItem::new);
		ESPADA = REGISTRY.register("espada", ESPADAItem::new);
		PEDRA = REGISTRY.register("pedra", PEDRAItem::new);
		SLIME_MACE = REGISTRY.register("slime_mace", SlimeMaceItem::new);
		RIPA = REGISTRY.register("ripa", RipaItem::new);
		ROLO = REGISTRY.register("rolo", RoloItem::new);
		TACO_COM_ARAME = REGISTRY.register("taco_com_arame", TacoComArameItem::new);
		MOLOTOV = REGISTRY.register("molotov", MolotovItem::new);
		TIJOLO = REGISTRY.register("tijolo", TijoloItem::new);
		MARRETA_GRAVITACIONAL = REGISTRY.register("marreta_gravitacional", MarretaGravitacionalItem::new);
		ARMA_DE_BURACO_NEGRO = REGISTRY.register("arma_de_buraco_negro", ArmaDeBuracoNegroItem::new);
		UMBRAVEU = REGISTRY.register("umbraveu", UmbraveuItem::new);
		SINGULARIS_ITEM = REGISTRY.register("singularis_item", SingularisItemItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}