package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.List;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletableFuture;

public class UmbraveuEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;

		// No 1.20.1, entity.level() já retorna um Level, então simplificamos aqui:
		Level world = entity.level();
		
		if (world == null)
			return;

		// --- SISTEMA DE COOLDOWN (0.5 Segundos / 10 Ticks) ---
		if (entity.getPersistentData().getDouble("umbraveu_cooldown") > world.getGameTime()) {
			return;
		}
		entity.getPersistentData().putDouble("umbraveu_cooldown", (world.getGameTime() + 10));

		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Vec3 look = entity.getLookAngle();
		double stepPerTick = 0.6;
		double spawnY = y + entity.getEyeHeight() * 0.75;

		if (world instanceof ServerLevel _level) {
			// --- MATEMÁTICA DE ROTAÇÃO (BYPASS GIMBAL LOCK) ---
			double lx = Math.max(-1.0, Math.min(1.0, look.x));
			double ly = look.y;
			double lz = look.z;

			double yawRad = Math.asin(lx);
			double pitchRad = Math.atan2(-ly, lz);
			double rollRad = Math.atan2(-Math.sin(pitchRad) * Math.sin(yawRad), Math.cos(pitchRad));

			float finalPitch = (float) Math.toDegrees(pitchRad);
			float finalYaw = (float) Math.toDegrees(yawRad);
			float finalRoll = (float) Math.toDegrees(rollRad);

			String command = "photon fx photon:slash block ~ ~1.2 ~ 0 0 0 " + finalPitch + " " + finalYaw + " " + finalRoll + " 1 1 1 0 false true";

			_level.getServer().getCommands().performPrefixedCommand(
					entity.createCommandSourceStack().withPermission(4).withSuppressedOutput(), command);
		}

		// --- SISTEMA DE DANO (2.0f = 1 Coração) ---
		for (int i = 0; i < 20; i++) {
			final int tick = i;
			CompletableFuture.delayedExecutor(tick * 50, TimeUnit.MILLISECONDS).execute(() -> {
				if (world instanceof ServerLevel _serverLevel) {
					_serverLevel.getServer().execute(() -> {
						double currentX = x + (look.x * stepPerTick * tick);
						double currentY = spawnY + (look.y * stepPerTick * tick);
						double currentZ = z + (look.z * stepPerTick * tick);

						final Vec3 _center = new Vec3(currentX, currentY, currentZ);
						List<Entity> _entfound = _serverLevel.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.6), e -> true).stream()
								.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();

						for (Entity entityiterator : _entfound) {
							if (entityiterator != entity && entityiterator instanceof LivingEntity _livEnt) {
								if (entity instanceof Player _player) {
									_livEnt.hurt(_livEnt.damageSources().playerAttack(_player), 1.5f);
								} else {
									_livEnt.hurt(_livEnt.damageSources().mobAttack((LivingEntity) entity), 1.5f);
								}
								_livEnt.invulnerableTime = 10;
							}
						}
					});
				}
			});
		}
	}
}