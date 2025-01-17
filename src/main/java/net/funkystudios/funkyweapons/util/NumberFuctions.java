package net.funkystudios.funkyweapons.util;

import java.awt.*;

public class NumberFuctions {
    public static class Random {
        public static int random(int min, int max){
            return (int) ((Math.random()) * (max - min) + min);
        }
        public static double random(double min, double max){
            return (double) (Math.random() * (max - min) + min);
        }
        public static float random(float min, float max){
            return (float) (Math.random() * (max - min) + min);
        }
    }

    public static class Converters {
        final static int SECONDS_TO_TICKS = 20;
        final static int MINUTES_TO_SECONDS = 60;
        final static int HOURS_TO_SECONDS = MINUTES_TO_SECONDS * 60;
        public static float[] colorToRGBA(int intColor){
            Color color = new Color(intColor);
            int intRed = color.getRed();
            int intGreen = color.getGreen();
            int intBlue = color.getBlue();
            int alpha = color.getAlpha();
            return new float[] {
                    intToRGBFloatPercent(intRed),
                    intToRGBFloatPercent(intGreen),
                    intToRGBFloatPercent(intBlue),
                    intToRGBFloatPercent(alpha)
            };
        }

        private static float intToRGBFloatPercent(int intVal){
            return ((float)intVal / 255F);
        }

        public static int timeInTicks(int s){
            return s * SECONDS_TO_TICKS;
        }
        public static int timeInTicks(int s, int m){
            int totalSecs = s + m * MINUTES_TO_SECONDS;
            return totalSecs * SECONDS_TO_TICKS;
        }
        public static int timeInTicks(int s, int m, int h){
            int totalSeconds = s + (m * MINUTES_TO_SECONDS) + (h * HOURS_TO_SECONDS);
            return totalSeconds * SECONDS_TO_TICKS;
        }

    }




}
