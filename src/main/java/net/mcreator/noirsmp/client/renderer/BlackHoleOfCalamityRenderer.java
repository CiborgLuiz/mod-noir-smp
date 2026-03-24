package net.mcreator.noirsmp.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.noirsmp.entity.BlackHoleOfCalamityEntity;
import net.mcreator.noirsmp.client.model.animations.buraconegroAnimation;
import net.mcreator.noirsmp.client.model.Modelburaconegro;

import com.mojang.blaze3d.vertex.PoseStack;

public class BlackHoleOfCalamityRenderer extends MobRenderer<BlackHoleOfCalamityEntity, Modelburaconegro<BlackHoleOfCalamityEntity>> {
	public BlackHoleOfCalamityRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelburaconegro.LAYER_LOCATION)), 0f);
	}

	@Override
	protected void scale(BlackHoleOfCalamityEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(6f, 6f, 6f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackHoleOfCalamityEntity entity) {
		return new ResourceLocation("noir_smp:textures/entities/buraconegro.png");
	}

	private static final class AnimatedModel extends Modelburaconegro<BlackHoleOfCalamityEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BlackHoleOfCalamityEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BlackHoleOfCalamityEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, buraconegroAnimation.normal, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BlackHoleOfCalamityEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}