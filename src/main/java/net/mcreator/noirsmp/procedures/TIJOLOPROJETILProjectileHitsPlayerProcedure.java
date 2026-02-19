package net.mcreator.noirsmp.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TIJOLOPROJETILProjectileHitsPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (_level.isClientSide()) {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noir_smp:tijoloacerto")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
	}
}