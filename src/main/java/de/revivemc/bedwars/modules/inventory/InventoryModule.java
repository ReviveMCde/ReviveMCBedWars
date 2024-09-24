package de.revivemc.bedwars.modules.inventory;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.setup.builder.GameStateBuilder;
import de.revivemc.core.entitiesutils.items.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryModule {

    private final Player player;
    private final Inventory inventory;
    private final GameStateBuilder gameStateBuilder = BedWars.getInstance().getGameStateBuilder();

    public InventoryModule(Player player) {
        this.player = player;
        this.inventory = player.getInventory();
    }

    public void setLobbyInventory() {
        inventory.setItem(0, new ItemCreator(Material.BED).setName("§8» §aTeamauswahl").setAmount(1).setFlags().toItemStack());
        inventory.setItem(4, new ItemCreator(Material.PAPER).setName("§8» §eVoting").setAmount(1).setFlags().toItemStack());
        inventory.setItem(8, new ItemCreator(Material.SLIME_BALL).setName("§8» §cSpiel Verlassen").setAmount(1).setFlags().toItemStack());
    }

    public void openTeamInventory() {
        final Inventory teamInventory = Bukkit.createInventory(null, 9, "§8» §aTeamauswahl");
        teamInventory.clear();

        setPlaceholder(teamInventory);
        if (gameStateBuilder.getGameState().equalsIgnoreCase("2x1")) {
            teamInventory.setItem(0, (new ItemCreator("1da76d6ddcdbb4973332155796c030cfa2fe855ce539e813e588c61d4d6bca5c")).setName("§8» §9Blau").toItemStack());
            teamInventory.setItem(1, (new ItemCreator("f9a51f27d2d938897bc42a3fe2c3135da2671686f57824115f8f8da78a")).setName("§8» §cRot").toItemStack());
        } else if (gameStateBuilder.getGameState().equalsIgnoreCase("4x1")) {
            teamInventory.setItem(0, (new ItemCreator("1da76d6ddcdbb4973332155796c030cfa2fe855ce539e813e588c61d4d6bca5c")).setName("§8» §9Blau").toItemStack());
            teamInventory.setItem(1, (new ItemCreator("f9a51f27d2d938897bc42a3fe2c3135da2671686f57824115f8f8da78a")).setName("§8» §cRot").toItemStack());
            teamInventory.setItem(2, (new ItemCreator("f7a9964f572fd03c32dfa2586155fa3d10e627df779a41f262fde82bfb41ba0")).setName("§8» §eGelb").toItemStack());
            teamInventory.setItem(3, (new ItemCreator("9cb81a35d2b48d5fd81249369433c078b7c8bf42df5aa9c375c1ac85f4514")).setName("§8» §aGrün").toItemStack());
        } else if (gameStateBuilder.getGameState().equalsIgnoreCase("8x1")) {
            teamInventory.setItem(0, (new ItemCreator("1da76d6ddcdbb4973332155796c030cfa2fe855ce539e813e588c61d4d6bca5c")).setName("§8» §9Blau").toItemStack());
            teamInventory.setItem(1, (new ItemCreator("f9a51f27d2d938897bc42a3fe2c3135da2671686f57824115f8f8da78a")).setName("§8» §cRot").toItemStack());
            teamInventory.setItem(2, (new ItemCreator("f7a9964f572fd03c32dfa2586155fa3d10e627df779a41f262fde82bfb41ba0")).setName("§8» §eGelb").toItemStack());
            teamInventory.setItem(3, (new ItemCreator("9cb81a35d2b48d5fd81249369433c078b7c8bf42df5aa9c375c1ac85f4514")).setName("§8» §aGrün").toItemStack());
            teamInventory.setItem(4, (new ItemCreator("85bec1574de373dfb775ab58b2c1e4621d92c6daac7c6a74d78fb70fff4d0")).setName("§8» §6Orange").toItemStack());
            teamInventory.setItem(5, (new ItemCreator("29e4a399befd967ec282c719fbfd644863281374dcb8137a72f7c4d013a73f")).setName("§8» §bTürkis").toItemStack());
            teamInventory.setItem(6, (new ItemCreator("2342b9bf9f1f6295842b0efb591697b14451f803a165ae58d0dcebd98eacc")).setName("§8» §0Schwarz").toItemStack());
            teamInventory.setItem(7, (new ItemCreator("6c4dc8338415b2b989ab79495986ec7895aa03679d2bcdd6d9ebb633b87fc4")).setName("§8» §5Lila").toItemStack());
        } else {
            teamInventory.setItem(0, new ItemCreator(Material.BARRIER).setName("Diese GameState existiert nicht!").setAmount(1).toItemStack());
        }

        this.player.openInventory(teamInventory);
        this.player.playSound(this.player.getLocation(), Sound.LEVEL_UP, 1, 1);
    }


    public void openVotingInventory(int id) {
        if (id == 0) {
            final Inventory votingInventory = Bukkit.createInventory(null, 9*3, "§8» §eVoting");

            setPlaceholder(votingInventory);
            votingInventory.setItem(11, new ItemCreator("ec6e604bd53d97887595a062b7c512ca4dbbfe48bb4adcef7125d1db103ab7ff").setName("§8» §6Gold Voting").setAmount(1).setFlags().toItemStack());
            votingInventory.setItem(15, new ItemCreator(Material.PAPER).setName("§8» §aMap Voting").setAmount(1).setFlags().toItemStack());

            this.player.openInventory(votingInventory);
            this.player.playSound(this.player.getLocation(), Sound.LEVEL_UP, 1, 1);
        } else if (id == 1) {
            final Inventory goldVotingInventory = Bukkit.createInventory(null, 9*3, "§8» §6Gold Voting");

            setPlaceholder(goldVotingInventory);
            goldVotingInventory.setItem(11, new ItemCreator("34d098fe16017ad6962727c5aaf221ac3c4d08ede6f5ca2bd72ce3aec920426b").setName("§8» §aFür Gold Stimmen").setAmount(1).setFlags().toItemStack());
            goldVotingInventory.setItem(15, new ItemCreator("6953b12a0946b629b4c0889d41fd26ed26fb729d4d514b59727124c37bb70d8d").setName("§8» §cGegen Gold Stimmen").setAmount(1).setFlags().toItemStack());

            this.player.openInventory(goldVotingInventory);
            this.player.playSound(this.player.getLocation(), Sound.LEVEL_UP, 1, 1);

        } else {
            final Inventory mapVotingInventory = Bukkit.createInventory(null, 9*3, "§8» §aMap Voting");

            setPlaceholder(mapVotingInventory);

            this.player.openInventory(mapVotingInventory);
            this.player.playSound(this.player.getLocation(), Sound.LEVEL_UP, 1, 1);
        }
    }

    private void setPlaceholder(final Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            final ItemStack pane = new ItemCreator(Material.STAINED_GLASS_PANE, (short) 7).setName(" ").setAmount(1).toItemStack();
            inventory.setItem(i, pane);
        }
    }
}
