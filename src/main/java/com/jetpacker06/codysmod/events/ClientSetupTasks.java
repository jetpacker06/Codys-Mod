package com.jetpacker06.codysmod.events;

import com.jetpacker06.codysmod.register.AllBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientSetupTasks {
    public static void onClientSetup(final FMLCommonSetupEvent event) {
        registerRenderTypes(event);
    }

    @SuppressWarnings("removal")
    public static void registerRenderTypes(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.INVERTED_POWERED_RAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.POTTED_ROSE.get(), RenderType.cutout());
    }
}
