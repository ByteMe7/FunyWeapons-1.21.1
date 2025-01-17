package net.funkystudios.funkyweapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.block.util.IColoredBlock;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.particle.ModParticles;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearDripParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearFallingParticle;
import net.funkystudios.funkyweapons.particle.custom.TurquoiseObsidianTearLandingParticle;
import net.funkystudios.funkyweapons.item.utiil.IColoredItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;

public class FunkyWeaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        registerItemColors(ModItems.APACHE_TEARS_BUCKET, ModItems.OBSIDIAN_TEARS_BUCKET, ModItems.RUSTY_WATER_BUCKET);
        registerBlockColors(
                ModBlocks.RUSTY_WATER_CAULDRON, ModBlocks.APACHE_TEAR_CAULDRON, ModBlocks.OBSIDIAN_TEAR_CAULDRON,
                ModBlocks.APACHE_TEARS_FLUID_BLOCK, ModBlocks.OBSIDIAN_TEARS_FLUID_BLOCK, ModBlocks.RUSTY_WATER_FLUID_BLOCK
        );
        registerParticles();

    }

    private static void registerBlockColors(Block... blocks){
        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(state.getBlock() instanceof IColoredBlock coloredBlock){
                return coloredBlock.getColor(tintIndex);
            }
            return -1;
        }), blocks);
    }

    private static void registerItemColors(ItemConvertible... items){
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> ((IColoredItem) stack.getItem()).getColor(tintIndex)), items);
    }

    private static void registerParticles(){
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_DRIP, TurquoiseObsidianTearDripParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_FALLING, TurquoiseObsidianTearFallingParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TURQUOISE_OBSIDIAN_TEAR_LAND, TurquoiseObsidianTearLandingParticle.Factory::new);
    }
}
