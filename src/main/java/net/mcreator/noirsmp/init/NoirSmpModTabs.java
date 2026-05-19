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
				tabData.accept(NoirSmpModItems.DADO_FEURAL.get());
				tabData.accept(NoirSmpModItems.MANOPLA_DE_SLIME.get());
				tabData.accept(NoirSmpModItems.MANOPLA_DA_CALAMIDADE.get());
				tabData.accept(NoirSmpModItems.LAMINA_DO_ARAUTO_PLUMIFERO.get());
				tabData.accept(NoirSmpModItems.LEVIATAN.get());
				tabData.accept(NoirSmpModItems.AGULHA_DOS_PESADELOS_PROFUNDOS.get());
				tabData.accept(NoirSmpModItems.ESPADA.get());
				tabData.accept(NoirSmpModItems.PEDRA.get());
				tabData.accept(NoirSmpModItems.SLIME_MACE.get());
				tabData.accept(NoirSmpModItems.DOPPEL_MASK.get());
				tabData.accept(NoirSmpModItems.PASSOS_ETERIOS_BOOTS.get());
				tabData.accept(NoirSmpModItems.MARRETA_GRAVITACIONAL.get());
				tabData.accept(NoirSmpModItems.ARMA_DE_BURACO_NEGRO.get());
				tabData.accept(NoirSmpModItems.UMBRAVEU.get());
				tabData.accept(NoirSmpModItems.SINGULARIS_ITEM.get());
				tabData.accept(NoirSmpModItems.EGIDE_PRISMATICA.get());
				tabData.accept(NoirSmpModItems.NINJATO.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_SPEED.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_REGEN.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_STRENGTH.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_SLOW_FALLING.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_NIGHT_VISION.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_JUMP_BOOST.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_INVISIBILITY.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_RESISTENCE.get());
				tabData.accept(NoirSmpModItems.SINO_DE_MARFIM_AQUATIC_RESPIRATION.get());
				tabData.accept(NoirSmpModItems.ESPETO.get());
				tabData.accept(NoirSmpModItems.BENGALA.get());
				tabData.accept(NoirSmpModItems.MARRETA.get());
				tabData.accept(NoirSmpModItems.CANO_DE_METAL.get());
				tabData.accept(NoirSmpModItems.ROLO.get());
				tabData.accept(NoirSmpModItems.TACO_COM_ARAME.get());
				tabData.accept(NoirSmpModItems.RIPA.get());
				tabData.accept(NoirSmpModItems.MOLOTOV.get());
				tabData.accept(NoirSmpModItems.TIJOLO.get());
				tabData.accept(NoirSmpModItems.MEDALHAO_DO_PARASITA.get());
				tabData.accept(NoirSmpModItems.FRAGMENTO_DO_CAOS.get());
				tabData.accept(NoirSmpModItems.AMULETO_DA_AGILIDADE.get());
				tabData.accept(NoirSmpModItems.CORACAO_CONGELADO.get());
				tabData.accept(NoirSmpModItems.AETHERION.get());
				tabData.accept(NoirSmpModBlocks.AETHERION_ORE.get().asItem());
				tabData.accept(NoirSmpModBlocks.AETHERION_BLOCK.get().asItem());
				tabData.accept(NoirSmpModItems.AETHERION_PICKAXE.get());
				tabData.accept(NoirSmpModItems.AETHERION_AXE.get());
				tabData.accept(NoirSmpModItems.AETHERION_SWORD.get());
				tabData.accept(NoirSmpModItems.AETHERION_SHOVEL.get());
				tabData.accept(NoirSmpModItems.AETHERION_HOE.get());
				tabData.accept(NoirSmpModItems.AETHERION_ARMOR_HELMET.get());
				tabData.accept(NoirSmpModItems.AETHERION_ARMOR_CHESTPLATE.get());
				tabData.accept(NoirSmpModItems.AETHERION_ARMOR_LEGGINGS.get());
				tabData.accept(NoirSmpModItems.AETHERION_ARMOR_BOOTS.get());
				tabData.accept(NoirSmpModBlocks.SINTETIC_LOG.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_WOOD.get().asItem());
				tabData.accept(NoirSmpModBlocks.STRIPPED_SINTETIC_LOG.get().asItem());
				tabData.accept(NoirSmpModBlocks.STRIPPED_SINTETIC_WOOD.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_PLANKS.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_LEAVES.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_STAIRS.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_SLAB.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_FENCE.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_FENCE_GATE.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_DOOR.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_TRAPDOOR.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_PRESSURE_PLATE.get().asItem());
				tabData.accept(NoirSmpModBlocks.SINTETIC_BUTTON.get().asItem());
				tabData.accept(NoirSmpModBlocks.DIMENSAO_000_GRAMA.get().asItem());
				tabData.accept(NoirSmpModBlocks.DIMENSAO_000_TERRA.get().asItem());
				tabData.accept(NoirSmpModBlocks.PEDRA_DISTORCIDA.get().asItem());
				tabData.accept(NoirSmpModItems.DISTORCED_FLUID_BUCKET.get());
			}).withSearchBar().build());
}