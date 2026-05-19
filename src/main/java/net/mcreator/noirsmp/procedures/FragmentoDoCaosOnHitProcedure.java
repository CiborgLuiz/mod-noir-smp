package net.mcreator.noirsmp.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.noirsmp.init.NoirSmpModItems; 

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FragmentoDoCaosOnHitProcedure {
    
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
        execute(null, world, entity, sourceentity, amount);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
        if (entity == null || sourceentity == null) return;

        if (sourceentity instanceof LivingEntity attacker && entity instanceof LivingEntity target) {
            
            CuriosApi.getCuriosHelper().findFirstCurio(attacker, NoirSmpModItems.FRAGMENTO_DO_CAOS.get()).ifPresent(curio -> {
                RandomSource random = attacker.getRandom();

                if (random.nextFloat() <= 0.05f) {
                    if (event instanceof LivingHurtEvent hurtEvent) {
                        hurtEvent.setCanceled(true);
                        
                        target.hurt(new DamageSource(
                            world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, 
                                new ResourceLocation("noir_smp", "dano_anomalo"))), 
                            attacker
                        ), (float) (amount * 3.0));
                    }
                } else {
                    int roll = random.nextInt(5);
                    switch (roll) {
                        case 0 -> target.setSecondsOnFire(5);
                        case 1 -> {
                            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                            target.setTicksFrozen(140);
                        }
                        case 2 -> {
                            target.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), (float) (amount * 0.5));
                        }
                        case 3 -> target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
                        case 4 -> { 
                            target.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), (float) (amount * 0.5));
                        }
                    }
                }
            });
        }
    }
}