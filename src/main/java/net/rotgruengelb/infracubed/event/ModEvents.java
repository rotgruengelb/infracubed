package net.rotgruengelb.infracubed.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.rotgruengelb.infracubed.InfraCubed;
import net.rotgruengelb.infracubed.block.ModBlocks;
import net.rotgruengelb.infracubed.event.client.StepChanger;
import net.rotgruengelb.infracubed.event.server.CampfireUpdraft;
import net.rotgruengelb.quirl.mechanics.interact.shovel.v1.CustomShovelBlockInteract;

public class ModEvents {

    public static void registerModClientEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(new StepChanger());
        InfraCubed.LOGGER.info("Registering ModClientEvents for " + InfraCubed.MOD_ID);
    }

    public static void registerModServerEvents() {
        ServerTickEvents.START_SERVER_TICK.register(new CampfireUpdraft());
        CustomShovelBlockInteract.addResult(Blocks.WARPED_NYLIUM.getDefaultState(), ModBlocks.WARPED_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);
        CustomShovelBlockInteract.addResult(Blocks.CRIMSON_NYLIUM.getDefaultState(), ModBlocks.CRIMSON_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);
        InfraCubed.LOGGER.info("Registering ModServerEvents for " + InfraCubed.MOD_ID);
    }
}
