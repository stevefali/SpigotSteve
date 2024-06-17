package org.steve.spigotsteve;


import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.spigotsteve.events.DropEvent;


public final class SpigotSteve extends JavaPlugin {

    public DropEvent dropEvent;
    @Override
    public void onEnable() {
        // Plugin startup logic
        dropEvent = new DropEvent();
        getServer().getPluginManager().registerEvents(dropEvent, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(dropEvent);
    }
}
