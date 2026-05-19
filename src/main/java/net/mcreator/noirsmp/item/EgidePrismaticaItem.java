package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.noirsmp.procedures.EgidePrismaticaRightclickedProcedure;
import net.mcreator.noirsmp.procedures.EgidePrismaticaCooldownTickProcedureProcedure;

public class EgidePrismaticaItem extends ShieldItem {
	public EgidePrismaticaItem() {
		super(new Item.Properties().durability(3500).fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		EgidePrismaticaRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EgidePrismaticaCooldownTickProcedureProcedure.execute(entity);
	}
}