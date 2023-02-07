package com.jetpacker06.codysmod.tag;

import com.jetpacker06.codysmod.CodysMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class AllTags {
    private static TagKey<Block> create(String pName) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CodysMod.MOD_ID, pName));
    }

    public static final TagKey<Block> MINEABLE_WITH_CACTUS_KNIFE = create("mineable/cactus_knife");
    public static final TagKey<Block> MINEABLE_WITH_COCOA_CHOPPER = create("mineable/cocoa_chopper");
    public static final TagKey<Block> MINEABLE_WITH_FARMERS_HATCHET = create("mineable/farmers_hatchet");

    public static final TagKey<Block> TILLABLE = create("tillable");
}
