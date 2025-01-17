package net.funkystudios.funkyweapons.block.custom.cauldron;

import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.block.util.ModCauldronBlock;
import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.state.StateManager;

public class ApacheTearsCauldronBlock extends ModCauldronBlock {

    public ApacheTearsCauldronBlock() {
        super(Colors.APACHE_TEARS.getIntColor(), null, new CauldronBehavior.CauldronBehaviorMap("apache_tears_cauldron", ModCauldronBehavior.APACHE_TEARS_CAULDRON), AbstractBlock.Settings.copy(Blocks.CAULDRON));
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