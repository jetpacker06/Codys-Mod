package com.jetpacker06.codysmod.register;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.register.AllItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class Tab {
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CodysMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> CODYSMOD;
    private static final ArrayList<RegistryObject<Item>> codysmodItems = new ArrayList<>();
    public static void add(RegistryObject<Item> item) {
        codysmodItems.add(item);
    }

    public static void register(IEventBus eventBus) {

        CODYSMOD = TAB_REGISTER.register("codysmod",
                () -> CreativeModeTab.builder()
                        .title(Component.translatable("tab.codysmod.codysmod"))
                        .icon(() -> new ItemStack(AllItems.VEGETABLE_STEW.get()))
                        .displayItems((b, output) -> {
                            for (RegistryObject<Item> item : codysmodItems) {
                                output.accept(item.get());
                            }
                        })
                        .build());
        TAB_REGISTER.register(eventBus);
    }
}
