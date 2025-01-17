package net.funkystudios.funkyweapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.funkystudios.funkyweapons.particle.ModParticles;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearDripParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearFallingParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearLandingParticle;

public class FunkyWeaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        registerParticles();

    }

    private static void registerParticles(){
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_DRIP, TurquoiseObsidianTearDripParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_FALLING, TurquoiseObsidianTearFallingParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_LAND, TurquoiseObsidianTearLandingParticle.Factory::new);
    }
}
