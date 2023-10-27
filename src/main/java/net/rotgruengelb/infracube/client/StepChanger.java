package net.rotgruengelb.infracube.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rotgruengelb.infracube.util.ModTags;

public class StepChanger implements ClientTickEvents.EndTick {

    @Override
    public void onEndTick(MinecraftClient client) {
        if (client.player != null) {
            World world = client.player.getWorld();
            BlockPos pos = client.player.getBlockPos();

            if (world.getBlockState(pos).getBlock().getDefaultState().isIn(ModTags.Blocks.PATH_BLOCKS)) {
                client.player.setStepHeight(1.0000004F);

            } else if (!world.getBlockState(pos).getBlock().getDefaultState().isIn(ModTags.Blocks.PATH_BLOCKS)
                    && client.player.getStepHeight() == 1.0000004F) {
                client.player.setStepHeight(0.6F);
            }
        }
    }
}
