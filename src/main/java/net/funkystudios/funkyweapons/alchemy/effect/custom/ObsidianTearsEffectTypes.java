package net.funkystudios.funkyweapons.alchemy.effect.custom;

import net.funkystudios.funkyweapons.util.Constants;
import net.minecraft.entity.effect.StatusEffectInstance;

public enum ObsidianTearsEffectTypes {
    NAUSEA_FIRERES_ONFIRE(1,
            new StatusEffectInstance[]{
                    Constants.StatusEffects.Vanilla.SHORT_FIRE_RES,
                    Constants.StatusEffects.Vanilla.LONG_NAUSEA
            });
    private final StatusEffectInstance[] effects;
    private final int extra;


    ObsidianTearsEffectTypes(int extra, StatusEffectInstance... effects) {
        this.effects = effects;
        this.extra = extra;
    }

    public StatusEffectInstance[] getEffects(){
        return this.effects;
    }

   public int getExtra(){
        return  this.extra;
   }
}
