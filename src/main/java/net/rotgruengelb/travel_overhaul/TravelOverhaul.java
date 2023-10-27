package net.rotgruengelb.travel_overhaul;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.rotgruengelb.quirl.behavior.shovel.v1.CustomShovelInteract;
import net.rotgruengelb.travel_overhaul.block.ModBlocks;
import net.rotgruengelb.travel_overhaul.util.CampfireUpdraftChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelOverhaul implements ModInitializer {

    public static final String MOD_ID = "travel_overhaul";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        CustomShovelInteract.addResult(Blocks.WARPED_NYLIUM.getDefaultState(), ModBlocks.WARPED_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);
        CustomShovelInteract.addResult(Blocks.CRIMSON_NYLIUM.getDefaultState(), ModBlocks.CRIMSON_NYLIUM_PATH.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);

        ServerTickEvents.START_SERVER_TICK.register(new CampfireUpdraftChecker());
    }
}
