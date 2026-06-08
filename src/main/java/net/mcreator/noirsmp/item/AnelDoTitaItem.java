package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AnelDoTitaItem extends Item {
	public AnelDoTitaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.anel_do_tita.description_0"));
		list.add(Component.translatable("item.noir_smp.anel_do_tita.description_1"));
		list.add(Component.translatable("item.noir_smp.anel_do_tita.description_2"));
		list.add(Component.translatable("item.noir_smp.anel_do_tita.description_3"));
		list.add(Component.translatable("item.noir_smp.anel_do_tita.description_4"));
	}
}