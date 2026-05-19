package net.mcreator.noirsmp.events;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;

import top.theillusivec4.curios.api.CuriosApi;
import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber(modid = "noir_smp")
public class MedalhaoCombateEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            
            CuriosApi.getCuriosHelper().findFirstCurio(player, NoirSmpModItems.MEDALHAO_DO_PARASITA.get()).ifPresent(data -> {
                
                float danoCausado = event.getAmount();
                float cura = danoCausado * 0.30f; 
                
                if (cura > 0) {
                    player.heal(cura);
                    
                    if (player.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.HEART, player.getX(), player.getY() + 1.5, player.getZ(), 3, 0.3, 0.3, 0.3, 0.1);
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        if (event.getEntity() instanceof Player player) {
            
            CuriosApi.getCuriosHelper().findFirstCurio(player, NoirSmpModItems.MEDALHAO_DO_PARASITA.get()).ifPresent(data -> {
                event.setAmount(event.getAmount() * 0.25f);
            });
        }
    }
}