package com.jetpacker06.codysmod;

import com.jetpacker06.codysmod.events.CommonSetupTasks;
import com.jetpacker06.codysmod.potion.AllPotions;
import com.jetpacker06.codysmod.register.AllBlocks;
import com.jetpacker06.codysmod.register.AllItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CodysMod.MOD_ID)
public class CodysMod {

    public static final String MOD_ID = "codysmod";
    public static final Logger LOGGER = LogUtils.getLogger();
    public CodysMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetupTasks::onCommonSetup);
        AllBlocks.register(modEventBus);
        AllItems.register(modEventBus);
        AllPotions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Loaded " + MOD_ID);
    }
}