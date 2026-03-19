package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.Entity;

public class GravityNoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
	}
}