package com.jetpacker06.codysmod.register;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.item.Tab;
import com.jetpacker06.codysmod.item.TackHammerItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodysMod.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> IRON_TACK_HAMMER = ITEMS.register("iron_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).defaultDurability(256)));
    public static final RegistryObject<Item> DIAMOND_TACK_HAMMER = ITEMS.register("diamond_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).defaultDurability(1024)));
}
