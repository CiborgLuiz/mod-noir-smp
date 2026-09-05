package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class KillProgressaoMKIProcedure {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {

        Entity sourceEntity = event.getSource().getEntity();

        if (!(sourceEntity instanceof Player player))
            return;

        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKI.get())
            return;

        stack.getOrCreateTag().putDouble(
            "kills",
            stack.getOrCreateTag().getDouble("kills") + 1
        );
    }
}