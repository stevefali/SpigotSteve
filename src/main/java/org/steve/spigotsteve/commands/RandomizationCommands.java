package org.steve.spigotsteve.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;
import java.util.function.Function;

import static org.bukkit.Bukkit.getLogger;

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
