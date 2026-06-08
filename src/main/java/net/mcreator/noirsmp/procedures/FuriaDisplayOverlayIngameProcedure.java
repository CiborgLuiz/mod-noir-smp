package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class FuriaDisplayOverlayIngameProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null) return false;
        
        if (entity instanceof Player player) {
            long currentTime = player.level().getGameTime();
            long frenesiEndTime = player.getPersistentData().getLong("NoirFrenesiFim");
            
            return currentTime < frenesiEndTime;
        }
        
        return false;
    }
}