package net.mcreator.noirsmp.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.init.NoirSmpModMenus;
import net.mcreator.noirsmp.init.NoirSmpModItems;

public class SlotCentralProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof NoirSmpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == NoirSmpModItems.ESPADA.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof NoirSmpModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == NoirSmpModItems.PEDRA.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof NoirSmpModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == NoirSmpModItems.SLIME_MACE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof NoirSmpModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				ItemStack _setstack7 = new ItemStack(NoirSmpModItems.SLIME_MACE.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(1).set(_setstack7);
				ItemStack _setstack8 = new ItemStack(NoirSmpModItems.ESPADA.get()).copy();
				_setstack8.setCount(1);
				_menu.getSlots().get(2).set(_setstack8);
				ItemStack _setstack9 = new ItemStack(NoirSmpModItems.PEDRA.get()).copy();
				_setstack9.setCount(1);
				_menu.getSlots().get(3).set(_setstack9);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}