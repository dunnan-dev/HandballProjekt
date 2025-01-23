package com.example.handballprojekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBMatchStatements {
    DBConnection db = new DBConnection();

    public Match getMatchByID(int id) {
        Match match = null;
        try {
            String sql = "select * from Match where MatchID = " + id;

            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeamID");
                int awayTeamID = resultSet.getInt("AwayTeamID");

                match = new Match(matchID, homeTeamID, awayTeamID);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return match;
    }

    public boolean CreateMatch(int homeTeamId, int awayTeamId) {
        try {
            // Dynamisk SQL til indsættelse af kamp
            String sql = "INSERT INTO Match (HomeTeam, AwayTeam) VALUES (" + homeTeamId + ", " + awayTeamId + ")";

            // Udfør SQL-forespørgslen
            Statement statement = db.dbConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String getTeamNameByID(int teamID) {
        String teamName = null;
        try {
            String sql = "SELECT Name FROM Team WHERE TeamID = " + teamID;
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                teamName = resultSet.getString("Name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teamName;
    }

    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();

        try {
            // Hent alle matches fra databasen
            String sql = "SELECT MatchID, HomeTeam, AwayTeam FROM Match";
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeam");
                int awayTeamID = resultSet.getInt("AwayTeam");

                // Slå holdnavne op baseret på HomeTeamID og AwayTeamID
                String homeTeamName = getTeamNameByID(homeTeamID);
                String awayTeamName = getTeamNameByID(awayTeamID);

                // Opret og tilføj Match-objekt til listen
                Match match = new Match(matchID, homeTeamID, awayTeamID, homeTeamName, awayTeamName);
                matches.add(match);
            }
        } catch (Exception e) {
            System.out.println("Fejl i getAllMatches: " + e.getMessage());
        }

        return matches;
    }
}




