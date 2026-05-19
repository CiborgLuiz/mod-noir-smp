package net.mcreator.noirsmp.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class AmuletoDaAgilidadeCuriosBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_SPEED))
			_livingEntity1.getAttribute(Attributes.ATTACK_SPEED)
					.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_SPEED) ? _livingEntity0.getAttribute(Attributes.ATTACK_SPEED).getBaseValue() : 0) - 1));
	}
}