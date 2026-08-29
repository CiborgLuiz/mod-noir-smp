package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class MascaraDaRaposaCriticoFurtivoProcedure {
    public static void execute(Entity sourceentity, Entity entity) {
        if (!(sourceentity instanceof LivingEntity atacante))
            return;

        if (!(entity instanceof LivingEntity alvo))
            return;

        if (sourceentity.getPersistentData().getBoolean("mascara_raposa_ativa")
                && atacante.isShiftKeyDown()) {

            alvo.hurt(atacante.damageSources().mobAttack(atacante), 4.0F);
        }
    }
}