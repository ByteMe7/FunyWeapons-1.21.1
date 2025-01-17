package net.funkystudios.funkyweapons.util;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageSources {
    public static final RegistryKey<DamageType> SHARDS_DAMAGE_TYPE;
    public static final RegistryKey<DamageType> BLEEDING_DAMAGE_TYPE;


    private static RegistryKey<DamageType> registerDamageType(String name){
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(FunkyWeapons.MOD_ID, name));
    }
    public static void register(){
        FunkyWeapons.LOGGER.info("Registering damage sources for: " + FunkyWeapons.MOD_ID);
    }

    static {
        SHARDS_DAMAGE_TYPE = registerDamageType("shards_damage_type");
        BLEEDING_DAMAGE_TYPE = registerDamageType("bleeding_damage_type");
    }
}
