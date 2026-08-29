package net.mcreator.noirsmp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;

import net.mcreator.noirsmp.init.NoirSmpModMobEffects;
import net.mcreator.noirsmp.ImpactFrame;

import java.util.List;

public class BuracoNegroOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity buracoNegro) {
        if (buracoNegro == null || world.isClientSide())
            return;

        double tick = buracoNegro.getPersistentData().getDouble("tick");
        double vida = buracoNegro.getPersistentData().getDouble("vida");

        if (!buracoNegro.getPersistentData().getBoolean("initialized")) {
            vida = 1012;
            buracoNegro.getPersistentData().putDouble("vida", vida);
            buracoNegro.getPersistentData().putBoolean("initialized", true);
        }

        tick++;

        if (tick >= 20) {
            tick = 0;
            vida -= 1;
            buracoNegro.getPersistentData().putDouble("vida", vida);
            
            if (buracoNegro instanceof LivingEntity living) {
                float maxH = living.getMaxHealth();
                living.setHealth(Math.max(1, (float) ((vida / 1012.0) * maxH)));
            }

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

            String entityName = alvo.getType().getDescriptionId().toLowerCase();
            String className = alvo.getClass().getSimpleName().toLowerCase();
            boolean isCorpse = entityName.contains("corpse") || className.contains("corpse");

            Vec3 dir = centro.subtract(alvo.position());
            double dist = dir.length();

            if (dist < 0.05) continue;

            Vec3 normal = dir.normalize();
     
            double speed = isCorpse ? 0 : Math.min(2.2, 0.3 + (2.0 / dist));
            Vec3 puxao = normal.scale(speed);

            if (alvo instanceof Player player) {
                player.setDeltaMovement(player.getDeltaMovement().add(puxao));
                player.hurtMarked = true;
            } else if (!isCorpse) {
                alvo.setDeltaMovement(alvo.getDeltaMovement().add(puxao));
            }
            if (dist < 5 && alvo instanceof LivingEntity living && !isCorpse) {
                living.addEffect(new MobEffectInstance(NoirSmpModMobEffects.ESPAGETIFICACAO.get(), 40, 1));
            }
            if (dist < 2) {
                if (alvo instanceof LivingEntity living) {
                    living.hurt(living.damageSources().generic(), 10);
                }
                if (!(alvo instanceof Player) && !isCorpse) {
                    alvo.discard();
                }
            }
        }
        BuraconegroblocosProcedure.execute(world, x, y, z, buracoNegro);
    }

    private static void explodir(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (world.isClientSide()) {
            net.mcreator.noirsmp.ImpactFrame.trigger(x, y, z, entity.level().dimension().location().toString());
        }

        if (world instanceof ServerLevel level) {
            level.explode(entity, x, y, z, 40f, Level.ExplosionInteraction.BLOCK);

            for (Entity e : level.getEntities(entity, new AABB(x, y, z, x, y, z).inflate(50))) {
                String name = e.getType().getDescriptionId().toLowerCase();
                if (name.contains("corpse") || e.getClass().getSimpleName().toLowerCase().contains("corpse")) 
                    continue;

                Vec3 dir = e.position().subtract(new Vec3(x, y, z)).normalize();
                e.setDeltaMovement(dir.scale(5.0));
                e.hurtMarked = true;
                
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().explosion(null), 100f);
                }
            }
        }
        entity.discard();
    }
}