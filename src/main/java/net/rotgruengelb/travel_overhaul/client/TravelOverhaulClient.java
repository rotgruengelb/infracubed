package net.rotgruengelb.travel_overhaul.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class TravelOverhaulClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(new StepChanger());

    }
}
