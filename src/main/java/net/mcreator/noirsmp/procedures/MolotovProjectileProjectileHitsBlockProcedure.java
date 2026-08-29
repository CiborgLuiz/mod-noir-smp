package net.mcreator.noirsmp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

public class MolotovProjectileProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int radius = 4;
        RandomSource random = world.getRandom();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    
                    if (dx * dx + dy * dy + dz * dz <= radius * radius) {
                        
                        BlockPos targetPos = BlockPos.containing(x + dx, y + dy, z + dz);
                        
                        BlockPos belowPos = targetPos.below(); 
                        
                        BlockState targetBlock = world.getBlockState(targetPos);
                        BlockState belowBlock = world.getBlockState(belowPos);

                        if (random.nextFloat() < 0.7f) {
                            
                            boolean isTargetValid = targetBlock.isAir() || targetBlock.canBeReplaced();
                            
                            boolean hasFloor = !belowBlock.isAir() && !belowBlock.canBeReplaced();

                            if (isTargetValid && hasFloor) {
                                world.setBlock(targetPos, BaseFireBlock.getState(world, targetPos), 3);
                            }
                        }
                    }
                }
            }
        }
    }
}