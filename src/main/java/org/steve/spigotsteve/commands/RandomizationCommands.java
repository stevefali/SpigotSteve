package org.steve.spigotsteve.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RandomizationCommands implements CommandExecutor {

    private final FileConfiguration fileConfig;

    private final String[] spigotSteveRules;



    public RandomizationCommands(FileConfiguration config, String[] spigotSteveRules) {
        this.fileConfig = config;
        this.spigotSteveRules = spigotSteveRules;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("spigotsteve")) {
            if (args.length != 2) {
                sendInputIncorrectMessage(sender);
            } else {
                if (args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("false")) {
                    for (String rule : spigotSteveRules) {
                        if (Objects.equals(args[0], rule)) {
                            fileConfig.set(rule, Boolean.valueOf(args[1]));
                            return true;
                        }
                    }
                }
                else  {
                    sendInputIncorrectMessage(sender);
                }
            }
        }


        return false;
    }

    private void sendInputIncorrectMessage(CommandSender sender) {
        sender.sendMessage("Error! Correct format for SpigotSteve GameRule commands is '/spigotSteve <rule> <true/false>'");
    }

}
