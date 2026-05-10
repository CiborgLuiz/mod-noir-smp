package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.noirsmp.procedures.DoppelMaskRightclickedProcedure;

public class DoppelMaskItem extends Item {
	public DoppelMaskItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		DoppelMaskRightclickedProcedure.execute(entity);
		return InteractionResultHolder.sidedSuccess(entity.getItemInHand(hand), world.isClientSide());
	}
}