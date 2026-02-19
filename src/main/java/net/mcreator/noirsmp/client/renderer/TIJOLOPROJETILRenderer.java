package net.mcreator.noirsmp.client.renderer;

import com.mojang.math.Axis;

public class TIJOLOPROJETILRenderer extends EntityRenderer<TIJOLOPROJETILEntity> {

	private static final ResourceLocation texture = new ResourceLocation("noir_smp:textures/entities/tijolo.png");

	private final ModelTijoloProjetil model;

	public TIJOLOPROJETILRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelTijoloProjetil(context.bakeLayer(ModelTijoloProjetil.LAYER_LOCATION));
	}

	@Override
	public void render(TIJOLOPROJETILEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, entityIn.getYRot(), entityIn.getXRot());
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(TIJOLOPROJETILEntity entity) {
		return texture;
	}

}