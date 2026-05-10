package net.mcreator.noirsmp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.entity.DoppelEntity;

import java.util.List;

@Mod.EventBusSubscriber
public class DoppelEvents {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()) {
			Player player = event.player;
			
			if (player.tickCount % 20 == 0) {
				if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == NoirSmpModItems.DOPPEL_MASK.get()) {
					if (!player.getCooldowns().isOnCooldown(NoirSmpModItems.DOPPEL_MASK.get())) {
						Level level = player.level();
						List<DoppelEntity> doppels = level.getEntitiesOfClass(DoppelEntity.class, 
							player.getBoundingBox().inflate(64.0D), e -> e.getOwner() == player);

						if (doppels.isEmpty() && level instanceof ServerLevel _level) {
							BlockPos spawnPos = BlockPos.containing(player.getX(), player.getY(), player.getZ());
							DoppelEntity entityToSpawn = (DoppelEntity) NoirSmpModEntities.DOPPEL.get().spawn(_level, spawnPos, MobSpawnType.MOB_SUMMONED);
							
							if (entityToSpawn != null) {
								entityToSpawn.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
								entityToSpawn.setOwnerUUID(player.getUUID());
								entityToSpawn.setTame(true);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerTakeFatalDamage(LivingHurtEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			if (player.getHealth() <= event.getAmount()) {
				if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == NoirSmpModItems.DOPPEL_MASK.get()) {
					Level level = player.level();
					List<DoppelEntity> doppels = level.getEntitiesOfClass(DoppelEntity.class, 
						player.getBoundingBox().inflate(100), e -> e.getOwner() == player);

					if (!doppels.isEmpty()) {
						DoppelEntity doppel = doppels.get(0);
						event.setCanceled(true);
						
						player.setHealth(1.0F);
						Vec3 pPos = player.position();
						Vec3 dPos = doppel.position();
						player.teleportTo(dPos.x, dPos.y, dPos.z);
						doppel.setPos(pPos.x, pPos.y, pPos.z);

						player.getCooldowns().addCooldown(NoirSmpModItems.DOPPEL_MASK.get(), 1200);
						doppel.kill();
						level.broadcastEntityEvent(player, (byte) 35);
					}
				}
			}
		}
	}
}