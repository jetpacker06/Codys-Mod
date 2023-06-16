package com.jetpacker06.codysmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CustomDoorBlock extends DoorBlock {
    public enum DoorMaterial {
        STONE,
        METAL,
        WOOD
    }
    private final boolean requiresRedstone;
    private final DoorMaterial doorMaterial;

    public CustomDoorBlock(Properties pProperties, BlockSetType blockSetType, boolean requiresRedstone, DoorMaterial doorMaterial) {
        super(pProperties, blockSetType);
        this.requiresRedstone = requiresRedstone;
        this.doorMaterial = doorMaterial;
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos,
                                          @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pBlockHitResult) {
        if (this.requiresRedstone)
            return InteractionResult.PASS;
        pState = pState.cycle(OPEN);
        pLevel.setBlock(pPos, pState, 10);
        pLevel.levelEvent(pPlayer, pState.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pPos, 0);
        pLevel.gameEvent(pPlayer, this.isOpen(pState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }
    public int getOpenSound() {
        return switch (this.doorMaterial) {
            case STONE, METAL -> 1005;
            case WOOD -> 1006;
        };
    }
    public int getCloseSound() {
        return switch (this.doorMaterial) {
            case STONE, METAL -> 1011;
            case WOOD -> 1012;
        };
    }
}
