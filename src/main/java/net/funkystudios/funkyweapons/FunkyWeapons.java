package net.funkystudios.funkyweapons;

import net.fabricmc.api.ModInitializer;

import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.particle.ModParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunkyWeapons implements ModInitializer {
	public static final String MOD_ID = "funky-weapons";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.register();
		ModItems.register();

		ModParticles.registerParticles();

		LOGGER.info("Hello Fabric world!");
	}
}