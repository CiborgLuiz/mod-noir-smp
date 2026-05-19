package net.mcreator.noirsmp.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.BlockPos;

import org.joml.Vector3f;

import java.util.Comparator;

public class EgidePrismaticaRightclickedProcedure {

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		// SISTEMA DE COOLDOWN PERSONALIZADO
		CompoundTag persistentData = entity.getPersistentData();

		if (persistentData.getDouble("egideCooldown") > 0) {
			return;
		}

		// DEFINE COOLDOWN (15 SEGUNDOS = 300 TICKS)
		persistentData.putDouble("egideCooldown", 300);

		// SOM
		if (world instanceof Level level) {
			if (!level.isClientSide()) {
				level.playSound(
						null,
						BlockPos.containing(x, y, z),
						ForgeRegistries.SOUND_EVENTS.getValue(
								new ResourceLocation("noir_smp:shieldboom")
						),
						SoundSource.PLAYERS,
						1.5f,
						1f
				);
			} else {
				level.playLocalSound(
						x, y, z,
						ForgeRegistries.SOUND_EVENTS.getValue(
								new ResourceLocation("noir_smp:shieldboom")
						),
						SoundSource.PLAYERS,
						1.5f,
						1f,
						false
				);
			}
		}

		// EMPURRÃO
		double radius = 20.0;

		world.getEntitiesOfClass(
				Entity.class,
				new AABB(
						x - radius, y - radius, z - radius,
						x + radius, y + radius, z + radius
				),
				e -> e instanceof LivingEntity && e != entity
		).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z)))
				.forEach(target -> {

					// DIREÇÃO HORIZONTAL
					double dx = target.getX() - x;
					double dz = target.getZ() - z;

					double horizontalDistance = Math.sqrt(dx * dx + dz * dz);

					if (horizontalDistance > 0) {

						dx /= horizontalDistance;
						dz /= horizontalDistance;

						double distance = Math.sqrt(
								(target.getX() - x) * (target.getX() - x) +
								(target.getY() - y) * (target.getY() - y) +
								(target.getZ() - z) * (target.getZ() - z)
						);

						// FORÇA
						double strength = 4.5 * (1.0 - (distance / radius));

						target.setDeltaMovement(
								dx * strength,
								0.35,
								dz * strength
						);

						target.hurtMarked = true;
					}
				});

		// PULSO VISUAL
		if (world instanceof ServerLevel serverLevel) {

			for (int ring = 1; ring <= 20; ring++) {

				double currentRadius = ring * 1.1;

				for (double angle = 0; angle < 360; angle += 5) {

					double radians = Math.toRadians(angle);

					double px = x + Math.cos(radians) * currentRadius;
					double py = y + 0.15;
					double pz = z + Math.sin(radians) * currentRadius;

					serverLevel.sendParticles(
							new DustParticleOptions(
									new Vector3f(0.75f, 0.75f, 0.75f),
									2.3f
							),
							px,
							py,
							pz,
							1,
							0,
							0,
							0,
							0
					);
				}
			}
		}
	}
}