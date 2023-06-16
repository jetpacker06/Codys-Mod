package com.jetpacker06.codysmod.item;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.register.AllItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CodysMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Tab {
    public static CreativeModeTab CODYSMOD;// = new CreativeModeTab("CodysMod") {

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        CODYSMOD = event.registerCreativeModeTab(
                new ResourceLocation(CodysMod.MOD_ID, "codysmod_tab"),
                builder -> builder.icon(() -> new ItemStack(AllItems.CAN.get()))
                        .title(Component.translatable("itemGroup.CodysMod")).build()
        );
    }
}
