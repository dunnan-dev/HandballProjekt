package com.example.handballprojekt.DB;

import com.example.handballprojekt.DBO.MatchDBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Árni

// Klasse til at håndtere databaseoperationer for "Match"-tabellen
public class DBMatchStatements {
    DBConnection db = new DBConnection(); // Databaseforbindelse

    // Henter en specifik kamp fra databasen baseret på dens ID
    public MatchDBO getMatchByID(int id) {
        MatchDBO matchDBO = null; // Initialiserer match som null
        try {
            // SQL-forespørgsel til at hente en kamp baseret på ID
            String sql = "select * from Match where MatchID = " + id;

            // Opretter en SQL-statement og udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Henter data fra resultatsættet og opretter et MatchDBO-objekt
            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeamID");
                int awayTeamID = resultSet.getInt("AwayTeamID");

                matchDBO = new MatchDBO(matchID, homeTeamID, awayTeamID);
            }
        } catch (Exception e) {
            // Logger fejlmeddelelse, hvis noget går galt
            System.out.println(e.getMessage());
        }
        return matchDBO; // Returnerer det fundne match eller null
    }

    // Opretter en ny kamp i databasen
    public boolean CreateMatch(int homeTeamId, int awayTeamId) {
        try {
            // SQL-forespørgsel til at indsætte en ny kamp
            String sql = "INSERT INTO Match (HomeTeam, AwayTeam) VALUES (" + homeTeamId + ", " + awayTeamId + ")";

            // Udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            // Logger fejlmeddelelse og returnerer false ved fejl
            System.out.println(e.getMessage());
            return false;
        }
        return true; // Returnerer true, hvis indsættelsen lykkes
    }

    // Henter navnet på et team baseret på dets ID
    public String getTeamNameByID(int teamID) {
        String teamName = null; // Initialiserer teamName som null
        try {
            // SQL-forespørgsel til at hente teamnavnet baseret på ID
            String sql = "SELECT Name FROM Team WHERE TeamID = " + teamID;
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Henter teamnavnet, hvis det findes
            if (resultSet.next()) {
                teamName = resultSet.getString("Name");
            }
        } catch (Exception e) {
            // Logger fejlmeddelelse, hvis noget går galt
            System.out.println(e.getMessage());
        }
        return teamName; // Returnerer teamnavnet eller null, hvis det ikke findes
    }

    // Henter en liste af alle kampe fra databasen
    public List<MatchDBO> getAllMatches() {
        List<MatchDBO> matchDBOS = new ArrayList<>(); // Opretter en liste til at gemme kampe

        try {
            // SQL-forespørgsel til at hente alle kampe
            String sql = "SELECT MatchID, HomeTeam, AwayTeam FROM Match";
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Itererer gennem resultatsættet
            while (resultSet.next()) {
                int matchID = resultSet.getInt("MatchID");
                int homeTeamID = resultSet.getInt("HomeTeam");
                int awayTeamID = resultSet.getInt("AwayTeam");

                // Henter holdnavne baseret på ID'er
                String homeTeamName = getTeamNameByID(homeTeamID);
                String awayTeamName = getTeamNameByID(awayTeamID);

                // Opretter et MatchDBO-objekt og tilføjer det til listen
                MatchDBO matchDBO = new MatchDBO(matchID, homeTeamID, awayTeamID, homeTeamName, awayTeamName);
                matchDBOS.add(matchDBO);
            }
        } catch (Exception e) {
            // Logger fejlmeddelelse ved fejl
            System.out.println("Fejl i getAllMatches: " + e.getMessage());
        }

        return matchDBOS; // Returnerer listen med kampe
    }
}
