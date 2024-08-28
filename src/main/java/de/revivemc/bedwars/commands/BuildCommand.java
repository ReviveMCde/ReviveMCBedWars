package de.revivemc.bedwars.commands;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.build.BuildModule;
import de.revivemc.core.ReviveMCAPI;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        final ReviveMCPlayer reviveMCPlayer = ReviveMCAPI.getInstance().getCyturaPlayerManager().getPlayers().get(player.getUniqueId());
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);
        if (!player.hasPermission("bedwars.build")) {
            player.sendMessage(prefix + "Du hast keine Rechte auf diesen Befehl.");
            return true;
        }

        if (args.length > 1) {
            player.sendMessage(prefix + "Verwende: 'build'");
            return true;
        }

        final BuildModule buildModule = new BuildModule(player.getUniqueId());

        if (!buildModule.playerExists()) {
            buildModule.insertIntoDatabase();
        }

        if (!buildModule.getBuildModeState()) {
            player.getInventory().clear();
            player.setGameMode(GameMode.CREATIVE);
            buildModule.setBuildModeState(true);
            player.sendMessage(prefix + "§cDu wurdest in den Bau-Modus versetzt.");
            return true;
        }

        player.setGameMode(GameMode.SURVIVAL);
        buildModule.setBuildModeState(false);
        player.sendMessage(prefix + "§cDu wurdest aus den Bau-Modus versetzt.");
        return false;
    }
}
