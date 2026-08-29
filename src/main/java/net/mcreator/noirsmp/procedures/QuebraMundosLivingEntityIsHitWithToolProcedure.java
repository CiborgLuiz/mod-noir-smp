package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.mcreator.noirsmp.ImpactFrame;

import net.mcreator.noirsmp.NoirSmpMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class QuebraMundosLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, ItemStack itemstack) {
        if (world == null || sourceentity == null) return;

        if (sourceentity instanceof Player _player) {
            if (_player.getCooldowns().isOnCooldown(itemstack.getItem())) {
                return;
            } else {
                _player.getCooldowns().addCooldown(itemstack.getItem(), 400); 
            }
        }

        if (world instanceof ServerLevel _level) {
            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.END_PORTAL_SPAWN, SoundSource.PLAYERS, 1.0F, 0.8F);
        }

        for (int i = 1; i <= 8; i++) { 
            final int step = i;
            NoirSmpMod.queueServerWork(step * 10, () -> {
                
                if (world instanceof ServerLevel _level) {
                    double size = (step % 2 == 0) ? 3.0 : 2.0; 
                    
                    for (double r = 0; r <= size; r += 0.2) {
                        _level.sendParticles(ParticleTypes.WITCH, x + r, y + 1.5, z, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x - r, y + 1.5, z, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x, y + 1.5, z + r, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x, y + 1.5, z - r, 1, 0, 0, 0, 0);
                        
                        double diag = r * 0.5;
                        _level.sendParticles(ParticleTypes.WITCH, x + diag, y + 1.5, z + diag, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x - diag, y + 1.5, z + diag, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x + diag, y + 1.5, z - diag, 1, 0, 0, 0, 0);
                        _level.sendParticles(ParticleTypes.WITCH, x - diag, y + 1.5, z - diag, 1, 0, 0, 0, 0);
                    }
                    
                    _level.sendParticles(ParticleTypes.SQUID_INK, x, y + 1.5, z, 60, 1.2, 0.2, 1.2, 0.01);
                }

                if (step >= 6) {
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y + 1.5, z, 150, 4, 4, 4, 0.1);
                        _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.PLAYERS, 2.0F, 0.5F);
                    }
                    
                    final Vec3 center = new Vec3(x, y + 1.5, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - 15, y - 15, z - 15, x + 15, y + 15, z + 15), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(center))).collect(Collectors.toList());
                    
                    for (Entity entityiterator : _entfound) {
                        if (entityiterator != sourceentity && entityiterator instanceof LivingEntity) {
                            Vec3 moveVector = new Vec3(x - entityiterator.getX(), (y + 1.5) - entityiterator.getY(), z - entityiterator.getZ()).normalize().scale(0.85);
                            entityiterator.setDeltaMovement(entityiterator.getDeltaMovement().add(moveVector));
                            
                            entityiterator.hurt(entityiterator.damageSources().magic(), 2.0F); 
                        }
                    }
                }
            });
        }

        NoirSmpMod.queueServerWork(85, () -> {
            
			try {
    			net.mcreator.noirsmp.ImpactFrame.trigger(x, y, z, sourceentity.level().dimension().location().toString());
			} catch (Throwable e) {
			}
            
            if (world instanceof ServerLevel _level) {
                _level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y + 1.5, z, 400, 4, 4, 4, 0.5); 
                _level.sendParticles(ParticleTypes.SQUID_INK, x, y + 1.5, z, 300, 4, 4, 4, 0.8);
                _level.sendParticles(ParticleTypes.SONIC_BOOM, x, y + 1.5, z, 1, 0, 0, 0, 0); 
                _level.sendParticles(ParticleTypes.FLASH, x, y + 1.5, z, 3, 0, 0, 0, 0); 
                
                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 3.0F, 0.6F);
            }

            final Vec3 center = new Vec3(x, y + 1.5, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - 12, y - 12, z - 12, x + 12, y + 12, z + 12), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(center))).collect(Collectors.toList());
            
            for (Entity entityiterator : _entfound) {
                if (entityiterator != sourceentity && entityiterator instanceof LivingEntity) {
                    entityiterator.hurt(entityiterator.damageSources().magic(), 40.0F); 
                    Vec3 knockback = new Vec3(entityiterator.getX() - x, entityiterator.getY() - y, entityiterator.getZ() - z).normalize().scale(2.5);
                    entityiterator.setDeltaMovement(entityiterator.getDeltaMovement().add(knockback));
                }
            }
        });
    }
}