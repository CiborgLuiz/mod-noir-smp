package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.VacaInvertidaEntity;
import net.mcreator.noirsmp.client.model.Modelcow;

public class VacaInvertidaRenderer extends MobRenderer<VacaInvertidaEntity, Modelcow<VacaInvertidaEntity>> {
	public VacaInvertidaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcow<VacaInvertidaEntity>(context.bakeLayer(Modelcow.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VacaInvertidaEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/cow_inversa.png");
	}
}