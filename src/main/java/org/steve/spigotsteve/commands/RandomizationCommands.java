package org.steve.spigotsteve.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import static org.bukkit.Bukkit.getLogger;

public class RandomizationCommands  implements CommandExecutor {

    private final FileConfiguration fileConfig;
    public RandomizationCommands(FileConfiguration config) {
        this.fileConfig = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("spigotsteve")) {
            if (args.length != 2) {
                sendInputIncorrectMessage(sender);
            } else {
                getLogger().info("SpigotSteve command executed. Rule is: " + args[0] + ", value entered is: " + args[1]);
            }

        }


        return false;
    }

    private void sendInputIncorrectMessage(CommandSender sender) {
        sender.sendMessage("Error! Correct format for SpigotSteve GameRule commands is '/spigotSteve <rule> <true/false>'");
    }
}
