package net.funkystudios.funkyweapons.alchemy.effect.custom;

import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ShardsEffect extends StatusEffect {
    Vec3d currentPos, lastPos;
    public ShardsEffect() {
        super(StatusEffectCategory.NEUTRAL, Colors.OBSIDIAN_SHARDS.getIntColor());
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            currentPos = entity.getPos();
            if(!currentPos.equals(lastPos)){
                DamageSource shards = new DamageSource(
                        world.getRegistryManager()
                                .get(RegistryKeys.DAMAGE_TYPE)
                                .entryOf(ModDamageSources.SHARDS_DAMAGE_TYPE)
                );
                entity.damage(shards,0.2f * amplifier);
            }
            lastPos = entity.getPos();
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


}
