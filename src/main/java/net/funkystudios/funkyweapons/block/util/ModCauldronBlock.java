package net.funkystudios.funkyweapons.block.util;

import net.minecraft.block.CauldronBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.world.biome.Biome;

public class ModCauldronBlock extends LeveledCauldronBlock implements IColoredBlock{
    private final int color;


    public ModCauldronBlock(int color, Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, Settings settings) {
        super(precipitation, behaviorMap, settings);
        this.color = color;
    }


    @Override
    public int getColor(int tintIndex) {
        return tintIndex == 0 ? color : -1;
    }
}
