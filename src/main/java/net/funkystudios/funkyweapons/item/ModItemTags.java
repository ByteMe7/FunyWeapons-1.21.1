package net.funkystudios.funkyweapons.item;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> HAMMER;
    public static final TagKey<Item> TURQUOISE_REPAIR;

    private static TagKey<Item> createTag(String name){
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(FunkyWeapons.MOD_ID, name));
    }

    static {
        HAMMER = createTag("hammer");
        TURQUOISE_REPAIR = createTag("turquoise_repair");
    }
}
