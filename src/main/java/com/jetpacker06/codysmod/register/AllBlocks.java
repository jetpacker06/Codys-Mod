package com.jetpacker06.codysmod.register;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.block.CustomDoorBlock;
import com.jetpacker06.codysmod.block.ModBlockSetTypes;
import com.jetpacker06.codysmod.item.Tab;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CodysMod.MOD_ID);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        CodysMod.LOGGER.info("registered " + name);
        return toReturn;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        AllItems.ITEMS.register(
                name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static RegistryObject<Block> registerDoorBlock(String doorType, BlockSetType blockSetType, boolean requiresRedstone,
                                                           CustomDoorBlock.DoorMaterial doorMaterial, BlockBehaviour.Properties properties) {
        return registerBlock(doorType + "_door", () -> new CustomDoorBlock(properties, blockSetType, requiresRedstone, doorMaterial));
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
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_FENCE_GATE = registerBlock("black_nether_brick_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> NETHER_BRICK_FENCE_GATE = registerBlock("nether_brick_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));


    public static final RegistryObject<Block> GOLD_LANTERN = registerBlock("gold_lantern", () ->
            new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> GOLD_SOUL_LANTERN = registerBlock("gold_soul_lantern", () ->
            new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN)));
    public static final RegistryObject<Block> COPPER_LANTERN = registerBlock("copper_lantern", () ->
            new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> COPPER_SOUL_LANTERN = registerBlock("copper_soul_lantern", () ->
            new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN)));


    public static final RegistryObject<Block> GOLD_DOOR = registerDoorBlock("gold", BlockSetType.f_271208_, false,
            CustomDoorBlock.DoorMaterial.METAL, BlockBehaviour.Properties.copy(Blocks.IRON_DOOR).requiresCorrectToolForDrops());
    public static final RegistryObject<Block> COPPER_DOOR = registerDoorBlock("copper", ModBlockSetTypes.COPPER, false,
            CustomDoorBlock.DoorMaterial.METAL, BlockBehaviour.Properties.copy(Blocks.IRON_DOOR).requiresCorrectToolForDrops());
    public static final RegistryObject<Block> DEEPSLATE_DOOR = registerDoorBlock("deepslate", BlockSetType.f_271479_, false,
            CustomDoorBlock.DoorMaterial.STONE, BlockBehaviour.Properties.copy(Blocks.IRON_DOOR).requiresCorrectToolForDrops());


    public static final RegistryObject<Block> CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_MUD_BRICKS = registerBlock("cracked_mud_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS)));
    public static final RegistryObject<Block> CRACKED_PURPUR = registerBlock("cracked_purpur", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)));

    public static final RegistryObject<Block> ICE_BRICKS = registerBlock("ice_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> CRACKED_ICE_BRICKS = registerBlock("cracked_ice_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> ICE_BRICK_STAIRS = registerBlock("ice_brick_stairs", () ->
            new StairBlock(() -> ICE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> ICE_BRICK_WALL = registerBlock("ice_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
}