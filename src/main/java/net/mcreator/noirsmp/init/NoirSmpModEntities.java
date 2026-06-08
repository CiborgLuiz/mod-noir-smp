/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.entity.*;
import net.mcreator.noirsmp.NoirSmpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NoirSmpModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NoirSmpMod.MODID);
	public static final RegistryObject<EntityType<MolotovProjectileEntity>> MOLOTOV_PROJECTILE = register("molotov_projectile", EntityType.Builder.<MolotovProjectileEntity>of(MolotovProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MolotovProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TijoloProjectileEntity>> TIJOLO_PROJECTILE = register("tijolo_projectile", EntityType.Builder.<TijoloProjectileEntity>of(TijoloProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TijoloProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MiniBuracoNegroEntity>> MINI_BURACO_NEGRO = register("mini_buraco_negro", EntityType.Builder.<MiniBuracoNegroEntity>of(MiniBuracoNegroEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MiniBuracoNegroEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlackHoleOfCalamityEntity>> BLACK_HOLE_OF_CALAMITY = register("black_hole_of_calamity", EntityType.Builder.<BlackHoleOfCalamityEntity>of(BlackHoleOfCalamityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(BlackHoleOfCalamityEntity::new).fireImmune().sized(1.8f, 0.5f));
	public static final RegistryObject<EntityType<LeviatanProjectileEntity>> LEVIATAN_PROJECTILE = register("leviatan_projectile", EntityType.Builder.<LeviatanProjectileEntity>of(LeviatanProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LeviatanProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 1f));
	public static final RegistryObject<EntityType<DoppelEntity>> DOPPEL = register("doppel",
			EntityType.Builder.<DoppelEntity>of(DoppelEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DoppelEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SingularisEntity>> SINGULARIS = register("singularis",
			EntityType.Builder.<SingularisEntity>of(SingularisEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SingularisEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<GalinhaInvertidaEntity>> GALINHA_INVERTIDA = register("galinha_invertida",
			EntityType.Builder.<GalinhaInvertidaEntity>of(GalinhaInvertidaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GalinhaInvertidaEntity::new)

					.sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<VacaInvertidaEntity>> VACA_INVERTIDA = register("vaca_invertida",
			EntityType.Builder.<VacaInvertidaEntity>of(VacaInvertidaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VacaInvertidaEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<RaposaInvertidaEntity>> RAPOSA_INVERTIDA = register("raposa_invertida",
			EntityType.Builder.<RaposaInvertidaEntity>of(RaposaInvertidaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RaposaInvertidaEntity::new)

					.sized(0.7f, 0.7f));
	public static final RegistryObject<EntityType<CabraInvertidaEntity>> CABRA_INVERTIDA = register("cabra_invertida",
			EntityType.Builder.<CabraInvertidaEntity>of(CabraInvertidaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CabraInvertidaEntity::new)

					.sized(0.9f, 0.9f));
	public static final RegistryObject<EntityType<PorcoInvertidoEntity>> PORCO_INVERTIDO = register("porco_invertido",
			EntityType.Builder.<PorcoInvertidoEntity>of(PorcoInvertidoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PorcoInvertidoEntity::new)

					.sized(0.9f, 0.9f));
	public static final RegistryObject<EntityType<ZumbiInvertidoEntity>> ZUMBI_INVERTIDO = register("zumbi_invertido",
			EntityType.Builder.<ZumbiInvertidoEntity>of(ZumbiInvertidoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZumbiInvertidoEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EsqueletoInvertidoEntity>> ESQUELETO_INVERTIDO = register("esqueleto_invertido",
			EntityType.Builder.<EsqueletoInvertidoEntity>of(EsqueletoInvertidoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EsqueletoInvertidoEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BlackHoleOfCalamityEntity.init();
			DoppelEntity.init();
			SingularisEntity.init();
			GalinhaInvertidaEntity.init();
			VacaInvertidaEntity.init();
			RaposaInvertidaEntity.init();
			CabraInvertidaEntity.init();
			PorcoInvertidoEntity.init();
			ZumbiInvertidoEntity.init();
			EsqueletoInvertidoEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BLACK_HOLE_OF_CALAMITY.get(), BlackHoleOfCalamityEntity.createAttributes().build());
		event.put(DOPPEL.get(), DoppelEntity.createAttributes().build());
		event.put(SINGULARIS.get(), SingularisEntity.createAttributes().build());
		event.put(GALINHA_INVERTIDA.get(), GalinhaInvertidaEntity.createAttributes().build());
		event.put(VACA_INVERTIDA.get(), VacaInvertidaEntity.createAttributes().build());
		event.put(RAPOSA_INVERTIDA.get(), RaposaInvertidaEntity.createAttributes().build());
		event.put(CABRA_INVERTIDA.get(), CabraInvertidaEntity.createAttributes().build());
		event.put(PORCO_INVERTIDO.get(), PorcoInvertidoEntity.createAttributes().build());
		event.put(ZUMBI_INVERTIDO.get(), ZumbiInvertidoEntity.createAttributes().build());
		event.put(ESQUELETO_INVERTIDO.get(), EsqueletoInvertidoEntity.createAttributes().build());
	}
}