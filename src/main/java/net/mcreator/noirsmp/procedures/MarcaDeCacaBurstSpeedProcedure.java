package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

@Mod.EventBusSubscriber
public class MarcaDeCacaBurstSpeedProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null && event.getSource().getEntity() != null) {
            Entity target = event.getEntity();
            Entity killer = event.getSource().getEntity();
            
            if (target instanceof LivingEntity _livingTarget && _livingTarget.hasEffect(MobEffects.GLOWING)) {
                if (killer instanceof LivingEntity _livingKiller) {
                    _livingKiller.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1, false, false));
                }
            }
        }
    }
}