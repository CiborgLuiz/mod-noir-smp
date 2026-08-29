package net.mcreator.noirsmp.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

import java.util.UUID;

public class MarcaDoCarniceiroCuriosWhileBaubleIsEquippedTickProcedure {

    private static final UUID DAMAGE_UUID = UUID.fromString("2f1d8c4e-1111-4444-8888-aaaaaaaaaaaa");
    private static final UUID SPEED_UUID  = UUID.fromString("3e2a9d5f-2222-5555-9999-bbbbbbbbbbbb");

    public static void execute(LevelAccessor world, Entity entity) {
        if (!(entity instanceof LivingEntity living))
            return;

        int stacks = entity.getPersistentData().getInt("carniceiro_stacks");
        int timer = entity.getPersistentData().getInt("carniceiro_timer");

        timer++;
        entity.getPersistentData().putInt("carniceiro_timer", timer);

        if (timer >= 100) {
            stacks = 0;
            entity.getPersistentData().putInt("carniceiro_stacks", 0);
        }

        int lastApplied = entity.getPersistentData().getInt("carniceiro_last_applied");

        if (lastApplied != stacks) {

            AttributeInstance damage = living.getAttribute(Attributes.ATTACK_DAMAGE);

            if (damage != null) {
                damage.removeModifier(DAMAGE_UUID);

                if (stacks > 0) {
                    damage.addPermanentModifier(new AttributeModifier(
                        DAMAGE_UUID,
                        "carniceiro_damage",
                        stacks * 0.5,
                        AttributeModifier.Operation.ADDITION
                    ));
                }
            }

            AttributeInstance speed = living.getAttribute(Attributes.ATTACK_SPEED);

            if (speed != null) {
                speed.removeModifier(SPEED_UUID);

                if (stacks > 0) {
                    speed.addPermanentModifier(new AttributeModifier(
                        SPEED_UUID,
                        "carniceiro_speed",
                        stacks * 0.04,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                    ));
                }
            }

            entity.getPersistentData().putInt("carniceiro_last_applied", stacks);
        }

        if (stacks > 0 && world instanceof ServerLevel serverLevel) {

            if (entity.tickCount % 2 == 0) {

                int amount = 2 + (stacks * 3);
                double radius = 0.18 + (stacks * 0.07);
                double baseY = entity.getY() + 0.85;

                for (int i = 0; i < amount; i++) {
                    double angle = (Math.PI * 2 * i / amount) + (entity.tickCount * 0.12);

                    double px = entity.getX() + Math.cos(angle) * radius;
                    double py = baseY + (i % 2) * 0.08 + (stacks * 0.02);
                    double pz = entity.getZ() + Math.sin(angle) * radius;

                    serverLevel.sendParticles(
                        ParticleTypes.CRIMSON_SPORE,
                        px, py, pz,
                        1,
                        0.005, 0.005, 0.005,
                        0
                    );
                }

                if (stacks >= 3) {
                    serverLevel.sendParticles(
                        ParticleTypes.DAMAGE_INDICATOR,
                        entity.getX(),
                        entity.getY() + 1.0,
                        entity.getZ(),
                        stacks - 2,
                        0.15, 0.2, 0.15,
                        0
                    );
                }

                if (stacks == 5) {
                    serverLevel.sendParticles(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        entity.getX(),
                        entity.getY() + 1.0,
                        entity.getZ(),
                        2,
                        0.12, 0.18, 0.12,
                        0.01
                    );
                }
            }
        }
    }
}