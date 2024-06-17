package org.steve.spigotsteve;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.steve.spigotsteve.drops.RandomDrops;
import org.steve.spigotsteve.events.DropEvent;
import org.steve.spigotsteve.events.SpigotSteveServerEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public final class SpigotSteve extends JavaPlugin {

    public DropEvent dropEvent;
    SpigotSteveServerEvent serverEvent;
    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Number of Items: " + Material.values().length);
        getLogger().info("First item in list: " + Material.values()[0].name());
        getLogger().info("Last item in list: " + Material.values()[Material.values().length - 1].name());

        // TODO: Check Material names vs Item names - ID's or other way of getting Material from Item or ItemStack?
        // TODO: Possibly print out all Material items
        // TODO: Possibly make new exclusion list
        // TODO:

        ArrayList<Material> materials = new ArrayList<>();
        materials.addAll(List.of(Material.values()));

        getLogger().info("******** Material values: *********");
        materials.forEach(item -> {
            getLogger().info(item.toString());

        });

        getLogger().info("Finished printing");

        checkItemInList(materials, Material.ARROW);
        checkItemInList(materials, Material.SPECTRAL_ARROW);
        checkItemInList(materials, Material.DIRT);
        checkItemInList(materials, Material.GRASS);
        checkItemInList(materials, Material.DIAMOND_AXE);
        checkItemInList(materials, Material.GRASS_BLOCK);


        dropEvent = new DropEvent();
        serverEvent = new SpigotSteveServerEvent();
        getServer().getPluginManager().registerEvents(dropEvent, this);
        getServer().getPluginManager().registerEvents(serverEvent, this);


//        RandomDrops.shuffleItems();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(dropEvent);
        HandlerList.unregisterAll(serverEvent);
    }



    private void checkItemInList(ArrayList<Material> materials ,Material material) {
        getLogger().info("Contains + " + material.name() + ": " + materials.contains(material));
    }


}
