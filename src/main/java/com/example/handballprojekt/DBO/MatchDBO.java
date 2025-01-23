package com.example.handballprojekt.DBO;

//Árni + Oliver

public class MatchDBO {

    private int MatchID; // Kampens unikke ID
    private int HomeTeamID; // ID for hjemmeholdet
    private int AwayTeamID; // ID for udeholdet
    private String HomeTeamName; // Navn på hjemmeholdet
    private String AwayTeamName; // Navn på udeholdet

    // Konstruktor, der initialiserer alle felter
    public MatchDBO(int MatchID, int HomeTeamID, int AwayTeamID, String HomeTeamName, String AwayTeamName) {
        this.MatchID = MatchID;
        this.HomeTeamID = HomeTeamID;
        this.AwayTeamID = AwayTeamID;
        this.HomeTeamName = HomeTeamName;
        this.AwayTeamName = AwayTeamName;
    }

    // Overbelastet konstruktor, der kun initialiserer IDs (navne kan tilføjes senere)
    public MatchDBO(int matchID, int homeTeamID, int awayTeamID) {
        // Felterne sættes, men HomeTeamName og AwayTeamName forbliver tomme
        this.MatchID = matchID;
        this.HomeTeamID = homeTeamID;
        this.AwayTeamID = awayTeamID;
    }

    // Getter for kampens ID
    public int getMatchID() {
        return MatchID;
    }

    // Getter for hjemmeholdets ID
    public int getHomeTeamID() {
        return HomeTeamID;
    }

    // Getter for udeholdets ID
    public int getAwayTeamID() {
        return AwayTeamID;
    }

    // Overrider toString-metoden for at give en tekstrepræsentation af objektet
    @Override
    public String toString() {
        return "MatchDBO ID: " + MatchID + ", Home Team: " + HomeTeamName + ", Away Team: " + AwayTeamName;
    }
}
