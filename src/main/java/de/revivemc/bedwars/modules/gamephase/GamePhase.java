package de.revivemc.bedwars.modules.gamephase;

public class GamePhase {

    private String gameState = "LOBBY";

    public GamePhase() {

    }

    public String getCurrentGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void changeGameStateToInGame() {
        this.setGameState("INGAME");
    }

    public void changeGameStateToEnd() {
        this.setGameState("END");
    }


    public enum GamePhaseState {
        LOBBY, INGAME, END
    }
}
