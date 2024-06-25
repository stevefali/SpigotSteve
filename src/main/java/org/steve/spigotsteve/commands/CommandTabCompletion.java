package org.steve.spigotsteve.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandTabCompletion implements TabCompleter {

    private String[] spigotSteveRules;
    private final String[] tF = {"true", "false"};

    public CommandTabCompletion(String[] spigotSteveRules) {
        this.spigotSteveRules = spigotSteveRules;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("spigotsteve")) {
            List<String> suggestions = new ArrayList<>();
            //TODO: Shorten this!
            if (args.length <= 1) {
                for (String rule : spigotSteveRules) {
                    String suggestion = matchTypedLetters(args[0], rule);
                    if (suggestion != null) {
                        suggestions.add(suggestion);
                    }
                }
                return suggestions;
            }
            else if (args.length == 2) {
                for (String word : tF) {
                    String suggestion = matchTypedLetters(args[1], word);
                    if (suggestion != null) {
                        suggestions.add(suggestion);
                    }
                }
                return suggestions;
            }
        }

        return null;
    }

    private String matchTypedLetters(String typedArg, String rule) {
        if (rule.substring(0, typedArg.length()).equalsIgnoreCase(typedArg)) {
            return rule;
        } else {
            return null;
        }
    }
}
