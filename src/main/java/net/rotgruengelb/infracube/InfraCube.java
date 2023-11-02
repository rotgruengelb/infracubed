package net.rotgruengelb.infracubed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.rotgruengelb.infracubed.block.ModBlocks;
import net.rotgruengelb.infracubed.util.CampfireUpdraftChecker;
import net.rotgruengelb.quirl.mechanics.interact.shovel.v1.CustomShovelBlockInteract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfraCube implements ModInitializer {

    public static final String MOD_ID = "infracubed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        CustomShovelBlockInteract.addResult(Blocks.WARPED_NYLIUM.getDefaultState(), ModBlocks.WARPED_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);
        CustomShovelBlockInteract.addResult(Blocks.CRIMSON_NYLIUM.getDefaultState(), ModBlocks.CRIMSON_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);

        ServerTickEvents.START_SERVER_TICK.register(new CampfireUpdraftChecker());
    }
}
