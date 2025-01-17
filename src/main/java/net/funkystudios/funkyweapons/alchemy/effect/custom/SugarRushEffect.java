package net.funkystudios.funkyweapons.alchemy.effect.custom;

import net.funkystudios.funkyweapons.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.funkystudios.funkyweapons.util.NumberFuctions.Converters;

public class SugarRushEffect extends StatusEffect {
    public SugarRushEffect() {
        super(StatusEffectCategory.NEUTRAL, Constants.Colors.SUGAR_RUSH.getIntColor());
    }

    @Override
    public void onEntityRemoval(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, Converters.timeInTicks(35), 2));
    }


}
