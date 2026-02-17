package net.mcreator.noirsmp.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class ManoplaDeSlimeLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (!(sourceentity instanceof Player _plrCldCheck0 && _plrCldCheck0.getCooldowns().isOnCooldown(NoirSmpModItems.MANOPLA_DE_SLIME.get()))) {
			particleAmount = 64;
			particleRadius = 1.5;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ITEM_SLIME, (x + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
						(z + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (int) particleAmount, particleRadius, particleRadius, particleRadius, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish")), SoundSource.PLAYERS, 10, 10);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish")), SoundSource.PLAYERS, 10, 10, false);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 45, false, false));
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(NoirSmpModItems.MANOPLA_DE_SLIME.get(), 200);
		}
	}
}