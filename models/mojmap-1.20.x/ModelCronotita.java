// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCronotita<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "cronotita"), "main");
	private final ModelPart Head;
	private final ModelPart Horns_Animated;
	private final ModelPart Tiara_Separate;
	private final ModelPart left_blade;
	private final ModelPart right_blade;
	private final ModelPart Body;
	private final ModelPart Wings_Animated_R;
	private final ModelPart r;
	private final ModelPart Wings_Animated_L;
	private final ModelPart l;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightBoot;
	private final ModelPart LeftBoot;

	public ModelCronotita(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Horns_Animated = this.Head.getChild("Horns_Animated");
		this.Tiara_Separate = this.Head.getChild("Tiara_Separate");
		this.left_blade = this.Head.getChild("left_blade");
		this.right_blade = this.Head.getChild("right_blade");
		this.Body = root.getChild("Body");
		this.Wings_Animated_R = this.Body.getChild("Wings_Animated_R");
		this.r = this.Wings_Animated_R.getChild("r");
		this.Wings_Animated_L = this.Body.getChild("Wings_Animated_L");
		this.l = this.Wings_Animated_L.getChild("l");
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
				CubeListBuilder.create().texOffs(27, 73)
						.addBox(4.0F, -8.5F, -4.5F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 75)
						.addBox(-5.0F, -8.5F, -4.5F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(33, 38)
						.addBox(-4.5F, -9.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(91, 13)
						.addBox(-4.5F, -8.5F, 4.0F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(33, 49)
						.addBox(-4.5F, 0.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(96, 86)
						.addBox(1.7F, 1.5F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(106, 63)
						.addBox(-3.3F, -5.5F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.2F, -8.7F, -6.1F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(97, 40).addBox(-2.3F, -2.5F, 0.0F, 5.0F, 5.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.2F, -7.3F, -6.1F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Horns_Animated = Head.addOrReplaceChild("Horns_Animated", CubeListBuilder.create(),
				PartPose.offset(0.0F, -8.5F, 3.3F));

		PartDefinition cube_r3 = Horns_Animated.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(66, 102).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, 0.8F, -3.3F, 0.5499F, -0.5148F, -0.0999F));

		PartDefinition cube_r4 = Horns_Animated.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(13, 104).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, 0.8F, -3.3F, 0.899F, -0.5148F, -0.0999F));

		PartDefinition cube_r5 = Horns_Animated.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(106, 56).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, 4.8F, 0.7F, 0.6023F, 0.8616F, 0.5701F));

		PartDefinition cube_r6 = Horns_Animated.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(109, 77).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, 4.8F, 0.7F, 0.9514F, 0.8616F, 0.5701F));

		PartDefinition cube_r7 = Horns_Animated.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(26, 104).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, 4.8F, 0.7F, 0.6023F, -0.8616F, -0.5701F));

		PartDefinition cube_r8 = Horns_Animated.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(109, 71).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, 4.8F, 0.7F, 0.9514F, -0.8616F, -0.5701F));

		PartDefinition cube_r9 = Horns_Animated.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(53, 102).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, 0.8F, -3.3F, 0.899F, 0.5148F, 0.0999F));

		PartDefinition cube_r10 = Horns_Animated.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(97, 49).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, 0.8F, -3.3F, 0.5499F, 0.5148F, 0.0999F));

		PartDefinition cube_r11 = Horns_Animated.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(21, 75).addBox(2.5F, -3.4F, -1.3F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.6F, -4.3F, -9.1F, 0.1344F, -0.599F, 0.2999F));

		PartDefinition cube_r12 = Horns_Animated.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(79, 102).addBox(-0.4F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 0.5F, -6.1F, 0.435F, -0.0151F, 0.1739F));

		PartDefinition cube_r13 = Horns_Animated.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(21, 81).addBox(0.0613F, -7.5746F, -0.7393F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 0.5F, -7.1F, 0.1344F, 0.599F, -0.2999F));

		PartDefinition cube_r14 = Horns_Animated.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(109, 92).addBox(-1.6151F, -4.5786F, -0.0932F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 0.5F, -7.1F, 0.435F, 0.0151F, -0.1739F));

		PartDefinition Tiara_Separate = Head.addOrReplaceChild("Tiara_Separate",
				CubeListBuilder.create().texOffs(95, 33)
						.addBox(-4.5F, -8.0F, -2.1F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(96, 73)
						.addBox(4.5F, -8.0F, -2.1F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(97, 0)
						.addBox(-4.5F, -8.0F, -2.1F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -8.4F, 0.0F));

		PartDefinition left_blade = Head.addOrReplaceChild("left_blade", CubeListBuilder.create(),
				PartPose.offset(-5.0F, 0.0F, -2.25F));

		PartDefinition cube_r15 = left_blade.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(88, 100).addBox(-0.9F, -7.0F, -1.0F, 0.5F, 7.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -2.6F, 1.25F, 0.0F, -0.3491F, 0.0F));

		PartDefinition right_blade = Head.addOrReplaceChild("right_blade", CubeListBuilder.create(),
				PartPose.offset(5.0F, 0.0F, -2.25F));

		PartDefinition cube_r16 = right_blade.addOrReplaceChild(
				"cube_r16", CubeListBuilder.create().texOffs(101, 100).addBox(-0.4974F, -7.0F, 0.0036F, 0.5F, 7.0F,
						5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.6F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 38)
						.addBox(-5.0F, -1.0F, -3.0F, 10.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(21, 92)
						.addBox(-4.0F, -0.9F, -3.525F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 88)
						.addBox(-4.5F, 0.0F, 3.0F, 9.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r17 = Body.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(95, 24).addBox(0.8995F, -6.8995F, -5.5F, 6.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.3F, 0.6F, -0.1555F, -0.1536F, -0.7734F));

		PartDefinition cube_r18 = Body.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(69, 92)
						.addBox(0.8995F, -5.8995F, -4.9F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(110, 49)
						.addBox(1.8995F, -4.8995F, -5.1F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.8F, -1.1F, -0.2849F, -0.274F, -0.7459F));

		PartDefinition Wings_Animated_R = Body.addOrReplaceChild("Wings_Animated_R", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-5.0F, 0.0F, 3.6F, 0.0F, -2.618F, 0.0F));

		PartDefinition r = Wings_Animated_R.addOrReplaceChild("r", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-0.5F, 1.5F, 0.301F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r19 = r.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.2824F, -10.5F, -15.8375F, 0.0F, 21.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.0007F, 0.0F, 5.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Wings_Animated_L = Body.addOrReplaceChild("Wings_Animated_L", CubeListBuilder.create(),
				PartPose.offsetAndRotation(5.0F, 0.0F, 3.6F, 0.0F, 2.618F, 0.0F));

		PartDefinition l = Wings_Animated_L.addOrReplaceChild("l", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.5F, 1.5F, 0.301F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r20 = l.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(33, 0).addBox(0.2824F, -10.5F, -0.1625F, 0.0F, 21.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0007F, 0.0F, 0.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(75, 77)
						.addBox(-3.5F, -1.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 94)
						.addBox(-3.5F, 9.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-4.0F, -5.0F, -3.5F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(27, 60)
						.addBox(-4.5F, -4.0F, -4.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r21 = RightArm.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(13, 104).addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -1.2F, -1.0F, 0.9514F, -0.8616F, -0.1337F));

		PartDefinition cube_r22 = RightArm.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(66, 102).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -1.2F, -1.0F, 0.6023F, -0.8616F, -0.1337F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(85, 58)
						.addBox(-1.5F, -1.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(88, 92)
						.addBox(-1.5F, 9.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(58, 60)
						.addBox(-2.0F, -5.0F, -3.5F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(66, 0)
						.addBox(-2.5F, -4.0F, -4.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r23 = LeftArm.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(13, 104).mirror()
						.addBox(-0.5F, 0.8051F, 3.507F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5F, -1.2F, -1.0F, 0.9514F, 0.8616F, 0.1337F));

		PartDefinition cube_r24 = LeftArm.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(66, 102).mirror()
						.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5F, -1.2F, -1.0F, 0.6023F, 0.8616F, 0.1337F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(66, 13)
						.addBox(-3.6F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 102)
						.addBox(-3.3F, 0.3F, -3.1F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 102)
						.addBox(-3.3F, 0.3F, 2.2F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition cube_r25 = RightLeg.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(21, 81).mirror()
						.addBox(-1.0613F, -7.5746F, -0.7393F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-3.1F, 8.0F, -0.4F, -0.6583F, 0.5494F, -0.9659F));

		PartDefinition cube_r26 = RightLeg.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(109, 92).mirror()
						.addBox(-0.3849F, -4.5786F, -0.0932F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-3.1F, 8.0F, -0.4F, -0.8436F, 0.7522F, -1.679F));

		PartDefinition cube_r27 = RightLeg.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(66, 109)
						.addBox(-3.6F, -3.0F, -3.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(66, 109)
						.addBox(-3.6F, -3.0F, -9.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3F, 1.9F, 6.1F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(70, 30)
						.addBox(-2.4F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 102)
						.addBox(-1.8F, 0.3F, -3.1F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 102)
						.addBox(-1.8F, 0.3F, 2.2F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r28 = LeftLeg.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(21, 81).addBox(0.0613F, -7.5746F, -0.7393F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1F, 8.0F, -0.4F, -0.6583F, -0.5494F, 0.9659F));

		PartDefinition cube_r29 = LeftLeg.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(109, 92).addBox(-1.6151F, -4.5786F, -0.0932F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1F, 8.0F, -0.4F, -0.8436F, -0.7522F, 1.679F));

		PartDefinition cube_r30 = LeftLeg.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(53, 109)
						.addBox(-1.4F, -3.0F, -3.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 109)
						.addBox(-1.4F, -3.0F, -9.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3F, 1.9F, 6.1F, 0.0F, 0.0F, 0.3491F));

		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(70, 47)
						.addBox(-3.6F, 9.3F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(110, 0)
						.addBox(-3.1F, 8.8F, -4.0F, 4.5F, 3.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot",
				CubeListBuilder.create().texOffs(48, 77)
						.addBox(-2.4F, 9.3F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(110, 5)
						.addBox(-1.4F, 8.8F, -4.0F, 4.5F, 3.0F, 0.5F, new CubeDeformation(0.0F)),
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