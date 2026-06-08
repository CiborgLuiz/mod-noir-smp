package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import top.theillusivec4.curios.api.CuriosApi; 
import net.mcreator.noirsmp.init.NoirSmpModItems; 

@Mod.EventBusSubscriber
public class SeloDoMartirCuriosWhileBaubleIsEquippedTickProcedure {

    public static void execute() {
    }

    @SubscribeEvent
    public static void onEntityDamaged(LivingDamageEvent event) {
        if (event != null && event.getSource().getEntity() != null) {
            Entity attacker = event.getSource().getEntity();

            if (attacker instanceof Player player) {
                
                CuriosApi.getCuriosHelper().findEquippedCurio(NoirSmpModItems.SELO_DO_MARTIR.get(), player).ifPresent(curio -> {
                    
                    float damageDealt = event.getAmount(); 
                    float conversionRate = 0.05f;
                    float maxAbsorption = 10.0f;
                    
                    float absorptionToAdd = damageDealt * conversionRate;
                    float currentAbsorption = player.getAbsorptionAmount();
                    float newAbsorption = Math.min(maxAbsorption, currentAbsorption + absorptionToAdd);

                    player.setAbsorptionAmount(newAbsorption);
                });
            }
        }
    }
}