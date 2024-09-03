package de.revivemc.bedwars.modules.team;

import de.revivemc.core.ReviveMCAPI;
import de.revivemc.core.entitiesutils.items.ItemHandler;
import de.revivemc.core.gameutils.teams.Team;
import de.revivemc.core.gameutils.teams.TeamHandler;
import org.bukkit.Color;
import org.bukkit.Material;

public class TeamModule {

    private TeamHandler teamHandler;
    private ItemHandler itemHandler;


    public void createTeams(String gameState) {
        switch (gameState) {
            case "1x1":
                teamHandler.addTeam("Blau", Color.BLUE, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "blue");
                teamHandler.addTeam("Rot", Color.RED, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "red");
                break;

            case "4x1":
                teamHandler.addTeam("Blau", Color.BLUE, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "blue");
                teamHandler.addTeam("Rot", Color.RED, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "red");
                teamHandler.addTeam("Grün", Color.GREEN, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "green");
                teamHandler.addTeam("Gelb", Color.YELLOW, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "yellow");
                break;

            case "8x1":
                teamHandler.addTeam("Blau", Color.BLUE, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "blue");
                teamHandler.addTeam("Rot", Color.RED, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "red");
                teamHandler.addTeam("Grün", Color.GREEN, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "green");
                teamHandler.addTeam("Gelb", Color.YELLOW, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "yellow");
                teamHandler.addTeam("Orange", Color.ORANGE, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "orange");
                teamHandler.addTeam("Türkis", Color.AQUA, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "aqua");
                teamHandler.addTeam("Schwarz", Color.BLACK, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "black");
                teamHandler.addTeam("Pink", Color.FUCHSIA, itemHandler.createNewItemCreator(Material.BLAZE_POWDER).toItemStack(), "fuchsia");
        }
    }

    public TeamHandler getTeamHandler() {
        return teamHandler;
    }
}
