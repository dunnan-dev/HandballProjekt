package com.example.handballprojekt.DB;


import com.example.handballprojekt.DBO.MatchDBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBMatchStatements {
    DBConnection db = new DBConnection();

    public MatchDBO getMatchByID(int id) {
        MatchDBO matchDBO = null;
        try {
            String sql = "select * from Match where MatchID = " + id;

            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeamID");
                int awayTeamID = resultSet.getInt("AwayTeamID");

                matchDBO = new MatchDBO(matchID, homeTeamID, awayTeamID);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matchDBO;
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

    public List<MatchDBO> getAllMatches() {
        List<MatchDBO> matchDBOS = new ArrayList<>();

        try {
            // Hent alle matchDBOS fra databasen
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

                // Opret og tilføj MatchDBO-objekt til listen
                MatchDBO matchDBO = new MatchDBO(matchID, homeTeamID, awayTeamID, homeTeamName, awayTeamName);
                matchDBOS.add(matchDBO);
            }
        } catch (Exception e) {
            System.out.println("Fejl i getAllMatches: " + e.getMessage());
        }

        return matchDBOS;
    }
}






