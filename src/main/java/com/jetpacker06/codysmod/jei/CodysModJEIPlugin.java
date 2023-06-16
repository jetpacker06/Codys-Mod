package com.jetpacker06.codysmod.jei;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.potion.AllPotions;
import com.jetpacker06.codysmod.register.AllItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
@SuppressWarnings("unused")
public class CodysModJEIPlugin implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(CodysMod.MOD_ID, "jei_plugin");
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    public static void addPotionInformation(IRecipeRegistration reg, Potion potion, String translationKey) {
        reg.addItemStackInfo(PotionUtils.setPotion(new ItemStack(Items.POTION), potion),
                Component.translatable(translationKey));
    }
    @Override
    public void registerRecipes(@NotNull IRecipeRegistration reg) {
        addPotionInformation(reg, AllPotions.GLOWING.get(), "codysmod.glowing_potion_information");
        addPotionInformation(reg, AllPotions.LONG_GLOWING.get(), "codysmod.glowing_potion_information");

        addPotionInformation(reg, AllPotions.LUCK.get(), "codysmod.luck_potion_recipe_information");
        addPotionInformation(reg, AllPotions.STRONG_LUCK.get(), "codysmod.luck_potion_recipe_information");
        addPotionInformation(reg, AllPotions.LONG_LUCK.get(), "codysmod.luck_potion_recipe_information");

        addPotionInformation(reg, AllPotions.HASTE.get(), "codysmod.haste_potion_recipe_information");
        addPotionInformation(reg, AllPotions.STRONG_HASTE.get(), "codysmod.haste_potion_recipe_information");
        addPotionInformation(reg, AllPotions.LONG_HASTE.get(), "codysmod.haste_potion_recipe_information");

        addPotionInformation(reg, AllPotions.NAUSEA.get(), "codysmod.nausea_potion_recipe_information");
        addPotionInformation(reg, AllPotions.STRONG_NAUSEA.get(), "codysmod.nausea_potion_recipe_information");
        addPotionInformation(reg, AllPotions.LONG_NAUSEA.get(), "codysmod.nausea_potion_recipe_information");

        addPotionInformation(reg, AllPotions.WITHER.get(), "codysmod.wither_potion_recipe_information");
        addPotionInformation(reg, AllPotions.STRONG_WITHER.get(), "codysmod.wither_potion_recipe_information");
        addPotionInformation(reg, AllPotions.LONG_WITHER.get(), "codysmod.wither_potion_recipe_information");

        reg.addItemStackInfo(new ItemStack(AllItems.IRON_TACK_HAMMER.get()), Component.translatable("tooltip.codysmod.tack_hammer"));
        reg.addItemStackInfo(new ItemStack(AllItems.DIAMOND_TACK_HAMMER.get()), Component.translatable("tooltip.codysmod.tack_hammer"));
        reg.addItemStackInfo(new ItemStack(AllItems.CACTUS_KNIFE.get()), Component.translatable("tooltip.codysmod.cactus_knife"));
        reg.addItemStackInfo(new ItemStack(AllItems.COCOA_CHOPPER.get()), Component.translatable("tooltip.codysmod.cocoa_chopper"));
        reg.addItemStackInfo(new ItemStack(AllItems.FARMERS_HATCHET.get()), Component.translatable("tooltip.codysmod.farmers_hatchet"));
    }
}