package net.mcreator.noirsmp.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.noirsmp.init.NoirSmpModEntities;

public class EsqueletoInvertidoEntity extends Monster implements RangedAttackMob {

	private int stamina = 200;
	private int staminaRecovery = 0;

	public EsqueletoInvertidoEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(NoirSmpModEntities.ESQUELETO_INVERTIDO.get(), world);
	}

	public EsqueletoInvertidoEntity(EntityType<EsqueletoInvertidoEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 30;
		setNoAi(false);

		this.setItemSlot(
				EquipmentSlot.MAINHAND,
				new ItemStack(Items.BOW));
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1,
				new RangedAttackGoal(this, 1.0D, 35, 70F));

		this.goalSelector.addGoal(2,
				new RandomStrollGoal(this, 0.8D));

		this.goalSelector.addGoal(3,
				new RandomLookAroundGoal(this));

		this.goalSelector.addGoal(4,
				new FloatGoal(this));

		this.targetSelector.addGoal(1,
				new HurtByTargetGoal(this));

		this.targetSelector.addGoal(2,
				new NearestAttackableTargetGoal<>(
						this,
						Player.class,
						true));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(
				new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(
				new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {

		if (damagesource.is(DamageTypes.FALL))
			return false;

		if (damagesource.getEntity() instanceof Player player) {

			ItemStack weapon = player.getMainHandItem();

			if (!weapon.is(ItemTags.create(
					new ResourceLocation(
							"forge",
							"dimensao000entidadesdano")))) {

				amount = 1.0F;
			}
		}

		return super.hurt(damagesource, amount);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {

		Arrow arrow = new Arrow(this.level(), this);

		double dx = target.getX() - this.getX();

		double dy =
				target.getY()
						+ target.getEyeHeight()
						- arrow.getY();

		double dz =
				target.getZ() - this.getZ();

		arrow.setBaseDamage(6);

		arrow.shoot(
				dx,
				dy + Math.sqrt(dx * dx + dz * dz) * 0.02D,
				dz,
				3.0F,
				1.0F);

		this.level().addFreshEntity(arrow);
	}

	@Override
	public boolean doHurtTarget(Entity entity) {

		boolean success = super.doHurtTarget(entity);

		if (success && entity instanceof LivingEntity target) {

			target.addEffect(new MobEffectInstance(
					MobEffects.MOVEMENT_SLOWDOWN,
					100,
					0,
					false,
					true));
		}

		return success;
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide()) {

			Player player =
					this.level().getNearestPlayer(this, 80);

			AttributeInstance speed =
					this.getAttribute(Attributes.MOVEMENT_SPEED);

			if (player != null) {

				this.getLookControl().setLookAt(
						player,
						60F,
						60F);

				double distance =
						this.distanceTo(player);

				if (distance < 14) {

					double dx =
							this.getX() - player.getX();

					double dz =
							this.getZ() - player.getZ();

					this.setDeltaMovement(
							dx * 0.10D,
							0,
							dz * 0.10D);

					stamina--;
					staminaRecovery = 0;

				} else {

					staminaRecovery++;

					if (staminaRecovery > 40) {
						stamina = Math.min(
								200,
								stamina + 2);
					}
				}

				if (speed != null) {

					if (stamina > 150) {

						speed.setBaseValue(0.38D);

					} else if (stamina > 100) {

						speed.setBaseValue(0.33D);

					} else if (stamina > 50) {

						speed.setBaseValue(0.28D);

					} else {

						speed.setBaseValue(0.22D);
					}
				}
			}
		}
	}

	public static void init() {
		SpawnPlacements.register(
				NoirSmpModEntities.ESQUELETO_INVERTIDO.get(),
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) ->

				(world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(
								world,
								pos,
								random)
						&& Mob.checkMobSpawnRules(
								entityType,
								world,
								reason,
								pos,
								random)));
	}

	public static AttributeSupplier.Builder createAttributes() {

		AttributeSupplier.Builder builder =
				Mob.createMobAttributes();

		builder = builder.add(
				Attributes.MOVEMENT_SPEED,
				0.30D);

		builder = builder.add(
				Attributes.MAX_HEALTH,
				80D);

		builder = builder.add(
				Attributes.ARMOR,
				8D);

		builder = builder.add(
				Attributes.ATTACK_DAMAGE,
				6D);

		builder = builder.add(
				Attributes.FOLLOW_RANGE,
				80D);

		builder = builder.add(
				Attributes.KNOCKBACK_RESISTANCE,
				0.6D);

		return builder;
	}
}