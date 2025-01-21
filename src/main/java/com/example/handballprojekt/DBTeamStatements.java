package com.example.handballprojekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    
   

    public class DBTeamStatements {
        DBConnection db = new DBConnection();

        public Team getTeamByID(int id) {
            Team team = null;
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

                    team = new Team(teamID, teamName, score, wins, loss, draw);
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
        public boolean CreateTeam(String name) {
            try {
                String sql = "INSERT INTO Team (Name, Score, Wins, Loss, Draw) " +
                        "VALUES ('" + name + "', 0, 0, 0, 0)";

                Statement statement = db.dbConnect().createStatement();
                statement.executeUpdate(sql);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }


        public List<Team> getAllTeams() {
            List<Team> teams = new ArrayList<>();

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

                    Team team = new Team(teamID, name, score, wins, losses, draws);
                    teams.add(team);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return teams;
        }


    }


