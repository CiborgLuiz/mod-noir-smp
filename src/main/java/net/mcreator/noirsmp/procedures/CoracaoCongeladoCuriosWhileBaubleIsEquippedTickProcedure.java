package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class CoracaoCongeladoCuriosWhileBaubleIsEquippedTickProcedure {

    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event == null || event.getEntity() == null)
            return;

        Entity entity = event.getEntity(); 
        Entity sourceentity = event.getSource().getEntity();

        if (entity instanceof LivingEntity livingTarget && sourceentity instanceof LivingEntity livingAttacker) {
            boolean isWearingNecklace = top.theillusivec4.curios.api.CuriosApi.getCuriosHelper()
                    .findEquippedCurio(NoirSmpModItems.CORACAO_CONGELADO.get(), livingTarget).isPresent();

            if (isWearingNecklace) {
                livingAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));

                livingAttacker.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 0));

                if (Math.random() < 0.25) {
                    livingAttacker.setTicksFrozen(80);
                }
            }
        }
    }

    public static void execute() {
    }
}