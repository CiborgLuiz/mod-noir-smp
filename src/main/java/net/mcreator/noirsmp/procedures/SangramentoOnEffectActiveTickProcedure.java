package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.noirsmp.init.NoirSmpModParticleTypes;
import net.mcreator.noirsmp.init.NoirSmpModMobEffects;
import net.mcreator.noirsmp.NoirSmpMod;

public class SangramentoOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		NoirSmpMod.queueServerWork(20, () -> {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(NoirSmpModMobEffects.SANGRAMENTO.get()) ? _livEnt.getEffect(NoirSmpModMobEffects.SANGRAMENTO.get()).getAmplifier() : 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (NoirSmpModParticleTypes.SANGUE.get()), (x + Mth.nextDouble(RandomSource.create(), -1, 1) * 0.3), (y + Mth.nextDouble(RandomSource.create(), -1, 1) * 1),
						(z + Mth.nextDouble(RandomSource.create(), -1, 1) * 0.3), 2, 0.3, 1, 0.3, 1);
		});
	}
}