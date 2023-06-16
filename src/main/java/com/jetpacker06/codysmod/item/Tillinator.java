package com.jetpacker06.codysmod.item;

import com.jetpacker06.codysmod.tag.AllTags;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class Tillinator extends Item implements Vanishable {
    private final int radius;

    public Tillinator(Properties pProperties, int radius) {
        super(pProperties);
        if (radius % 2 == 0) {
            throw new IllegalArgumentException("Radius must be odd.");
        }
        this.radius = radius;
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        if (pContext.getLevel() instanceof ClientLevel) {
            return InteractionResult.PASS;
        }
        ServerLevel pLevel = (ServerLevel) pContext.getLevel();
        Block clickedBlock = pLevel.getBlockState(pContext.getClickedPos()).getBlock();
        if (!(clickedBlock.defaultBlockState().is(AllTags.TILLABLE) || clickedBlock.defaultBlockState().is(Blocks.FARMLAND))) {
            return InteractionResult.PASS;
        }
        BlockPos pos = pContext.getClickedPos().north((this.radius - 1) / 2).east((this.radius - 1) / 2);

        int blocksTilled = 0;
        for (int i=0;i<radius;i++) {
            for (int j=0;j<radius;j++) {
                if (pLevel.getBlockState(pos).is(AllTags.TILLABLE)) {
                    pLevel.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 2);
                    blocksTilled++;
                }
                pos = pos.west();
            }
            pos = pos.south().east(this.radius);
        }
        if (pContext.getPlayer() == null) {
            return InteractionResult.SUCCESS;
        }
        if (pContext.getPlayer().isCreative()) {
            return InteractionResult.SUCCESS;
        }
        pContext.getItemInHand().hurtAndBreak(blocksTilled, pContext.getPlayer(), (p_150845_) -> {
            p_150845_.broadcastBreakEvent(pContext.getHand());
        });
        return InteractionResult.SUCCESS;
    }
}