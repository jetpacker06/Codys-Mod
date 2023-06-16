package com.jetpacker06.codysmod.enchant;

import com.jetpacker06.codysmod.CodysMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllEnchantments {
    /* The Wool Fortune enchantment is currently disabled. */
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, CodysMod.MOD_ID);
    private static RegistryObject<Enchantment> register(String pIdentifier, Enchantment pEnchantment) {
        return ENCHANTMENTS.register(pIdentifier, () -> pEnchantment);
    }
    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

    public static final RegistryObject<Enchantment> WOOL_FORTUNE = register("wool_fortune", new WoolFortuneEnchantment(
            Enchantment.Rarity.RARE, ModEnchantmentCategories.SHEARS, EquipmentSlot.MAINHAND
    ));
}
