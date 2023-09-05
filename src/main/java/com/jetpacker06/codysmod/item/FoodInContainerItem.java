package com.jetpacker06.codysmod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FoodInContainerItem extends Item {

    private final Item containerItem;

    public FoodInContainerItem(Properties pProperties, Item containerItem) {
        super(pProperties);
        this.containerItem = containerItem;
    }

    public Item getContainerItem() {
        return this.containerItem;
    }

    /**
     * This method is copied from the BowlFoodItem class, but the item is replaced with this.getContainerItem()
     */
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(this.getContainerItem());
    }
}
