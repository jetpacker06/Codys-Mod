package com.jetpacker06.codysmod.events;

import com.jetpacker06.codysmod.potion.AllPotions;
import com.jetpacker06.codysmod.potion.ModPotionUtil;
import com.jetpacker06.codysmod.register.AllItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupTasks {
    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        registerCompostables(event);
        registerBrewingRecipes(event);
    }
    private static void registerCompostables(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(Items.POISONOUS_POTATO, 0.65f);
        });
    }
    private static void registerBrewingRecipes(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModPotionUtil.add3PotionRecipes(Potions.AWKWARD, AllPotions.HASTE.get(), AllPotions.LONG_HASTE.get(),
                    AllPotions.STRONG_HASTE.get(), Items.GLOW_BERRIES);
            ModPotionUtil.add3PotionRecipes(Potions.AWKWARD, AllPotions.WITHER.get(), AllPotions.LONG_WITHER.get(),
                    AllPotions.STRONG_WITHER.get(), AllItems.WITHER_ESSENCE.get());
            ModPotionUtil.add3PotionRecipes(Potions.AWKWARD, AllPotions.LUCK.get(), AllPotions.LONG_LUCK.get(),
                    AllPotions.STRONG_LUCK.get(), Items.EXPERIENCE_BOTTLE);
            ModPotionUtil.add3PotionRecipes(Potions.AWKWARD, AllPotions.NAUSEA.get(), AllPotions.LONG_NAUSEA.get(),
                    AllPotions.STRONG_NAUSEA.get(), Items.POISONOUS_POTATO);
            ModPotionUtil.addPotionAndLong(Potions.AWKWARD, AllPotions.GLOWING.get(), AllPotions.LONG_GLOWING.get(),
                    Items.GLOW_INK_SAC);
        });
    }
}
