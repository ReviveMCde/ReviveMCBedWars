package de.revivemc.bedwars.modules.scoreboard;

import de.revivemc.bedwars.modules.team.TeamModule;
import de.revivemc.core.ReviveMCAPI;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import de.revivemc.core.playerutils.scoreboard.ReviveMCScoreboardBuilder;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.Bukkit;

public class ScoreboardModule {

    public void buildLobbyScoreboard(ReviveMCPlayer reviveMCPlayer) {
        reviveMCPlayer.initialScoreboard();
        final ReviveMCScoreboardBuilder reviveMCScoreboardBuilder = reviveMCPlayer.getCyturaScoreboardBuilder();
        reviveMCScoreboardBuilder.setLine(7, "§8§m---------", "§8§m---------");
        reviveMCScoreboardBuilder.setLine(6, " ", " ");
        reviveMCScoreboardBuilder.setLine(5, " §8§l» ", "§7Ranking");
        reviveMCScoreboardBuilder.setLine(4, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(3, " ", " ");
        reviveMCScoreboardBuilder.setLine(2, " §8§l» ", "§7Map");
        reviveMCScoreboardBuilder.setLine(1, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(0, " ", " ");
        MinecraftServer.getServer().postToMainThread(() -> {
            reviveMCScoreboardBuilder.setBoard(reviveMCPlayer.getFirstColor() + "§lReviveMC §8× §7BedWars");
            Bukkit.getOnlinePlayers().forEach(player -> {
                ReviveMCAPI.getInstance().getCyturaTablistManager().setDefaultTablist(ReviveMCAPI.getInstance().getCyturaPlayerManager().getPlayers().get(player.getUniqueId()));
            });
        });
    }

    public void buildInGameScoreboard(ReviveMCPlayer reviveMCPlayer) {
        reviveMCPlayer.initialScoreboard();
        final ReviveMCScoreboardBuilder reviveMCScoreboardBuilder = reviveMCPlayer.getCyturaScoreboardBuilder();
        final TeamModule teamModule = new TeamModule();
        reviveMCScoreboardBuilder.setLine(10, "§8§m---------", "§8§m---------");
        reviveMCScoreboardBuilder.setLine(9, " ", " ");
        reviveMCScoreboardBuilder.setLine(8, " §8§l» ", "§7Map");
        reviveMCScoreboardBuilder.setLine(7, " §8» ", reviveMCPlayer.getSecondColor() + "MAP");
        reviveMCScoreboardBuilder.setLine(6, " ", " ");
        reviveMCScoreboardBuilder.setLine(5, " §8§l» ", "Team1");
        reviveMCScoreboardBuilder.setLine(4, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(3, " ", " ");
        reviveMCScoreboardBuilder.setLine(2, " §8§l» ", "Team2");
        reviveMCScoreboardBuilder.setLine(1, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(0, " ", " ");
        MinecraftServer.getServer().postToMainThread(() -> {
            reviveMCScoreboardBuilder.setBoard(reviveMCPlayer.getFirstColor() + "§lReviveMC §8× §7BedWars");
            Bukkit.getOnlinePlayers().forEach(player -> {
                ReviveMCAPI.getInstance().getCyturaTablistManager().setDefaultTablist(ReviveMCAPI.getInstance().getCyturaPlayerManager().getPlayers().get(player.getUniqueId()));
            });
        });
    }

    public void buildEndScoreboard(ReviveMCPlayer reviveMCPlayer) {
        reviveMCPlayer.initialScoreboard();
        final ReviveMCScoreboardBuilder reviveMCScoreboardBuilder = reviveMCPlayer.getCyturaScoreboardBuilder();
        reviveMCScoreboardBuilder.setLine(10, "§8§m---------", "§8§m---------");
        reviveMCScoreboardBuilder.setLine(9, " ", " ");
        reviveMCScoreboardBuilder.setLine(8, " §8§l» ", "§7Rang");
        reviveMCScoreboardBuilder.setLine(7, " §8» ", reviveMCPlayer.getPermissionGroupColor() + reviveMCPlayer.getPermissionGroup().getName());
        reviveMCScoreboardBuilder.setLine(6, " ", " ");
        reviveMCScoreboardBuilder.setLine(5, " §8§l» ", "§7DEIN NAME");
        reviveMCScoreboardBuilder.setLine(4, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(3, " ", " ");
        reviveMCScoreboardBuilder.setLine(2, " §8§l» ", "§7GEGNER NAME");
        reviveMCScoreboardBuilder.setLine(1, " §8» ", reviveMCPlayer.getSecondColor() + "0");
        reviveMCScoreboardBuilder.setLine(0, " ", " ");
        MinecraftServer.getServer().postToMainThread(() -> {
            reviveMCScoreboardBuilder.setBoard(reviveMCPlayer.getFirstColor() + "§lReviveMC §8× §7BedWars");
            Bukkit.getOnlinePlayers().forEach(player -> {
                ReviveMCAPI.getInstance().getCyturaTablistManager().setDefaultTablist(ReviveMCAPI.getInstance().getCyturaPlayerManager().getPlayers().get(player.getUniqueId()));
            });
        });
    }
}
