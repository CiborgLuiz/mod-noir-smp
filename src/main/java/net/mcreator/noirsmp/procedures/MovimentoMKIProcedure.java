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
public class MovimentoMKIProcedure {

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {

        Entity entity = event.getEntity();

        if (!(entity instanceof Player player))
            return;

        ItemStack stack = player.getMainHandItem();

        if (stack.isEmpty())
            return;

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKI.get())
            return;

        atualizarDistancia(stack, player);
    }

    private static void atualizarDistancia(ItemStack stack, Player player) {

        CompoundTag tag = stack.getOrCreateTag();

        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        if (!tag.getBoolean("distance_initialized")) {

            tag.putDouble("last_x", x);
            tag.putDouble("last_y", y);
            tag.putDouble("last_z", z);

            tag.putBoolean("distance_initialized", true);

            return;
        }

        double lastX = tag.getDouble("last_x");
        double lastY = tag.getDouble("last_y");
        double lastZ = tag.getDouble("last_z");

        double distance = Math.sqrt(
            Math.pow(x - lastX, 2) +
            Math.pow(y - lastY, 2) +
            Math.pow(z - lastZ, 2)
        );

        if (distance > 0.001) {

            if (distance < 2.0) {
                double acumulada = tag.getDouble("distance_buffer");

                acumulada += distance;

                if (acumulada >= 1.0) {

                    double blocosCompletos = Math.floor(acumulada);

                    double andadaAtual = tag.getDouble("andada");

                    tag.putDouble(
                        "andada",
                        andadaAtual + blocosCompletos
                    );

                    acumulada -= blocosCompletos;
                }

                tag.putDouble(
                    "distance_buffer",
                    acumulada
                );
            }
        }

        tag.putDouble("last_x", x);
        tag.putDouble("last_y", y);
        tag.putDouble("last_z", z);
    }
}