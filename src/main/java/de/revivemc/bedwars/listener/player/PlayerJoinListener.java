package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.BedWars;
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
        final int leftPlayersToStart = gameStateBuilder.minimumPlayersToStart() - Bukkit.getOnlinePlayers().size();
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setHealth(20);
        scoreboardModule.buildLobbyScoreboard(reviveMCPlayer);
        inventoryModule.setLobbyInventory();
        final LocationBuilder locationBuilder = new LocationBuilder();
        player.teleport(locationBuilder.getWaitingLobby());
        reviveMCPlayer.setTablist();


        if (GameState.isState(GameState.LOBBY)) {
            player.sendMessage(prefix + "Current Gamestate: LOBBY");
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
                    startCooldown(prefix);
                }
            }
        } else if (GameState.isState(GameState.INGAME)) {
            return;
        } else if (GameState.isState(GameState.END )) {
            return;
        }
    }

    public void startCooldown(String prefix) {
        Countdown countdown = new Countdown();
        countdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (countdown.countdown == 0) {
                    Bukkit.getScheduler().cancelTask(countdown.task);
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.sendMessage(prefix + "Das Spiel startert jetzt.");
                        players.playSound(players.getLocation(), Sound.LEVEL_UP, 1, 1);
                    });
                    //gameModule.changeGameToInGame(player);

                    CloudPlugin.getInstance().thisService().setState(ServiceState.VISIBLE);
                    CloudPlugin.getInstance().thisService().update();
                }

                if (countdown.countdown == 30) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 30 Sekunen.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 15) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 15 Sekunden.");
                    Bukkit.broadcastMessage(prefix + "Votingphase abgeschlossen.");
                    CloudPlugin.getInstance().thisService().setMOTD("MAPNAME");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 10) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 10 Sekunden.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 5) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 5 Sekunden.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 4) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 4 Sekunden.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 3) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 3 Sekunden.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 2) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 2 Sekunden.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }

                if (countdown.countdown == 1) {
                    Bukkit.broadcastMessage(prefix + "Das Spiel startet in 1 Sekunde.");
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 1, 1);
                    });
                }


                countdown.countdown--;
            }
        }, 0, 20);
    }



    public class Countdown {
        public int countdown = 30;
        public int task;
    }
}
