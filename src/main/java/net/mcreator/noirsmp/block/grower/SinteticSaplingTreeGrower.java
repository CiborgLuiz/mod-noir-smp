package net.mcreator.noirsmp.block.grower;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.features.FeatureUtils;

public class SinteticSaplingTreeGrower extends AbstractTreeGrower {
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean hasFlower) {
		if (randomSource.nextFloat() < 0.4) {
			return FeatureUtils.createKey("noir_smp:campos_sinteticos_densos_tree");
		}
		return FeatureUtils.createKey("noir_smp:campos_sinteticos_tree");
	}
}