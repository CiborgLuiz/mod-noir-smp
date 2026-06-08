package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.PorcoInvertidoEntity;
import net.mcreator.noirsmp.client.model.Modelpig;

public class PorcoInvertidoRenderer extends MobRenderer<PorcoInvertidoEntity, Modelpig<PorcoInvertidoEntity>> {
	public PorcoInvertidoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpig<PorcoInvertidoEntity>(context.bakeLayer(Modelpig.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PorcoInvertidoEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/pig_inversa.png");
	}
}