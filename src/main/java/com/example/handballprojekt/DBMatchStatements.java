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
                String homeTeamName = resultSet.getString("HomeTeamName");
                String awayTeamName = resultSet.getString("AwayTeamName");

                match = new Match(matchID, homeTeamID, awayTeamID);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return match;
    }

    public boolean CreateMatch(String homeTeam, String awayTeam) {
        try {
            String sql = "INSERT INTO Match (HomeTeam, AwayTeam) " +
                    "VALUES ('" + homeTeam + "', '" + awayTeam + "')";

            Statement statement = db.dbConnect().createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Match";

            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeam");
                int awayTeamID = resultSet.getInt("AwayTeam");

                Match match = new Match(matchID, homeTeamID, awayTeamID);
                matches.add(match);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return matches;
    }


}

