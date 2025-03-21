package com.example.handballprojekt.DBO;

//Árni + Michael

// Database Object (DBO) til at repræsentere et hold
public class TeamDBO {

    private int teamID; // Unikt ID for holdet
    private String name; // Navn på holdet
    private int score; // Holdets samlede score
    private int wins; // Antal sejre for holdet
    private int losses; // Antal nederlag for holdet
    private int draws; // Antal uafgjorte kampe for holdet
    private int Coach;

    // Konstruktor, der initialiserer alle felter
    public TeamDBO(int teamID, String name, int score, int wins, int losses, int draws, int Coach) {
        this.teamID = teamID;
        this.name = name;
        this.score = score;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.Coach = Coach;
    }

    // Getter-metode for teamID
    public int getTeamID() {
        return teamID;
    }

    // Getter-metode for holdnavn
    public String getName() {
        return name;
    }

    // Getter-metode for score
    public int getScore() {
        return score;
    }

    // Getter-metode for sejre
    public int getWins() {
        return wins;
    }

    // Getter-metode for nederlag
    public int getLosses() {
        return losses;
    }

    // Getter-metode for uafgjorte
    public int getDraws() {
        return draws;
    }

    public int getCoach() {
        return Coach;
    }
}
