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

import net.mcreator.noirsmp.procedures.SingularisItemRightclickedProcedure;

import java.util.List;

public class SingularisItemItem extends Item {
	public SingularisItemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.noir_smp.singularis_item.description_0"));
		list.add(Component.translatable("item.noir_smp.singularis_item.description_1"));
		list.add(Component.translatable("item.noir_smp.singularis_item.description_2"));
		list.add(Component.translatable("item.noir_smp.singularis_item.description_3"));
		list.add(Component.translatable("item.noir_smp.singularis_item.description_4"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
    	InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
    	ItemStack itemstack = ar.getObject();
    
    	double x = entity.getX();
    	double y = entity.getY();
    	double z = entity.getZ();

    	SingularisItemRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
    
    	return ar;
	}
}