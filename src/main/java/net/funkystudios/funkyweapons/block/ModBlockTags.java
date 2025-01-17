package net.funkystudios.funkyweapons.block;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> NEEDS_TURQUOISE_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_TURQUOISE_TOOL;
    public static final TagKey<Block> NEEDS_TURQUOISE_OBSIDIAN_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_TURQUOISE_OBSIDIAN_TOOL;
    public static final TagKey<Block> NEEDS_OBSIDIAN_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL;
    public static final TagKey<Block> NEEDS_CANDY_CANE_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_CANDY_CANE_TOOL;
    public static final TagKey<Block> TREE_FELL_BLOCKS;

    private static TagKey<Block> createTag(String name){
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FunkyWeapons.MOD_ID, name));
    }

    static {
        NEEDS_TURQUOISE_TOOL = createTag("needs_turquoise_tool");
        INCORRECT_FOR_TURQUOISE_TOOL = createTag("incorrect_for_turquoise_tool");
        NEEDS_TURQUOISE_OBSIDIAN_TOOL = createTag("needs_turquoise_obsidian_tool");
        INCORRECT_FOR_TURQUOISE_OBSIDIAN_TOOL = createTag("incorrect_for_turquoise_obsidian_tool");
        NEEDS_OBSIDIAN_TOOL = createTag("needs_obsidian_tool");
        INCORRECT_FOR_OBSIDIAN_TOOL = createTag("incorrect_for_obsidian_tool");
        NEEDS_CANDY_CANE_TOOL = createTag("needs_candy_cane_tool");
        INCORRECT_FOR_CANDY_CANE_TOOL = createTag("incorrect_for_candy_cane_tool");
        TREE_FELL_BLOCKS = createTag("tree_fell_blocks");
    }

}
