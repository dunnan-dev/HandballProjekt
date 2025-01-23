package com.example.handballprojekt.DBO;

public class MatchDBO {

    private int MatchID;
    private int HomeTeamID;
    private int AwayTeamID;
    private String HomeTeamName;
    private String AwayTeamName;


    public MatchDBO(int MatchID, int HomeTeamID, int AwayTeamID, String HomeTeamName, String AwayTeamName) {
        this.MatchID = MatchID;
        this.HomeTeamID = HomeTeamID;
        this.AwayTeamID = AwayTeamID;
        this.HomeTeamName = HomeTeamName;
        this.AwayTeamName = AwayTeamName;

    }

    public MatchDBO(int matchID, int homeTeamID, int awayTeamID) {
    }

    public int getMatchID() {return MatchID;}

    public int getHomeTeamID() {return HomeTeamID;}

    public int getAwayTeamID() {return AwayTeamID;}

    public String toString() {
        return "MatchDBO ID: " + MatchID + ", Home Team: " + HomeTeamName + ", Away Team: " + AwayTeamName;}

}


