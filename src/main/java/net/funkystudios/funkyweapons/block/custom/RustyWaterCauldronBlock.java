package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;

public class RustyWaterCauldronBlock extends LeveledCauldronBlock {
    public RustyWaterCauldronBlock() {
        super(AbstractBlock.Settings.copy(Blocks.CAULDRON), null, ModCauldronBehavior.RUSTY_WATER_CAULDRON);
        this.setDefaultState(((BlockState) this.getDefaultState()).with(LEVEL, 3));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }


}
