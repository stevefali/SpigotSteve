package org.steve.spigotsteve.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class DropEvent implements Listener {


    @EventHandler
    public void blockDrop(BlockDropItemEvent event) {

        ArrayList<ItemStack> moddedLoot = new ArrayList<>();

        World world = event.getBlock().getWorld();
        Location location = event.getBlock().getLocation();


        event.getItems().forEach(item -> {
            getLogger().info(item.getName() + " was dropped!");
            moddedLoot.add(new ItemStack(Material.GOLD_BLOCK));
//            event.getItems().remove(item);
        });

        event.setCancelled(true);

        getLogger().info("# of vanilla drops: " + moddedLoot.size());
        world.dropItemNaturally(location, new ItemStack(Material.DIAMOND_BLOCK));

    }

    @EventHandler
    public void entityDrop(EntityDropItemEvent event) {



        getLogger().info(event.getItemDrop().getName() + " was dropped by " + event.getEntity().getName());
    }


}
