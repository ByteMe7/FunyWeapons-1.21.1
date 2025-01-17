package net.funkystudios.funkyweapons.item.utiil;

import com.google.common.base.Suppliers;
import net.funkystudios.funkyweapons.block.ModBlockTags;
import net.funkystudios.funkyweapons.item.utiil.ModItemTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial{
    TURQUOISE (ModBlockTags.INCORRECT_FOR_TURQUOISE_TOOL,
            1200, 5.0f, 4.0f, 22, ModItemTags.TURQUOISE_REPAIR),
    TURQUOISE_OBSIDIAN(ModBlockTags.INCORRECT_FOR_TURQUOISE_OBSIDIAN_TOOL,
            1200, 12.0F, 7.0F, 35, ModItemTags.TURQUOISE_OBSIDIAN_REPAIR),
    OBSIDIAN(ModBlockTags.INCORRECT_FOR_OBSIDIAN_TOOL,
            1200, 10.0F, 6.0F, 35, ModItemTags.OBSIDIAN_REPAIR),
   CANDY_CANE(ModBlockTags.INCORRECT_FOR_CANDY_CANE_TOOL,
            45, 12.0f, 2.5f, 12, ModItemTags.CANDY_CANE_REPAIR);

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability,final float miningSpeed,
                     final float attackDamage, final int enchantability, TagKey<Item> repair) {
        final Supplier<Ingredient> repairIngredient = () -> Ingredient.fromTag(repair);
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
