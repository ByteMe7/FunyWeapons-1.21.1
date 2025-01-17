package net.funkystudios.funkyweapons.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_STONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_CRYING_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_ALLOY_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_TURQUOISE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TURQUOISE_ALLOY_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_ALLOY_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.MUG, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_CHOCOLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOODEN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_OBSIDIAN_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOODEN_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_OBSIDIAN_SPIKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TURQUOISE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CANDY_CANE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY_CANE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY_CANE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY_CANE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY_CANE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WOODEN_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WOODEN_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY_CANE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CHAINSAW, Models.HANDHELD);
    }
}
