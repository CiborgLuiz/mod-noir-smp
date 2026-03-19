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

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelburaconegro<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("noir_smp", "modelburaconegro"), "main");
	public final ModelPart bone2;
	public final ModelPart group;
	public final ModelPart group4;
	public final ModelPart group3;
	public final ModelPart group2;
	public final ModelPart bone;
	public final ModelPart bone3;

	public Modelburaconegro(ModelPart root) {
		this.bone2 = root.getChild("bone2");
		this.group = this.bone2.getChild("group");
		this.group4 = this.bone2.getChild("group4");
		this.group3 = this.bone2.getChild("group3");
		this.group2 = this.bone2.getChild("group2");
		this.bone = this.bone2.getChild("bone");
		this.bone3 = this.bone2.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(1.0F, 11.6F, -1.0F));
		PartDefinition group = bone2.addOrReplaceChild("group", CubeListBuilder.create().texOffs(34, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6F, 8.4F, 1.0F));
		PartDefinition group4 = bone2.addOrReplaceChild("group4", CubeListBuilder.create().texOffs(34, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 8.4F, 1.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition group3 = bone2.addOrReplaceChild("group3", CubeListBuilder.create().texOffs(34, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 8.4F, 1.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition group2 = bone2.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(34, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 8.4F, 1.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(13, 55).addBox(-13.0F, 2.0F, -13.1F, 26.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6F, 6.4F, 1.0F));
		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(13, 55).addBox(-13.0F, 2.0F, -13.1F, 26.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6F, 6.4F, 1.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}