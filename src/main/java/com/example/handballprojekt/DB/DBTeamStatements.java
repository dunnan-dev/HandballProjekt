package com.example.handballprojekt.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.handballprojekt.DBO.TeamDBO;

    
   

    public class DBTeamStatements {
        DBConnection db = new DBConnection();

        public TeamDBO getTeamByID(int id) {
            TeamDBO team = null;
            try {
                String sql = "select * from Team where TeamID = " + id;

                Statement statement = db.dbConnect().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

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
                System.out.println(e.getMessage());
            }
            return team;
        }

        public Boolean updateTeamByID(int id, int score, int wins, int loss, int draw) {
            try {
                String sql = "UPDATE Team SET Score = " + score +
                        ", Wins = " + wins +
                        ", Loss = " + loss +
                        ", Draw = " + draw +
                        " WHERE TeamID = " + id;

                System.out.println(sql);

                Statement statement = db.dbConnect().createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }
        public void CreateTeam(String name) {
            try {
                String sql = "INSERT INTO Team (Name, Score, Wins, Loss, Draw) " +
                        "VALUES ('" + name + "', 0, 0, 0, 0)";

                Statement statement = db.dbConnect().createStatement();
                statement.executeUpdate(sql);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        public List<TeamDBO> getAllTeams() {
            List<TeamDBO> teams = new ArrayList<>();

            try {
                String sql = "SELECT * FROM Team";

                Statement statement = db.dbConnect().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

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
                System.out.println("Error while retrieving teams: " + e.getMessage());
            }

            return teams;
        }

            public int getTeamIdByName(String teamName){
                int teamId = -1;
                try {
                    // SQL til at finde TeamID baseret på navn
                    String sql = "SELECT TeamID FROM Team WHERE Name = '" + teamName + "'";

                    // Udfør forespørgslen
                    Statement statement = db.dbConnect().createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    // Hent TeamID, hvis det findes
                    if (resultSet.next()) {
                        teamId = resultSet.getInt("TeamID");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                return teamId;
            }
        }