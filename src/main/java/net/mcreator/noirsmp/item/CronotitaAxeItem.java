package net.mcreator.noirsmp.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class CronotitaAxeItem extends AxeItem {
	public CronotitaAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 3164;
			}

			public float getSpeed() {
				return 18f;
			}

			public float getAttackDamageBonus() {
				return 28f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 40;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(NoirSmpModItems.CRONOTITA_INGOT.get()));
			}
		}, 1, -2.7f, new Item.Properties());
	}
}