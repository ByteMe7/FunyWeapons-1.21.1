package net.funkystudios.funkyweapons.util;

import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;

import net.funkystudios.funkyweapons.util.NumberFuctions.Converters;
public class Constants {



    public static enum Colors {
        OBSIDIAN_TEARS(0xDF210a39),
        TURQUOISE_OBSIDIAN_TEARS(0xFF3a6386),
        APACHE_TEARS(0xDF07f5ed),
        SUGAR_RUSH(0xDFe8cecc),
        BLEEDING_EFFECT(0xf21707),
        RUSTY_WATER(0xDF751c01),
        OBSIDIAN_SHARDS(0x1c002b),
        RUST_DUST(0xFF834919);
        private final int intColor;
        private final float redPercent;
        private final float greenPercent;
        private final float bluePercent;
        private final float alphaPercent;

        Colors(int intColor) {
            this.intColor = intColor;
            float[] info = Converters.colorToRGBA(intColor);
            this.redPercent = info[0];
            this.greenPercent = info[1];
            this.bluePercent = info[2];
            this.alphaPercent = info[3];
        }

        public int getIntColor() {
            return this.intColor;
        }

        public float getRedPercent(){
            return this.redPercent;
        }

        public float getGreenPercent(){
            return this.greenPercent;
        }

        public float getBluePercent(){
            return this.bluePercent;
        }

        public float getAlphaPercent(){
            return this.alphaPercent;
        }

    }



    public static class StatusEffects{
        public static class Vanilla{
            public static final StatusEffectInstance SHORT_SPEED = new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED,60);
            public static final StatusEffectInstance LONG_SPEED = new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED,240);
            public static final StatusEffectInstance SHORT_FIRE_RES = new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.FIRE_RESISTANCE,160);
            public static final StatusEffectInstance LONG_NAUSEA = new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.NAUSEA, 4000);
        }

        public static class Mod{
            public static final StatusEffectInstance SUGAR_RUSH, SHARDS, BLEEDING;

            static {
                SUGAR_RUSH = new StatusEffectInstance(ModEffects.SUGAR_RUSH, Converters.timeInTicks(30, 1), 1);
                SHARDS = new StatusEffectInstance(ModEffects.SHARDS, Converters.timeInTicks(5));
                BLEEDING = new StatusEffectInstance(ModEffects.BLEEDING, Converters.timeInTicks(7));
            }
        }
    }

    public static class ModFoods{
        public static final FoodComponent HOT_CHOCOLATE = new FoodComponent.Builder()
                .saturationModifier(2f)
                .statusEffect(StatusEffects.Vanilla.SHORT_SPEED, 1)
                .alwaysEdible()
                .build(),
                ROASTED_HOT_CHOCOLATE = new FoodComponent.Builder()
                        .alwaysEdible()
                        .statusEffect(StatusEffects.Vanilla.LONG_SPEED, 1)
                        .saturationModifier(3f)
                        .build(),
                POBLANO = new FoodComponent.Builder()
                        .nutrition(2)
                        .saturationModifier(3f)
                        .snack()
                        .statusEffect(StatusEffects.Vanilla.SHORT_FIRE_RES,1)
                        .build(),
                ROASTED_POBLANO = new FoodComponent.Builder()
                        .nutrition(3)
                        .saturationModifier(3.5f)
                        .snack()
                        .statusEffect(StatusEffects.Vanilla.SHORT_FIRE_RES,1)
                        .build(),
                CANDY_CANE = new FoodComponent.Builder()
                        .nutrition(3)
                        .saturationModifier(1f)
                        .snack()
                        .alwaysEdible()
                        .statusEffect(StatusEffects.Mod.SUGAR_RUSH, 1)
                        .build(),
                CANDY_CANE_TOOLS = new FoodComponent.Builder()
                        .nutrition(5)
                        .saturationModifier(4.5f)
                        .alwaysEdible()
                        .statusEffect(StatusEffects.Mod.SUGAR_RUSH, 1)
                        .build();
    }

}
