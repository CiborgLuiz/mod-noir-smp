package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;

import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.entity.TijoloProjectileEntity;

public class TijoloArremessarOnDispenseAttemptWithResultProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return;
		double fromZ = 0;
		double fromX = 0;
		double fromY = 0;
		fromX = x + 0.5 + direction.getStepX() * 0.6;
		fromY = y + 0.5 + direction.getStepY() * 0.6;
		fromZ = z + 0.5 + direction.getStepZ() * 0.6;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = initArrowProjectile(createArrowWeaponItemStack(new TijoloProjectileEntity(NoirSmpModEntities.TIJOLO_PROJECTILE.get(), 0, 0, 0, projectileLevel), 10, (byte) 0), null, 4, true, false, false,
					AbstractArrow.Pickup.CREATIVE_ONLY);
			_entityToSpawn.setPos(fromX, fromY, fromZ);
			_entityToSpawn.shoot((direction.getStepX()), (direction.getStepY()), (direction.getStepZ()), (float) 1.4, 1);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.setSecondsOnFire(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static AbstractArrow createArrowWeaponItemStack(AbstractArrow entityToSpawn, int knockback, byte piercing) {
		if (knockback > 0)
			entityToSpawn.setKnockback(knockback);
		if (piercing > 0)
			entityToSpawn.setPierceLevel(piercing);
		return entityToSpawn;
	}
}