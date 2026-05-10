// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 5.1.1 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class SingularisAnimation {
	public static final AnimationDefinition eyerotation = AnimationDefinition.Builder.withLength(3.0F).looping()
			.addAnimation("eye",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 360.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("eye",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5F, KeyframeAnimations.scaleVec(0.7F, 0.7F, 1.0F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5F, KeyframeAnimations.scaleVec(0.7F, 0.7F, 1.0F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.5F, KeyframeAnimations.scaleVec(0.7F, 0.7F, 1.0F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}