package org.steve.spigotsteve;


import org.bukkit.GameRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.spigotsteve.commands.RandomizationCommands;
import org.steve.spigotsteve.events.DropEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public final class SpigotSteve extends JavaPlugin {

    private final FileConfiguration config = getConfig();
    public DropEvent dropEvent;

    public final String[] spigotSteveRules = {"doBlockRandomDrops", "doEntityRandomDrops", "doPlayerRandomDrops"};

    @Override
    public void onEnable() {
        // Plugin startup logic

        for (String rule : spigotSteveRules) {
            config.addDefault(rule, true);
        }

        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("spigotSteve").setExecutor(new RandomizationCommands(config, spigotSteveRules));

        dropEvent = new DropEvent(config);
        getServer().getPluginManager().registerEvents(dropEvent, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();

        HandlerList.unregisterAll(dropEvent);
    }





}

