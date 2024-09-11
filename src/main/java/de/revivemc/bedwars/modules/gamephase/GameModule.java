package de.revivemc.bedwars.modules.gamephase;

import de.revivemc.bedwars.modules.map.MapManager;
import org.bukkit.entity.Player;

public class GameModule {

    public final MapManager mapManager = new MapManager();

    public static void changeGameToIngame(final Player player) {
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);

    }
}
