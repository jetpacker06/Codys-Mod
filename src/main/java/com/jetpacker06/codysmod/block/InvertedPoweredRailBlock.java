package com.jetpacker06.codysmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.RailShape;
import org.jetbrains.annotations.NotNull;

// the POWERED property is inverted in this class.
// if the rail is receiving a redstone signal, POWERED is false, otherwise it's true.
// minecarts decide whether to speed up or slow down based on the POWERED property.
public class InvertedPoweredRailBlock extends PoweredRailBlock {
    public static final BooleanProperty INVERT_POWERED = BooleanProperty.create("invert_powered");

    public InvertedPoweredRailBlock(Properties p_55218_) {
        super(p_55218_, true);
    }

    @Override
    protected void updateState(BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pBlock) {
        boolean flag = pState.getValue(INVERT_POWERED);
        boolean flag1 = pLevel.hasNeighborSignal(pPos) || this.findPoweredRailSignal(pLevel, pPos, pState, true, 0) || this.findPoweredRailSignal(pLevel, pPos, pState, false, 0);
        if (flag1 != flag) {
            pLevel.setBlock(pPos, pState.setValue(INVERT_POWERED, flag1).setValue(POWERED, !flag1), 3);
            pLevel.updateNeighborsAt(pPos.below(), this);
            if (pState.getValue(getShapeProperty()).isAscending()) {
                pLevel.updateNeighborsAt(pPos.above(), this);
            }
        }
    }

    @Override
    protected void registerDefaultState() {
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SHAPE, RailShape.NORTH_SOUTH)
                .setValue(POWERED, Boolean.TRUE)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(INVERT_POWERED, Boolean.FALSE)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(INVERT_POWERED);
    }
}
