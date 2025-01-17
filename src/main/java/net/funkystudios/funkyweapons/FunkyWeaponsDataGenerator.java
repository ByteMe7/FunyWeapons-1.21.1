package net.funkystudios.funkyweapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.funkystudios.funkyweapons.datagen.*;
import net.funkystudios.funkyweapons.datagen.lang.ModEnUsProvider;

public class FunkyWeaponsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModFluidTagProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModLootBlockTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModEnUsProvider::new);

	}
}
