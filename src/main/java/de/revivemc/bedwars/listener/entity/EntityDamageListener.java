package de.revivemc.bedwars.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onPlayerDamageListener(EntityDamageEvent event) {
        event.setCancelled(true);
    }
}
