package com.meisa.intromod.item;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class VoidApple extends Item {

    public VoidApple() {
        super(new Properties().tab(IntroMod.TAB_TENNO).food(new Food.Builder()
                .effect(() -> new EffectInstance(Effects.POISON, 60), 1f)
                .build()));
    }
}
