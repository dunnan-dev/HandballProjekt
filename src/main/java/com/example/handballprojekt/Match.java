package com.example.handballprojekt;

public class Match {

    private int MatchID;
    private int HomeTeamID;
    private int AwayTeamID;
    private String HomeTeamName;
    private String AwayTeamName;


    public Match(int MatchID, int HomeTeamID, int AwayTeamID, String HomeTeamName, String AwayTeamName) {
        this.MatchID = MatchID;
        this.HomeTeamID = HomeTeamID;
        this.AwayTeamID = AwayTeamID;
        this.HomeTeamName = HomeTeamName;
        this.AwayTeamName = AwayTeamName;

    }

    public Match(int matchID, int homeTeamID, int awayTeamID) {
    }

    public int getMatchID() {return MatchID;}

    public int getHomeTeamID() {return HomeTeamID;}

    public int getAwayTeamID() {return AwayTeamID;}

    public String toString() {
        return "Match ID: " + MatchID + ", Home Team: " + HomeTeamName + ", Away Team: " + AwayTeamName;}

}
