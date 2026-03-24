package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.init.NoirSmpModMobEffects;
import net.mcreator.noirsmp.NoirSmpMod;

public class EspagetificacaoOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		NoirSmpMod.queueServerWork(20, () -> {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						- (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(NoirSmpModMobEffects.ESPAGETIFICACAO.get()) ? _livEnt.getEffect(NoirSmpModMobEffects.ESPAGETIFICACAO.get()).getAmplifier() : 0));
		});
	}
}