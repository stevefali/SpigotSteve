package org.steve.spigotsteve.events;

import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.steve.spigotsteve.SpigotSteve;
import org.steve.spigotsteve.drops.RandomDrops;
import java.util.ArrayList;
import java.util.Arrays;

import static org.bukkit.Bukkit.*;

public class DropEvent implements Listener {

    FileConfiguration config;
    public DropEvent(FileConfiguration config) {
        this.config = config;
    }

    //TODO: Make drop randomization conditional based on spigotSteve gameRules

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
        });


        event.setCancelled(true);

        moddedLoot.forEach(vanillaDrop -> {
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


    @EventHandler
    private void blockBreak(BlockBreakEvent event) {
        getLogger().info(event.getBlock().getType().name());

        if (event.getBlock().getType().name().equals("GRASS_BLOCK")) {
//            event.getBlock().getWorld().setGameRule(SpigotSteve.DO_PLAYER_RANDOM_DROPS, false);
            getLogger().info("Grass block matched!!");

        }

        getLogger().info("Block Random Drops: " + config.getBoolean("doBlockRandomDrops"));
//        getLogger().info("Player random drops: " + event.getBlock().getWorld().getGameRuleValue(SpigotSteve.DO_PLAYER_RANDOM_DROPS));





    }


}
