package net.funkystudios.funkyweapons.alchemy.potion;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.funkystudios.funkyweapons.util.Constants.StatusEffects;

public class ModPotions {


    public static Potion OBSIDIAN_TEARS, APACHE_TEARS, BLEEDING, SUGAR_RUSH;

    public static Potion registerPotion(String name, StatusEffectInstance effect){
        return Registry.register(Registries.POTION, new Identifier(FunkyWeapons.MOD_ID, name),
                new Potion(effect));
    }
    public static void registerPotions(){
        OBSIDIAN_TEARS = registerPotion("obsidian_tears",
                new StatusEffectInstance(ModEffects.OBSIDIAN_TEARS));
        APACHE_TEARS = registerPotion("apache_tears",new StatusEffectInstance(ModEffects.APACHE_TEARS));
        BLEEDING = registerPotion("bleeding", new StatusEffectInstance(ModEffects.BLEEDING));
        SUGAR_RUSH = registerPotion("sugar_rush", StatusEffects.Mod.SUGAR_RUSH);

        registerPotionRecipes();
    }
    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.REGENERATION, Items.CHORUS_FLOWER,
                ModPotions.OBSIDIAN_TEARS);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.THICK, ModItems.RUST_DUST, ModPotions.BLEEDING);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.SWIFTNESS, ModItems.CANDY_CANE, ModPotions.SUGAR_RUSH);
    }
}
