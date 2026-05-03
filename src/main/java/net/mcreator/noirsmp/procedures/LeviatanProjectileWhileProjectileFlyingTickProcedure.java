package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;

import net.mcreator.noirsmp.init.NoirSmpModItems;

import java.util.UUID;

public class LeviatanProjectileWhileProjectileFlyingTickProcedure {

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (!(world instanceof ServerLevel level) || entity == null)
			return;

		Entity owner = getOwner(level, entity);
		if (owner == null)
			return;

		if (owner instanceof Player player && player.isShiftKeyDown()) {
			endHook(entity, owner);
			return;
		}

		handleChainSound(level, entity);

		if (!entity.getPersistentData().getBoolean("hooked")) {

			if (entity.horizontalCollision || entity.verticalCollision) {

				entity.getPersistentData().putBoolean("hooked", true);
				entity.getPersistentData().putString("hook_type", "block");

				entity.setDeltaMovement(Vec3.ZERO);

				triggerImpact(entity, owner);
			}

			for (Entity target : level.getEntities(entity, entity.getBoundingBox().inflate(0.6))) {

				if (target == owner || !target.isAlive())
					continue;

				entity.getPersistentData().putBoolean("hooked", true);
				entity.getPersistentData().putString("hook_type", "entity");
				entity.getPersistentData().putString("target_uuid", target.getStringUUID());

				target.setDeltaMovement(Vec3.ZERO);
				target.fallDistance = 0;

				triggerImpact(entity, owner);
				break;
			}
		}

		if (!entity.getPersistentData().getBoolean("hooked")) {
			renderChain(level,
				owner.position().add(0, owner.getEyeHeight(), 0),
				entity.position(),
				entity.tickCount
			);
			return;
		}

		String type = entity.getPersistentData().getString("hook_type");

		if ("block".equals(type)) {

			Vec3 anchor = entity.position();
			Vec3 playerPos = owner.position();

			Vec3 dir = anchor.subtract(playerPos).normalize();

			owner.setDeltaMovement(
				owner.getDeltaMovement().scale(0.85).add(dir.scale(0.4))
			);

			owner.hasImpulse = true;
			owner.hurtMarked = true;

			renderChain(level,
				playerPos.add(0, owner.getEyeHeight(), 0),
				anchor,
				entity.tickCount
			);

			if (playerPos.distanceTo(anchor) < 2.0) {
				endHook(entity, owner);
			}
		}

		if ("entity".equals(type)) {

			try {
				String tuid = entity.getPersistentData().getString("target_uuid");

				if (tuid.isEmpty())
					return;

				Entity target = level.getEntity(UUID.fromString(tuid));

				if (target == null || !target.isAlive()) {
					endHook(entity, owner);
					return;
				}

				entity.setDeltaMovement(Vec3.ZERO);
				entity.setPos(
					target.getX(),
					target.getY() + target.getBbHeight() * 0.5,
					target.getZ()
				);

				Vec3 ownerPos = owner.position().add(0, owner.getEyeHeight(), 0);
				Vec3 targetPos = target.position().add(0, target.getEyeHeight(), 0);

				Vec3 dir = ownerPos.subtract(targetPos).normalize();

				target.setDeltaMovement(dir.scale(0.6));

				target.fallDistance = 0;
				target.hasImpulse = true;
				target.hurtMarked = true;

				renderChain(level, ownerPos, targetPos, entity.tickCount);

				if (target.distanceTo(owner) < 2.2) {
					endHook(entity, owner);
				}

			} catch (Exception ignored) {}
		}
	}

	private static void triggerImpact(Entity hook, Entity owner) {

		hook.getPersistentData().putBoolean("impact", true);
		hook.getPersistentData().putInt("impact_tick", hook.tickCount);

		owner.getPersistentData().putBoolean("leviatan_impact", true);
		owner.getPersistentData().putInt("leviatan_impact_tick", owner.tickCount);

		owner.setDeltaMovement(owner.getDeltaMovement().scale(0.3));
	}

	private static void renderChain(ServerLevel level, Vec3 start, Vec3 end, int tick) {

		Vec3 diff = end.subtract(start);
		double distance = diff.length();
		Vec3 dir = diff.normalize();

		for (double i = 0; i < distance; i += 0.25) {

			Vec3 pos = start.add(dir.scale(i));

			double wave = Math.sin((tick + i) * 0.4) * 0.05;

			level.sendParticles(ParticleTypes.CRIT,
				pos.x,
				pos.y,
				pos.z,
				1, 0, 0, 0, 0);

			if (((int) (i * 10)) % 3 == 0) {
				level.sendParticles(ParticleTypes.ENCHANT,
					pos.x + wave,
					pos.y,
					pos.z + wave,
					1, 0, 0, 0, 0);
			}

			if (((int) (i * 10)) % 5 == 0) {
				level.sendParticles(ParticleTypes.SMOKE,
					pos.x,
					pos.y - 0.05,
					pos.z,
					1, 0, 0, 0, 0);
			}
		}
	}

	private static void handleChainSound(ServerLevel level, Entity entity) {

		if (!entity.getPersistentData().contains("sound_tick"))
			entity.getPersistentData().putInt("sound_tick", 0);

		int last = entity.getPersistentData().getInt("sound_tick");

		if (entity.tickCount - last > 40) {

			entity.getPersistentData().putInt("sound_tick", entity.tickCount);

			level.playSound(
				null,
				entity.getX(),
				entity.getY(),
				entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noir_smp:correntes")),
				SoundSource.PLAYERS,
				0.7f,
				0.9f + (entity.tickCount % 10) * 0.02f
			);
		}
	}

	private static void endHook(Entity hook, Entity owner) {
		hook.discard();
		resetCooldown(owner);
	}

	private static Entity getOwner(ServerLevel level, Entity entity) {
		try {
			String uuid = entity.getPersistentData().getString("owner_uuid");
			if (!uuid.isEmpty())
				return level.getEntity(UUID.fromString(uuid));
		} catch (Exception ignored) {}

		if (entity instanceof Projectile proj) {
			Entity owner = proj.getOwner();
			if (owner != null)
				entity.getPersistentData().putString("owner_uuid", owner.getStringUUID());
			return owner;
		}
		return null;
	}

	private static void resetCooldown(Entity entity) {
		if (entity instanceof Player player) {
			player.getCooldowns().removeCooldown(NoirSmpModItems.LEVIATAN.get());
		}
	}
}