package org.steve.spigotsteve.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.steve.spigotsteve.SpigotSteve;

import static org.bukkit.Bukkit.getLogger;

public class SpigotSteveServerEvent implements Listener {

    @EventHandler
    public void serverReadyEvent(ServerLoadEvent event) {
        getLogger().info("Server  Loaded");
    }
}
