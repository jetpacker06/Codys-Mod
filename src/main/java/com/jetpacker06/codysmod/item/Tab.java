package com.jetpacker06.codysmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class Tab {
    public static final CreativeModeTab CODYSMOD = new CreativeModeTab("CodysMod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.STONE);
        }
    };
}
