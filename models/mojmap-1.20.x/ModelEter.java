// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelEter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "eter"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightBoot;
	private final ModelPart LeftBoot;

	public ModelEter(ModelPart root) {
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
				CubeListBuilder.create().texOffs(0, 52)
						.addBox(4.0F, -8.5F, -4.6F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(-4.9F, -8.5F, -4.6F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.5F, -9.0F, -4.6F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-4.5F, 0.0F, -4.6F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(42, 77)
						.addBox(-4.5F, -8.5F, 3.9F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(21, 82).addBox(-9.0F, -4.0F, -0.3F, 9.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.9F, -4.8F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(69, 54).addBox(0.0F, -4.0F, -0.3F, 9.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.9F, -4.8F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(95, 80).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, -7.7F, 0.0F, 0.899F, -0.5148F, -0.0999F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(95, 73).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, -7.7F, 0.0F, 0.5499F, -0.5148F, -0.0999F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(91, 11).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, -7.7F, 0.0F, 0.899F, 0.5148F, 0.0999F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(90, 53).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, -7.7F, 0.0F, 0.5499F, 0.5148F, 0.0999F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(89, 30).addBox(-1.5F, -6.0F, -1.0F, 1.0F, 6.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, 0.0F, -1.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(78, 88).addBox(0.5F, -6.0F, -1.0F, 1.0F, 6.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 0.0F, -1.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-4.5F, 0.0F, -2.5F, 9.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(63, 77)
						.addBox(-3.0F, 1.1F, 2.5F, 6.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 11)
						.addBox(-4.5F, 12.0F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Body.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(81, 19).addBox(-0.5F, -3.0F, -3.0F, 2.0F, 4.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, 14.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r10 = Body
				.addOrReplaceChild("cube_r10",
						CubeListBuilder.create().texOffs(78, 77).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 4.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(4.5F, 14.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r11 = Body.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(98, 18)
						.addBox(1.8995F, -5.8995F, -5.7F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(21, 71)
						.addBox(0.8995F, -6.8995F, -5.5F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.9F, -1.4F, -0.4305F, -0.3953F, -0.6979F));

		PartDefinition cube_r12 = Body.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(26, 88).addBox(0.8995F, -6.8995F, -5.5F, 6.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.4F, 0.3F, -0.2916F, -0.2799F, -0.744F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(42, 64)
						.addBox(-3.5F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 52)
						.addBox(-4.0F, -2.9F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 41)
						.addBox(-4.5F, -3.1F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(69, 42)
						.addBox(-3.5F, 4.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r13 = RightArm.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(56, 91).addBox(0.0F, -2.0F, -3.0F, 1.0F, 4.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.9F, 9.0F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(65, 64)
						.addBox(-1.5F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(54, 19)
						.addBox(-2.0F, -2.9F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(31, 41)
						.addBox(-2.5F, -3.1F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 71)
						.addBox(-1.5F, 4.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r14 = LeftArm
				.addOrReplaceChild("cube_r14",
						CubeListBuilder.create().texOffs(91, 88).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(3.9F, 9.0F, 0.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(29, 22)
						.addBox(-3.6F, -0.9F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(89, 0)
						.addBox(-3.3F, 0.3F, -3.1F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 83)
						.addBox(-3.2F, -0.8F, 2.1F, 5.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 60)
						.addBox(-3.2F, -0.8F, -3.05F, 5.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition cube_r15 = RightLeg.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(0, 96).addBox(-3.6F, -3.0F, -3.5F, 5.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3F, 1.6F, -0.1F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(37, 0)
						.addBox(-2.4F, -0.9F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(90, 42)
						.addBox(-1.7F, 0.3F, -3.1F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 88)
						.addBox(-1.8F, -0.8F, 2.1F, 5.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 88)
						.addBox(-1.8F, -0.8F, -3.05F, 5.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r16 = LeftLeg.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(26, 97).addBox(-1.4F, -3.0F, -3.5F, 5.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3F, 1.6F, -0.1F, 0.0F, 0.0F, 0.3491F));

		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(62, 0)
						.addBox(-3.6F, 9.3F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(98, 24)
						.addBox(-3.1F, 8.3F, -4.0F, 4.5F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot",
				CubeListBuilder.create().texOffs(62, 31)
						.addBox(-2.4F, 9.3F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(91, 98)
						.addBox(-1.4F, 8.3F, -4.0F, 4.5F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
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