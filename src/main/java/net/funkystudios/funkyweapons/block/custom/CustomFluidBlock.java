package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.block.util.IColoredBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;

public class CustomFluidBlock extends FluidBlock implements IColoredBlock {
    private final int color;
    public CustomFluidBlock(int color, FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
        this.color = color;
    }

    @Override
    public int getColor(int tintIndex) {
        return tintIndex == 0 ? color : -1;
    }
}
