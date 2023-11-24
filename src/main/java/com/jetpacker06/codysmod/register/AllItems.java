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

import java.util.function.Supplier;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodysMod.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private static RegistryObject<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Tab.CODYSMOD)));
    }
    private static <I extends Item> RegistryObject<Item> register(String name, Supplier<? extends I> supplier) {
        return ITEMS.register(name, supplier);
    }

    public static final RegistryObject<Item> IRON_TACK_HAMMER = register("iron_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().stacksTo(1).defaultDurability(256).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> DIAMOND_TACK_HAMMER = register("diamond_tack_hammer", () ->
            new TackHammerItem(new Item.Properties().stacksTo(1).defaultDurability(1024).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> CACTUS_KNIFE = register("cactus_knife", () ->
            new CactusKnifeItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_CACTUS_KNIFE,
                    new Item.Properties().stacksTo(1).defaultDurability(512).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> COCOA_CHOPPER = register("cocoa_chopper", () ->
            new CocoaChopperItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_COCOA_CHOPPER,
                    new Item.Properties().stacksTo(1).defaultDurability(512).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> FARMERS_HATCHET = register("farmers_hatchet", () ->
            new FarmersHatchetItem(0, 0, Tiers.IRON, AllTags.MINEABLE_WITH_FARMERS_HATCHET,
                    new Item.Properties().stacksTo(1).defaultDurability(512).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> TILLINATOR_3000 = register("tillinator_3000", () ->
            new Tillinator(new Item.Properties().stacksTo(1).defaultDurability(1016).tab(Tab.CODYSMOD), 3));
    public static final RegistryObject<Item> TILLINATOR_5000 = register("tillinator_5000", () ->
            new Tillinator(new Item.Properties().stacksTo(1).defaultDurability(2032).tab(Tab.CODYSMOD), 5));

    public static final RegistryObject<Item> NETHERITE_FISHING_ROD = register("netherite_fishing_rod", () ->
            new FishingRodItem(new Item.Properties().stacksTo(1).defaultDurability(2032).tab(Tab.CODYSMOD)));

    public static final RegistryObject<Item> DIAMOND_SHEARS = register("diamond_shears", () ->
            new ShearsItem(new Item.Properties().stacksTo(1).defaultDurability(1016).tab(Tab.CODYSMOD)));
    public static final RegistryObject<Item> NETHERITE_SHEARS = register("netherite_shears", () ->
            new ShearsItem(new Item.Properties().stacksTo(1).defaultDurability(2032).tab(Tab.CODYSMOD)));

    public static final RegistryObject<Item> WARM_MILK = register("warm_milk", () ->
            new WarmMilkBucketItem(new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(Tab.CODYSMOD)));

    public static final RegistryObject<Item> COPPER_NUGGET = simpleItem("copper_nugget");
    public static final RegistryObject<Item> NETHERITE_NUGGET = simpleItem("netherite_nugget");
    public static final RegistryObject<Item> WITHER_ESSENCE = simpleItem("wither_essence");

    public static final RegistryObject<Item> VEGETABLE_STEW = register("vegetable_stew", () ->
            new FoodInContainerItem(
                    new Item.Properties().stacksTo(16).food(ModFoods.VEGETABLE_STEW).tab(Tab.CODYSMOD),
                    Items.BOWL
            ));
}