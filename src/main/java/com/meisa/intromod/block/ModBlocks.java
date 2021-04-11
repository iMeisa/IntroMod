package com.meisa.intromod.block;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> ARGON_DEPOSIT = register("argon_deposit",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL)
                    .strength(5f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PACKED_VOID_ESSENCE = register("packed_void_essence",
            () -> new Block(AbstractBlock.Properties.of(Material.SNOW)
                    .instabreak().sound(SoundType.WOOL)));

    public static void register() {}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(IntroMod.TAB_TENNO)));

        return toReturn;
    }
}
