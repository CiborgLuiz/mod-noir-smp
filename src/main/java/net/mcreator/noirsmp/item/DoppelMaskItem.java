package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.noirsmp.procedures.DoppelMaskRightclickedProcedure;

import java.util.List;

public class DoppelMaskItem extends Item {
	public DoppelMaskItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_0"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_1"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_2"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_3"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_4"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_5"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_6"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_7"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_8"));
		list.add(Component.translatable("item.noir_smp.doppel_mask.description_9"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		DoppelMaskRightclickedProcedure.execute(entity);
		return InteractionResultHolder.sidedSuccess(entity.getItemInHand(hand), world.isClientSide());
	}
}