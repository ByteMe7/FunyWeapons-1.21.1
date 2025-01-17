package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.state.StateManager;

public class RustyWaterCauldronBlock extends LeveledCauldronBlock {
    public RustyWaterCauldronBlock() {
        super( null, new CauldronBehavior.CauldronBehaviorMap("rusty_cauldron", ModCauldronBehavior.RUSTY_WATER_CAULDRON) ,AbstractBlock.Settings.copy(Blocks.CAULDRON));
        this.setDefaultState(((BlockState) this.getDefaultState()).with(LEVEL, 3));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }


}
