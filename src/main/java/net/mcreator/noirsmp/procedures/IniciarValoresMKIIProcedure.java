package net.mcreator.noirsmp.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class IniciarValoresMKIIProcedure {

    public static void execute(Player player) {

        if (player == null)
            return;

        for (ItemStack stack : player.getInventory().items) {
            inicializar(stack);
        }

        for (ItemStack stack : player.getInventory().armor) {
            inicializar(stack);
        }

        for (ItemStack stack : player.getInventory().offhand) {
            inicializar(stack);
        }
    }

    private static void inicializar(ItemStack stack) {

        if (stack == null || stack.isEmpty())
            return;

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKII.get())
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