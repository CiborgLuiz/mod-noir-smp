package net.mcreator.noirsmp.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class LaminaDoArautoPlumiferoItem extends SwordItem {
	public LaminaDoArautoPlumiferoItem() {
		super(new Tier() {
			public int getUses() {
				return 2650;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 13f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.VINE));
			}
		}, 3, -2.5f, new Item.Properties());
	}
}