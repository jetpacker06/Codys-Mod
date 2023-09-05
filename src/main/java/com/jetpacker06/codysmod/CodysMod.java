package com.jetpacker06.codysmod;

import com.jetpacker06.codysmod.events.ClientSetupTasks;
import com.jetpacker06.codysmod.events.CommonSetupTasks;
import com.jetpacker06.codysmod.register.Tab;
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
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(CommonSetupTasks::onCommonSetup);
        eventBus.addListener(ClientSetupTasks::onClientSetup);
        AllBlocks.register(eventBus);
        AllItems.register(eventBus);
        AllPotions.register(eventBus);

        Tab.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Loaded " + MOD_ID);
    }
}