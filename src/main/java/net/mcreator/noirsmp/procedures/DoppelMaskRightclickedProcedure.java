package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.entity.DoppelEntity;

public class DoppelMaskRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (entity instanceof Player _player) {
			ItemStack maskInHand = _player.getItemInHand(InteractionHand.MAIN_HAND);

			// Verifica se o item clicado é a máscara e se não está em cooldown
			if (maskInHand.getItem() == NoirSmpModItems.DOPPEL_MASK.get() && !_player.getCooldowns().isOnCooldown(maskInHand.getItem())) {
				
				ItemStack currentHelmet = _player.getItemBySlot(EquipmentSlot.HEAD);

				// Lógica para salvar o capacete atual (evita deletar o item)
				if (!currentHelmet.isEmpty()) {
					if (!_player.getInventory().add(currentHelmet)) {
						_player.drop(currentHelmet, false);
					}
				}

				// Equipa a máscara na cabeça
				_player.setItemSlot(EquipmentSlot.HEAD, maskInHand.copy());
				
				// Remove o item da mão
				if (maskInHand.getCount() > 1) {
					maskInHand.shrink(1);
				} else {
					_player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
				}

				// Invoca o Doppel no lado do servidor
				if (world instanceof ServerLevel _level) {
					// Criamos o BlockPos a partir das coordenadas x, y, z
					BlockPos spawnPos = BlockPos.containing(x, y, z);
					Entity entityToSpawn = NoirSmpModEntities.DOPPEL.get().spawn(_level, spawnPos, MobSpawnType.MOB_SUMMONED);
					
					if (entityToSpawn instanceof DoppelEntity _doppel) {
						_doppel.moveTo(x, y, z, entity.getYRot(), entity.getXRot());
						// Define o UUID do dono para sincronizar skin e comportamento
						_doppel.setOwnerUUID(_player.getUUID());
						_doppel.setTame(true);
					}
				}
			}
		}
	}
}