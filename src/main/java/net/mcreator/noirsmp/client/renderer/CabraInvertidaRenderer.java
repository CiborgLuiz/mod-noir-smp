package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.CabraInvertidaEntity;
import net.mcreator.noirsmp.client.model.Modelgoat_inversa;

public class CabraInvertidaRenderer extends MobRenderer<CabraInvertidaEntity, Modelgoat_inversa<CabraInvertidaEntity>> {
	public CabraInvertidaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoat_inversa<CabraInvertidaEntity>(context.bakeLayer(Modelgoat_inversa.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CabraInvertidaEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/goat_inversa.png");
	}
}