package net.mcreator.noirsmp.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class SinoDeMarfimInvisibilityRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck0 && _plrCldCheck0.getCooldowns().isOnCooldown(NoirSmpModItems.SINO_DE_MARFIM_INVISIBILITY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 2, false, false));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(NoirSmpModItems.SINO_DE_MARFIM_INVISIBILITY.get(), 3000);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noir_smp:sininho")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noir_smp:sininho")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
	}
}