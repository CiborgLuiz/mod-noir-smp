package net.mcreator.noirsmp.item;

public class LeviatanItem extends SwordItem {
	public LeviatanItem() {
		super(new Tier() {
			public int getUses() {
				return 3500;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 21f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -3.2f, new Item.Properties());
	}
}