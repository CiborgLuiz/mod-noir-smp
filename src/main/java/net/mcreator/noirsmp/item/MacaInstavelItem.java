package net.mcreator.noirsmp.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class MacaInstavelItem extends Item {
	public MacaInstavelItem() {
		super(new Item.Properties().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(4).saturationMod(7f).build()));
	}
}