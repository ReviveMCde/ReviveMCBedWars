package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.modules.build.BuildModule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final BuildModule buildModule = new BuildModule(event.getPlayer().getUniqueId());
        if (buildModule.getBuildModeState()) {
            event.setCancelled(false);
            return;
        }
        event.setCancelled(true);
    }
}
