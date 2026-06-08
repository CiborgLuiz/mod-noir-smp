package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;

@Mod.EventBusSubscriber
public class ProjetoZeroPlayerRespawnProcedure {

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            
            if (player.level().dimension().location().toString().equals("noir_smp:projeto_zero")) {
                
                double portalX = player.getPersistentData().getDouble("NoirPortalX");
                double portalZ = player.getPersistentData().getDouble("NoirPortalZ");
                
                double offsetX = (1000 + (Math.random() * 1000)) * (Math.random() > 0.5 ? 1 : -1);
                double offsetZ = (1000 + (Math.random() * 1000)) * (Math.random() > 0.5 ? 1 : -1);
                
                int newX = (int)(portalX + offsetX);
                int newZ = (int)(portalZ + offsetZ);
                
                ServerLevel noirLevel = player.serverLevel();
                
                int safeY = noirLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, newX, newZ);
                BlockPos nightmareSpawn = new BlockPos(newX, safeY + 1, newZ);
                
                player.setRespawnPosition(noirLevel.dimension(), nightmareSpawn, 0.0F, true, false);
            }
        }
    }
}