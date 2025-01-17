package net.funkystudios.funkyweapons.alchemy.effect.custom;


import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public class BleedingEffect extends StatusEffect {
    private float health = 0f;
    public BleedingEffect() {
        super(StatusEffectCategory.HARMFUL, Colors.BLEEDING_EFFECT.getIntColor());
    }

    @Override
    public void onApplied(LivingEntity entity,int amplifier) {
        super.onApplied(entity, amplifier);
        health = entity.getHealth();
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            if(amplifier > 2) {
                DamageSource bleeding = new DamageSource(
                        world.getRegistryManager()
                                .get(RegistryKeys.DAMAGE_TYPE)
                                .entryOf(ModDamageSources.BLEEDING_DAMAGE_TYPE)
                );
                entity.damage(bleeding, 0.5f * amplifier);
            }
            if(entity.getHealth() < health && !hasGreaterRegen(entity, amplifier)){
                health = entity.getHealth();
            }
            entity.setHealth(health);

        }
        return true;
    }

    private boolean hasGreaterRegen(LivingEntity entity, int amplifier){
        if(!entity.hasStatusEffect(StatusEffects.REGENERATION)) return false;
        return entity.getStatusEffect(StatusEffects.REGENERATION).getAmplifier() > amplifier;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
