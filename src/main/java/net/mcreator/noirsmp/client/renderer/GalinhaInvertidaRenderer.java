package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.noirsmp.entity.GalinhaInvertidaEntity;

public class GalinhaInvertidaRenderer extends MobRenderer<GalinhaInvertidaEntity, ChickenModel<GalinhaInvertidaEntity>> {
	public GalinhaInvertidaRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel<GalinhaInvertidaEntity>(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GalinhaInvertidaEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/chicken_inversa.png");
	}
}