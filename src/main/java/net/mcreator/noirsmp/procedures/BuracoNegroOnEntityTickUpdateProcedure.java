package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.noirsmp.init.NoirSmpModMobEffects;

import java.util.Comparator;

public class BuracoNegroOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sphereRadius = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double sqaureDistance = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		particleAmount = 100;
		particleRadius = 6;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, (x + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
					(z + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (int) particleAmount, particleRadius, particleRadius, particleRadius, 1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(NoirSmpModMobEffects.ESPAGETIFICACAO.get(), 60, 1));
		if (!world.isClientSide()) {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("vx")), (entity.getPersistentData().getDouble("vy")), (entity.getPersistentData().getDouble("vz"))));
			BuraconegroblocosProcedure.execute(world, x, y, z);
		} else {
			sphereRadius = 35;
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((sphereRadius * 2) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.toList()) {
					if (!(getEntityGameType(entityiterator) == GameType.SPECTATOR) && !(getEntityGameType(entityiterator) == GameType.CREATIVE)) {
						dx = entity.getX() - entityiterator.getX();
						dy = entity.getY() - entityiterator.getY();
						dz = entity.getZ() - entityiterator.getZ();
						if (dx <= sphereRadius * 2 || dy <= sphereRadius * 2 || dz <= sphereRadius * 2) {
							entityiterator.setDeltaMovement(new Vec3((dx / 10), (dy / 10), (dz / 10)));
						}
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}