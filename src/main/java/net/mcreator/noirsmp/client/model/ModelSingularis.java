package net.mcreator.noirsmp.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelSingularis<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("noir_smp", "model_singularis"), "main");
	public final ModelPart head;
	public final ModelPart eye;

	public ModelSingularis(ModelPart root) {
		this.head = root.getChild("head");
		this.eye = this.head.getChild("eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 35).addBox(1.7F, -7.4F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 35).addBox(0.7F, -8.4F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 35)
						.addBox(0.7F, -4.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 35).addBox(1.7F, -5.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 35)
						.addBox(-1.7F, -4.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 35).addBox(-2.7F, -5.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 35)
						.addBox(-2.7F, -7.4F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 35).addBox(-1.7F, -8.4F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -9.7F, -5.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 22).addBox(-3.0F, 1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 18)
				.addBox(-4.0F, -4.0F, -4.85F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(34, 30).addBox(1.0F, 1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.7F, 0.3F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(34, 18).addBox(-3.0F, -3.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 26).addBox(-3.0F, 1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.7F, 0.3F, 0.0F, 0.0F, 0.7854F));
		PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(34, 34).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.7F, 0.6F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}