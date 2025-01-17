package net.funkystudios.funkyweapons.alchemy.effect;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.alchemy.effect.custom.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static RegistryEntry<StatusEffect> SHARDS, BLEEDING, OBSIDIAN_TEARS, APACHE_TEARS, SUGAR_RUSH;
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(FunkyWeapons.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        SHARDS = registerStatusEffect("shards", new ShardsEffect());
        BLEEDING = registerStatusEffect("bleeding", new BleedingEffect());
        OBSIDIAN_TEARS = registerStatusEffect("obsidian_tears", new ObsidianTearsEffect());
        APACHE_TEARS = registerStatusEffect("apache_tears", new ApacheTearsEffect());
        SUGAR_RUSH = registerStatusEffect("sugar_rush", new SugarRushEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.ofVanilla("91AEAA56-376B-4498-935B-2F7F68070635"), 0.65000000298023224, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    }
}
