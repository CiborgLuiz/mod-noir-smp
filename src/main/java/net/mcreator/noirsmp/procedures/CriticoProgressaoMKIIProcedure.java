package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class CriticoProgressaoMKIIProcedure {

    @SubscribeEvent
    public static void onCriticalHit(CriticalHitEvent event) {

        Player player = event.getEntity();

        if (player == null)
            return;

        ItemStack stack = player.getMainHandItem();

        if (stack.isEmpty())
            return;

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKII.get())
            return;
            
        stack.getOrCreateTag().putDouble(
            "hitscrit",
            stack.getOrCreateTag().getDouble("hitscrit") + 1
        );
    }
}