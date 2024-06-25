package org.steve.spigotsteve.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.steve.spigotsteve.drops.RandomDrops;

import java.util.ArrayList;

import static org.bukkit.Bukkit.*;

public class DropEvent implements Listener {

    FileConfiguration config;

    public DropEvent(FileConfiguration config) {
        this.config = config;
    }

    @EventHandler
    public void blockDrop(BlockDropItemEvent event) {

        if (RandomDrops.getShuffledList() == null) {
            RandomDrops.shuffleItems(event.getBlock().getWorld().getSeed());
        }

        if (config.getBoolean("doBlockRandomDrops")) {

            ArrayList<Material> moddedLoot = new ArrayList<>();

            World world = event.getBlock().getWorld();
            Location location = event.getBlock().getLocation();

            event.getItems().forEach(item -> {
                moddedLoot.add(item.getItemStack().getType());
            });

            event.setCancelled(true);

            moddedLoot.forEach(vanillaDrop -> {
                dropSomething(location, world, vanillaDrop);
            });
        }
    }

    @EventHandler
    public void entityDrop(EntityDeathEvent event) {
        if (RandomDrops.getShuffledList() == null) {
            RandomDrops.shuffleItems(event.getEntity().getWorld().getSeed());
        }

        if (event.getEntity() instanceof Player) {
            if (config.getBoolean("doPlayerRandomDrops")) {
                modifyEntityDrops(event);
            }

        } else if (config.getBoolean("doEntityRandomDrops")) {
            modifyEntityDrops(event);
        }
    }

    private void modifyEntityDrops(EntityDeathEvent event) {
        World world = event.getEntity().getWorld();
        Location location = event.getEntity().getLocation();

        ArrayList<Material> moddedLoot = new ArrayList<>();

        event.getDrops().forEach(item -> {
            for (int i = 0; i < item.getAmount(); i++) {
                moddedLoot.add(item.getType());
            }
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
