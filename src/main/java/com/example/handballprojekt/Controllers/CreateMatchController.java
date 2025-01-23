package com.example.handballprojekt.Controllers;

import HelperMethods.HelperMethods.HelperMethods;
import com.example.handballprojekt.DB.DBMatchStatements;
import com.example.handballprojekt.DB.DBTeamStatements;
import com.example.handballprojekt.DBO.TeamDBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateMatchController {

    private DBTeamStatements dbTeam = new DBTeamStatements();
    private DBMatchStatements dbMatch = new DBMatchStatements();

    @FXML
    private Button goBackToMatchView;

    @FXML
    void onAction_GoToMatchView(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/MatchViewPage.fxml", event);

    }

    @FXML
    private ChoiceBox<String> homeTeamChoiceBox;

    @FXML
    private ChoiceBox<String> awayTeamChoiceBox;



    @FXML
    public void initialize() {
        // Hent alle hold fra databasen
        List<TeamDBO> teams; teams = dbTeam.getAllTeams();

        // Ekstraher holdnavne
        List<String> teamNames = new ArrayList<>();
        for (TeamDBO team : teams) {
            teamNames.add(team.getName());
        }

        // Konverter til ObservableList for ChoiceBox
        ObservableList<String> observableTeamNames = FXCollections.observableArrayList(teamNames);

        // Indstil holdnavnene i ChoiceBoxes
        homeTeamChoiceBox.setItems(observableTeamNames);
        awayTeamChoiceBox.setItems(observableTeamNames);
    }

    @FXML
    private void handleCreateMatch() {
        // Hent værdier fra ChoiceBox
        String homeTeam = homeTeamChoiceBox.getValue();
        String awayTeam = awayTeamChoiceBox.getValue();

        // Valider valg
        if (homeTeam == null || awayTeam == null) {
            System.out.println("Vælg både hjemmehold og udehold før du opretter kampen.");
            return;
        }

        // Find TeamID for hjemme- og udehold
        int homeTeamId = dbTeam.getTeamIdByName(homeTeam);
        int awayTeamId = dbTeam.getTeamIdByName(awayTeam);

        // Tjek om TeamID blev fundet
        if (homeTeamId == -1 || awayTeamId == -1) {
            System.out.println("Kunne ikke finde hold i databasen.");
            return;
        }

        // Indsæt kampen i databasen
        boolean success = dbMatch.CreateMatch(homeTeamId, awayTeamId);

        // Bekræft resultatet
        if (success) {
            System.out.println("Kamp oprettet mellem " + homeTeam + " og " + awayTeam);
        } else {
            System.out.println("Kunne ikke oprette kampen.");
        }
    }
}

