package net.funkystudios.funkyweapons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.custom.ApacheTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.ObsidianTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.RustyWaterCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.TurquoiseObsidianBlock;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RAW_TURQUOISE_BLOCK;
    public static final Block TURQUOISE_BLOCK;
    public static final Block TURQUOISE_ALLOY_BLOCK;
    public static final Block CRACKED_STONE_BLOCK;
    public static final Block TURQUOISE_CRYING_OBSIDIAN;
    public static final Block TURQUOISE_ORE;
    public static final Block DEEPSLATE_TURQUOISE_ORE;
    public static final Block APACHE_TEARS_FLUID_BLOCK;
    public static final Block APACHE_TEAR_CAULDRON;
    public static final Block OBSIDIAN_TEARS_FLUID_BLOCK;
    public static final Block OBSIDIAN_TEAR_CAULDRON;
    public static final Block RUSTY_WATER_FLUID_BLOCK;
    public static final Block RUSTY_WATER_CAULDRON;


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FunkyWeapons.MOD_ID, name),
                block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(FunkyWeapons.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(FunkyWeapons.MOD_ID, name), block);
    }


    public static void register(){
        FunkyWeapons.LOGGER.info("Registering blocks for: " + FunkyWeapons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(RAW_TURQUOISE_BLOCK);
            entries.add(TURQUOISE_BLOCK);

            entries.add(TURQUOISE_ALLOY_BLOCK);

            entries.add(CRACKED_STONE_BLOCK);
            entries.add(TURQUOISE_ORE);
            entries.add(DEEPSLATE_TURQUOISE_ORE);

            entries.add(TURQUOISE_CRYING_OBSIDIAN);
        });
    }

    static {
        RAW_TURQUOISE_BLOCK = registerBlock("raw_turquoise_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        TURQUOISE_BLOCK = registerBlock("turquoise_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        TURQUOISE_ALLOY_BLOCK = registerBlock("turquoise_alloy_block", new Block(AbstractBlock.Settings.create().strength(4f, 5f).requiresTool().solid()));

        CRACKED_STONE_BLOCK = registerBlock("cracked_stone_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

        TURQUOISE_CRYING_OBSIDIAN = registerBlock("turquoise_crying_obsidian", new TurquoiseObsidianBlock());

        TURQUOISE_ORE = registerBlock("turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.copy(Blocks.COPPER_ORE)));
        DEEPSLATE_TURQUOISE_ORE = registerBlock("deepslate_turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COPPER_ORE)));

        APACHE_TEARS_FLUID_BLOCK = registerBlockWithoutBlockItem("apache_tears_fluid_block", new FluidBlock(ModFluids.APACHE_TEARS_STILL, AbstractBlock.Settings.copy(Blocks.WATER)));
        APACHE_TEAR_CAULDRON = registerBlockWithoutBlockItem("apache_tears_cauldron_block", new ApacheTearsCauldronBlock());
        OBSIDIAN_TEARS_FLUID_BLOCK = registerBlockWithoutBlockItem("obsidian_tears_fluid_block", new FluidBlock(ModFluids.OBSIDIAN_TEARS_STILL, AbstractBlock.Settings.copy(Blocks.WATER)));
        OBSIDIAN_TEAR_CAULDRON = registerBlockWithoutBlockItem("obsidian_tears_cauldron_block", new ObsidianTearsCauldronBlock());
        RUSTY_WATER_FLUID_BLOCK = registerBlockWithoutBlockItem("rusty_water_fluid_block", new FluidBlock(ModFluids.RUSTY_WATER_STILL, AbstractBlock.Settings.copy(Blocks.WATER)));
        RUSTY_WATER_CAULDRON = registerBlockWithoutBlockItem("rusty_water_cauldron_block", new RustyWaterCauldronBlock());
    }
}
