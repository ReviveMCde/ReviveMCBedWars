package de.revivemc.bedwars.modules.gamephase;

public enum GameState {
    LOBBY(true), INGAME(false), END(false);

    private boolean canJoin;

    private static GameState currentState;

    GameState(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public boolean canJoin() {
        return canJoin;
    }

    public static void setState(GameState currentState) {
        GameState.currentState = currentState;
    }

    public static boolean isState(GameState gameState) {
        return gameState == GameState.currentState;
    }

    public static GameState getCurrentState() {
        return currentState;
    }
}
