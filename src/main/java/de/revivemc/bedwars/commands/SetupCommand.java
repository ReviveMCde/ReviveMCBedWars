package de.revivemc.bedwars.commands;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.setup.GameStateBuilder;
import de.revivemc.bedwars.modules.setup.LocationBuilder;
import de.revivemc.bedwars.modules.setup.MapBuilder;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final Player player = (Player) sender;
        final ReviveMCPlayer reviveMCPlayer = new ReviveMCPlayer(player.getUniqueId());
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);

        if (!player.hasPermission("bedwars.setup")) {
            player.sendMessage(prefix + "§cDu hast keine Rechte auf diesen Befehl.");
            return true;
        }

        final GameStateBuilder gameStateBuilder = new GameStateBuilder();
        final LocationBuilder locationBuilder = new LocationBuilder();
        final MapBuilder mapBuilder = new MapBuilder();

        if (args.length == 0) {
            displaySetupsOptions(prefix, player);
            return true;
        }

        if (args[0].equalsIgnoreCase("setwaitinglobby")) {
            locationBuilder.createWaitingLobby(player.getLocation());
            player.sendMessage(prefix + "Du hast den Spawnpunkt für die WarteLobby gesetzt.");

            return true;
        }else if (args[0].equalsIgnoreCase("newmap")) {
            player.sendMessage(prefix + "return");

            return true;
        } else if (args[0].equalsIgnoreCase("configuremap")) {
            if (args.length != 2) {
                player.sendMessage(prefix + "Verwende: 'setup configuremap <MapName>' §8| §7Konfiguriere eine bestehende Map.");

                return true;
            }

            player.sendMessage(prefix + "return");

            return true;
        } else {
            displaySetupsOptions(prefix, player);
        }

        return false;
    }

    public void displaySetupsOptions(final String prefix, final Player player) {
        player.sendMessage(prefix + "§m-----------------------");
        player.sendMessage(prefix + "BedWars - Setup");
        player.sendMessage(prefix + " ");
        player.sendMessage(prefix + "/setup setwaitinglobby §8| §7Setzte den WarteLobby Spawn.");
        player.sendMessage(prefix + "/setup newmap §8| §7Richte eine neue Map ein.");
        player.sendMessage(prefix + "/setup configuremap <MapName> §8| §7Konfiguriere eine bestehende Map.");
        player.sendMessage(prefix + " ");
        player.sendMessage(prefix + "§m-----------------------");
    }
}
