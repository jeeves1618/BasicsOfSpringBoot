package net.myphenotype.microservices.Player.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player extends  BaseEntity {
    @Id
    private int playerId;
    private String playerName;
    private String playerType;
    private int runsScored;
    private int wicketsTaken;
    private String teamCode;

    public Player() {
    }

    public Player(int playerId, String playerName, String playerType, int runsScored, int wicketsTaken, String teamCode) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerType = playerType;
        this.runsScored = runsScored;
        this.wicketsTaken = wicketsTaken;
        this.teamCode = teamCode;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerType='" + playerType + '\'' +
                ", runsScored=" + runsScored +
                ", wicketsTaken=" + wicketsTaken +
                ", teamCode='" + teamCode + '\'' +
                '}';
    }
}
