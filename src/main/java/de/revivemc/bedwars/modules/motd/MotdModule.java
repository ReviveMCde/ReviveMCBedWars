package de.revivemc.bedwars.modules.motd;

import de.revivemc.bedwars.BedWars;
import net.minecraft.server.v1_8_R3.MinecraftServer;

import javax.print.DocFlavor;

public class MotdModule {

    public MotdModule() {

    }

    public String getCurrentMotd() {
       return BedWars.getInstance().getServer().getMotd();
    }

    public void setMotd(String motd) {

    }
}
