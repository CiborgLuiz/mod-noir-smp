package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.noirsmp.init.NoirSmpModItems;

@Mod.EventBusSubscriber
public class IniciarValoresMKIProcedure {

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {

        Entity entity = event.getEntity();

        if (!(entity instanceof Player player))
            return;

        initializeStack(player.getMainHandItem());

        for (ItemStack stack : player.getInventory().items) {
            initializeStack(stack);
        }

        for (ItemStack stack : player.getInventory().armor) {
            initializeStack(stack);
        }

        initializeStack(player.getOffhandItem());
    }

    private static void initializeStack(ItemStack stack) {

        if (stack.isEmpty())
            return;

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKI.get())
            return;

        CompoundTag tag = stack.getOrCreateTag();

        if (!tag.contains("kills"))
            tag.putDouble("kills", 0);

        if (!tag.contains("hits"))
            tag.putDouble("hits", 0);

        if (!tag.contains("hitscrit"))
            tag.putDouble("hitscrit", 0);

        if (!tag.contains("andada"))
            tag.putDouble("andada", 0);

        if (!tag.contains("dano"))
            tag.putDouble("dano", 0);

        if (!tag.contains("desgaste"))
            tag.putDouble("desgaste", 0);

        if (!tag.contains("last_x"))
            tag.putDouble("last_x", 0);

        if (!tag.contains("last_y"))
            tag.putDouble("last_y", 0);

        if (!tag.contains("last_z"))
            tag.putDouble("last_z", 0);

        if (!tag.contains("distance_initialized"))
            tag.putBoolean("distance_initialized", false);
    }
}