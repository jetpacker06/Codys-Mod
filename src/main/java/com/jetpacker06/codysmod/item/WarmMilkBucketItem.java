package com.jetpacker06.codysmod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WarmMilkBucketItem extends MilkBucketItem {
    public WarmMilkBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pItemStack, @NotNull Level pLevel, @NotNull Entity pEntity,
                              int p_41407_, boolean p_41408_) {
        if (pLevel instanceof ClientLevel)
            return;
        CompoundTag tag = pItemStack.getTag();
        if (tag == null)
            tag = new CompoundTag();
        if (!tag.contains("Ticks"))
            tag.putInt("Ticks", 6001);
        int ticks = tag.getInt("Ticks") - 1;
        tag.putInt("Ticks", ticks);
        pItemStack.setTag(tag);
        if (ticks < 1) {
            ((ServerPlayer) pEntity).getInventory().setItem(p_41407_, new ItemStack(Items.MILK_BUCKET));
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pItemStack, @NotNull Level pLevel, @NotNull LivingEntity pEntity) {
        for (MobEffectInstance effectInstance : pEntity.getActiveEffects()) {
            if (!effectInstance.getEffect().isBeneficial())
                pEntity.removeEffect(effectInstance.getEffect());
        }
        return new ItemStack(Items.BUCKET);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pItemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.codysmod.warm_milk").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.translatable("tooltip.codysmod.press_shift").withStyle(ChatFormatting.YELLOW));
        }
        CompoundTag tag = pItemStack.getTag();
        if (tag == null)
            tag = new CompoundTag();
        if (!tag.contains("Ticks"))
            tag.putInt("Ticks", 6001);
        int ticks = tag.getInt("Ticks");
        int minutes = 0;
        int seconds = 0;
        while (ticks > 20) {
            seconds += 1;
            ticks-= 20;
            if (seconds % 60 == 0) {
                seconds = 0;
                minutes += 1;
            }
        }

        String clock = "Warmth will last " + minutes + ":";
        String toAdd = String.valueOf(seconds);
        if (toAdd.length() == 1) {
            toAdd = "0" + toAdd;
        }
        components.add(Component.literal(clock + toAdd));
    }
}
