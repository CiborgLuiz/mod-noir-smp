package net.mcreator.noirsmp.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.noirsmp.entity.LeviatanProjectileEntity;
import net.mcreator.noirsmp.client.model.Modelancora;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class LeviatanProjectileRenderer extends EntityRenderer<LeviatanProjectileEntity> {

	private static final ResourceLocation texture = new ResourceLocation("noir_smp:textures/entities/ancoraentidade.png");
	private final Modelancora model;

	public LeviatanProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelancora(context.bakeLayer(Modelancora.LAYER_LOCATION));
	}

	@Override
	public void render(LeviatanProjectileEntity entity, float yaw, float partialTicks,
					   PoseStack poseStack, MultiBufferSource buffer, int light) {

		poseStack.pushPose();

		int shake = entity.getPersistentData().getInt("impact_shake");

		if (shake > 0) {

			float intensity = shake * 4.0f;
			float rot = (float)Math.sin((entity.tickCount + partialTicks) * 8) * intensity;

			poseStack.mulPose(Axis.ZP.rotationDegrees(rot));
			poseStack.mulPose(Axis.XP.rotationDegrees(rot * 0.5f));

			entity.getPersistentData().putInt("impact_shake", shake - 1);
		}

		int slow = entity.getPersistentData().getInt("slow_motion");

		if (slow > 0) {
			partialTicks *= 0.2f;
			entity.getPersistentData().putInt("slow_motion", slow - 1);
		}

		VertexConsumer vb = buffer.getBuffer(RenderType.entityCutout(texture));

		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

		model.renderToBuffer(poseStack, vb, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

		poseStack.popPose();

		super.render(entity, yaw, partialTicks, poseStack, buffer, light);
	}

	@Override
	public ResourceLocation getTextureLocation(LeviatanProjectileEntity entity) {
		return texture;
	}
}