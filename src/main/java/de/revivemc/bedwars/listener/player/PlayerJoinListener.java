package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.countdown.CountdownManager;
import de.revivemc.bedwars.modules.gamephase.GamePhase;
import de.revivemc.bedwars.modules.gamephase.GameState;
import de.revivemc.bedwars.modules.inventory.InventoryModule;
import de.revivemc.bedwars.modules.scoreboard.ScoreboardModule;
import de.revivemc.bedwars.modules.setup.builder.GameStateBuilder;
import de.revivemc.bedwars.modules.setup.builder.LocationBuilder;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import de.revivemc.core.playerutils.events.ReviveMCPlayerJoinEvent;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.service.ServiceState;
import eu.thesimplecloud.plugin.startup.CloudPlugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(ReviveMCPlayerJoinEvent event) {
        Player player = event.getPlayer();
        final GamePhase gamePhase = new GamePhase();
        final ScoreboardModule scoreboardModule = new ScoreboardModule();
        final ICloudPlayer iCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(player.getUniqueId());
        final ReviveMCPlayer reviveMCPlayer = new ReviveMCPlayer(player.getUniqueId());
        final GameStateBuilder gameStateBuilder = BedWars.getInstance().getGameStateBuilder();
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);
        final InventoryModule inventoryModule = new InventoryModule(player);
        final CountdownManager countdownManager = new CountdownManager();
        final int leftPlayersToStart = gameStateBuilder.minimumPlayersToStart() - Bukkit.getOnlinePlayers().size();
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setGameMode(GameMode.SURVIVAL);
        scoreboardModule.buildLobbyScoreboard(reviveMCPlayer);
        inventoryModule.setLobbyInventory();
        final LocationBuilder locationBuilder = new LocationBuilder();
        player.teleport(locationBuilder.getWaitingLobby());
        reviveMCPlayer.setTablist();


        if (GameState.isState(GameState.LOBBY)) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.LEVEL_UP, 1, 1);
                players.sendMessage(prefix + "Der Spieler " + reviveMCPlayer.getSecondColor() + player.getName() + " §7hat das Spiel betreten.");
                if (Bukkit.getOnlinePlayers().size() < gameStateBuilder.minimumPlayersToStart()) {
                    if (leftPlayersToStart == 1) {
                        players.sendMessage(prefix + "Es wird noch ein Spieler benötigt damit das Spiel starten kann.");
                    } else {
                        players.sendMessage(prefix + "Es werden noch " + reviveMCPlayer.getSecondColor() + leftPlayersToStart + " §7Spieler benötigt damit das Spiel starten kann.");
                    }
                } else {
                    if (!countdownManager.isCountdownActive()) {
                        countdownManager.startCooldown(prefix, player);
                    }
                }
            }
        } else if (GameState.isState(GameState.INGAME)) {
            return;
        } else if (GameState.isState(GameState.END )) {
            return;
        }
    }
}
