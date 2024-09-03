package de.revivemc.bedwars.modules.setup.builder;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class GameStateBuilder {

    private final YamlConfiguration configuration;
    private final File file = new File("plugins//BedWars//gameState.yml");

    public GameStateBuilder() {
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void createGameState(String gameState) {
        try {
            configuration.set("GameState", gameState);
            configuration.save(file);
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }
    }

    public String getGameState() {
        return configuration.getString("GameState");
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    public File getFile() {
        return file;
    }

    public boolean existsFile() {
        return file.exists();
    }

    public int minimumPlayersToStart() {
        if (getGameState().equalsIgnoreCase("2x1")) {
            return 2;
        } else if (getGameState().equalsIgnoreCase("4x1")) {
            return 2;
        } else if (getGameState().equalsIgnoreCase("8x1")) {
            return 4;
        }
        return 0;
    }
}
