package net.funkystudios.funkyweapons.block.custom.cauldron;

import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.block.util.ModCauldronBlock;
import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;

public class ObsidianTearsCauldronBlock extends ModCauldronBlock {

    public ObsidianTearsCauldronBlock() {
        super(Colors.OBSIDIAN_TEARS.getIntColor(), null, new CauldronBehavior.CauldronBehaviorMap("obsidian_tears", ModCauldronBehavior.OBSIDIAN_TEARS_CAULDRON), AbstractBlock.Settings.copy(Blocks.WATER_CAULDRON).mapColor(MapColor.DARK_DULL_PINK));
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState().with(LEVEL,1)));
    }

    @Override
    public boolean isFull(BlockState state) {
        return true;
    }



}
