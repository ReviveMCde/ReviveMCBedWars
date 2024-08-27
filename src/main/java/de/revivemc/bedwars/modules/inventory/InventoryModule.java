package de.revivemc.bedwars.modules.inventory;

import de.revivemc.core.ReviveMCAPI;
import de.revivemc.core.entitiesutils.items.ItemCreator;
import de.revivemc.core.entitiesutils.items.ItemHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryModule {

    private final Player player;
    private final Inventory inventory;

    public InventoryModule(Player player) {
        this.player = player;
        this.inventory = player.getInventory();
    }

    public void setLobbyInventory() {
        inventory.setItem(0, new ItemCreator(Material.BED).setName("§8» §aTeamauswahl").setAmount(1).setFlags().toItemStack());
        inventory.setItem(4, new ItemCreator(Material.MAP).setName("§8» §eMapauswahl").setAmount(1).setFlags().toItemStack());
        inventory.setItem(8, new ItemCreator(Material.SLIME_BALL).setName("§8» §cSpiel Verlassen").setAmount(1).setFlags().toItemStack());
    }
}
