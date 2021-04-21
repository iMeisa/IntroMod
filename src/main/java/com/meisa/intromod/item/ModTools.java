package com.meisa.intromod.item;

import com.meisa.intromod.IntroMod;
import com.meisa.intromod.util.Registration;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;

public class ModTools {

    public static final RegistryObject<Item> VOID_SWORD =
            Registration.ITEMS.register("void_sword",
                    () -> new SwordItem(ModItemTier.VOID, 0, 10f,
                            new Item.Properties().group(IntroMod.TAB_TENNO)));



    public static void register () {}

    public enum ModItemTier implements IItemTier {

        VOID(10, 1000000, 10, 100, 5,
                Ingredient.fromStacks(new ItemStack(ModItems.VOID_ESSENCE.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage,
                    int enchantibility, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantibility;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }
}
