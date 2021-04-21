package com.meisa.intromod.world.gen;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = IntroMod.MOD_ID)
public class ModTreeGeneration {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        List<Supplier<ConfiguredFeature<?, ?>>> base = event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);


//        base.add(() -> Feature.TREE.withConfiguration(RedwoodTree.REDWOOD_TREE_CONFIG).withPlacement(Placement.DARK_OAK_TREE.configure(NoPlacementConfig.INSTANCE)));

//        BlockClusterFeatureConfig blockClusterFeatureConfig = (new BlockClusterFeatureConfig.Builder(
//                new SimpleBlockStateProvider(ModBlocks.ARGON_DEPOSIT.get().getDefaultState()),
//                new SimpleBlockPlacer()
//        )).build();
//        base.add(() -> Feature.RANDOM_PATCH.withConfiguration(blockClusterFeatureConfig).withPlacement(Placement.SPREAD_32_ABOVE.configure(NoPlacementConfig.INSTANCE)));

        BlockWithContextConfig blockWithContextConfig = new BlockWithContextConfig(
                ModBlocks.ARGON_DEPOSIT.get().getDefaultState(),
                new ArrayList<>(Arrays.asList(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.SAND.getDefaultState())),
                new ArrayList<>(Collections.singletonList(Blocks.AIR.getDefaultState())),
                new ArrayList<>(Collections.singletonList(Blocks.AIR.getDefaultState()))
        );
        ConfiguredPlacement<?> placement = ArgonPlacement.DARK_OAK_TREE.configure(NoPlacementConfig.INSTANCE);

        base.add(() -> Feature.SIMPLE_BLOCK.withConfiguration(blockWithContextConfig).withPlacement(placement));
    }
}
