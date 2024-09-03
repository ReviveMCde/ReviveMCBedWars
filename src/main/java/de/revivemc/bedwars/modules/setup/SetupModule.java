package de.revivemc.bedwars.modules.setup;

import de.revivemc.bedwars.BedWars;
import de.revivemc.bedwars.modules.setup.builder.GameStateBuilder;
import de.revivemc.bedwars.modules.setup.builder.LocationBuilder;
import de.revivemc.bedwars.modules.setup.builder.MapBuilder;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SetupModule {

    private ArrayList<Player> setupPhase;
    private final String mapName;
    private final String teamName;
    private final Player player;
    private final GameStateBuilder gameStateBuilder;
    private final LocationBuilder locationBuilder;
    private final MapBuilder mapBuilder;

    public SetupModule(final String mapName, final String teamName, final Player player) {
        this.player = player;
        this.mapName = mapName;
        this.teamName = teamName;
        this.gameStateBuilder = BedWars.getInstance().getGameStateBuilder();
        this.locationBuilder = new LocationBuilder();
        this.mapBuilder = new MapBuilder(this.mapName);
    }


    public Player getSetupPhase() {
        return setupPhase.get(setupPhase.size() - 1);
    }

    public void addSetupPhase() {
        this.setupPhase.add(player);
    }

    public void removeSetupPhase() {
        this.setupPhase.remove(player);
    }

    public void phaseManagerSetTeamSpawnPoint() {
        mapBuilder.createSpawnPoint(this.teamName, player.getLocation());
    }
}
