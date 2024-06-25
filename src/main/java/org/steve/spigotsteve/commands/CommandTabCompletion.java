package org.steve.spigotsteve.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.List;

public class CommandTabCompletion implements TabCompleter {

    private final String[] spigotSteveRules;
    private final String[] tF = {"true", "false"};

    public CommandTabCompletion(String[] spigotSteveRules) {
        this.spigotSteveRules = spigotSteveRules;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("spigotsteve")) {
            List<String> suggestions = new ArrayList<>();
            String[] completions = {};
            int index = 0;

            if (args.length <= 1) {
                completions = spigotSteveRules;
            } else if (args.length == 2) {
                completions = tF;
                index = 1;
            } else {
                return suggestions;
            }

            for (String word : completions) {
                String suggestion = matchTypedLetters(args[index], word);
                if (suggestion != null) {
                    suggestions.add(suggestion);
                }
            }
            return suggestions;
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
