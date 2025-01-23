package com.example.handballprojekt.Controllers;

import HelperMethods.HelperMethods.HelperMethods;
import com.example.handballprojekt.DB.DBMatchStatements;
import com.example.handballprojekt.DB.DBTeamStatements;
import com.example.handballprojekt.DBO.TeamDBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Controller-klasse til at håndtere oprettelse af kampe i brugergrænsefladen
public class CreateMatchController {

    private DBTeamStatements dbTeam = new DBTeamStatements(); // Databasehåndtering for hold
    private DBMatchStatements dbMatch = new DBMatchStatements(); // Databasehåndtering for kampe

    @FXML
    private Button goBackToMatchView; // Knappen til at gå tilbage til matchvisningen

    // Metode, der håndterer knappen for at gå tilbage til matchvisningen
    @FXML
    void onAction_GoToMatchView(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/MatchViewPage.fxml", event);
    }

    @FXML
    private ChoiceBox<String> homeTeamChoiceBox; // ChoiceBox til valg af hjemmehold

    @FXML
    private ChoiceBox<String> awayTeamChoiceBox; // ChoiceBox til valg af udehold

    // Initialiseringsmetode, der kører automatisk, når scenen indlæses
    @FXML
    public void initialize() {
        // Hent alle hold fra databasen
        List<TeamDBO> teams = dbTeam.getAllTeams();

        // Ekstraher holdnavne fra TeamDBO-objekter
        List<String> teamNames = new ArrayList<>();
        for (TeamDBO team : teams) {
            teamNames.add(team.getName());
        }

        // Konverter holdnavnene til en ObservableList, der kan bruges i ChoiceBox
        ObservableList<String> observableTeamNames = FXCollections.observableArrayList(teamNames);

        // Indstil holdnavne i begge ChoiceBoxes
        homeTeamChoiceBox.setItems(observableTeamNames);
        awayTeamChoiceBox.setItems(observableTeamNames);
    }

    // Metode, der håndterer oprettelse af en ny kamp
    @FXML
    private void handleCreateMatch() {
        // Hent de valgte hold fra ChoiceBoxes
        String homeTeam = homeTeamChoiceBox.getValue();
        String awayTeam = awayTeamChoiceBox.getValue();

        // Valider, at begge hold er valgt
        if (homeTeam == null || awayTeam == null) {
            System.out.println("Vælg både hjemmehold og udehold før du opretter kampen.");
            return; // Stopper metoden, hvis validering fejler
        }

        // Find TeamID for de valgte hold via deres navne
        int homeTeamId = dbTeam.getTeamIdByName(homeTeam);
        int awayTeamId = dbTeam.getTeamIdByName(awayTeam);

        // Tjek, om TeamID blev fundet i databasen
        if (homeTeamId == -1 || awayTeamId == -1) {
            System.out.println("Kunne ikke finde hold i databasen.");
            return; // Stopper metoden, hvis holdene ikke findes
        }

        // Indsæt kampen i databasen
        boolean success = dbMatch.CreateMatch(homeTeamId, awayTeamId);

        // Bekræft og udskriv resultatet af operationen
        if (success) {
            System.out.println("Kamp oprettet mellem " + homeTeam + " og " + awayTeam);
        } else {
            System.out.println("Kunne ikke oprette kampen.");
        }
    }
}
