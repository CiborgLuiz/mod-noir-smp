package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

import net.mcreator.noirsmp.entity.SingularisEntity;
import net.mcreator.noirsmp.client.model.ModelSingularis;

public class SingularisRenderer extends MobRenderer<SingularisEntity, ModelSingularis<SingularisEntity>> {
	public SingularisRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSingularis(context.bakeLayer(ModelSingularis.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(SingularisEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/singularis.png");
	}

	@Override
	public void setupRotations(SingularisEntity entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTicks) {
		super.setupRotations(entity, poseStack, ageInTicks, rotationYaw, partialTicks);
		
		float pitch = entity.getViewXRot(partialTicks);
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
	}
}