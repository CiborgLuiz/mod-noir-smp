package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

@Mod.EventBusSubscriber
public class MarcaDeCacaDanoExtraProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            Entity target = event.getEntity();
            if (target instanceof LivingEntity _living && _living.hasEffect(MobEffects.GLOWING)) {
                float danoExtra = 2.0F; 
                event.setAmount(event.getAmount() + danoExtra);
            }
        }
    }
}