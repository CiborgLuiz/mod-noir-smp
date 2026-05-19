package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

public class EgidePrismaticaCooldownDisplayProcedure {

	public static void execute(Entity entity) {
		if (entity == null)
			return;

		CompoundTag persistentData = entity.getPersistentData();

		double cooldown = persistentData.getDouble("egideCooldown");

		if (cooldown > 0) {

			// CONVERTE TICKS PRA SEGUNDOS
			double seconds = cooldown / 20.0;

			// ARREDONDA PRA 1 CASA DECIMAL
			String formatted = String.format("%.1f", seconds);

			if (entity instanceof Player player && !player.level().isClientSide()) {

				player.displayClientMessage(
					Component.literal(
						"§1§lÉgide Prismática: "
						+ (cooldown > 200 ? "§c" : cooldown > 100 ? "§e" : "§a")
						+ formatted + "s"
					),
					true
				);
			}
		}
	}
}