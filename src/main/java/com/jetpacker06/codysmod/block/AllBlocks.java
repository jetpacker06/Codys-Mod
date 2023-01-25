package com.jetpacker06.codysmod.block;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.item.AllItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CodysMod.MODID);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        CodysMod.LOGGER.info("registered " + name);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        AllItems.ITEMS.register(
                name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    public static final RegistryObject<Block> BLACK_NETHER_BRICKS = registerBlock("black_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_BLACK_NETHER_BRICKS = registerBlock("chiseled_black_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_BLACK_NETHER_BRICKS = registerBlock("cracked_black_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS)));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_SLAB = registerBlock("black_nether_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_SLAB)));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_STAIRS = registerBlock("black_nether_brick_stairs", () ->
            new StairBlock(() -> BLACK_NETHER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_STAIRS)));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_FENCE = registerBlock("black_nether_brick_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}