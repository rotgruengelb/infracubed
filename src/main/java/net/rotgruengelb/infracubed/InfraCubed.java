package net.rotgruengelb.infracubed;

import net.fabricmc.api.ModInitializer;
import net.rotgruengelb.infracubed.block.ModBlocks;
import net.rotgruengelb.infracubed.event.ModEvents;
import net.rotgruengelb.infracubed.util.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfraCubed implements ModInitializer {

    public static final String MOD_ID = "infracubed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModEvents.registerModServerEvents();
        ModBlocks.registerModBlocks();
        ModTags.registerModTags();
    }
}
