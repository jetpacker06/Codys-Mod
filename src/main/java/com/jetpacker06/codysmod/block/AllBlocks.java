package com.jetpacker06.codysmod.block;

import com.jetpacker06.codysmod.CodysMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CodysMod.MODID);
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
