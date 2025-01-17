package net.funkystudios.funkyweapons.block.custom.cauldron;

import net.funkystudios.funkyweapons.block.util.ModCauldronBlock;
import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.state.StateManager;

public class RustyWaterCauldronBlock extends ModCauldronBlock {
    public RustyWaterCauldronBlock() {
        super(Colors.RUSTY_WATER.getIntColor(),null, new CauldronBehavior.CauldronBehaviorMap("rusty_cauldron", ModCauldronBehavior.RUSTY_WATER_CAULDRON) ,AbstractBlock.Settings.copy(Blocks.CAULDRON));
        this.setDefaultState(((BlockState) this.getDefaultState()).with(LEVEL, 3));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }


}
