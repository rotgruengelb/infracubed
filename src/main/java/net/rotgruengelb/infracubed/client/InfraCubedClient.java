package net.rotgruengelb.infracubed.client;

import net.fabricmc.api.ClientModInitializer;
import net.rotgruengelb.infracubed.event.ModEvents;

public class InfraCubedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModEvents.registerModClientEvents();

    }
}
