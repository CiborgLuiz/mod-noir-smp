package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.RaposaInvertidaEntity;
import net.mcreator.noirsmp.client.model.Modelfox;

public class RaposaInvertidaRenderer extends MobRenderer<RaposaInvertidaEntity, Modelfox<RaposaInvertidaEntity>> {
	public RaposaInvertidaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfox<RaposaInvertidaEntity>(context.bakeLayer(Modelfox.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RaposaInvertidaEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/fox_inversa.png");
	}
}