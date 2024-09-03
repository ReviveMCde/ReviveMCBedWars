package de.revivemc.bedwars.modules.setup.builder;

import de.revivemc.bedwars.BedWars;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class MapBuilder {

    private final File file;
    private final YamlConfiguration configuration;
    private final String mapName;

    public MapBuilder(final String mapName) {
        this.mapName = mapName;
        this.file = new File("plugins//BedWars//maps//" + mapName + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void createSpawnPoint(String team, Location location) {
        try {
            configuration.set(mapName + "." + team + ".X", location.getX());
            configuration.set(mapName + "." + team + ".Y", location.getY());
            configuration.set(mapName + "." + team + ".Z", location.getZ());
            configuration.set(mapName + "." + team + ".Yaw", location.getYaw());
            configuration.set(mapName + "." + team + ".Pitch", location.getPitch());
            configuration.set(mapName + "." + team + ".World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createShopSpawn(String team, Location location) {
        try {
            configuration.set(mapName + "." + team + ".Shop.X", location.getX());
            configuration.set(mapName + "." + team + ".Shop.Y", location.getY());
            configuration.set(mapName + "." + team + ".Shop.Z", location.getZ());
            configuration.set(mapName + "." + team + ".Shop.Yaw", location.getYaw());
            configuration.set(mapName + "." + team + ".Shop.Pitch", location.getPitch());
            configuration.set(mapName + "." + team + ".Shop.World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createBronzeSpawnLocation(String team, Location location) {
        try {
            configuration.set(mapName + "." + team + ".BronzeX", location.getX());
            configuration.set(mapName + "." + team + ".BronzeY", location.getY());
            configuration.set(mapName + "." + team + ".BronzeZ", location.getZ());
            configuration.set(mapName + "." + team + ".Bronze.World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createIronSpawnLocation(String team, Location location) {
        try {
            configuration.set(mapName + "." + team + ".IronX", location.getX());
            configuration.set(mapName + "." + team + ".IronY", location.getY());
            configuration.set(mapName + "." + team + ".IronZ", location.getZ());
            configuration.set(mapName + "." + team + ".Iron.World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createGoldSpawnLocation(Location location) {
        try {
            configuration.set(mapName + ".Gold", location.getX());
            configuration.set(mapName + ".Gold", location.getY());
            configuration.set(mapName + ".Gold", location.getZ());
            configuration.set(mapName + ".Gold.World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createMapDeathLocation(Location location) {
        try {
            configuration.set(mapName + ".DeathHeight", location.getY());
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Location getSpawnPoint(String team) {
        double X = configuration.getDouble(mapName + "." + team + ".X");
        double Y = configuration.getDouble(mapName + "." + team + ".Y");
        double Z = configuration.getDouble(mapName + "." + team + ".Z");
        double Yaw = configuration.getDouble(mapName + "." + team + ".Yaw");
        double Pitch = configuration.getDouble(mapName + "." + team + ".Pitch");
        World world = BedWars.getInstance().getServer().getWorld(configuration.getString(mapName + "." + team + ".World"));
        Location location = new Location(world, X, Y, Z);
        location.setYaw((float)Yaw);
        location.setPitch((float)Pitch);
        return location;
    }

    public Location getShopSpawn(String team) {
        double X = configuration.getDouble(mapName + "." + team + ".Shop.X");
        double Y = configuration.getDouble(mapName + "." + team + ".Shop.Y");
        double Z = configuration.getDouble(mapName + "." + team + ".Shop.Z");
        double Yaw = configuration.getDouble(mapName + "." + team + ".Shop.Yaw");
        double Pitch = configuration.getDouble(mapName + "." + team + ".Shop.Pitch");
        World world = BedWars.getInstance().getServer().getWorld(configuration.getString(mapName + "." + team + ".Shop.World"));
        Location location = new Location(world, X, Y, Z);
        location.setYaw((float)Yaw);
        location.setPitch((float)Pitch);
        return location;
    }

    public Location getBronzeSpawnLocation(String team, Player player) {
        Location location = player.getLocation();
        location.setX(configuration.getDouble(mapName + "." + team + ".BronzeX"));
        location.setY(configuration.getDouble(mapName + "." + team + ".BronzeY"));
        location.setZ(configuration.getDouble(mapName + "." + team + ".BronzeZ"));
        return location;
    }

    public Location getIronSpawnLocation(String team, Player player) {
        Location location = player.getLocation();
        location.setX(configuration.getDouble(mapName + "." + team + ".IronX"));
        location.setY(configuration.getDouble(mapName + "." + team + ".IronY"));
        location.setZ(configuration.getDouble(mapName + "." + team + ".IronZ"));
        return location;
    }

    public Location getGoldSpawnLocation(Player player) {
        Location location = player.getLocation();
        location.setX(configuration.getDouble(mapName + ".Gold"));
        location.setY(configuration.getDouble(mapName + ".Gold"));
        location.setZ(configuration.getDouble(mapName + ".Gold"));
        return location;
    }

    public Location getMapDeathLocation(Player player) {
        Location location = player.getLocation();
        location.setY(configuration.getDouble(mapName + ".DeathHeight"));
        return location;
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    public File getFile() {
        return file;
    }
}
