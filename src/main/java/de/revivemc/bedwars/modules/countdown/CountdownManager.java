package de.revivemc.bedwars.modules.countdown;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.gamephase.GameModule;
import de.revivemc.bedwars.modules.gamephase.GamePhase;
import de.revivemc.bedwars.modules.gamephase.GameState;
import eu.thesimplecloud.api.service.ServiceState;
import eu.thesimplecloud.plugin.startup.CloudPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class CountdownManager {

    private final Countdown countdown;


    public CountdownManager() {
        this.countdown = new Countdown();
    }

    public boolean isCountdownActive() {
        return Bukkit.getScheduler().isCurrentlyRunning(countdown.task);
    }

    public void stopCooldown(final String prefix) {
        if (isCountdownActive()) {
            Bukkit.getScheduler().cancelTask(countdown.task);
            this.countdown.countdown = 30;
            Bukkit.getOnlinePlayers().forEach(players -> {
                players.sendMessage(prefix + "Der Countdown wurde unterbrochen.");
                players.playSound(players.getLocation(), Sound.ANVIL_BREAK, 1, 1);
            });
        }
    }

    public void startCooldown(final String prefix, final Player player) {
        countdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (countdown.countdown == 0) {
                    Bukkit.getScheduler().cancelTask(countdown.task);
                    Bukkit.getOnlinePlayers().forEach(players -> {
                        players.sendMessage(prefix + "Das Spiel startert jetzt.");
                        players.playSound(players.getLocation(), Sound.LEVEL_UP, 1, 1);
                    });
                    GameState.setState(GameState.INGAME);
                    GameModule.changeGameToIngame(player);

                    CloudPlugin.getInstance().thisService().setState(ServiceState.INVISIBLE);
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
