package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber
public class MarcaDoCarniceiroAoAtacarProcedure {

    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event == null)
            return;

        Entity sourceentity = event.getSource().getEntity();

        if (sourceentity == null)
            return;

        int stacks = sourceentity.getPersistentData().getInt("carniceiro_stacks");

        if (stacks < 5)
            stacks++;

        sourceentity.getPersistentData().putInt("carniceiro_stacks", stacks);
        sourceentity.getPersistentData().putInt("carniceiro_timer", 0);
    }
}