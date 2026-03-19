package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.init.NoirSmpModMenus;

public class Slot2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof NoirSmpModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(0).remove(1);
			_menu.getSlots().get(1).remove(1);
			_menu.getSlots().get(3).remove(1);
			_player.containerMenu.broadcastChanges();
		}
	}
}