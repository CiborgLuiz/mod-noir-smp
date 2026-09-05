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

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelCustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("noir_smp", "model_custom_model"), "main");
	public final ModelPart Head;

	public ModelCustomModel(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(23, 21).addBox(-3.5F, -9.3F, -5.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 24).addBox(1.5F, -9.3F, -5.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 18)
						.addBox(-1.5F, -8.8F, -5.1F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 12).addBox(-5.0F, -4.9732F, 4.1388F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 24)
						.addBox(-5.0F, -8.8F, -5.1F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 24).addBox(3.0F, -8.8F, -5.1F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 15)
						.addBox(0.0F, -4.9732F, 4.1388F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 0).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-11.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -7.4934F, -3.5588F, -0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}