package com.meisa.intromod.block;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> ARGON_DEPOSIT = register("argon_deposit",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(5f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PACKED_VOID_ESSENCE = register("packed_void_essence",
            () -> new Block(AbstractBlock.Properties.create(Material.SNOW).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> REDWOOD_PLANK = register("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> REDWOOD_LOG = register("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> REDWOOD_LEAVES = register("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> REDWOOD_SAPLING = register("redwood_sapling",
            () -> new RedwoodSapling(
                    RedwoodTree::new, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)
            ));

    public static void register() {}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(IntroMod.TAB_TENNO)));

        return toReturn;
    }
}
