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

import net.mcreator.noirsmp.procedures.ManoplaDaCalamidadeLivingEntityIsHitWithToolProcedure;

import java.util.List;

public class ManoplaDaCalamidadeItem extends SwordItem {
	public ManoplaDaCalamidadeItem() {
		super(new Tier() {
			public int getUses() {
				return 2534;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 7f;
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
		}, 3, -1.8f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ManoplaDaCalamidadeLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.manopla_da_calamidade.description_0"));
		list.add(Component.translatable("item.noir_smp.manopla_da_calamidade.description_1"));
		list.add(Component.translatable("item.noir_smp.manopla_da_calamidade.description_2"));
		list.add(Component.translatable("item.noir_smp.manopla_da_calamidade.description_3"));
	}
}