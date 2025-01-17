package net.funkystudios.funkyweapons.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnUsProvider extends FabricLanguageProvider {
    public ModEnUsProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(ModItems.RAW_TURQUOISE, "Raw Turquoise");
        translationBuilder.add(ModBlocks.RAW_TURQUOISE_BLOCK, "Block of Raw Turquoise");
        translationBuilder.add(ModItems.TURQUOISE, "Turquoise");
        translationBuilder.add(ModBlocks.TURQUOISE_BLOCK, "Block of Turquoise");

        translationBuilder.add(ModItems.TURQUOISE_ALLOY_NUGGET, "Turquoise Alloy Nugget");
        translationBuilder.add(ModItems.TURQUOISE_ALLOY_INGOT, "Turquoise Alloy Ingot");
        translationBuilder.add(ModBlocks.TURQUOISE_ALLOY_BLOCK, "Block of Turquoise Alloy");

        translationBuilder.add(ModItems.TURQUOISE_SWORD, "Turquoise Sword");
        translationBuilder.add(ModItems.TURQUOISE_PICKAXE, "Turquoise Pickaxe");
        translationBuilder.add(ModItems.TURQUOISE_SHOVEL, "Turquoise Shovel");
        translationBuilder.add(ModItems.TURQUOISE_AXE, "Turquoise Axe");
        translationBuilder.add(ModItems.TURQUOISE_HOE, "Turquoise Hoe");
        translationBuilder.add(ModItems.TURQUOISE_HAMMER, "Turquoise Hammer");


        translationBuilder.add(ModItems.CANDY_CANE_SWORD, "Candy Cane Sword");
        translationBuilder.add(ModItems.CANDY_CANE_PICKAXE, "Candy Cane Pickaxe");
        translationBuilder.add(ModItems.CANDY_CANE_SHOVEL, "Candy Cane Shovel");
        translationBuilder.add(ModItems.CANDY_CANE_AXE, "Candy Cane Axe");
        translationBuilder.add(ModItems.CANDY_CANE_HOE, "Candy Cane Hoe");
        translationBuilder.add(ModItems.CANDY_CANE_HAMMER, "Candy Cane Hammer");
        translationBuilder.add(ModItems.CANDY_CANE_BOW, "Candy Cane Bow");

        translationBuilder.add(ModItems.WOODEN_MACUAHUITL, "Wooden Macuahuitl");
        translationBuilder.add(ModItems.STONE_MACUAHUITL, "Stone Macuahuitl");
        translationBuilder.add(ModItems.IRON_MACUAHUITL, "Iron Macuahuitl");
        translationBuilder.add(ModItems.GOLD_MACUAHUITL, "Gold Macuahuitl");
        translationBuilder.add(ModItems.DIAMOND_MACUAHUITL, "Diamond Macuahuitl");
        translationBuilder.add(ModItems.NETHERITE_MACUAHUITL, "Netherite Macuahuitl");
        translationBuilder.add(ModItems.OBSIDIAN_MACUAHUITL, "Obsidian Macuahuitl");
        translationBuilder.add(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL, "Turquoise Obsidian Macuahuitl");

        translationBuilder.add(ModItems.WOODEN_SPIKE, "Wooden Spike");
        translationBuilder.add(ModItems.STONE_SPIKE, "Stone Spike");
        translationBuilder.add(ModItems.IRON_SPIKE, "Iron Spike");
        translationBuilder.add(ModItems.GOLD_SPIKE, "Gold Spike");
        translationBuilder.add(ModItems.DIAMOND_SPIKE, "Diamond Spike");
        translationBuilder.add(ModItems.NETHERITE_SPIKE, "Netherite Spike");
        translationBuilder.add(ModItems.OBSIDIAN_SPIKE, "Obsidian Spike");
        translationBuilder.add(ModItems.TURQUOISE_OBSIDIAN_SPIKE, "Turquoise Obsidian Spike");

        translationBuilder.add(ModItems.WOODEN_SHARD, "Wooden Shard");
        translationBuilder.add(ModItems.STONE_FRAGMENT, "Stone Fragment");
        translationBuilder.add(ModItems.IRON_FRAGMENT, "Iron Fragment");
        translationBuilder.add(ModItems.GOLD_FRAGMENT, "Gold Fragment");
        translationBuilder.add(ModItems.DIAMOND_SHARD, "Diamond Shard");
        translationBuilder.add(ModItems.NETHERITE_FRAGMENT, "Netherite Fragment");
        translationBuilder.add(ModItems.OBSIDIAN_SHARD, "Obsidian Shard");
        translationBuilder.add(ModItems.TURQUOISE_OBSIDIAN_SHARD, "Turquoise Obsidian Shard");

        translationBuilder.add(ModBlocks.CRACKED_STONE_BLOCK, "Cracked Stone");
        translationBuilder.add(ModBlocks.TURQUOISE_ORE, "Turquoise Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_TURQUOISE_ORE, "Deepslate Turquoise Ore");

        translationBuilder.add(ModItems.CHAINSAW, "Chainsaw");


        translationBuilder.add(ModItems.CLAY_MUG, "Clay Mug");
        translationBuilder.add(ModItems.MUG, "Mug");
        translationBuilder.add(ModItems.HOT_CHOCOLATE, "Hot Chocolate");

        translationBuilder.add("death.attack.shards", "%s failed to remove the shards");

        translationBuilder.add("itemgroup.funky_materials", "Funky Materials");
        translationBuilder.add("itemgroup.funkyblocks", "Funky Blocks");
        translationBuilder.add("itemgroup.funkyfood", "Funky Food");
        translationBuilder.add("itemgroup.funkyweapons", "Funky Weapons");
        translationBuilder.add("itemgroup.funky_armor", "Funky Armor");
        translationBuilder.add("itemgroup.funky_tools", "Funky Tools");
        translationBuilder.add("item.funkyweapons.candy_cane_bow.tooltip0", "A simple bow made of candy with a sugar string: ");
        translationBuilder.add("item.funkyweapons.candy_cane_bow.tooltip1", "Might not have as much durability");

    }

    private static void potionTranslationBuilder(TranslationBuilder translationBuilder,
                                                 String key, String name){
        translationBuilder.add("item.minecraft.potion.effect." + key,name + " Potion");
        translationBuilder.add("item.minecraft.splash_potion.effect." + key,"Splash Potion of " + name);
        translationBuilder.add("item.minecraft.lingering_potion.effect." + key,"Lingering Potion of " + name);
    }
}
