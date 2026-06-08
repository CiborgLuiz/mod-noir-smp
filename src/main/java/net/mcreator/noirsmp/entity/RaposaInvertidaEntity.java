package net.mcreator.noirsmp.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.noirsmp.init.NoirSmpModEntities;

public class RaposaInvertidaEntity extends Monster {
	public RaposaInvertidaEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(NoirSmpModEntities.RAPOSA_INVERTIDA.get(), world);
	}

	public RaposaInvertidaEntity(EntityType<RaposaInvertidaEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 8;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.0D, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});

		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

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
					new ResourceLocation("forge", "dimensao000entidadesdano")))) {

				amount = 1.0F;
			}
		}

		return super.hurt(damagesource, amount);
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide()) {

			Player nearestPlayer = this.level().getNearestPlayer(this, 40);

			if (nearestPlayer != null) {

				double distance = this.distanceTo(nearestPlayer);

				if (distance <= 12) {
					this.getAttribute(Attributes.MOVEMENT_SPEED)
							.setBaseValue(0.55D);
				} else {
					this.getAttribute(Attributes.MOVEMENT_SPEED)
							.setBaseValue(0.35D);
				}

				this.getLookControl().setLookAt(
						nearestPlayer,
						50.0F,
						50.0F);
			}
		}
	}

	public static void init() {
		SpawnPlacements.register(
				NoirSmpModEntities.RAPOSA_INVERTIDA.get(),
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) ->

				(world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(world, pos, random)
						&& Mob.checkMobSpawnRules(
								entityType,
								world,
								reason,
								pos,
								random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();

		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35D);
		builder = builder.add(Attributes.MAX_HEALTH, 25D);
		builder = builder.add(Attributes.ARMOR, 2D);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 9D);
		builder = builder.add(Attributes.FOLLOW_RANGE, 40D);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2D);

		return builder;
	}
}