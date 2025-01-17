package net.funkystudios.funkyweapons.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
//    public static final SimpleParticleType OBSIDIAN_SHARDS_PARTICLE = FabricParticleTypes.simple();
    public static final SimpleParticleType TURQUOISE_OBSIDIAN_TEAR_DRIP = FabricParticleTypes.simple(false);
    public static final SimpleParticleType TURQUOISE_OBSIDIAN_TEAR_FALLING = FabricParticleTypes.simple(false);
    public static final SimpleParticleType TURQUOISE_OBSIDIAN_TEAR_LAND = FabricParticleTypes.simple(false);

    private static SimpleParticleType register(String name, SimpleParticleType particleType){
        return  Registry.register(Registries.PARTICLE_TYPE, Identifier.of(FunkyWeapons.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        register("turquoise_obsidian_tear_drip", TURQUOISE_OBSIDIAN_TEAR_DRIP);
        register("turquoise_obsidian_tear_falling", TURQUOISE_OBSIDIAN_TEAR_FALLING);
        register("turquoise_obsidian_tear_land", TURQUOISE_OBSIDIAN_TEAR_LAND);
    }


}
