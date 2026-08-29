package net.mcreator.noirsmp.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.noirsmp.init.NoirSmpModItems;

public class EterAxeItem extends AxeItem {
	public EterAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2444;
			}

			public float getSpeed() {
				return 16.5f;
			}

			public float getAttackDamageBonus() {
				return 25f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 35;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(NoirSmpModItems.ETER_DUST.get()));
			}
		}, 1, -2.8f, new Item.Properties());
	}
}