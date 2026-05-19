/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.noirsmp.item.*;
import net.mcreator.noirsmp.NoirSmpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
	public static final RegistryObject<Item> EGIDE_PRISMATICA;
	public static final RegistryObject<Item> MEDALHAO_DO_PARASITA;
	public static final RegistryObject<Item> FRAGMENTO_DO_CAOS;
	public static final RegistryObject<Item> CORACAO_CONGELADO;
	public static final RegistryObject<Item> AMULETO_DA_AGILIDADE;
	public static final RegistryObject<Item> SINTETIC_LOG;
	public static final RegistryObject<Item> SINTETIC_WOOD;
	public static final RegistryObject<Item> STRIPPED_SINTETIC_LOG;
	public static final RegistryObject<Item> STRIPPED_SINTETIC_WOOD;
	public static final RegistryObject<Item> SINTETIC_PLANKS;
	public static final RegistryObject<Item> SINTETIC_LEAVES;
	public static final RegistryObject<Item> SINTETIC_STAIRS;
	public static final RegistryObject<Item> SINTETIC_SLAB;
	public static final RegistryObject<Item> SINTETIC_FENCE;
	public static final RegistryObject<Item> SINTETIC_FENCE_GATE;
	public static final RegistryObject<Item> SINTETIC_DOOR;
	public static final RegistryObject<Item> SINTETIC_TRAPDOOR;
	public static final RegistryObject<Item> SINTETIC_PRESSURE_PLATE;
	public static final RegistryObject<Item> SINTETIC_BUTTON;
	public static final RegistryObject<Item> AETHERION;
	public static final RegistryObject<Item> AETHERION_ORE;
	public static final RegistryObject<Item> AETHERION_BLOCK;
	public static final RegistryObject<Item> AETHERION_PICKAXE;
	public static final RegistryObject<Item> AETHERION_AXE;
	public static final RegistryObject<Item> AETHERION_SWORD;
	public static final RegistryObject<Item> AETHERION_SHOVEL;
	public static final RegistryObject<Item> AETHERION_HOE;
	public static final RegistryObject<Item> AETHERION_ARMOR_HELMET;
	public static final RegistryObject<Item> AETHERION_ARMOR_CHESTPLATE;
	public static final RegistryObject<Item> AETHERION_ARMOR_LEGGINGS;
	public static final RegistryObject<Item> AETHERION_ARMOR_BOOTS;
	public static final RegistryObject<Item> DIMENSAO_000_GRAMA;
	public static final RegistryObject<Item> DIMENSAO_000_TERRA;
	public static final RegistryObject<Item> PEDRA_DISTORCIDA;
	public static final RegistryObject<Item> DISTORCED_FLUID_BUCKET;
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
		EGIDE_PRISMATICA = REGISTRY.register("egide_prismatica", EgidePrismaticaItem::new);
		MEDALHAO_DO_PARASITA = REGISTRY.register("medalhao_do_parasita", MedalhaoDoParasitaItem::new);
		FRAGMENTO_DO_CAOS = REGISTRY.register("fragmento_do_caos", FragmentoDoCaosItem::new);
		CORACAO_CONGELADO = REGISTRY.register("coracao_congelado", CoracaoCongeladoItem::new);
		AMULETO_DA_AGILIDADE = REGISTRY.register("amuleto_da_agilidade", AmuletoDaAgilidadeItem::new);
		SINTETIC_LOG = block(NoirSmpModBlocks.SINTETIC_LOG);
		SINTETIC_WOOD = block(NoirSmpModBlocks.SINTETIC_WOOD);
		STRIPPED_SINTETIC_LOG = block(NoirSmpModBlocks.STRIPPED_SINTETIC_LOG);
		STRIPPED_SINTETIC_WOOD = block(NoirSmpModBlocks.STRIPPED_SINTETIC_WOOD);
		SINTETIC_PLANKS = block(NoirSmpModBlocks.SINTETIC_PLANKS);
		SINTETIC_LEAVES = block(NoirSmpModBlocks.SINTETIC_LEAVES);
		SINTETIC_STAIRS = block(NoirSmpModBlocks.SINTETIC_STAIRS);
		SINTETIC_SLAB = block(NoirSmpModBlocks.SINTETIC_SLAB);
		SINTETIC_FENCE = block(NoirSmpModBlocks.SINTETIC_FENCE);
		SINTETIC_FENCE_GATE = block(NoirSmpModBlocks.SINTETIC_FENCE_GATE);
		SINTETIC_DOOR = doubleBlock(NoirSmpModBlocks.SINTETIC_DOOR);
		SINTETIC_TRAPDOOR = block(NoirSmpModBlocks.SINTETIC_TRAPDOOR);
		SINTETIC_PRESSURE_PLATE = block(NoirSmpModBlocks.SINTETIC_PRESSURE_PLATE);
		SINTETIC_BUTTON = block(NoirSmpModBlocks.SINTETIC_BUTTON);
		AETHERION = REGISTRY.register("aetherion", AetherionItem::new);
		AETHERION_ORE = block(NoirSmpModBlocks.AETHERION_ORE);
		AETHERION_BLOCK = block(NoirSmpModBlocks.AETHERION_BLOCK);
		AETHERION_PICKAXE = REGISTRY.register("aetherion_pickaxe", AetherionPickaxeItem::new);
		AETHERION_AXE = REGISTRY.register("aetherion_axe", AetherionAxeItem::new);
		AETHERION_SWORD = REGISTRY.register("aetherion_sword", AetherionSwordItem::new);
		AETHERION_SHOVEL = REGISTRY.register("aetherion_shovel", AetherionShovelItem::new);
		AETHERION_HOE = REGISTRY.register("aetherion_hoe", AetherionHoeItem::new);
		AETHERION_ARMOR_HELMET = REGISTRY.register("aetherion_armor_helmet", AetherionArmorItem.Helmet::new);
		AETHERION_ARMOR_CHESTPLATE = REGISTRY.register("aetherion_armor_chestplate", AetherionArmorItem.Chestplate::new);
		AETHERION_ARMOR_LEGGINGS = REGISTRY.register("aetherion_armor_leggings", AetherionArmorItem.Leggings::new);
		AETHERION_ARMOR_BOOTS = REGISTRY.register("aetherion_armor_boots", AetherionArmorItem.Boots::new);
		DIMENSAO_000_GRAMA = block(NoirSmpModBlocks.DIMENSAO_000_GRAMA);
		DIMENSAO_000_TERRA = block(NoirSmpModBlocks.DIMENSAO_000_TERRA);
		PEDRA_DISTORCIDA = block(NoirSmpModBlocks.PEDRA_DISTORCIDA);
		DISTORCED_FLUID_BUCKET = REGISTRY.register("distorced_fluid_bucket", DistorcedFluidItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), properties));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(EGIDE_PRISMATICA.get(), new ResourceLocation("blocking"), ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
		});
	}
}