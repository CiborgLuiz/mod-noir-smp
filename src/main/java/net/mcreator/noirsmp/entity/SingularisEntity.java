package net.mcreator.noirsmp.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.noirsmp.procedures.SingularisOnEntityTickUpdateProcedure;
import net.mcreator.noirsmp.procedures.SingularisEntityDiesProcedure;
import net.mcreator.noirsmp.init.NoirSmpModEntities;

public class SingularisEntity extends PathfinderMob {
    public final AnimationState animationState0 = new AnimationState();

    public SingularisEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(NoirSmpModEntities.SINGULARIS.get(), world);
    }

    public SingularisEntity(EntityType<SingularisEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        SingularisEntityDiesProcedure.execute(this.level(), this);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        SingularisOnEntityTickUpdateProcedure.execute(this.level(), this);
        if (this.level().isClientSide()) {
            this.animationState0.animateWhen(true, this.tickCount);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 60.0);
        builder = builder.add(Attributes.ARMOR, 10.0);
        builder = builder.add(Attributes.FLYING_SPEED, 0.6);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32.0);
        return builder;
    }
}