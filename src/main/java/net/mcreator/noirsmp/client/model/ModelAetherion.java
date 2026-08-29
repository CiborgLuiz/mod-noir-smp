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
public class ModelAetherion<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("noir_smp", "model_aetherion"), "main");
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;
	public final ModelPart RightBoot;
	public final ModelPart LeftBoot;

	public ModelAetherion(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightBoot = root.getChild("RightBoot");
		this.LeftBoot = root.getChild("LeftBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(21, 83).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(56, 43).addBox(4.0F, -8.5F, -4.6F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-4.5F, 0.0F, -4.6F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 58).addBox(-4.9F, -8.5F, -4.6F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-4.5F, -9.0F, -4.6F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 77).addBox(-4.5F, -8.5F, 3.9F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(77, 56).addBox(-7.0F, -3.0F, -0.3F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.3F, -4.6F, 0.0F, 0.0F, 0.4363F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 23).addBox(0.0F, -3.0F, -0.3F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.3F, -4.6F, 0.0F, 0.0F, -0.4363F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 90).addBox(-1.5F, -4.166F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, -8.1F, 0.0F, 0.7416F, 0.096F, -0.9986F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(11, 88).addBox(-2.0F, -0.134F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, -8.1F, 0.0F, 0.4879F, -0.0264F, -0.7669F));
		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(21, 58).addBox(0.5F, -4.166F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, -8.0F, 0.0F, 0.7416F, -0.096F, 0.9986F));
		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(89, 15).addBox(0.0F, -0.134F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, -8.0F, 0.0F, 0.4879F, 0.0264F, 0.7669F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(68, 9).addBox(-4.5F, 0.0F, 2.5F, 9.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(59, 82).addBox(-4.0F, 2.0F, 3.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(78, 82)
						.addBox(-2.0F, 0.0F, 3.0F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -1.0F, -3.1F, 10.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 65)
						.addBox(-3.0F, 1.0F, -3.4F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(89, 9).addBox(-1.9F, 2.5F, -3.8F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(40, 80).addBox(-3.0F, -3.0F, -2.7F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, -1.1F, -0.3185F, 0.3035F, 0.7363F));
		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(27, 54).addBox(-3.8F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.9F, 10.7F, -0.2F, 0.0F, 0.0F, 0.3491F));
		PartDefinition cube_r9 = Body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(27, 43).addBox(-4.2F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9F, 10.7F, -0.2F, 0.0F, 0.0F, -0.3491F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(77, 40).addBox(-3.5F, -5.5F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(37, 28)
				.addBox(-4.0F, -4.0F, -3.5F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(33, 0).addBox(-4.5F, -5.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition cube_r10 = RightArm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(89, 82).addBox(-0.5F, -2.9F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(77, 48).addBox(-1.5F, -5.5F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 43)
				.addBox(-2.0F, -4.0F, -3.5F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(37, 14).addBox(-2.5F, -5.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition cube_r11 = LeftArm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(89, 87).addBox(-0.5F, -2.9F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(56, 62).addBox(-1.6F, -0.1F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(87, 23).addBox(-2.5F, 2.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition cube_r12 = RightLeg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(41, 90).addBox(-0.7F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9F, 5.0F, -0.5F, 0.0F, 0.0F, -0.5236F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(21, 65).addBox(-2.4F, -0.1F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 88).addBox(1.5F, 2.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition cube_r13 = LeftLeg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(46, 90).addBox(-0.3F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.9F, 5.0F, -0.5F, 0.0F, 0.0F, 0.5236F));
		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(75, 62).addBox(-2.6F, 9.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(75, 72).addBox(-2.4F, 9.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}