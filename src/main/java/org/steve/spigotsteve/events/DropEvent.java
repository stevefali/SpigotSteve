package org.steve.spigotsteve.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.steve.spigotsteve.drops.RandomDrops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class DropEvent implements Listener {


    @EventHandler
    public void blockDrop(BlockDropItemEvent event) {

        if (RandomDrops.getShuffledList() == null) {
            RandomDrops.shuffleItems(event.getBlock().getWorld().getSeed());
        }

        ArrayList<Material> moddedLoot = new ArrayList<>();

        World world = event.getBlock().getWorld();
        Location location = event.getBlock().getLocation();

        event.getItems().forEach(item -> {
            moddedLoot.add(item.getItemStack().getType());
//
        });

        event.setCancelled(true);

        moddedLoot.forEach(vanillaDrop -> {
//            Material randomizedDrop = RandomDrops.getRandomizedItem(vanillaDrop);
//            try {
//                world.dropItemNaturally(location, new ItemStack(randomizedDrop));
//            } catch (Exception e) {
//                getLogger().info("** Error dropping " + randomizedDrop.name());
//            }
            dropSomething(location, world, vanillaDrop);
        });
    }

    @EventHandler
    public void entityDrop(EntityDeathEvent event) {
        if (RandomDrops.getShuffledList() == null) {
            RandomDrops.shuffleItems(event.getEntity().getWorld().getSeed());
        }

        World world = event.getEntity().getWorld();
        Location location = event.getEntity().getLocation();

        ArrayList<Material> moddedLoot = new ArrayList<>();

        event.getDrops().forEach(item -> {
            moddedLoot.add(item.getType());
        });

        event.getDrops().clear();

        moddedLoot.forEach(vanillaDrop -> {
            dropSomething(location, world, vanillaDrop);
        });
    }


    private void dropSomething(Location location, World world, Material vanillaLoot) {
        Material randomizedLoot = RandomDrops.getRandomizedItem(vanillaLoot);
        try {
            world.dropItemNaturally(location, new ItemStack(randomizedLoot));
        } catch (Exception e) {
            getLogger().info("*** Error dropping " + randomizedLoot.name());
        }
    }




}
