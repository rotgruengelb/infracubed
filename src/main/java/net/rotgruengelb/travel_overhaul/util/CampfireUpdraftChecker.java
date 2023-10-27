package net.rotgruengelb.travel_overhaul.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rotgruengelb.travel_overhaul.TravelOverhaul;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.block.CampfireBlock.SIGNAL_FIRE;

public class CampfireUpdraftChecker implements ServerTickEvents.StartTick {
    private static boolean isSignalCampfire(BlockState state) {
        return state.contains(SIGNAL_FIRE) && state.isIn(BlockTags.CAMPFIRES) && state.get(SIGNAL_FIRE);
    }

    @Override
    public void onStartTick(MinecraftServer server) {
        List<ServerPlayerEntity> players = server.getPlayerManager().getPlayerList();
        for (ServerPlayerEntity player : players) {

            World world = player.getWorld();
            BlockPos pos = player.getBlockPos();

            int range = 24;
            ItemStack chest_slot_content = player.getInventory().getArmorStack(2);

            if (chest_slot_content.getItem() instanceof ElytraItem && player.isFallFlying()) {

                for (int i = 0; i < range; i++) {
                    BlockState downBlock = world.getBlockState(pos.down(i));
                    if (!downBlock.isAir()) {
                        if (downBlock.isOf(Blocks.CAMPFIRE) || downBlock.isOf(Blocks.SOUL_CAMPFIRE)) {
                            if (CampfireBlock.isLitCampfire(downBlock)) {
                                Map<Integer, Double> valuesMap = new HashMap<>();
                                valuesMap.put(0, 0.0);
                                valuesMap.put(1, 0.0);
                                valuesMap.put(5, 0.7);
                                valuesMap.put(24, 0.0);

                                if (!isSignalCampfire(downBlock)) {
                                    valuesMap.put(2, 0.1);
                                    valuesMap.put(3, 0.2);
                                    valuesMap.put(4, 0.5);
                                    valuesMap.put(6, 0.7);
                                    valuesMap.put(7, 0.7);
                                    valuesMap.put(8, 0.5);
                                    valuesMap.put(9, 0.4);
                                    valuesMap.put(10, 0.2);
                                    valuesMap.put(11, 0.1);
                                    valuesMap.put(12, 0.0);
                                    valuesMap.put(13, 0.0);
                                    valuesMap.put(14, 0.0);
                                    valuesMap.put(15, 0.8);
                                    valuesMap.put(16, 0.0);
                                    valuesMap.put(17, 0.0);
                                    valuesMap.put(18, 0.0);
                                    valuesMap.put(19, 0.0);
                                    valuesMap.put(20, 0.0);
                                    valuesMap.put(21, 0.0);
                                    valuesMap.put(22, 0.0);
                                    valuesMap.put(23, 0.0);

                                } else {
                                    valuesMap.put(2, 0.1);
                                    valuesMap.put(3, 0.5);
                                    valuesMap.put(4, 0.7);
                                    valuesMap.put(6, 0.8);
                                    valuesMap.put(7, 1.0);
                                    valuesMap.put(8, 1.0);
                                    valuesMap.put(9, 1.2);
                                    valuesMap.put(10, 1.2);
                                    valuesMap.put(11, 1.2);
                                    valuesMap.put(12, 1.0);
                                    valuesMap.put(13, 1.0);
                                    valuesMap.put(14, 0.8);
                                    valuesMap.put(15, 0.8);
                                    valuesMap.put(16, 0.7);
                                    valuesMap.put(17, 0.5);
                                    valuesMap.put(18, 0.4);
                                    valuesMap.put(19, 0.2);
                                    valuesMap.put(20, 0.2);
                                    valuesMap.put(21, 0.1);
                                    valuesMap.put(22, 0.1);
                                    valuesMap.put(23, 0.1);
                                }
                                double updaft = valuesMap.get(i);

                                TravelOverhaul.LOGGER.info(String.valueOf(updaft));
                                if (updaft > 0.2) {
                                    player.addVelocity(0, updaft, 0);
                                    player.velocityModified = true;
                                    chest_slot_content.damage(1, Random.create(), player);
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}
