package de.revivemc.bedwars.modules.setup.builder;

import de.revivemc.bedwars.BedWars;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationBuilder {
    private final File file = new File("plugins//BedWars//waitingLobby.yml");
    private final YamlConfiguration configuration;

    public LocationBuilder() {
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void createWaitingLobby(Location location) {
        try {
            configuration.set("X", location.getX());
            configuration.set("Y", location.getY());
            configuration.set("Z", location.getZ());
            configuration.set("Yaw", location.getYaw());
            configuration.set("Pitch", location.getPitch());
            configuration.set("World", location.getWorld().getName());
            configuration.save(file);
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }
    }

    public Location getWaitingLobby() {
        double X = configuration.getDouble("X");
        double Y = configuration.getDouble("Y");
        double Z = configuration.getDouble("Z");
        double Yaw = configuration.getDouble("Yaw");
        double Pitch = configuration.getDouble("Pitch");
        World world = BedWars.getInstance().getServer().getWorld(configuration.getString("World"));
        Location location = new Location(world, X, Y, Z);
        location.setYaw((float)Yaw);
        location.setPitch((float)Pitch);
        return location;
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    public File getFile() {
        return file;
    }

    public boolean fileExists() {
        return file.exists();
    }
}
