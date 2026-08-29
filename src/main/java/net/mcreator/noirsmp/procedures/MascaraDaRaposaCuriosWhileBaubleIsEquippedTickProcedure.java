package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.Vec3;

public class MascaraDaRaposaCuriosWhileBaubleIsEquippedTickProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;

        entity.getPersistentData().putBoolean("mascara_raposa_ativa", true);

        if (entity instanceof LivingEntity living) {

            if (!living.level().isClientSide())
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));

            int cooldown = entity.getPersistentData().getInt("raposa_dash_cooldown");

            if (cooldown > 0) {
                entity.getPersistentData().putInt("raposa_dash_cooldown", cooldown - 1);
            }


            boolean agachando = living.isShiftKeyDown();
            boolean dashUsado = entity.getPersistentData().getBoolean("raposa_dash_usado");

            if (agachando && !dashUsado && cooldown <= 0) {

                Vec3 look = living.getLookAngle();

                living.setDeltaMovement(
                        look.x * 1.2,
                        living.getDeltaMovement().y + 0.08,
                        look.z * 1.2
                );

                living.hurtMarked = true;

                entity.getPersistentData().putBoolean("raposa_dash_usado", true);

                entity.getPersistentData().putInt("raposa_dash_cooldown", 60);
            }

            if (!agachando && dashUsado) {
                entity.getPersistentData().putBoolean("raposa_dash_usado", false);
            }
        }
    }
}