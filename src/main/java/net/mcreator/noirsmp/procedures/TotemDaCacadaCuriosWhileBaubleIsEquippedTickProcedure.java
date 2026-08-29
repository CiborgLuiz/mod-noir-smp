package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class TotemDaCacadaCuriosWhileBaubleIsEquippedTickProcedure {
    
    public static void execute(LevelAccessor world, double x, double y, double z) {
        
        double radius = 10.0;

        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
                new AABB(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius), e -> true)
                .stream()
                .sorted(new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }.compareDistOf(x, y, z))
                .toList();

        for (Entity target : _entfound) {
            
            if (target.distanceToSqr(x, y, z) > 0.01) {
                
                if (target instanceof LivingEntity _livingTarget) {
                    
                    _livingTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0, false, false));
                    
                    if (world instanceof ServerLevel _level) {
                        
                        double pX = _livingTarget.getX();
                        double pY = _livingTarget.getY() + _livingTarget.getBbHeight() + 0.3;
                        double pZ = _livingTarget.getZ();
                        
                        _level.sendParticles(ParticleTypes.WITCH, pX, pY, pZ, 1, 0.1, 0.1, 0.1, 0.01);
                    }
                }
            }
        }
    }
}