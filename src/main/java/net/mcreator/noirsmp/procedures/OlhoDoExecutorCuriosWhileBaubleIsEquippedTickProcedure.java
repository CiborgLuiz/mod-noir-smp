package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import top.theillusivec4.curios.api.CuriosApi;
import net.mcreator.noirsmp.init.NoirSmpModItems; 

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OlhoDoExecutorCuriosWhileBaubleIsEquippedTickProcedure {
    public static void execute() {
    }
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null && event.getSource().getEntity() != null) {
            execute(event, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null) return;
        
        if (sourceentity instanceof LivingEntity attacker && entity instanceof LivingEntity target) {
            if (CuriosApi.getCuriosHelper().findFirstCurio(attacker, NoirSmpModItems.OLHO_DO_EXECUTOR.get()).isPresent()) {
                
                float maxHealth = target.getMaxHealth();
                float currentHealth = target.getHealth();
                float healthPercentage = currentHealth / maxHealth;
                
                if (event instanceof LivingHurtEvent hurtEvent) {
                    
                    if (healthPercentage <= 0.10f) {
                        if (Math.random() <= 0.25) {
                            hurtEvent.setCanceled(true); 
                            target.kill(); 
                            return; 
                        }
                    }
                    
                    float originalDamage = hurtEvent.getAmount();
                    float damageMultiplier = 1.0f + (0.5f * (1.0f - healthPercentage)); 
                    
                    hurtEvent.setAmount(originalDamage * damageMultiplier);
                }
            }
        }
    }
}