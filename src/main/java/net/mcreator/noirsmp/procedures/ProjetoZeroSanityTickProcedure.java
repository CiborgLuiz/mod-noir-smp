package net.mcreator.noirsmp.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

@Mod.EventBusSubscriber
public class ProjetoZeroSanityTickProcedure {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide()) return;

        Player entity = event.player;
        Level world = entity.level();

        boolean isInNoir = world.dimension().location().toString().equals("noir_smp:projeto_zero");
        boolean wasInNoir = entity.getPersistentData().getBoolean("NoirEnteredDimension");

        if (isInNoir) {
            if (!wasInNoir) {
                entity.getPersistentData().putBoolean("NoirEnteredDimension", true);
                entity.getPersistentData().putDouble("NoirSanity", 100.0);
                entity.getPersistentData().putInt("NoirDarknessCooldown", 0);
                entity.getPersistentData().putDouble("NoirPortalX", entity.getX());
                entity.getPersistentData().putDouble("NoirPortalZ", entity.getZ());
            }
            double sanity = entity.getPersistentData().getDouble("NoirSanity");
            if (sanity > 0) {
                sanity -= 0.002;
                entity.getPersistentData().putDouble("NoirSanity", sanity);
            }

            int darknessCooldown = entity.getPersistentData().getInt("NoirDarknessCooldown");
            if (darknessCooldown > 0) {
                darknessCooldown--;
                entity.getPersistentData().putInt("NoirDarknessCooldown", darknessCooldown);
            }

            double chance = Math.random(); 
            
            double offsetX = entity.getX() + ((Math.random() * 4 + 2) * (Math.random() > 0.5 ? 1 : -1));
            double offsetZ = entity.getZ() + ((Math.random() * 4 + 2) * (Math.random() > 0.5 ? 1 : -1));
            BlockPos offsetPos = BlockPos.containing(offsetX, entity.getY(), offsetZ);
            BlockPos playerPos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());

            if (sanity <= 75.0 && sanity > 50.0) {
                if (chance < 0.02) {
                    world.playSound(null, offsetPos, SoundEvents.ZOMBIE_STEP, SoundSource.PLAYERS, 0.6f, 0.8f);
                }
            } 
            else if (sanity <= 50.0 && sanity > 25.0) {
                if (darknessCooldown == 0 && chance < 0.03) {
                    entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 0, false, false));
                    world.playSound(null, offsetPos, SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 0.8f, 1.0f);
                    entity.getPersistentData().putInt("NoirDarknessCooldown", 600);
                } else if (chance > 0.96) { 
                    world.playSound(null, offsetPos, SoundEvents.SKELETON_STEP, SoundSource.PLAYERS, 0.7f, 0.9f);
                }
            } 
            else if (sanity <= 25.0 && sanity > 0.0) {
                if (chance < 0.04) {
                    entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0, false, false));
                    entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false));
                    world.playSound(null, playerPos, SoundEvents.PLAYER_HURT, SoundSource.PLAYERS, 1.0f, 1.0f);
                } else if (chance > 0.93) {
                    world.playSound(null, offsetPos, SoundEvents.IRON_GOLEM_STEP, SoundSource.PLAYERS, 1.0f, 1.2f);
                }
            } 
            else if (sanity <= 0.0) {
                entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false));
                
                if (chance < 0.08) {
                    world.playSound(null, offsetPos, SoundEvents.WARDEN_HEARTBEAT, SoundSource.PLAYERS, 1.0f, 0.8f);
                } else if (chance > 0.88) {
                    world.playSound(null, offsetPos, SoundEvents.ENDERMAN_STARE, SoundSource.HOSTILE, 1.0f, 0.1f);
                }
            }
        } else {
            if (wasInNoir) {
                entity.getPersistentData().putBoolean("NoirEnteredDimension", false);
                entity.getPersistentData().putDouble("NoirSanity", 100.0);
                entity.getPersistentData().putInt("NoirDarknessCooldown", 0);
                entity.removeAllEffects();
            }
        }
    }
}