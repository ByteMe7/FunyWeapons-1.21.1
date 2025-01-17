package net.funkystudios.funkyweapons.alchemy.potion;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.funkystudios.funkyweapons.item.ModItems;
import static net.funkystudios.funkyweapons.util.NumberFuctions.timeInTicks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {


    public final static RegistryEntry<Potion> OBSIDIAN_TEARS;
    public final static RegistryEntry<Potion> APACHE_TEARS;
    public final static RegistryEntry<Potion> BLEEDING;
    public final static RegistryEntry<Potion> SUGAR_RUSH;

    private static RegistryEntry<Potion> register(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(FunkyWeapons.MOD_ID, name), potion);
    }
    public static void register(){

    }

    static {
        OBSIDIAN_TEARS = register("obsidian_tears",
                new Potion(new StatusEffectInstance(ModEffects.OBSIDIAN_TEARS, timeInTicks(40))));
        APACHE_TEARS = register("apache_tears",
                new Potion(new StatusEffectInstance(ModEffects.APACHE_TEARS, timeInTicks(40))));
        BLEEDING = register("bleeding",
                new Potion(new StatusEffectInstance(ModEffects.BLEEDING, timeInTicks(40))));
        SUGAR_RUSH = register("sugar_rush",
                new Potion(new StatusEffectInstance(ModEffects.SUGAR_RUSH, timeInTicks(40))));
    }

}
