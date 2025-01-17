package net.funkystudios.funkyweapons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.custom.TurquoiseObsidianBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
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
    }
}
