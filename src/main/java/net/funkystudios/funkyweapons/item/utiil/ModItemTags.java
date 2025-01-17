package net.funkystudios.funkyweapons.item.utiil;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> HAMMER;
    public static final TagKey<Item> MACUAHUITL;
    public static final TagKey<Item> TURQUOISE_REPAIR;
    public static final TagKey<Item> TURQUOISE_OBSIDIAN_REPAIR;
    public static final TagKey<Item> OBSIDIAN_REPAIR;
    public static final TagKey<Item> CANDY_CANE_REPAIR;
    public static final TagKey<Item> EXPANDABLE_MINING_TOOL;

    private static TagKey<Item> createTag(String name){
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(FunkyWeapons.MOD_ID, name));
    }

    static {
        HAMMER = createTag("hammer");
        MACUAHUITL = createTag("macuahuitl");
        TURQUOISE_REPAIR = createTag("turquoise_repair");
        TURQUOISE_OBSIDIAN_REPAIR = createTag("turquoise_obsidian_repair");
        OBSIDIAN_REPAIR = createTag("obsidian_repair");
        CANDY_CANE_REPAIR = createTag("candy_cane_repair");
        EXPANDABLE_MINING_TOOL = createTag("expandable_mining_tools");
    }
}
