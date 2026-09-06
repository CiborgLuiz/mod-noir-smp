package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.noirsmp.procedures.EgidePrismaticaRightclickedProcedure;
import net.mcreator.noirsmp.procedures.EgidePrismaticaCooldownTickProcedureProcedure;

import java.util.List;

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
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_0"));
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_1"));
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_2"));
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_3"));
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_4"));
		list.add(Component.translatable("item.noir_smp.egide_prismatica.description_5"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EgidePrismaticaCooldownTickProcedureProcedure.execute(entity);
	}
}