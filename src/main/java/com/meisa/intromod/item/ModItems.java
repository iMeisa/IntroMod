package com.meisa.intromod.item;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> ARGON_CRYSTAL =
            Registration.ITEMS.register("argon_crystal",
                    () -> new Item(new Item.Properties().group(IntroMod.TAB_TENNO)));

    public static final RegistryObject<Item> VOID_ESSENCE =
            Registration.ITEMS.register("void_essence",
                    () -> new Item(new Item.Properties().group(IntroMod.TAB_TENNO)));

    public static final RegistryObject<Item> VOID_APPLE =
            Registration.ITEMS.register("void_apple",
                    VoidApple::new);


    public static void register() {}

}
