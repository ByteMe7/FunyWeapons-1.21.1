package net.funkystudios.funkyweapons.item.custom;

import net.funkystudios.funkyweapons.item.utiil.IColoredItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

public class CustomBucketItem extends BucketItem implements IColoredItem {
    private final int color;
    public CustomBucketItem(Fluid fluid, int color, Settings settings) {
        super(fluid, settings);
        this.color = color;
    }

    @Override
    public int getColor(int tintIndex) {
        return tintIndex == 1 ? color : -1;
    }
}
