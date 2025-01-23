package com.example.handballprojekt.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.handballprojekt.DBO.TeamDBO;

// Klasse, der indeholder metoder til at udføre databaseoperationer for "Team"-tabellen
public class DBTeamStatements {
    DBConnection db = new DBConnection(); // Instans af databaseforbindelse

    // Henter et specifikt team fra databasen baseret på ID
    public TeamDBO getTeamByID(int id) {
        TeamDBO team = null; // Initialiserer team som null
        try {
            // SQL-forespørgsel til at hente et team baseret på dets ID
            String sql = "select * from Team where TeamID = " + id;

            // Opretter en SQL-statement og udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Henter data fra resultatsættet og opretter et TeamDBO-objekt
            while (resultSet.next()) {
                int teamID = resultSet.getInt("TeamID");
                String teamName = resultSet.getString("Name");
                int score = resultSet.getInt("Score");
                int wins = resultSet.getInt("Wins");
                int loss = resultSet.getInt("Loss");
                int draw = resultSet.getInt("Draw");

                team = new TeamDBO(teamID, teamName, score, wins, loss, draw);
            }
        } catch (Exception e) {
            // Logger fejlmeddelelse, hvis noget går galt
            System.out.println(e.getMessage());
        }
        return team; // Returnerer det fundne team eller null, hvis det ikke findes
    }

    // Opdaterer et team i databasen baseret på ID
    public Boolean updateTeamByID(int id, int score, int wins, int loss, int draw) {
        try {
            // SQL-forespørgsel til at opdatere teamoplysninger
            String sql = "UPDATE Team SET Score = " + score +
                    ", Wins = " + wins +
                    ", Loss = " + loss +
                    ", Draw = " + draw +
                    " WHERE TeamID = " + id;

            System.out.println(sql); // Udskriver forespørgslen til debugging

            // Udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            // Logger fejlmeddelelse og returnerer false ved fejl
            System.out.println(e.getMessage());
            return false;
        }
        return true; // Returnerer true, hvis opdateringen lykkes
    }

    // Opretter et nyt team i databasen
    public void CreateTeam(String name) {
        try {
            // SQL-forespørgsel til at indsætte et nyt team med standardværdier
            String sql = "INSERT INTO Team (Name, Score, Wins, Loss, Draw) " +
                    "VALUES ('" + name + "', 0, 0, 0, 0)";

            // Udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            // Logger fejlmeddelelse ved fejl
            System.out.println(e.getMessage());
        }
    }

    // Henter en liste af alle teams fra databasen
    public List<TeamDBO> getAllTeams() {
        List<TeamDBO> teams = new ArrayList<>(); // Opretter en liste til at gemme teams

        try {
            // SQL-forespørgsel til at hente alle teams
            String sql = "SELECT * FROM Team";

            // Udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Itererer gennem resultatsættet og tilføjer hvert team til listen
            while (resultSet.next()) {
                int teamID = resultSet.getInt("TeamID");
                String name = resultSet.getString("Name");
                int score = resultSet.getInt("Score");
                int wins = resultSet.getInt("Wins");
                int losses = resultSet.getInt("Loss");
                int draws = resultSet.getInt("Draw");

                TeamDBO team = new TeamDBO(teamID, name, score, wins, losses, draws);
                teams.add(team);
            }
        } catch (Exception e) {
            // Logger fejlmeddelelse ved fejl
            System.out.println("Error while retrieving teams: " + e.getMessage());
        }

        return teams; // Returnerer listen med teams
    }

    // Finder et team-ID baseret på teamets navn
    public int getTeamIdByName(String teamName) {
        int teamId = -1; // Standardværdi, hvis ID ikke findes
        try {
            // SQL-forespørgsel til at finde TeamID baseret på navn
            String sql = "SELECT TeamID FROM Team WHERE Name = '" + teamName + "'";

            // Udfører forespørgslen
            Statement statement = db.dbConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Henter TeamID, hvis det findes i resultatsættet
            if (resultSet.next()) {
                teamId = resultSet.getInt("TeamID");
            }
        } catch (SQLException e) {
            // Logger fejlmeddelelse ved fejl
            System.out.println(e.getMessage());
        }
        return teamId; // Returnerer det fundne TeamID eller -1, hvis det ikke findes
    }
}
