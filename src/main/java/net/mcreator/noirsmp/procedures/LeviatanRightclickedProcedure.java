package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.entity.LeviatanProjectileEntity;

public class LeviatanRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (entity instanceof LivingEntity shooter) {

            if (world instanceof ServerLevel projectileLevel) {

                Projectile projectile = initArrowProjectile(
                        createArrowWeaponItemStack(
                                new LeviatanProjectileEntity(
                                        NoirSmpModEntities.LEVIATAN_PROJECTILE.get(),
                                        shooter,
                                        projectileLevel
                                ),
                                1,
                                (byte) 0
                        ),
                        shooter,
                        4,
                        true,
                        false,
                        false,
                        AbstractArrow.Pickup.DISALLOWED
                );

                projectile.setPos(x, y + 1.7, z);

                projectile.shoot(
                        shooter.getLookAngle().x,
                        shooter.getLookAngle().y,
                        shooter.getLookAngle().z,
                        4.5f,
                        0
                );

                projectileLevel.addFreshEntity(projectile);
            }
        }

        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(NoirSmpModItems.LEVIATAN.get(), 150);
        }
    }

    private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage,
            boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {

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