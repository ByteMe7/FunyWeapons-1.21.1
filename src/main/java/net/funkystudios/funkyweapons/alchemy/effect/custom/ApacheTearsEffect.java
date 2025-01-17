package net.funkystudios.funkyweapons.alchemy.effect.custom;

import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;

public class ApacheTearsEffect extends InstantStatusEffect {
    public ApacheTearsEffect() {
        super(StatusEffectCategory.HARMFUL, Colors.APACHE_TEARS.getIntColor());
    }


    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.SHARDS, 600));
        }
    }
}
