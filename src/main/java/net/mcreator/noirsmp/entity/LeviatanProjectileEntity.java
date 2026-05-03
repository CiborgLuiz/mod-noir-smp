package net.mcreator.noirsmp.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;

import net.mcreator.noirsmp.init.NoirSmpModItems;
import net.mcreator.noirsmp.init.NoirSmpModEntities;
import net.mcreator.noirsmp.procedures.LeviatanProjectileWhileProjectileFlyingTickProcedure;

public class LeviatanProjectileEntity extends AbstractArrow implements ItemSupplier {

	public static final ItemStack PROJECTILE_ITEM = new ItemStack(NoirSmpModItems.LEVIATAN.get());

	public LeviatanProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(NoirSmpModEntities.LEVIATAN_PROJECTILE.get(), world);
		setup();
	}

	public LeviatanProjectileEntity(EntityType<? extends LeviatanProjectileEntity> type, Level world) {
		super(type, world);
		setup();
	}

	public LeviatanProjectileEntity(EntityType<? extends LeviatanProjectileEntity> type, LivingEntity shooter, Level world) {
		super(type, shooter, world);
		setup();
	}

	private void setup() {
		this.setBaseDamage(0);
		this.setKnockback(0);
		this.pickup = Pickup.DISALLOWED;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	public void onHitEntity(EntityHitResult result) {
		Entity target = result.getEntity();
		if (target == null || target == this.getOwner())
			return;

		this.getPersistentData().putBoolean("hooked", true);
		this.getPersistentData().putString("hook_type", "entity");
		this.getPersistentData().putString("target_uuid", target.getStringUUID());

		this.getPersistentData().putBoolean("impact", true);
		this.getPersistentData().putInt("impact_time", 5);
		this.getPersistentData().putBoolean("chain_sound", true);

		this.setDeltaMovement(Vec3.ZERO);
		this.setNoGravity(true);
	}

	@Override
	public void onHitBlock(BlockHitResult result) {
		Vec3 hit = result.getLocation();

		this.getPersistentData().putBoolean("hooked", true);
		this.getPersistentData().putString("hook_type", "block");

		this.getPersistentData().putBoolean("impact", true);
		this.getPersistentData().putInt("impact_time", 5);
		this.getPersistentData().putBoolean("chain_sound", true);

		this.teleportTo(hit.x, hit.y, hit.z);
		this.setDeltaMovement(Vec3.ZERO);
		this.setNoGravity(true);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getPersistentData().getBoolean("chain_sound")) {
			if (this.tickCount % 6 == 0) {
				this.level().playSound(
					null,
					this.getX(), this.getY(), this.getZ(),
					ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noir_smp:correntes")),
					SoundSource.PLAYERS,
					0.6f,
					1.0f
				);
			}
		}

		LeviatanProjectileWhileProjectileFlyingTickProcedure.execute(
			this.level(),
			this.getX(),
			this.getY(),
			this.getZ(),
			this
		);
	}

	public static LeviatanProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		LeviatanProjectileEntity projectile = new LeviatanProjectileEntity(NoirSmpModEntities.LEVIATAN_PROJECTILE.get(), entity, world);

		projectile.shoot(
			entity.getViewVector(1).x,
			entity.getViewVector(1).y,
			entity.getViewVector(1).z,
			power * 2,
			0
		);

		world.addFreshEntity(projectile);
		return projectile;
	}
}