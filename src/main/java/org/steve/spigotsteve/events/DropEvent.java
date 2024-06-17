package org.steve.spigotsteve.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
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
//            getLogger().info(item.getName() + " was dropped! " + item.getItemStack().getType().name());
            moddedLoot.add(item.getItemStack().getType());
//
        });

        event.setCancelled(true);

        getLogger().info("# of vanilla drops: " + moddedLoot.size());
//        world.dropItemNaturally(location, new ItemStack(Material.DIAMOND_BLOCK));
//
//        dropSomething(location, world, Material.CARROT);
//
        moddedLoot.forEach(vanillaDrop -> {
            Material randomizedDrop = RandomDrops.getRandomizedItem(vanillaDrop);
            try {
                world.dropItemNaturally(location, new ItemStack(randomizedDrop));
            } catch (Exception e) {
                getLogger().info("** Error dropping " + randomizedDrop.name());
            }
        });


    }

    @EventHandler
    public void entityDrop(EntityDropItemEvent event) {


        if (RandomDrops.getShuffledList() == null) {
            RandomDrops.shuffleItems(event.getEntity().getWorld().getSeed());
        }


        getLogger().info(event.getItemDrop().getName() + " was dropped by " + event.getEntity().getName());
    }


//    private void dropSomething(Location location, World world, Material material) {
//        try {
//            world.dropItemNaturally(location, new ItemStack(material));
//        } catch (Exception e) {
//            getLogger().info("******* Error material: " + material.name() + " ******");
//        }
//
//    }




}
