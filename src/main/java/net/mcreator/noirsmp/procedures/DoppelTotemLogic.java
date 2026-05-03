package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.entity.DoppelEntity;

import java.util.List;

@Mod.EventBusSubscriber
public class DoppelTotemLogic {
	@SubscribeEvent
	public static void onEntityHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			// Se o dano for matar o player
			if (player.getHealth() <= event.getAmount()) {
				if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == NoirSmpModItems.DOPPEL_MASK.get()) {
					Level level = player.level();
					// Procura o Doppel do player num raio de 100 blocos
					List<? extends DoppelEntity> doppels = level.getEntitiesOfClass(DoppelEntity.class, player.getBoundingBox().inflate(100), e -> e.getOwner() == player);
					
					if (!doppels.isEmpty()) {
						DoppelEntity doppel = doppels.get(0);
						event.setCanceled(true); // Cancela a morte

						// Efeito de Totem
						player.setHealth(2.0F);
						player.removeAllEffects();
						player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
						player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
						player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
						
						// Troca de Posição
						Vec3 pPos = player.position();
						Vec3 dPos = doppel.position();
						player.teleportTo(dPos.x, dPos.y, dPos.z);
						doppel.teleportTo(pPos.x, pPos.y, pPos.z);

						// Cooldown e Morte do Doppel
						player.getCooldowns().addCooldown(NoirSmpModItems.DOPPEL_MASK.get(), 1200);
						doppel.kill();
						
						// Visual de Totem
						level.broadcastEntityEvent(player, (byte) 35);
					}
				}
			}
		}
	}
}