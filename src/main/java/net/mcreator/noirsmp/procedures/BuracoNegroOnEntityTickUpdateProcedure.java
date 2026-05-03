package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.noirsmp.init.NoirSmpModMobEffects;

import java.util.List;

public class BuracoNegroOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity buracoNegro) {
		if (buracoNegro == null || world.isClientSide())
			return;

		double tick = buracoNegro.getPersistentData().getDouble("tick");
		double vida = buracoNegro.getPersistentData().getDouble("vida");

		if (vida == 0) {
			vida = 1012;
		}

		tick++;

		if (tick >= 20) {
			tick = 0;
			vida -= 1;

			buracoNegro.getPersistentData().putDouble("vida", vida);

			if (vida <= 0) {
				explodir(world, x, y, z, buracoNegro);
				return;
			}
		}

		buracoNegro.getPersistentData().putDouble("tick", tick);

		double raio = 55;

		Vec3 centro = new Vec3(x, y, z);

		List<Entity> entidades = world.getEntitiesOfClass(Entity.class,
				new AABB(x, y, z, x, y, z).inflate(raio),
				e -> e != buracoNegro);

		for (Entity alvo : entidades) {

			if (alvo instanceof Player p && (p.isCreative() || p.isSpectator()))
				continue;

			Vec3 dir = centro.subtract(alvo.position());
			double dist = dir.length();

			if (dist < 0.05)
				continue;

			Vec3 normal = dir.normalize();

			double speed = Math.min(2.2, 0.3 + (2.0 / dist));
			Vec3 puxao = normal.scale(speed);

			if (alvo instanceof Player player) {
				player.setDeltaMovement(player.getDeltaMovement().add(puxao));
				player.hurtMarked = true;
			} else {
				alvo.setDeltaMovement(puxao);
			}

			if (dist < 5 && alvo instanceof LivingEntity living) {
				living.addEffect(new MobEffectInstance(
						NoirSmpModMobEffects.ESPAGETIFICACAO.get(),
						40,
						1
				));
			}

			if (dist < 2) {

				if (alvo instanceof LivingEntity living) {
					living.hurt(living.damageSources().generic(), 10);
				}

				if (!(alvo instanceof Player)) {
					alvo.discard();
				}
			}
		}

		BuraconegroblocosProcedure.execute(world, x, y, z, buracoNegro);
	}

	private static void explodir(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (world instanceof ServerLevel level) {

			level.explode(
					null,
					x, y, z,
					10f,
					ServerLevel.ExplosionInteraction.BLOCK
			);

			for (Entity e : level.getEntities(entity,
					new AABB(x, y, z, x, y, z).inflate(20))) {

				Vec3 dir = e.position().subtract(new Vec3(x, y, z)).normalize();
				e.setDeltaMovement(dir.scale(2.5));
			}
		}

		entity.discard();
	}
}