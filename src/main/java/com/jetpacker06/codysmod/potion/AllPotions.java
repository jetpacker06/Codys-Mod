package com.jetpacker06.codysmod.potion;

import com.jetpacker06.codysmod.CodysMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, CodysMod.MOD_ID);
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    public static final RegistryObject<Potion> HASTE = POTIONS.register("haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    public static final RegistryObject<Potion> LONG_HASTE = POTIONS.register("long_haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0)));
    public static final RegistryObject<Potion> STRONG_HASTE = POTIONS.register("strong_haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)));

    public static final RegistryObject<Potion> WITHER = POTIONS.register("wither", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, 3600, 0)));
    public static final RegistryObject<Potion> LONG_WITHER = POTIONS.register("long_wither", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, 9600, 0)));
    public static final RegistryObject<Potion> STRONG_WITHER = POTIONS.register("strong_wither", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, 1800, 1)));

    public static final RegistryObject<Potion> LUCK = POTIONS.register("luck", () ->
            new Potion(new MobEffectInstance(MobEffects.LUCK, 3600, 0)));
    public static final RegistryObject<Potion> LONG_LUCK = POTIONS.register("long_luck", () ->
            new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 0)));
    public static final RegistryObject<Potion> STRONG_LUCK = POTIONS.register("strong_luck", () ->
            new Potion(new MobEffectInstance(MobEffects.LUCK, 1800, 1)));

    public static final RegistryObject<Potion> NAUSEA = POTIONS.register("nausea", () ->
            new Potion(new MobEffectInstance(MobEffects.CONFUSION, 3600, 0)));
    public static final RegistryObject<Potion> LONG_NAUSEA = POTIONS.register("long_nausea", () ->
            new Potion(new MobEffectInstance(MobEffects.CONFUSION, 9600, 0)));
    public static final RegistryObject<Potion> STRONG_NAUSEA = POTIONS.register("strong_nausea", () ->
            new Potion(new MobEffectInstance(MobEffects.CONFUSION, 1800, 1)));

    public static final RegistryObject<Potion> GLOWING = POTIONS.register("glowing", () ->
            new Potion(new MobEffectInstance(MobEffects.GLOWING, 3600, 0)));
    public static final RegistryObject<Potion> LONG_GLOWING = POTIONS.register("long_glowing", () ->
            new Potion(new MobEffectInstance(MobEffects.GLOWING, 9600, 0)));
}
