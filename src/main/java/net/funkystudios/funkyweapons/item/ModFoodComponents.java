package net.funkystudios.funkyweapons.item;

import net.funkystudios.funkyweapons.util.Constants;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {

    public static final FoodComponent CANDY_CANE;
    public static final FoodComponent HOT_CHOCOLATE;


    static {
        CANDY_CANE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).build();
        HOT_CHOCOLATE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25F).build();
    }
}
