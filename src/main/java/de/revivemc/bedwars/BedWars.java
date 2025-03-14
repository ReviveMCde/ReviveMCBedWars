package de.revivemc.bedwars;

import de.revivemc.bedwars.commands.BuildCommand;
import de.revivemc.bedwars.commands.SetupCommand;
import de.revivemc.bedwars.listener.entity.EntityDamageListener;
import de.revivemc.bedwars.listener.entity.EntitySpawnListener;
import de.revivemc.bedwars.listener.player.*;
import de.revivemc.bedwars.listener.world.WorldCancelListener;
import de.revivemc.bedwars.modules.database.DatabaseDriver;
import de.revivemc.bedwars.modules.gamephase.GamePhase;
import de.revivemc.bedwars.modules.gamephase.GameState;
import de.revivemc.bedwars.modules.motd.MotdModule;
import de.revivemc.bedwars.modules.setup.builder.GameStateBuilder;
import de.revivemc.core.playerutils.ReviveMCPlayer;
import eu.thesimplecloud.api.service.ServiceState;
import eu.thesimplecloud.plugin.startup.CloudPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BedWars extends JavaPlugin {


    private static BedWars instance;
    private final GamePhase gamePhase = new GamePhase();
    private final GameStateBuilder gameStateBuilder = new GameStateBuilder();
    private final MotdModule motdModule = new MotdModule();
    private static DatabaseDriver databaseDriver;


    @Override
    public void onEnable() {
        instance = this;
        databaseDriver = new DatabaseDriver("localhost", "ReviveMC_Cloud", "root", "~aO_8QPm|5S!LNp{?PZt(+Ez%ldr$iY%6My[kjEaYy*D`(4A0FmM1ajku{z402]0");
        initCommands();
        initListener();
        if (!gameStateBuilder.existsFile()) {
            gameStateBuilder.createGameState("2x1");
        }
        GameState.setState(GameState.LOBBY);
        motdModule.setMotdVisible();
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void initCommands() {
        getCommand("setup").setExecutor(new SetupCommand());
        getCommand("build").setExecutor(new BuildCommand());
    }

    public void initListener() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new WorldCancelListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockPlaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInventoryClickListener(), this);
    }


    public String getPrefix(ReviveMCPlayer reviveMCPlayer) {
        return "§8» " + reviveMCPlayer.getFirstColor() + "BedWars §8× §7";
    }

    public static BedWars getInstance() {
        return instance;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

    public GameStateBuilder getGameStateBuilder() {
        return gameStateBuilder;
    }

    public MotdModule getMotdModule() {
        return motdModule;
    }
}
