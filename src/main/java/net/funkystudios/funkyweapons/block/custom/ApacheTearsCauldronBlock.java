package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.state.StateManager;

public class ApacheTearsCauldronBlock extends LeveledCauldronBlock {

    public ApacheTearsCauldronBlock() {
        super(null, new CauldronBehavior.CauldronBehaviorMap("apache_tears_cauldron", ModCauldronBehavior.APACHE_TEARS_CAULDRON), AbstractBlock.Settings.copy(Blocks.CAULDRON));
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState().with(LEVEL,1)));
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}