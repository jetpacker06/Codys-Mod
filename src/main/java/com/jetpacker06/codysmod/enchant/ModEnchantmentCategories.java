package com.jetpacker06.codysmod.enchant;

import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ModEnchantmentCategories {
    public static final EnchantmentCategory SHEARS = EnchantmentCategory.create("shears",
            (item) -> item instanceof ShearsItem
    );
}
