/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.noirsmp.block.*;
import net.mcreator.noirsmp.NoirSmpMod;

public class NoirSmpModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NoirSmpMod.MODID);
	public static final RegistryObject<Block> PROJETO_ZERO_PORTAL;
	public static final RegistryObject<Block> SINTETIC_LOG;
	public static final RegistryObject<Block> SINTETIC_WOOD;
	public static final RegistryObject<Block> STRIPPED_SINTETIC_LOG;
	public static final RegistryObject<Block> STRIPPED_SINTETIC_WOOD;
	public static final RegistryObject<Block> SINTETIC_PLANKS;
	public static final RegistryObject<Block> SINTETIC_LEAVES;
	public static final RegistryObject<Block> SINTETIC_STAIRS;
	public static final RegistryObject<Block> SINTETIC_SLAB;
	public static final RegistryObject<Block> SINTETIC_FENCE;
	public static final RegistryObject<Block> SINTETIC_FENCE_GATE;
	public static final RegistryObject<Block> SINTETIC_DOOR;
	public static final RegistryObject<Block> SINTETIC_TRAPDOOR;
	public static final RegistryObject<Block> SINTETIC_PRESSURE_PLATE;
	public static final RegistryObject<Block> SINTETIC_BUTTON;
	public static final RegistryObject<Block> AETHERION_ORE;
	public static final RegistryObject<Block> AETHERION_BLOCK;
	public static final RegistryObject<Block> DIMENSAO_000_GRAMA;
	public static final RegistryObject<Block> DIMENSAO_000_TERRA;
	public static final RegistryObject<Block> PEDRA_DISTORCIDA;
	public static final RegistryObject<Block> DISTORCED_FLUID;
	static {
		PROJETO_ZERO_PORTAL = REGISTRY.register("projeto_zero_portal", ProjetoZeroPortalBlock::new);
		SINTETIC_LOG = REGISTRY.register("sintetic_log", SinteticLogBlock::new);
		SINTETIC_WOOD = REGISTRY.register("sintetic_wood", SinteticWoodBlock::new);
		STRIPPED_SINTETIC_LOG = REGISTRY.register("stripped_sintetic_log", StrippedSinteticLogBlock::new);
		STRIPPED_SINTETIC_WOOD = REGISTRY.register("stripped_sintetic_wood", StrippedSinteticWoodBlock::new);
		SINTETIC_PLANKS = REGISTRY.register("sintetic_planks", SinteticPlanksBlock::new);
		SINTETIC_LEAVES = REGISTRY.register("sintetic_leaves", SinteticLeavesBlock::new);
		SINTETIC_STAIRS = REGISTRY.register("sintetic_stairs", SinteticStairsBlock::new);
		SINTETIC_SLAB = REGISTRY.register("sintetic_slab", SinteticSlabBlock::new);
		SINTETIC_FENCE = REGISTRY.register("sintetic_fence", SinteticFenceBlock::new);
		SINTETIC_FENCE_GATE = REGISTRY.register("sintetic_fence_gate", SinteticFenceGateBlock::new);
		SINTETIC_DOOR = REGISTRY.register("sintetic_door", SinteticDoorBlock::new);
		SINTETIC_TRAPDOOR = REGISTRY.register("sintetic_trapdoor", SinteticTrapdoorBlock::new);
		SINTETIC_PRESSURE_PLATE = REGISTRY.register("sintetic_pressure_plate", SinteticPressurePlateBlock::new);
		SINTETIC_BUTTON = REGISTRY.register("sintetic_button", SinteticButtonBlock::new);
		AETHERION_ORE = REGISTRY.register("aetherion_ore", AetherionOreBlock::new);
		AETHERION_BLOCK = REGISTRY.register("aetherion_block", AetherionBlockBlock::new);
		DIMENSAO_000_GRAMA = REGISTRY.register("dimensao_000_grama", Dimensao000GramaBlock::new);
		DIMENSAO_000_TERRA = REGISTRY.register("dimensao_000_terra", Dimensao000TerraBlock::new);
		PEDRA_DISTORCIDA = REGISTRY.register("pedra_distorcida", PedraDistorcidaBlock::new);
		DISTORCED_FLUID = REGISTRY.register("distorced_fluid", DistorcedFluidBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}