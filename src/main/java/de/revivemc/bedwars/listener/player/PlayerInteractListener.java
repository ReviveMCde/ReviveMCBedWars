package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.modules.inventory.InventoryModule;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        final InventoryModule inventoryModule = new InventoryModule(player);
        final ICloudPlayer iCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(player.getUniqueId());
        final ReviveMCPlayer reviveMCPlayer = new ReviveMCPlayer(player.getUniqueId());
        assert iCloudPlayer != null;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand() == null) {
                return;
            }

            if (player.getItemInHand().getItemMeta() == null) {
                return;
            }

            if (player.getItemInHand().getItemMeta().getDisplayName() == null) {
                return;
            }

            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aTeamauswahl")) {
                inventoryModule.openTeamInventory();
                return;
            }

            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eVoting")) {
                inventoryModule.openVotingInventory(0);
                return;
            }

            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cSpiel Verlassen")) {
                iCloudPlayer.sendToLobby();
            }
        }
    }
}
