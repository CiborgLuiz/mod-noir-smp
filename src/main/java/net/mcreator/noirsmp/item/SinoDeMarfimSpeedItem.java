package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.noirsmp.procedures.SinoDeMarfimSpeedRightclickedProcedure;

import java.util.List;

public class SinoDeMarfimSpeedItem extends Item {
	public SinoDeMarfimSpeedItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.sino_de_marfim_speed.description_0"));
		list.add(Component.translatable("item.noir_smp.sino_de_marfim_speed.description_1"));
		list.add(Component.translatable("item.noir_smp.sino_de_marfim_speed.description_2"));
		list.add(Component.translatable("item.noir_smp.sino_de_marfim_speed.description_3"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SinoDeMarfimSpeedRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}