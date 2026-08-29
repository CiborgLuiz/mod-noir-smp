package net.mcreator.noirsmp.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class CronotitaSwordItem extends SwordItem {
	public CronotitaSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 3164;
			}

			public float getSpeed() {
				return 18f;
			}

			public float getAttackDamageBonus() {
				return 22f;
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
		}, 3, -2f, new Item.Properties());
	}
}