package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.EsqueletoInvertidoEntity;
import net.mcreator.noirsmp.client.model.Modelskeleton;

public class EsqueletoInvertidoRenderer extends MobRenderer<EsqueletoInvertidoEntity, Modelskeleton<EsqueletoInvertidoEntity>> {
	public EsqueletoInvertidoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton<EsqueletoInvertidoEntity>(context.bakeLayer(Modelskeleton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EsqueletoInvertidoEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/skeleton_inversa.png");
	}
}