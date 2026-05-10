package net.mcreator.noirsmp.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class DoppelMaskRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;

		if (entity instanceof Player _player) {
			ItemStack maskInHand = _player.getItemInHand(InteractionHand.MAIN_HAND);

			if (maskInHand.getItem() == NoirSmpModItems.DOPPEL_MASK.get() && !_player.getCooldowns().isOnCooldown(maskInHand.getItem())) {
				ItemStack currentHelmet = _player.getItemBySlot(EquipmentSlot.HEAD);

				if (!currentHelmet.isEmpty()) {
					if (!_player.getInventory().add(currentHelmet)) {
						_player.drop(currentHelmet, false);
					}
				}

				_player.setItemSlot(EquipmentSlot.HEAD, maskInHand.copy());
				
				if (maskInHand.getCount() > 1) {
					maskInHand.shrink(1);
				} else {
					_player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
				}
				
			}
		}
	}
}