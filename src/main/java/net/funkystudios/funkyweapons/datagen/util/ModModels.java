package net.funkystudios.funkyweapons.datagen.util;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model CUSTOM_BUCKET;

    private static Model item(String parent) {
        return new Model(Optional.of(Identifier.of(FunkyWeapons.MOD_ID, "item/" + parent)), Optional.empty());
    }

    static {
        CUSTOM_BUCKET = item("template_bucket");
    }
}
