package de.revivemc.bedwars.commands;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.setup.builder.GameStateBuilder;
import de.revivemc.bedwars.modules.setup.builder.LocationBuilder;
import de.revivemc.bedwars.modules.setup.builder.MapBuilder;
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
        final String secondColor = reviveMCPlayer.getSecondColor();

        if (!player.hasPermission("bedwars.setup")) {
            player.sendMessage(prefix + "§cDu hast keine Rechte auf diesen Befehl.");
            return true;
        }

        final GameStateBuilder gameStateBuilder = new GameStateBuilder();
        final LocationBuilder locationBuilder = new LocationBuilder();

        if (args.length == 0) {
            displaySetupsOptions(prefix, player);
            return true;
        }

        if (args[0].equalsIgnoreCase("setwaitinglobby")) {
            locationBuilder.createWaitingLobby(player.getLocation());
            player.sendMessage(prefix + "Du hast den Spawnpunkt für die WarteLobby gesetzt.");

            return true;
        } else if (args[0].equalsIgnoreCase("setperksshop")) {

        }else if (args[0].equalsIgnoreCase("newmap")) {
            if (args.length != 2) {
                player.sendMessage(prefix + "Verwende: 'setup newmap <MapName>' §8| §7Erstelle eine neue Map.");
                return true;
            }

            /*if (mapManager.mapExists(args[1])) {
                player.sendMessage(prefix + "Eine Map mit diesem Namen existiert bereits in der Datenbank.");
                return true;
            }*/

            //mapManager.createNewMap(args[1].toString());
            player.sendMessage(prefix + "Du hast die Map " + secondColor + args[1] + " §7erfolgreich erstellt.");
            player.sendMessage(prefix + "Konfiguriere sie jetzt mit: 'setup configuremap <MapName>'");
            return true;
        } else if (args[0].equalsIgnoreCase("configuremap")) {
            if (args.length == 1) {
                player.sendMessage(prefix + "Verwende: 'setup configuremap <MapName>' §8| §7Konfiguriere eine bestehende Map.");
                return true;
            }

            /*if (!mapManager.mapExists(args[1])) {
                player.sendMessage(prefix + "Diese Map existiert nicht in der Datenbank!");
                return true;
            }*/

            if (args.length == 2) {
                displaySetupPhase(prefix, player);
                return true;
            }

            if (args[3].equalsIgnoreCase("setTeamSpawn")) {
                if (args.length != 5) {
                    player.sendMessage("Verwende: 'setup configuremap <MapName> setTeamSpawn <Team>'");
                    return true;
                }

                player.sendMessage(prefix + "Du hast den TeamSpawn für das Team " + secondColor + args[4] + " §7auf der Map " + secondColor + args[2] + " §7platziert.");
                return true;

            } else if (args[3].equalsIgnoreCase("setTeamBed")) {
                if (args.length != 5) {
                    player.sendMessage("Verwende: 'setup configuremap <MapName> setTeamBed <Team>'");
                    return true;
                }

                player.sendMessage(prefix + "Du hast das TeamBed für das Team " + secondColor + args[4] + " §7auf der Map " + secondColor + args[2] + " §7platziert.");
                return true;
            } else if (args[3].equalsIgnoreCase("setShopSpawn")) {

            } else if (args[3].equalsIgnoreCase("setBronzeSpawn")) {

            } else if (args[3].equalsIgnoreCase("setIronSpawn")) {

            } else if (args[3].equalsIgnoreCase("setGoldSpawn")) {

            } else if (args[3].equalsIgnoreCase("setDeathHeight")) {

            } else if (args[3].equalsIgnoreCase("setMaxHeight")) {

            } else {
                displaySetupPhase(prefix, player);
            }

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
        player.sendMessage(prefix + "/setup setperksshop §8| §7Setzte den Perks-Shop Spawn.");
        player.sendMessage(prefix + "/setup newmap <MapName> §8| §7Richte eine neue Map ein.");
        player.sendMessage(prefix + "/setup configuremap <MapName> §8| §7Konfiguriere eine bestehende Map.");
        player.sendMessage(prefix + " ");
        player.sendMessage(prefix + "§m-----------------------");
    }

    public void displaySetupPhase(final String prefix, final Player player) {
        player.sendMessage(prefix + "§m-----------------------");
        player.sendMessage(prefix + "BedWars - Setup - ConfigureMap");
        player.sendMessage(prefix + " ");
        player.sendMessage(prefix + "/setup configuremap <MapName> setTeamSpawn <Team> §8| §7Setzte den Team Spawn.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setTeamBed <Team> §8| §7Setzte das Team Bett.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setShopSpawn §8| §7Setzte ein Shop Spawn.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setBronzeSpawn §8| §7Setzte einen Bronze Spawn.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setIronSpawn §8| §7Setze einen Iron Spawn.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setGoldSpawn §8| §7Setzte einen Gold Spawn.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setDeathHeight §8| §7Setzte die Todeshöhe.");
        player.sendMessage(prefix + "/setup configuremap <MapName> setMaxHeight §8| §7Setzte die Maximalehöhe.");
        player.sendMessage(prefix + " ");
        player.sendMessage(prefix + "§m-----------------------");
    }
}
