package de.revivemc.bedwars.modules.vote;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class VoteModule {

    private final HashMap<Player, Boolean> mapVote = new HashMap<>();
    private final HashMap<String, Player> mapVotePool = new HashMap<>();
    private final HashMap<Player, Boolean> goldVote = new HashMap<>();
    private final Player player;

    public VoteModule(Player player) {
        this.player = player;
    }

    public void putGoldVote(boolean state) {
        this.goldVote.put(this.player, state);
    }

    public void putMapVote(String mapName, boolean state) {
        this.mapVote.put(this.player, state);
        this.mapVotePool.put(mapName, this.player);
    }


    public boolean getGoldVote() {
        return this.goldVote.get(this.player);
    }


    public boolean getMapVote() {
        return this.mapVote.get(this.player);
    }

    /*public int getMapVoteCount() {
        return this.mapVotePool
    }*/


    public HashMap<Player, Boolean> getGoldVoteMap() {
        return this.goldVote;
    }

    public HashMap<Player, Boolean> getMapVoteMap() {
        return this.mapVote;
    }
}
