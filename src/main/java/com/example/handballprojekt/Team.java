package com.example.handballprojekt;

public class Team {

        private int teamID;
        private String teamName;
        private int points;
        private int wins;
        private int losses;
        private int draws;

        // Constructor
        public Team(int teamID, String teamName, int points, int wins, int losses, int draws) {
            this.teamID = teamID;
            this.teamName = teamName;
            this.points = points;
            this.wins = wins;
            this.losses = losses;
            this.draws = draws;
        }

        public String getTeamName() {
            return teamName;
        }

        public int getPoints() {
            return points;
        }

        public int getWins() {
            return wins;
        }

        public int getLosses() {
            return losses;
        }

        public int getDraws() {
            return draws;
        }

        public int getTeamID() {
            return teamID;
        }
    }

