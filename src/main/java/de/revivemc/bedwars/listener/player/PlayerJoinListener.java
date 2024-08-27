package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.gamephase.GamePhase;
import de.revivemc.bedwars.modules.inventory.InventoryModule;
import de.revivemc.bedwars.modules.scoreboard.ScoreboardModule;
import de.revivemc.bedwars.modules.setup.GameStateBuilder;
import de.revivemc.bedwars.modules.setup.LocationBuilder;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        final GamePhase gamePhase = new GamePhase();
        final ScoreboardModule scoreboardModule = new ScoreboardModule();
        final ReviveMCPlayer reviveMCPlayer = new ReviveMCPlayer(player.getUniqueId());
        final GameStateBuilder gameStateBuilder = new GameStateBuilder();
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);
        final InventoryModule inventoryModule = new InventoryModule(player);
        event.setJoinMessage(null);
        player.getInventory().clear();

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.playSound(players.getLocation(), Sound.LEVEL_UP, 1, 1);
            players.sendMessage(prefix + "Der Spieler " + reviveMCPlayer.getSecondColor() + player.getName() + " §7hat das Spiel betreten.");
        }

        //reviveMCPlayer.setTablist();
        scoreboardModule.buildLobbyScoreboard(reviveMCPlayer);
        inventoryModule.setLobbyInventory();
        final LocationBuilder locationBuilder = new LocationBuilder();
        player.teleport(locationBuilder.getWaitingLobby());

        return;
    }
}
