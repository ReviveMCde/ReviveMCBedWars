package de.revivemc.bedwars.modules.motd;

import de.revivemc.bedwars.BedWars;
import eu.thesimplecloud.api.service.ServiceState;
import eu.thesimplecloud.plugin.startup.CloudPlugin;
import net.minecraft.server.v1_8_R3.MinecraftServer;

import javax.print.DocFlavor;

public class MotdModule {

    public MotdModule() {

    }

    public String getCurrentMotd() {
       return CloudPlugin.getInstance().thisService().getMOTD();
    }

    public ServiceState getCurrentServiceState() {
        return CloudPlugin.getInstance().thisService().getState();
    }

    public void setMotdInvisbile(String currentMapPlayed) {
        CloudPlugin.getInstance().thisService().setMOTD("InGame - " + currentMapPlayed);
        CloudPlugin.getInstance().thisService().setState(ServiceState.INVISIBLE);
        CloudPlugin.getInstance().thisService().update();
    }

    public void setMotdVisible() {
        CloudPlugin.getInstance().thisService().setMOTD("Voting...");
        CloudPlugin.getInstance().thisService().setState(ServiceState.VISIBLE);
        CloudPlugin.getInstance().thisService().update();
    }

    public void setMotdVisibleMapFound(String currentMapPlayed) {
        CloudPlugin.getInstance().thisService().setMOTD(currentMapPlayed);
        CloudPlugin.getInstance().thisService().setState(ServiceState.VISIBLE);
        CloudPlugin.getInstance().thisService().update();
    }
}
