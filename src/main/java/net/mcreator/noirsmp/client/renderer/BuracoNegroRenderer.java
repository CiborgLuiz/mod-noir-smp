package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.BuracoNegroEntity;
import net.mcreator.noirsmp.client.model.Modelburaconegro;

import com.mojang.blaze3d.vertex.PoseStack;

public class BuracoNegroRenderer extends MobRenderer<BuracoNegroEntity, Modelburaconegro<BuracoNegroEntity>> {
	public BuracoNegroRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelburaconegro<BuracoNegroEntity>(context.bakeLayer(Modelburaconegro.LAYER_LOCATION)), 0f);
	}

	@Override
	protected void scale(BuracoNegroEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BuracoNegroEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/buraconegro.png");
	}
}