package de.revivemc.bedwars.listener.player;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.inventory.InventoryModule;
import de.revivemc.bedwars.modules.vote.VoteModule;
import de.revivemc.core.ReviveMCAPI;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        final ReviveMCPlayer reviveMCPlayer = ReviveMCAPI.getInstance().getCyturaPlayerManager().getPlayers().get(player.getUniqueId());
        final InventoryModule inventoryModule = new InventoryModule(player);
        final String prefix = BedWars.getInstance().getPrefix(reviveMCPlayer);

        if (event.getInventory().getName().equalsIgnoreCase("§8» §eVoting")) {

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Gold Voting")) {
                inventoryModule.openVotingInventory(1);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aMap Voting")) {
                inventoryModule.openVotingInventory(2);
                return;
            }
        }

        if (event.getInventory().getName().equalsIgnoreCase("§8» §6Gold Voting")) {
            final VoteModule voteModule = new VoteModule(player);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aFür Gold Stimmen")) {
                event.getView().close();
                player.sendMessage(prefix + "§aDu stimmst nun für Gold in der Runde!");
                voteModule.putGoldVote(true);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cGegen Gold Stimmen")) {
                event.getView().close();
                player.sendMessage(prefix + "§cDu stimmst nun gegen Gold in der Runde!");
            }
        }
    }
}
