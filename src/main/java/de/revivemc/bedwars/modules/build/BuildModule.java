package de.revivemc.bedwars.modules.build;

import de.revivemc.bedwars.BedWars;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class BuildModule {

    private final UUID uuid;

    public BuildModule(UUID uuid) {
        this.uuid = uuid;
    }

    public void setBuildModeState(boolean state) {
        if (!playerExists()) { return; }
        BedWars.getInstance().getDatabaseDriver().update("UPDATE `revivemc_lobby_build` SET `state`='" + state + "'  WHERE UUID='" + this.uuid + "'");
    }

    public boolean getBuildModeState() {
        if (!playerExists()) { return false; }
        try {
            ResultSet resultSet = BedWars.getInstance().getDatabaseDriver().query("SELECT * FROM `revivemc_lobby_build` WHERE  `UUID` = '" + this.uuid.toString() + "'");
            if (resultSet.next()) {
                return resultSet.getBoolean("state");
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void insertIntoDatabase() {
        BedWars.getInstance().getDatabaseDriver().update("INSERT INTO `revivemc_lobby_build`(`UUID`, `state`) VALUES ('" + this.uuid + "', 'false')");
    }

    public boolean playerExists() {
        try {
            ResultSet resultSet = BedWars.getInstance().getDatabaseDriver().query("SELECT * FROM `revivemc_lobby_build` WHERE  `UUID` = '" + this.uuid + "'");
            if (resultSet.next()) {
                return resultSet.getString("UUID") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
