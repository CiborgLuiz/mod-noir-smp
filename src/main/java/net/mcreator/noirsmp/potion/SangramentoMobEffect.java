package net.mcreator.noirsmp.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.noirsmp.procedures.SangramentoOnEffectActiveTickProcedure;

public class SangramentoMobEffect extends MobEffect {
	public SangramentoMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092544);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SangramentoOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}