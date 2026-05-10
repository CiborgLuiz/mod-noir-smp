package net.mcreator.noirsmp.entity;

import net.minecraftforge.network.PlayMessages;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModEntities;

public class DoppelEntity extends TamableAnimal {
	public DoppelEntity(EntityType<? extends DoppelEntity> type, Level level) {
		super(type, level);
		this.setTame(true);
		this.xpReward = 0;
		this.setNoAi(false);
		
		for (EquipmentSlot slot : EquipmentSlot.values()) {
			this.setDropChance(slot, 0.0F);
		}
	}

	public DoppelEntity(PlayMessages.SpawnEntity packet, Level level) {
		this(NoirSmpModEntities.DOPPEL.get(), level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			if (this.getOwner() instanceof Player owner) {
				for (EquipmentSlot slot : EquipmentSlot.values()) {
					ItemStack ownerItem = owner.getItemBySlot(slot);
					if (!ItemStack.matches(this.getItemBySlot(slot), ownerItem)) {
						this.setItemSlot(slot, ownerItem.copy());
						// Reforça que o item copiado tem 0% de chance de drop
						this.setDropChance(slot, 0.0F);
					}
				}
				if (owner.getItemBySlot(EquipmentSlot.HEAD).getItem() != NoirSmpModItems.DOPPEL_MASK.get()) {
					this.discard();
				}
			} else if (this.tickCount > 20) {
				this.discard();
			}
		}
	}

	@Override
	public void die(DamageSource cause) {
		super.die(cause);
		if (this.getOwner() instanceof Player owner) {
			owner.getCooldowns().addCooldown(NoirSmpModItems.DOPPEL_MASK.get(), 1200);
		}
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean hitByPlayer) {
		super.dropCustomDeathLoot(source, looting, hitByPlayer);
	}

	@Override
	protected void dropEquipment() {
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return null;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		return builder;
	}
}