package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class HitsProgressaoMKIProcedure {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {

        Entity attacker = event.getSource().getEntity();

        if (!(attacker instanceof Player player))
            return;

        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKI.get())
            return;

        if (event.getAmount() <= 0)
            return;

        stack.getOrCreateTag().putDouble(
            "hits",
            stack.getOrCreateTag().getDouble("hits") + 1
        );
    }
}