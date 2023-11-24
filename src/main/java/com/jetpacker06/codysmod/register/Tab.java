package com.jetpacker06.codysmod.register;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tab { /*
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
    } */
    public static CreativeModeTab CODYSMOD = new CreativeModeTab("CODYSMOD") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AllItems.VEGETABLE_STEW.get());
        }
    };
}
