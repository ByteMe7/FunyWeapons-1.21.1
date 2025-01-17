package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;

public class ObsidianTearsCauldronBlock extends LeveledCauldronBlock {

    public ObsidianTearsCauldronBlock() {
        super(null, new CauldronBehavior.CauldronBehaviorMap("obsidian_tears", ModCauldronBehavior.OBSIDIAN_TEARS_CAULDRON), AbstractBlock.Settings.copy(Blocks.WATER_CAULDRON).mapColor(MapColor.DARK_DULL_PINK));
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState().with(LEVEL,1)));
    }

    @Override
    public boolean isFull(BlockState state) {
        return true;
    }



}
