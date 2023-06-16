package com.jetpacker06.codysmod.register;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.item.*;
import com.jetpacker06.codysmod.item.farming.CactusKnifeItem;
import com.jetpacker06.codysmod.item.farming.CocoaChopperItem;
import com.jetpacker06.codysmod.item.farming.FarmersHatchetItem;
import com.jetpacker06.codysmod.tag.AllTags;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodysMod.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private static  RegistryObject<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()/*.tab(Tab.CODYSMOD)*/));
    }

    public static final RegistryObject<Item> IRON_TACK_HAMMER = ITEMS.register("iron_tack_hammer", () ->
            new TackHammerItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(256)));
    public static final RegistryObject<Item> DIAMOND_TACK_HAMMER = ITEMS.register("diamond_tack_hammer", () ->
            new TackHammerItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(1024)));
    public static final RegistryObject<Item> CACTUS_KNIFE = ITEMS.register("cactus_knife", () ->
            new CactusKnifeItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_CACTUS_KNIFE,
                    new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(512)));
    public static final RegistryObject<Item> COCOA_CHOPPER = ITEMS.register("cocoa_chopper", () ->
            new CocoaChopperItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_COCOA_CHOPPER,
                    new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(512)));
    public static final RegistryObject<Item> FARMERS_HATCHET = ITEMS.register("farmers_hatchet", () ->
            new FarmersHatchetItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_FARMERS_HATCHET,
                    new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(512)));
    public static final RegistryObject<Item> TILLINATOR_3000 = ITEMS.register("tillinator_3000", () ->
            new Tillinator(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(1016), 3));
    public static final RegistryObject<Item> TILLINATOR_5000 = ITEMS.register("tillinator_5000", () ->
            new Tillinator(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(2032), 5));

    public static final RegistryObject<Item> NETHERITE_FISHING_ROD = ITEMS.register("netherite_fishing_rod", () ->
            new FishingRodItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(2032)));

    public static final RegistryObject<Item> DIAMOND_SHEARS = ITEMS.register("diamond_shears", () ->
            new ShearsItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(1016)));
    public static final RegistryObject<Item> NETHERITE_SHEARS = ITEMS.register("netherite_shears", () ->
            new ShearsItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).defaultDurability(2032)));

    public static final RegistryObject<Item> WARM_MILK = ITEMS.register("warm_milk", () ->
            new WarmMilkBucketItem(new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> COPPER_NUGGET = simpleItem("copper_nugget");
    public static final RegistryObject<Item> NETHERITE_NUGGET = simpleItem("netherite_nugget");

    public static final RegistryObject<Item> CAN = simpleItem("can");
    public static final RegistryObject<Item> PORK_AND_BEANS = ITEMS.register("pork_and_beans", () ->
            new FoodInContainerItem(
                    new Item.Properties()/*.tab(Tab.CODYSMOD)*/.stacksTo(16).food(ModFoods.PORK_AND_BEANS),
                    AllItems.CAN.get()
            ));
}