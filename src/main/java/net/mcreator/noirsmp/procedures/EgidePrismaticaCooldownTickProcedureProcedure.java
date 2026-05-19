package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class EgidePrismaticaCooldownTickProcedureProcedure {

	public static void execute(Entity entity) {
		if (entity == null)
			return;

		CompoundTag persistentData = entity.getPersistentData();

		if (persistentData.getDouble("egideCooldown") > 0) {

			persistentData.putDouble(
					"egideCooldown",
					persistentData.getDouble("egideCooldown") - 1
			);

			// MOSTRA O TEMPO NA ACTION BAR
			EgidePrismaticaCooldownDisplayProcedure.execute(entity);
		}
	}
}