package com.jetpacker06.codysmod.tag;

import com.jetpacker06.codysmod.CodysMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AllTags {
    private static TagKey<Block> block(String pName) {
        return block(pName, false);
    }
    private static TagKey<Block> block(String pName, boolean forgeInsteadOfCodysMod) {
        if (forgeInsteadOfCodysMod) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", pName));
        }
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CodysMod.MOD_ID, pName));
    }
    private static TagKey<Item> item(String pName) {
        return item(pName, false);
    }
    private static TagKey<Item> item(String pName, boolean forgeInsteadOfCodysMod) {
        if (forgeInsteadOfCodysMod) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", pName));
        }
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CodysMod.MOD_ID, pName));
    }
/*--------------------------------------------------------------------------------------------------------------------*/
    public static final TagKey<Block> MINEABLE_WITH_CACTUS_KNIFE = block("mineable/cactus_knife");
    public static final TagKey<Block> MINEABLE_WITH_COCOA_CHOPPER = block("mineable/cocoa_chopper");
    public static final TagKey<Block> MINEABLE_WITH_FARMERS_HATCHET = block("mineable/farmers_hatchet");

    public static final TagKey<Block> TILLABLE = block("tillable");
/*--------------------------------------------------------------------------------------------------------------------*/

    public static final TagKey<Item> SHEARS = item("shears", true);
}
