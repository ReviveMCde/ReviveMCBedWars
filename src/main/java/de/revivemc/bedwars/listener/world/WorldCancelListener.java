package de.revivemc.bedwars.listener.world;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldCancelListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

    }

    @EventHandler
    public void onhandle(PlayerInteractEvent event) {
        try {
            if (event.getPlayer().getItemInHand().getType() == Material.FIREWORK) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.TRAP_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DARK_OAK_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ACACIA_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.BIRCH_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.JUNGLE_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.WOODEN_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.BEACON) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.COMMAND) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.CHEST) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ENDER_CHEST) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ARMOR_STAND) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DAYLIGHT_DETECTOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DAYLIGHT_DETECTOR_INVERTED) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.HOPPER) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ANVIL) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.FURNACE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DARK_OAK_FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ACACIA_FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.BIRCH_FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.JUNGLE_FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.SPRUCE_FENCE_GATE) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.NOTE_BLOCK) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.WORKBENCH) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.LEVER) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.STONE_BUTTON) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.WOOD_BUTTON) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DARK_OAK_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.ACACIA_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.WOODEN_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.DISPENSER) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.JUNGLE_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.BIRCH_DOOR) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType() == Material.SPRUCE_DOOR) {
                event.setCancelled(true);
            }
        } catch (Exception ex) {
            ;
        }
    }

    @EventHandler
    public void noUproot(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.SOIL) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrameManipulate(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof ItemFrame) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
}
