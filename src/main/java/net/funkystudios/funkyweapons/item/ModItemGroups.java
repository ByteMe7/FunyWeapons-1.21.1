package net.funkystudios.funkyweapons.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup FUNKY_WEAPONS =
            Registry.register(
                    Registries.ITEM_GROUP,
                    Identifier.of(FunkyWeapons.MOD_ID, "funky_weapons"),
                    FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.OBSIDIAN_MACUAHUITL))
                            .displayName(Text.translatable("itemGroup.funky-weapons.funkyweapons"))
                            .entries(((displayContext, entries) -> {
                                entries.add(ModItems.CANDY_CANE_SWORD);
                                entries.add(ModItems.TURQUOISE_SWORD);

                                entries.add(ModItems.CANDY_CANE_BOW);

                                entries.add(ModItems.WOODEN_MACUAHUITL);
                                entries.add(ModItems.STONE_MACUAHUITL);
                                entries.add(ModItems.IRON_MACUAHUITL);
                                entries.add(ModItems.GOLD_MACUAHUITL);
                                entries.add(ModItems.DIAMOND_MACUAHUITL);
                                entries.add(ModItems.NETHERITE_MACUAHUITL);
                                entries.add(ModItems.OBSIDIAN_MACUAHUITL);
                                entries.add(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL);
                            }))
                            .build());

    public static ItemGroup FUNKY_TOOLS = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(FunkyWeapons.MOD_ID, "funky_tools"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TURQUOISE_HAMMER))
                    .displayName(Text.translatable("itemgroup.funky_tools"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.WOODEN_HAMMER);
                        entries.add(ModItems.STONE_HAMMER);
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.GOLD_HAMMER);
                        entries.add(ModItems.DIAMOND_HAMMER);
                        entries.add(ModItems.NETHERITE_HAMMER);
                        entries.add(ModItems.TURQUOISE_HAMMER);
                        entries.add(ModItems.CANDY_CANE_HAMMER);
                    }))
                    .build());

    public static void register(){
        FunkyWeapons.LOGGER.info("Registering item groups for: " + FunkyWeapons.MOD_ID);
    }
}
