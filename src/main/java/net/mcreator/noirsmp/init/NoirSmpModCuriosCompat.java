package net.mcreator.noirsmp.init;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.noirsmp.procedures.CoracaoCongeladoCuriosWhileBaubleIsEquippedTickProcedure;
import net.mcreator.noirsmp.procedures.AmuletoDaAgilidadeCuriosBaubleIsUnequippedProcedure;
import net.mcreator.noirsmp.procedures.AmuletoDaAgilidadeCuriosBaubleIsEquippedProcedure;

public class NoirSmpModCuriosCompat {
	public static void registerCurios(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CuriosApi.registerCurio(NoirSmpModItems.MEDALHAO_DO_PARASITA.get(), new ICurioItem() {
			});
			CuriosApi.registerCurio(NoirSmpModItems.FRAGMENTO_DO_CAOS.get(), new ICurioItem() {
			});
			CuriosApi.registerCurio(NoirSmpModItems.CORACAO_CONGELADO.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					CoracaoCongeladoCuriosWhileBaubleIsEquippedTickProcedure.execute();
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.AMULETO_DA_AGILIDADE.get(), new ICurioItem() {
				@Override
				public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
					AmuletoDaAgilidadeCuriosBaubleIsEquippedProcedure.execute(slotContext.entity());
				}

				@Override
				public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
					AmuletoDaAgilidadeCuriosBaubleIsUnequippedProcedure.execute(slotContext.entity());
				}
			});
		});
	}
}