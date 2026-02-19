/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.noirsmp.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.noirsmp.entity.TIJOLOPROJETILEntity;
import net.mcreator.noirsmp.NoirSmpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NoirSmpModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NoirSmpMod.MODID);
	public static final RegistryObject<EntityType<TIJOLOPROJETILEntity>> TIJOLOPROJETIL = register("tijoloprojetil",
			EntityType.Builder.<TIJOLOPROJETILEntity>of(TIJOLOPROJETILEntity::new, MobCategory.MISC).setCustomClientFactory(TIJOLOPROJETILEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}