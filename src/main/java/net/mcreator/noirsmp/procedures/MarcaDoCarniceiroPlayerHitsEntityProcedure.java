package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;

public class MarcaDoCarniceiroPlayerHitsEntityProcedure {

    public static void execute(Entity sourceentity) {
        if (sourceentity == null)
            return;

        int stacks = sourceentity.getPersistentData().getInt("carniceiro_stacks");

        stacks = Math.min(stacks + 1, 5);

        sourceentity.getPersistentData().putInt("carniceiro_stacks", stacks);

        sourceentity.getPersistentData().putInt("carniceiro_timer", 0);
    }
}