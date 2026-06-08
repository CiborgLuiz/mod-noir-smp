package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.DustParticleOptions; 
import net.minecraft.core.BlockPos;

import org.joml.Vector3f;

import java.util.List;

public class FragmentoPrismaticoCuriosWhileBaubleIsEquippedTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        AABB hitbox = entity.getBoundingBox().inflate(3.0D);

        List<Projectile> projectiles = world.getEntitiesOfClass(Projectile.class, hitbox, e -> true);

        for (Projectile proj : projectiles) {
            if (proj.getOwner() != entity && !proj.getTags().contains("prism_checked")) {
                
                proj.addTag("prism_checked");

                if (Math.random() < 0.30) {
                    
                    Vec3 motion = proj.getDeltaMovement();
                    proj.setDeltaMovement(motion.scale(-1.5));

                    proj.setOwner(entity);

                    if (world instanceof ServerLevel _level) {
                        DustParticleOptions redMagicDust = new DustParticleOptions(new Vector3f(1.0f, 0.0f, 0.0f), 1.5f);
                        
                        _level.sendParticles(redMagicDust, proj.getX(), proj.getY() + 0.5, proj.getZ(), 40, 0.3, 0.3, 0.3, 0.1);
                        _level.sendParticles(ParticleTypes.LAVA, proj.getX(), proj.getY() + 0.5, proj.getZ(), 15, 0.4, 0.4, 0.4, 0.5);
                        _level.sendParticles(ParticleTypes.SMOKE, proj.getX(), proj.getY() + 0.5, proj.getZ(), 10, 0.2, 0.2, 0.2, 0.05);
                        _level.sendParticles(ParticleTypes.ENCHANTED_HIT, proj.getX(), proj.getY() + 0.5, proj.getZ(), 20, 0.5, 0.5, 0.5, 0.3);
                    }

                    if (world instanceof Level _lvl && !_lvl.isClientSide()) {
                        _lvl.playSound(null, BlockPos.containing(proj.getX(), proj.getY(), proj.getZ()),
                                SoundEvents.EVOKER_CAST_SPELL, SoundSource.PLAYERS, 1.0F, 1.5F);
                        _lvl.playSound(null, BlockPos.containing(proj.getX(), proj.getY(), proj.getZ()),
                                SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.PLAYERS, 1.0F, 2.0F);
                    }
                }
            }
        }
    }
}