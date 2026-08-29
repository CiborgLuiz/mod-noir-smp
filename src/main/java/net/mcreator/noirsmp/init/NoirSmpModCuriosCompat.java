package net.mcreator.noirsmp.init;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.noirsmp.procedures.*;

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
			CuriosApi.registerCurio(NoirSmpModItems.ANEL_DO_TITA.get(), new ICurioItem() {
				@Override
				public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
					AnelDoTitaCuriosBaubleIsEquippedProcedure.execute(slotContext.entity());
				}

				@Override
				public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
					AnelDoTitaCuriosBaubleIsUnequippedProcedure.execute(slotContext.entity());
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.EMBLEMA_DO_GUERREIRO.get(), new ICurioItem() {
				@Override
				public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
					EmblemaDoGuerreiroCuriosBaubleIsEquippedProcedure.execute(slotContext.entity());
				}

				@Override
				public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
					EmblemaDoGuerreiroCuriosBaubleIsUnequippedProcedure.execute(slotContext.entity());
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.FRAGMENTO_PRISMATICO.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					FragmentoPrismaticoCuriosWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity());
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.SELO_DO_MARTIR.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					SeloDoMartirCuriosWhileBaubleIsEquippedTickProcedure.execute();
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.RELOGIO_DA_VIOLENCIA.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					RelogioDaViolenciaCuriosWhileBaubleIsEquippedTickProcedure.execute();
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.OLHO_DO_EXECUTOR.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					OlhoDoExecutorCuriosWhileBaubleIsEquippedTickProcedure.execute();
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.MARCA_DO_CARNICEIRO.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					MarcaDoCarniceiroCuriosWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity());
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.TOTEM_DA_CACADA.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					TotemDaCacadaCuriosWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ());
				}
			});
			CuriosApi.registerCurio(NoirSmpModItems.MASCARA_DA_RAPOSA.get(), new ICurioItem() {
				@Override
				public void curioTick(SlotContext slotContext, ItemStack stack) {
					MascaraDaRaposaCuriosWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity());
				}
			});
		});
	}
}