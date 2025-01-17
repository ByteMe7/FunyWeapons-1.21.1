package net.funkystudios.funkyweapons.item;

import net.funkystudios.funkyweapons.block.ModBlockTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials{
    public static final ToolMaterial TURQUOISE = new ToolMaterial(ModBlockTags.INCORRECT_FOR_TURQUOISE_TOOL,
            1200, 5.0f, 4.0f, 22, ModItemTags.TURQUOISE_REPAIR);
    public static final ToolMaterial OBSIDIAN = new ToolMaterial(ModBlockTags.INCORRECT_FOR_OBSIDIAN_TOOL,
            1200, 5.0f, 5.0f, 13, ModItemTags.OBSIDIAN_REPAIR);
    public static final ToolMaterial TURQUOISE_OBSIDIAN = new ToolMaterial(ModBlockTags.NEEDS_TURQUOISE_OBSIDIAN_TOOL,
            1200, 12.0F, 7.0F, 35, ModItemTags.TURQUOISE_OBSIDIAN_REPAIR);
    public static final ToolMaterial CANDY_CANE = new ToolMaterial(ModBlockTags.INCORRECT_FOR_CANDY_CANE_TOOL,
            45, 12.0f, 2.5f, 12, ModItemTags.CANDY_CANE_REPAIR);

}
