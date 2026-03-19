package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;

public class GravityYesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(false);
	}
}