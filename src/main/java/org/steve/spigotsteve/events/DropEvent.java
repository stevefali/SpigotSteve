package org.steve.spigotsteve.events;

import org.bukkit.Registry;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

import static org.bukkit.Bukkit.getLogger;

public class DropEvent implements Listener {


    @EventHandler
    public void itemDrop(BlockDropItemEvent event) {

        event.getItems().forEach(item -> {
            getLogger().info(item.getName() + " was dropped!");
        });

    }


}
