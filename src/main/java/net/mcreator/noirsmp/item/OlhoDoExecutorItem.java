package net.mcreator.noirsmp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class OlhoDoExecutorItem extends Item {
	public OlhoDoExecutorItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_0"));
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_1"));
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_2"));
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_3"));
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_4"));
		list.add(Component.translatable("item.noir_smp.olho_do_executor.description_5"));
	}
}