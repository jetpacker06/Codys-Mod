package com.jetpacker06.codysmod.register;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.item.Tab;
import com.jetpacker06.codysmod.item.TackHammerItem;
import com.jetpacker06.codysmod.item.WarmMilkBucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodysMod.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private static  RegistryObject<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Tab.CODYSMOD)));
    }

    public static final RegistryObject<Item> IRON_TACK_HAMMER = ITEMS.register("iron_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).defaultDurability(256)));
    public static final RegistryObject<Item> DIAMOND_TACK_HAMMER = ITEMS.register("diamond_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).defaultDurability(1024)));


    public static final RegistryObject<Item> NETHERITE_FISHING_ROD = ITEMS.register("netherite_fishing_rod", () ->
            new FishingRodItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).defaultDurability(2032)));

    public static final RegistryObject<Item> WARM_MILK = ITEMS.register("warm_milk", () ->
            new WarmMilkBucketItem(new Item.Properties().tab(Tab.CODYSMOD).stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> COPPER_NUGGET = simpleItem("copper_nugget");
    public static final RegistryObject<Item> NETHERITE_NUGGET = simpleItem("netherite_nugget");
}
