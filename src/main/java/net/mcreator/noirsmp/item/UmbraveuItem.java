package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.noirsmp.procedures.UmbraveuSlashLogicProcedure;

import java.util.List;

public class UmbraveuItem extends SwordItem {
	public UmbraveuItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 18f;
			}

			public float getAttackDamageBonus() {
				return 16f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 40;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -2f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		UmbraveuSlashLogicProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.umbraveu.description_0"));
		list.add(Component.translatable("item.noir_smp.umbraveu.description_1"));
		list.add(Component.translatable("item.noir_smp.umbraveu.description_2"));
		list.add(Component.translatable("item.noir_smp.umbraveu.description_3"));
		list.add(Component.translatable("item.noir_smp.umbraveu.description_4"));
		list.add(Component.translatable("item.noir_smp.umbraveu.description_5"));
	}
}