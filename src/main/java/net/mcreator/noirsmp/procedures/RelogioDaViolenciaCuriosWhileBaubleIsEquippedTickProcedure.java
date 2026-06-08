package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import top.theillusivec4.curios.api.CuriosApi;
import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class RelogioDaViolenciaCuriosWhileBaubleIsEquippedTickProcedure {

    public static void execute() {
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event == null || event.getSource().getEntity() == null) return;
        
        if (event.getSource().getEntity() instanceof Player player) {
            ativarFrenesiSePuder(player);
            
            long currentTime = player.level().getGameTime();
            long frenesiEndTime = player.getPersistentData().getLong("NoirFrenesiFim");
            
            if (currentTime < frenesiEndTime) {
                event.setAmount(event.getAmount() * 1.5f);
            }
        }
        
        if (event.getEntity() instanceof Player player) {
            ativarFrenesiSePuder(player);
        }
    }

    private static void ativarFrenesiSePuder(Player player) {
        if (player.level().isClientSide()) return;

        CuriosApi.getCuriosHelper().findEquippedCurio(NoirSmpModItems.RELOGIO_DA_VIOLENCIA.get(), player).ifPresent(curio -> {
            
            long currentTime = player.level().getGameTime();
            long proximaFuria = player.getPersistentData().getLong("NoirProximaFuria");

            if (currentTime >= proximaFuria) {
                
                player.getPersistentData().putLong("NoirFrenesiFim", currentTime + 200);
                
                player.getPersistentData().putLong("NoirProximaFuria", currentTime + 800);

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 1, false, false));
            }
        });
    }
}