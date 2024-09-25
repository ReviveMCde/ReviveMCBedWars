package de.revivemc.bedwars.modules.vote;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VoteModule {

    private final HashMap<Player, Boolean> mapVote = new HashMap<>();
    private final HashMap<String, Player> mapVotePool = new HashMap<>();
    private final List<Player> goldVotePool = new ArrayList<>();
    private final List<Player> noGoldVotePool = new ArrayList<>();

    private final Player player;

    public VoteModule(Player player) {
        this.player = player;
    }

    public void putGoldVotePool(boolean state) {
        if (state) {
            this.goldVotePool.add(player);
        } else {
            this.noGoldVotePool.add(player);
        }
    }

    public void putMapVote(String mapName, boolean state) {
        this.mapVote.put(this.player, state);
        this.mapVotePool.put(mapName, this.player);
    }


    public boolean isInGoldVotePool() {
        return this.goldVotePool.contains(this.player);
    }

    public boolean isInNoGoldVotePool() {
        return this.noGoldVotePool.contains(this.player);
    }


    public boolean getMapVote() {
        return this.mapVote.get(this.player);
    }

    public boolean goldVoteEndPool() {
        if (this.goldVotePool.size() > this.noGoldVotePool.size()) {
            return true;
        } else if (this.goldVotePool.size() < this.noGoldVotePool.size()) {
            return false;
        } else {
            return true;
        }
    }

    /*public int getMapVoteCount() {
        return this.mapVotePool
    }*/


    public List<Player> getGoldVotePoolMap() {
        return this.goldVotePool;
    }

    public List<Player> getNoGoldVotePoolMap() {
        return this.noGoldVotePool;
    }

    public HashMap<Player, Boolean> getMapVoteMap() {
        return this.mapVote;
    }
}
