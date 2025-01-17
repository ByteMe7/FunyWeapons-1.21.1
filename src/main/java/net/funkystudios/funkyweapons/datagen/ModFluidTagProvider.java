package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(FluidTags.WATER)
                .add(ModFluids.RUSTY_WATER_STILL)
                .add(ModFluids.RUSTY_WATER_FLOWING)
                .add(ModFluids.OBSIDIAN_TEARS_STILL)
                .add(ModFluids.OBSIDIAN_TEARS_FLOWING)
                .add(ModFluids.APACHE_TEARS_STILL)
                .add(ModFluids.APACHE_TEARS_FLOWING);
    }
}
