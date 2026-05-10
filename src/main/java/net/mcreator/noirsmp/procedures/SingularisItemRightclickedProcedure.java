package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;

import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.entity.SingularisEntity;

import java.util.List;

public class SingularisItemRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null) return;
        
        if (world instanceof ServerLevel _level) {
            String playerUUID = entity.getStringUUID();
            
            List<SingularisEntity> entities = _level.getEntitiesOfClass(SingularisEntity.class, new AABB(x - 250, y - 250, z - 250, x + 250, y + 250, z + 250));
            
            boolean jaPossui = false;
            for (SingularisEntity singularis : entities) {
                if (singularis.getPersistentData().getString("OwnerUUID").equals(playerUUID)) {
                    jaPossui = true;
                    break;
                }
            }

            if (!jaPossui) {
                Entity spawned = NoirSmpModEntities.SINGULARIS.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
                if (spawned != null) {
                    spawned.getPersistentData().putString("OwnerUUID", playerUUID);
                    if (entity instanceof Player _player)
                        _player.displayClientMessage(Component.literal("§cSingularis Ativado."), true);
                }
            } else {
                if (entity instanceof Player _player && !_level.isClientSide())
                    _player.displayClientMessage(Component.literal("§7Você já possui um Singularis ativo por perto!"), true);
            }
        }
    }
}