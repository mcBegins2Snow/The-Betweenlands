package thebetweenlands.common.world.biome.spawning.spawners;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import thebetweenlands.common.world.WorldProviderBetweenlands;
import thebetweenlands.common.world.biome.spawning.MobSpawnHandler.BLSpawnEntry;

/**
 * Makes entities spawn only spawn below cave level. 
 * Spawning weight gradually increases as the y value decreases. 
 * Spawning weight at bedrock level is baseWeight.
 * Mostly used for hostile entities.
 */
public class CaveSpawnEntry extends BLSpawnEntry {
	private boolean canSpawnOnWater = false;
	
	public CaveSpawnEntry(Class<? extends EntityLiving> entityType) {
		super(entityType);
	}

	public CaveSpawnEntry(Class<? extends EntityLiving> entityType, short baseWeight) {
		super(entityType, baseWeight);
	}
	
	public CaveSpawnEntry setCanSpawnOnWater(boolean spawnOnWater) {
		this.canSpawnOnWater = spawnOnWater;
		return this;
	}

	@Override
	public void update(World world, BlockPos pos) {
		int surfaceHeight = WorldProviderBetweenlands.CAVE_START;
		short spawnWeight = (short) (this.getBaseWeight() / 3);
		if(pos.getY() < surfaceHeight) {
			double percentage = 1.0D - ((double)(surfaceHeight - pos.getY()) / (double)surfaceHeight);
			spawnWeight = (short) MathHelper.ceiling_double_int(this.getBaseWeight() / (2.0D * percentage + 1.0D));
		} else {
			spawnWeight = 0;
		}
		this.setWeight(spawnWeight);
	}
	
	@Override
	public boolean canSpawn(World world, Chunk chunk, BlockPos pos, IBlockState spawnBlockState, IBlockState surfaceBlockState) {
		return surfaceBlockState.isNormalCube() || (this.canSpawnOnWater && surfaceBlockState.getMaterial().isLiquid());
	}
}