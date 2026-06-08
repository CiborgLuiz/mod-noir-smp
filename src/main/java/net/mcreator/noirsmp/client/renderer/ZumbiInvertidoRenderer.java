package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.noirsmp.entity.ZumbiInvertidoEntity;
import net.mcreator.noirsmp.client.model.Modelzombie;

public class ZumbiInvertidoRenderer extends MobRenderer<ZumbiInvertidoEntity, Modelzombie<ZumbiInvertidoEntity>> {
	public ZumbiInvertidoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie<ZumbiInvertidoEntity>(context.bakeLayer(Modelzombie.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZumbiInvertidoEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/zombie_inversa.png");
	}
}