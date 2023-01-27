package com.jetpacker06.codysmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TackHammerItem extends Item {
    public TackHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack outputStack = itemStack.copy();
        outputStack.setDamageValue(outputStack.getDamageValue() + 1);
        if (outputStack.getDamageValue() >= outputStack.getMaxDamage())
            outputStack = new ItemStack(Items.AIR);
        return outputStack;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}