package com.jetpacker06.codysmod.enchant;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ModEnchantmentHelper {
    public static int getWoolFortune(LivingEntity entity) {
        return EnchantmentHelper.getEnchantmentLevel(AllEnchantments.WOOL_FORTUNE.get(), entity);
    }
}
