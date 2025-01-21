package com.example.handballprojekt;

public class Match {

    private int MatchID;
    private int HomeTeamID;
    private int AwayTeamID;
    private String HomeTeamName;
    private String AwayTeamName;

    public Match(int MatchID, int HomeTeamID, int AwayTeamID) {
        this.MatchID = MatchID;
        this.HomeTeamID = HomeTeamID;
        this.AwayTeamID = AwayTeamID;
        this.HomeTeamName = HomeTeamName;
        this.AwayTeamName = AwayTeamName;

    }
    public int getMatchID() {return MatchID;}

    public int getHomeTeamID() {return HomeTeamID;}

    public int getAwayTeamID() {return AwayTeamID;}

    public String getHomeTeamName() {return HomeTeamName;}

    public String getAwayTeamName() {return AwayTeamName;}

}
