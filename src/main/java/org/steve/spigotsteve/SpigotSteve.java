package org.steve.spigotsteve;


import org.bukkit.GameRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.spigotsteve.commands.RandomizationCommands;
import org.steve.spigotsteve.events.DropEvent;


public final class SpigotSteve extends JavaPlugin {

    private final FileConfiguration config = getConfig();
    public DropEvent dropEvent;

    @Override
    public void onEnable() {
        // Plugin startup logic

        config.addDefault("doBlockRandomDrops", true);
        config.addDefault("doEntityRandomDrops", true);
        config.addDefault("doPlayerRandomDrops", true);
        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("spigotSteve").setExecutor(new RandomizationCommands(config));

        dropEvent = new DropEvent(config);
        getServer().getPluginManager().registerEvents(dropEvent, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(dropEvent);
    }



//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//
//        if (command.getName().equalsIgnoreCase("spigotsteve")) {
//            getLogger().info("SpigotSteve command executed. Rule is: " + args[0] + ", value entered is: " + args[1]);
//        }
//
//        return false;
//    }
//
}
