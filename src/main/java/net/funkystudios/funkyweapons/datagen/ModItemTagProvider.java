package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.item.utiil.ModItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.HAMMER)
                .add(ModItems.CANDY_CANE_HAMMER)
                .add(ModItems.TURQUOISE_HAMMER)
                .add(ModItems.WOODEN_HAMMER)
                .add(ModItems.STONE_HAMMER)
                .add(ModItems.IRON_HAMMER)
                .add(ModItems.GOLD_HAMMER)
                .add(ModItems.DIAMOND_HAMMER)
                .add(ModItems.NETHERITE_HAMMER);

        getOrCreateTagBuilder(ModItemTags.EXPANDABLE_MINING_TOOL)
                .addTag(ModItemTags.HAMMER)
                .addTag(ItemTags.PICKAXES);

        getOrCreateTagBuilder(ModItemTags.CANDY_CANE_REPAIR)
                .add(ModItems.CANDY_CANE);

        getOrCreateTagBuilder(ModItemTags.OBSIDIAN_REPAIR)
                .add(Items.OBSIDIAN);

        getOrCreateTagBuilder(ModItemTags.TURQUOISE_REPAIR)
                .add(ModItems.TURQUOISE);

        getOrCreateTagBuilder(ModItemTags.TURQUOISE_OBSIDIAN_REPAIR)
                .add(ModBlocks.TURQUOISE_CRYING_OBSIDIAN.asItem());

        getOrCreateTagBuilder(ModItemTags.MACUAHUITL)
                .add(ModItems.WOODEN_MACUAHUITL)
                .add(ModItems.STONE_MACUAHUITL)
                .add(ModItems.IRON_MACUAHUITL)
                .add(ModItems.GOLD_MACUAHUITL)
                .add(ModItems.DIAMOND_MACUAHUITL)
                .add(ModItems.NETHERITE_MACUAHUITL)
                .add(ModItems.OBSIDIAN_MACUAHUITL)
                .add(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TURQUOISE_SWORD)
                .add(ModItems.CANDY_CANE_SWORD)
                .addTag(ModItemTags.MACUAHUITL);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CANDY_CANE_PICKAXE)
                .add(ModItems.TURQUOISE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CANDY_CANE_AXE)
                .add(ModItems.TURQUOISE_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CANDY_CANE_SHOVEL)
                .add(ModItems.TURQUOISE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TURQUOISE_HOE)
                .add(ModItems.CANDY_CANE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
    }
}
