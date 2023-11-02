package net.rotgruengelb.infracubed.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin {
    private double getMaxSpeedMultiplier() {

        BlockPos pos = ((AbstractMinecartEntity) (Object) this).getBlockPos();

        BlockState inState = ((AbstractMinecartEntity) (Object) this).getEntityWorld().getBlockState(pos);
        BlockState underState = ((AbstractMinecartEntity) (Object) this).getEntityWorld().getBlockState(pos.down());

        double multiplier = 1.1F;

        if (underState.isOf(Blocks.GRAVEL)) {
            multiplier += 0.06F;
            if (inState.isOf(Blocks.POWERED_RAIL) && inState.get(Properties.POWERED)) {
                multiplier += 0.6F;
            }
        }

        if (inState.isOf(Blocks.POWERED_RAIL) && inState.get(Properties.POWERED)) {
            multiplier += 0.2F;
        }

        if (underState.isOf(Blocks.SPONGE)) {
            multiplier = 1F;
        }

        return multiplier;
    }

    @Inject(method = "getMaxSpeed", at = @At("RETURN"), cancellable = true)
    private void getMaxSpeed(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(cir.getReturnValue() * getMaxSpeedMultiplier());
    }

    private float getVelocityMultiplierMultiplier() {

        BlockPos pos = ((AbstractMinecartEntity) (Object) this).getBlockPos();

        BlockState inState = ((AbstractMinecartEntity) (Object) this).getEntityWorld().getBlockState(pos);
        BlockState underState = ((AbstractMinecartEntity) (Object) this).getEntityWorld().getBlockState(pos.down());

        float multiplier = 1.01F;

        if (underState.isOf(Blocks.GRAVEL)) {
            multiplier += 0.02F;
            if (inState.isOf(Blocks.POWERED_RAIL) && inState.get(Properties.POWERED)) {
                multiplier += 0.03F;
            }
        }

        if (inState.isOf(Blocks.POWERED_RAIL) && inState.get(Properties.POWERED)) {
            multiplier += 0.03F;
        }

        if (underState.isOf(Blocks.SPONGE)) {
            multiplier = 1F;
        }

        return multiplier;
    }

    @Inject(method = "getVelocityMultiplier", at = @At("RETURN"), cancellable = true)
    private void getVelocityMultiplier(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(cir.getReturnValue() * getVelocityMultiplierMultiplier());
    }
}