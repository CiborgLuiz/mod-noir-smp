package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

public class SanidadeCommandProcedure {
    public static void execute(Entity entity, double valor) {
        if (entity == null || !(entity instanceof Player)) return;

        entity.getPersistentData().putDouble("NoirSanity", valor);

        if (entity instanceof Player player) {
            player.displayClientMessage(Component.literal("§8[Noir] §7Sua sanidade foi definida para: §c" + valor), false);
        }
    }
}