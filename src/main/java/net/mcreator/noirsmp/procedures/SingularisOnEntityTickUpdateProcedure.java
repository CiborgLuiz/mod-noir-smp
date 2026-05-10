package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.DustParticleOptions;
import org.joml.Vector3f;
import net.minecraft.util.Mth;

import java.util.UUID;

public class SingularisOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null) return;

        String ownerUUIDString = entity.getPersistentData().getString("OwnerUUID");
        if (!ownerUUIDString.isEmpty() && world instanceof ServerLevel serverLevel) {
            Player owner = serverLevel.getServer().getPlayerList().getPlayer(UUID.fromString(ownerUUIDString));

            if (owner != null && owner.isAlive()) {
                LivingEntity target = owner.getLastHurtMob();
                
                if (target != null && (!target.isAlive() || target.distanceTo(owner) > 25)) {
                    target = null;
                }

                double targetX, targetY, targetZ;
                double speed, radius, angle;

                if (target != null) {
                    speed = 0.08; 
                    radius = 3.0; 
                    angle = serverLevel.getGameTime() * speed;

                    targetX = target.getX() + Math.cos(angle) * radius;
                    targetZ = target.getZ() + Math.sin(angle) * radius;
                    targetY = target.getY() + (target.getBbHeight() / 2) + 0.5;

                    double dx = target.getX() - entity.getX();
                    double dy = (target.getY() + target.getBbHeight()/2) - entity.getY();
                    double dz = target.getZ() - entity.getZ();
                    double distanceXZ = Math.sqrt(dx * dx + dz * dz);

                    float yaw = (float) (Mth.atan2(dz, dx) * (180 / Math.PI)) - 90;
                    float pitch = (float) (-(Mth.atan2(dy, distanceXZ) * (180 / Math.PI)));

                    entity.setYRot(yaw);
                    entity.setXRot(pitch);
                    entity.setYHeadRot(yaw);

                    double attackCooldown = entity.getPersistentData().getDouble("AttackCooldown");
                    if (attackCooldown > 0) {
                        entity.getPersistentData().putDouble("AttackCooldown", attackCooldown - 1);
                    } else {
                        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
                        for (int i = 0; i < (int) (dist * 8); i++) {
                            double pX = entity.getX() + (dx / dist) * (i / 8.0);
                            double pY = entity.getY() + (dy / dist) * (i / 8.0);
                            double pZ = entity.getZ() + (dz / dist) * (i / 8.0);
                            serverLevel.sendParticles(new DustParticleOptions(new Vector3f(1.0f, 0.0f, 0.0f), 1.0f), pX, pY, pZ, 1, 0, 0, 0, 0);
                        }
                        target.hurt(target.level().damageSources().mobAttack((LivingEntity) entity), 6.0F);
                        entity.getPersistentData().putDouble("AttackCooldown", 12); 
                    }
                } else {
                    speed = 0.05;
                    radius = 0.7;
                    angle = serverLevel.getGameTime() * speed;

                    targetX = owner.getX() + Math.cos(angle) * radius;
                    targetZ = owner.getZ() + Math.sin(angle) * radius;
                    targetY = owner.getY() + owner.getEyeHeight() + 0.5;

                    entity.setYRot(owner.getYRot());
                    entity.setXRot(owner.getXRot());
                    entity.setYHeadRot(owner.getYRot());
                }

                entity.setDeltaMovement((targetX - entity.getX()) * 0.25, (targetY - entity.getY()) * 0.25, (targetZ - entity.getZ()) * 0.25);
            } else {
                entity.discard();
            }
        }
    }
}