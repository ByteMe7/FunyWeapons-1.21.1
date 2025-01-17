package net.funkystudios.funkyweapons.particle.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class ModBlockLeakParticle extends SpriteBillboardParticle {
    private final Fluid fluid;
    protected boolean obsidianTear;

    ModBlockLeakParticle(ClientWorld world, double x, double y, double z, Fluid fluid) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.fluid = fluid;
    }

    protected Fluid getFluid() {
        return this.fluid;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public int getBrightness(float tint) {
        return this.obsidianTear ? 240 : super.getBrightness(tint);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.updateAge();
        if (!this.dead) {
            this.velocityY -= (double)this.gravityStrength;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.updateVelocity();
            if (!this.dead) {
                this.velocityX *= 0.9800000190734863;
                this.velocityY *= 0.9800000190734863;
                this.velocityZ *= 0.9800000190734863;
                if (this.fluid != Fluids.EMPTY) {
                    BlockPos blockPos = BlockPos.ofFloored(this.x, this.y, this.z);
                    FluidState fluidState = this.world.getFluidState(blockPos);
                    if (fluidState.getFluid() == this.fluid && this.y < (double)((float)blockPos.getY() + fluidState.getHeight(this.world, blockPos))) {
                        this.markDead();
                    }

                }
            }
        }
    }

    protected void updateAge() {
        if (this.maxAge-- <= 0) {
            this.markDead();
        }

    }

    protected void updateVelocity() {
    }
    @Environment(EnvType.CLIENT)
    public static class Dripping extends ModBlockLeakParticle {
        private final ParticleEffect nextParticle;

        Dripping(ClientWorld world, double x, double y, double z, Fluid fluid, ParticleEffect nextParticle) {
            super(world, x, y, z, fluid);
            this.nextParticle = nextParticle;
            this.gravityStrength *= 0.02F;
            this.maxAge = 40;
        }

        protected void updateAge() {
            if (this.maxAge-- <= 0) {
                this.markDead();
                this.world.addParticle(this.nextParticle, this.x, this.y, this.z, this.velocityX, this.velocityY, this.velocityZ);
            }

        }

        protected void updateVelocity() {
            this.velocityX *= 0.02;
            this.velocityY *= 0.02;
            this.velocityZ *= 0.02;
        }
    }
    @Environment(EnvType.CLIENT)
    private static class ContinuousFalling extends Falling {
        protected final ParticleEffect nextParticle;

        ContinuousFalling(ClientWorld world, double x, double y, double z, Fluid fluid, ParticleEffect nextParticle) {
            super(world, x, y, z, fluid);
            this.nextParticle = nextParticle;
        }

        protected void updateVelocity() {
            if (this.onGround) {
                this.markDead();
                this.world.addParticle(this.nextParticle, this.x, this.y, this.z, 0.0, 0.0, 0.0);
            }

        }
    }

    @Environment(EnvType.CLIENT)
    static class Landing extends ModBlockLeakParticle {
        Landing(ClientWorld clientWorld, double d, double e, double f, Fluid fluid) {
            super(clientWorld, d, e, f, fluid);
            this.maxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        }
    }

    @Environment(EnvType.CLIENT)
    static class Falling extends ModBlockLeakParticle {
        Falling(ClientWorld clientWorld, double d, double e, double f, Fluid fluid) {
            this(clientWorld, d, e, f, fluid, (int)(64.0 / (Math.random() * 0.8 + 0.2)));
        }

        Falling(ClientWorld world, double x, double y, double z, Fluid fluid, int maxAge) {
            super(world, x, y, z, fluid);
            this.maxAge = maxAge;
        }

        protected void updateVelocity() {
            if (this.onGround) {
                this.markDead();
            }

        }
    }

    public static Particle createDrippingBlockTear(SimpleParticleType nextParticle, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        Dripping dripping = new Dripping(world, x, y, z, Fluids.EMPTY, nextParticle);
        dripping.obsidianTear = true;
        dripping.gravityStrength *= 0.01F;
        dripping.maxAge = 100;
        return  dripping;
    }
    public static Particle createFallingBlockTear(SimpleParticleType nextParticle, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        ModBlockLeakParticle modBlockLeakParticle = new ContinuousFalling(world, x, y, z, Fluids.EMPTY, nextParticle);
        modBlockLeakParticle.obsidianTear = true;
        modBlockLeakParticle.gravityStrength = 0.01F;
        return modBlockLeakParticle;
    }

    public static SpriteBillboardParticle createLandingBlockTear(SimpleParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        ModBlockLeakParticle modBlockLeakParticle = new Landing(world, x, y, z, Fluids.EMPTY);
        modBlockLeakParticle.obsidianTear = true;
        modBlockLeakParticle.maxAge = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        return modBlockLeakParticle;
    }


}
