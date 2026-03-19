package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.noirsmp.init.NoirSmpModMobEffects;

public class NinjatoLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(NoirSmpModMobEffects.SANGRAMENTO.get(), 80, 2));
	}
}