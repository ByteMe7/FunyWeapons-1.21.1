package net.funkystudios.funkyweapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.particle.ModParticles;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearDripParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearFallingParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearLandingParticle;
import net.funkystudios.funkyweapons.util.IColoredItem;

public class FunkyWeaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        registerItemColors();
        registerParticles();

    }

    private static void registerItemColors(){
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> ((IColoredItem) stack.getItem()).getColor(tintIndex)),
                ModItems.APACHE_TEARS_BUCKET, ModItems.OBSIDIAN_TEARS_BUCKET, ModItems.RUSTY_WATER_BUCKET);
    }

    private static void registerParticles(){
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_DRIP, TurquoiseObsidianTearDripParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_FALLING, TurquoiseObsidianTearFallingParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_LAND, TurquoiseObsidianTearLandingParticle.Factory::new);
    }
}
