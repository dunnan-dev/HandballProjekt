package com.example.handballprojekt.DBO;

public class TeamDBO {
    private int teamID;
    private String name;
    private int score;
    private int wins;
    private int losses;
    private int draws;

    public TeamDBO(int teamID, String name, int score, int wins, int losses, int draws) {
        this.teamID = teamID;
        this.name = name;
        this.score = score;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }

    // Getters for each property
    public int getTeamID() {
        return teamID;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }
}
