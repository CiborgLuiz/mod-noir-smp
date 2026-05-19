package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import net.mcreator.noirsmp.item.UmbraveuItem;

import java.util.List;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletableFuture;

public class UmbraveuSlashLogicProcedure {

    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null || !(sourceentity instanceof Player player))
            return;

        Level world = sourceentity.level();
        ItemStack mainHandItem = player.getMainHandItem();

        if (!(mainHandItem.getItem() instanceof UmbraveuItem)) {
            return;
        }

        if (player.getPersistentData().getDouble("umbraveu_cooldown") > world.getGameTime()) {
            return;
        }
        player.getPersistentData().putDouble("umbraveu_cooldown", (world.getGameTime() + 10));

        Vec3 look = player.getLookAngle();
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        double stepPerTick = 0.6;
        double spawnY = y + player.getEyeHeight() * 0.75;

        if (world instanceof ServerLevel _level) {
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
                    player.createCommandSourceStack().withPermission(4).withSuppressedOutput(), command);

            for (int i = 0; i < 20; i++) {
                final int tick = i;
                CompletableFuture.delayedExecutor(tick * 50, TimeUnit.MILLISECONDS).execute(() -> {
                    if (world instanceof ServerLevel _serverLevel) {
                        _serverLevel.getServer().execute(() -> {
                            double curX = x + (look.x * stepPerTick * tick);
                            double curY = spawnY + (look.y * stepPerTick * tick);
                            double curZ = z + (look.z * stepPerTick * tick);
                            final Vec3 _center = new Vec3(curX, curY, curZ);
                            
                            List<Entity> _entfound = _serverLevel.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.6), e -> true).stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();

                            for (Entity entityiterator : _entfound) {
                                if (entityiterator != player && entityiterator instanceof LivingEntity _livEnt) {
                                    _livEnt.hurt(_livEnt.damageSources().playerAttack(player), 1.5f);
                                    _livEnt.invulnerableTime = 5;
                                }
                            }
                        });
                    }
                });
            }
        }
    }
}