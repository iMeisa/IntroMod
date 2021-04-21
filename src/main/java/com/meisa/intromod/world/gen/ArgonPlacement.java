package com.meisa.intromod.world.gen;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.HeightmapBasedPlacement;
import net.minecraft.world.gen.placement.NoPlacementConfig;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArgonPlacement extends HeightmapBasedPlacement<NoPlacementConfig> {
    public ArgonPlacement(Codec<NoPlacementConfig> codec) {
        super(codec);
    }

    protected Heightmap.Type func_241858_a(NoPlacementConfig config) {
        return Heightmap.Type.MOTION_BLOCKING;
    }

    public Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random rand, NoPlacementConfig config, BlockPos pos) {
        return IntStream.range(0, 16).mapToObj((count) -> {
            int i = count / 4;
            int j = count % 4;
            int k = i * 4 + 1 + rand.nextInt(3) + pos.getX();
            int l = j * 4 + 1 + rand.nextInt(3) + pos.getZ();
            int i1 = helper.func_242893_a(this.func_241858_a(config), k, l);
            return new BlockPos(k, i1, l);
        });
    }
}
