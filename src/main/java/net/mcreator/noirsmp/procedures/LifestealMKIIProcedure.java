package net.mcreator.noirsmp.procedures;

import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class LifestealMKIIProcedure {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {

        if (!(event.getSource().getEntity() instanceof Player player))
            return;

        ItemStack stack = player.getMainHandItem();

        if (stack.isEmpty())
            return;

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKII.get())
            return;

        if (event.getSource().getDirectEntity() != player)
            return;

        float damage = event.getAmount();

        if (damage <= 0)
            return;

        double dano = stack.getOrCreateTag().getDouble("dano");

        int nivelLifesteal;

        if (dano >= 20000000)
            nivelLifesteal = 10;
        else if (dano >= 12000000)
            nivelLifesteal = 9;
        else if (dano >= 7000000)
            nivelLifesteal = 8;
        else if (dano >= 4000000)
            nivelLifesteal = 7;
        else if (dano >= 2000000)
            nivelLifesteal = 6;
        else if (dano >= 1000000)
            nivelLifesteal = 5;
        else if (dano >= 500000)
            nivelLifesteal = 4;
        else if (dano >= 250000)
            nivelLifesteal = 3;
        else if (dano >= 125000)
            nivelLifesteal = 2;
        else if (dano >= 50000)
            nivelLifesteal = 1;
        else
            nivelLifesteal = 0;

        float lifesteal = nivelLifesteal * 0.005f;

        if (lifesteal <= 0)
            return;

        float cura = damage * lifesteal;

        if (cura <= 0)
            return;
            
        player.heal(cura);
    }
}