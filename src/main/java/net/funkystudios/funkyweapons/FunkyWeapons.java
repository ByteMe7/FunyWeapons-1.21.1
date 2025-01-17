package net.funkystudios.funkyweapons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.funkystudios.funkyweapons.alchemy.potion.ModPotions;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.entity.ModEntities;
import net.funkystudios.funkyweapons.item.ModItemGroups;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.particle.ModParticles;
import net.funkystudios.funkyweapons.util.ExpandedMiningToolUsageEvent;
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
		ModBlocks.register();
		ModItems.register();
		ModItemGroups.register();
		ModPotions.register();
		ModEntities.register();
		ModParticles.registerParticles();

		PlayerBlockBreakEvents.BEFORE.register(new ExpandedMiningToolUsageEvent());
	}
}