package org.steve.spigotsteve;


import org.bukkit.GameRule;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.spigotsteve.events.DropEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public final class SpigotSteve extends JavaPlugin {

    public DropEvent dropEvent;

    public static GameRule DO_PLAYER_RANDOM_DROPS;
    @Override
    public void onEnable() {
        // Plugin startup logic
        dropEvent = new DropEvent();
        getServer().getPluginManager().registerEvents(dropEvent, this);

//        DO_PLAYER_RANDOM_DROPS.getClass().getConstructor(new GameRule("", Boolean.class));

        try {
            Class[] ruleArgs = new Class[2];
            ruleArgs[0] = String.class;
            ruleArgs[1] = Class.class;
            Constructor<GameRule> gameRuleConstructor = GameRule.class.getDeclaredConstructor(ruleArgs);
            gameRuleConstructor.setAccessible(true);

            DO_PLAYER_RANDOM_DROPS = gameRuleConstructor.newInstance("doPlayerRandomDrops", Boolean.class);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            getLogger().info(e.toString());
        }

//        new GameRule<>("doPlayerRandomDrops", Boolean.class);
        getLogger().info("***Game Rules: ***");
        Arrays.stream(GameRule.values()).toList().forEach(rule -> {
            getLogger().info(rule.getName());
        });

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(dropEvent);
    }
}
