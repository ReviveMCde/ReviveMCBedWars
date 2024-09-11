package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.build.BuildModule;
import de.revivemc.bedwars.modules.countdown.CountdownManager;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final BuildModule buildModule = new BuildModule(player.getUniqueId());
        final ReviveMCPlayer reviveMCPlayer = new ReviveMCPlayer(player.getUniqueId());
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);
        final CountdownManager countdownManager = new CountdownManager();
        if (buildModule.playerExists()) {
            if (buildModule.getBuildModeState()) {
                buildModule.setBuildModeState(false);
            }
        }
        countdownManager.stopCooldown(prefix);


        event.setQuitMessage(prefix + "Der Spieler " + reviveMCPlayer.getSecondColor() + player.getName() + " §7hat das Spiel verlassen.");

    }
}
