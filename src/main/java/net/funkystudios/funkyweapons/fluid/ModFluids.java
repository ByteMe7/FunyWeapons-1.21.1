package net.funkystudios.funkyweapons.fluid;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.fluid.custom.ApacheTearsFluid;
import net.funkystudios.funkyweapons.fluid.custom.ObsidianTearsFluid;
import net.funkystudios.funkyweapons.fluid.custom.RustyWaterFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid OBSIDIAN_TEARS_STILL;
    public static FlowableFluid OBSIDIAN_TEARS_FLOWING;
    public static FlowableFluid APACHE_TEARS_STILL;
    public static FlowableFluid APACHE_TEARS_FLOWING;
    public static FlowableFluid RUSTY_WATER_STILL;
    public static FlowableFluid RUSTY_WATER_FLOWING;

    public static FlowableFluid register(String name, FlowableFluid fluid){
        return Registry.register(Registries.FLUID, Identifier.of(FunkyWeapons.MOD_ID, name), fluid);
    }

    public static void register(){
        FunkyWeapons.LOGGER.info("Registering fluids for: " + FunkyWeapons.MOD_ID);
    }

    static {
        OBSIDIAN_TEARS_STILL = register("obsidian_tears_still", new ObsidianTearsFluid.Still());
        OBSIDIAN_TEARS_FLOWING = register("obsidian_tears_flowing", new ObsidianTearsFluid.Flowing());
        APACHE_TEARS_STILL = register("apache_tears_still", new ApacheTearsFluid.Still());
        APACHE_TEARS_FLOWING = register("apache_tears_flowing", new ApacheTearsFluid.Flowing());
        RUSTY_WATER_STILL = register("rusty_water_still", new RustyWaterFluid.Still());
        RUSTY_WATER_FLOWING = register("rusty_water_flowing", new RustyWaterFluid.Flowing());
    }
}
