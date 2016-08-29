package thebetweenlands.common.world.biome;

import thebetweenlands.common.registries.BlockRegistry;
import thebetweenlands.common.world.WorldProviderBetweenlands;
import thebetweenlands.common.world.gen.biome.feature.FlatLandFeature;
import thebetweenlands.common.world.gen.biome.feature.PatchFeature;

public class BiomeSludgePlains extends BiomeBetweenlands {

	public BiomeSludgePlains() {
		super(new BiomeProperties("sludge_plains").setBaseHeight(110.0F).setHeightVariation(3F).setWaterColor(0x3A2F0B));
		//this.setWeight(5);
		this.getBiomeGenerator().setTopBlockState(BlockRegistry.MUD.getDefaultState()).setFillerBlockHeight(1)
		.addFeature(new FlatLandFeature(WorldProviderBetweenlands.LAYER_HEIGHT))
		.addFeature(new PatchFeature(0.03125D * 5.75D, 0.03125D * 5.75D, BlockRegistry.SLUDGY_DIRT.getDefaultState()))
		.addFeature(new PatchFeature(0.74D, 0.74D, BlockRegistry.SWAMP_DIRT.getDefaultState()))
		.addFeature(new PatchFeature(0.65D, 0.65D, BlockRegistry.MUD.getDefaultState(), 1.0D / 1.35D, 1.72D));
	}

}
