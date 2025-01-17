package net.funkystudios.funkyweapons.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.funkystudios.funkyweapons.particle.ModParticles;
import net.funkystudios.funkyweapons.particle.util.ModBlockLeakParticle;
import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.funkystudios.funkyweapons.util.NumberFuctions.Converters;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class TurquoiseObsidianTearLandingParticle extends SpriteBillboardParticle {
    protected TurquoiseObsidianTearLandingParticle(ClientWorld level, double xCoord, double yCoord, double zCoord,
                                                   SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.maxAge = 20;
        this.setSpriteForAge(spriteSet);
        this.red = Colors.TURQUOISE_OBSIDIAN_TEARS.getRedPercent();
        this.green = Colors.TURQUOISE_OBSIDIAN_TEARS.getGreenPercent();
        this.blue = Colors.TURQUOISE_OBSIDIAN_TEARS.getBluePercent();
        this.alpha = Colors.TURQUOISE_OBSIDIAN_TEARS.getAlphaPercent();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientWorld level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            SpriteBillboardParticle landingObsidianTear = ModBlockLeakParticle.createLandingBlockTear(ModParticles.TURQUOISE_OBSIDIAN_TEAR_LAND, level, x, y, z, dx, dy, dz);
            landingObsidianTear.setSpriteForAge(this.sprites);
            var color = Colors.TURQUOISE_OBSIDIAN_TEARS;
            landingObsidianTear.setColor(color.getRedPercent(), color.getGreenPercent(), color.getGreenPercent());
            return landingObsidianTear;
        }
    }
}
