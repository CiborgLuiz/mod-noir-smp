package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.mcreator.noirsmp.init.NoirSmpModItems;

import java.util.UUID;

public class SingularisEntityDiesProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null) return;

        String ownerUUIDString = entity.getPersistentData().getString("OwnerUUID");
        
        if (!ownerUUIDString.isEmpty() && world instanceof ServerLevel serverLevel) {
            Player owner = serverLevel.getServer().getPlayerList().getPlayer(UUID.fromString(ownerUUIDString));
            
            if (owner != null) {
                owner.getCooldowns().addCooldown(NoirSmpModItems.SINGULARIS_ITEM.get(), 600); 
            }
        }
    }
}