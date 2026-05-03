// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelancora<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ancora"), "main");
	private final ModelPart group2;
	private final ModelPart group3;
	private final ModelPart group;

	public Modelancora(ModelPart root) {
		this.group2 = root.getChild("group2");
		this.group3 = root.getChild("group3");
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group2 = partdefinition.addOrReplaceChild("group2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, -19.0F, 0.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-3.0F, 7.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 30)
						.addBox(1.0F, 3.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 30)
						.addBox(-4.0F, 3.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-3.0F, 2.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(0.0F, 6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(0.0F, 3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-3.0F, 3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-3.0F, 6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 13)
						.addBox(-2.0F, 7.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 13)
						.addBox(-2.0F, 7.0F, 2.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 31)
						.addBox(-2.0F, 15.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 5)
						.addBox(0.0F, 11.0F, 0.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 5)
						.addBox(-3.0F, 11.0F, 0.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(25, 31)
						.addBox(-2.0F, 11.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 0)
						.addBox(-6.0F, -27.0F, 0.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 10)
						.addBox(-5.0F, -28.6F, 0.0F, 8.0F, 1.6F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(8.7F, -24.9F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-12.6F, -25.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -1.0F));

		PartDefinition cube_r1 = group2.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(31, 20).addBox(-0.2F, -2.0F, -0.1F, 2.2F, 2.3F, 2.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.2F, -18.8F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = group2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(31, 20).addBox(-2.0F, -2.0F, -0.1F, 2.2F, 2.4F, 2.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.4F, -19.1F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r3 = group2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(9, 5).addBox(-5.0F, -2.7F, 0.0F, 8.0F, 2.5F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.9F, -24.7F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r4 = group2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(9, 5).addBox(-5.0F, -2.0F, 0.0F, 8.0F, 2.6F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -24.6F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r5 = group2.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(1, 38).addBox(-2.5F, -3.2F, 0.1F, 3.0F, 3.0F, 1.8F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -26.1F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition group3 = partdefinition.addOrReplaceChild("group3", CubeListBuilder.create(),
				PartPose.offset(5.0F, -3.9F, -2.1F));

		PartDefinition cube_r6 = group3.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(31, 25).addBox(-2.25F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.4F, 11.8F, -0.8F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r7 = group3
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(34, 1).addBox(-2.0F, -1.85F, 2.0F, 2.0F, 2.6F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(18, 21)
						.addBox(-1.1F, 19.5F, -0.6F, 3.1F, 2.0F, 3.1F, new CubeDeformation(0.0F)).texOffs(16, 35)
						.addBox(-0.9F, -2.5F, -0.4F, 2.8F, 13.0F, 2.8F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 1.5F, -1.0F));

		PartDefinition cube_r8 = group
				.addOrReplaceChild("cube_r8",
						CubeListBuilder.create().texOffs(18, 14).addBox(-2.5F, -3.2F, -0.5F, 3.0F, 3.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r9 = group
				.addOrReplaceChild("cube_r9",
						CubeListBuilder.create().texOffs(18, 14).addBox(-2.5F, -3.2F, -0.5F, 3.0F, 3.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		group3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}