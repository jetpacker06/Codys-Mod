package com.jetpacker06.codysmod.potion;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModPotionUtil {
    public static void addPotionAndLong(Potion potionIngredient, Potion output, Potion outputLong,
                                         Item itemIngredient) {
        BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe(potionIngredient, itemIngredient, output));
        BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe(output, Items.REDSTONE, outputLong));
    }
    public static void add3PotionRecipes(Potion potionIngredient, Potion output, Potion outputLong, Potion outputStrong,
                                         Item itemIngredient) {
        addPotionAndLong(potionIngredient, output, outputLong, itemIngredient);
        BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe(output, Items.GLOWSTONE_DUST, outputStrong));
    }
}
