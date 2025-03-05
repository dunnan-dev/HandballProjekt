package com.example.handballprojekt.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.handballprojekt.DB.DBTeamStatements;
import com.example.handballprojekt.DBO.TeamDBO;

import HelperMethods.HelperMethods.HelperMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//Tevfik

// Controller-klasse til forsiden (Frontpage) i brugergrænsefladen
public class FrontpageController implements Initializable {

    @FXML
    private Button btn_createTeam; // Knap til at oprette et nyt hold

    @FXML
    private Button btn_deleteTeam; // Knap til at slette et eksisterende hold

    @FXML
    private Label welcomeText; // Label, der viser en velkomstbesked

    @FXML
    private TableColumn<TeamDBO, Integer> col_teamID; // Kolonne til at vise hold-ID

    @FXML
    private TableColumn<TeamDBO, String> col_Name; // Kolonne til at vise holdnavn

    @FXML
    private TableColumn<TeamDBO, Integer> col_Score; // Kolonne til at vise holdets score

    @FXML
    private TableColumn<TeamDBO, Integer> col_Wins; // Kolonne til at vise antal sejre

    @FXML
    private TableColumn<TeamDBO, Integer> col_Loss; // Kolonne til at vise antal nederlag

    @FXML
    private TableColumn<TeamDBO, Integer> col_Draw; // Kolonne til at vise antal uafgjorte kampe

    @FXML
    private TableColumn<TeamDBO, Integer> col_CoachID;

    @FXML
    private TableView<TeamDBO> table_Teams; // Tabel til at vise alle holdene

    // Initialiseringsmetode, der kører automatisk, når scenen indlæses
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Opretter forbindelse til databasen og henter alle hold
        DBTeamStatements dbCon = new DBTeamStatements();
        List<TeamDBO> teams = dbCon.getAllTeams();

        // Konverterer listen af hold til en ObservableList til TableView
        ObservableList<TeamDBO> teamList = FXCollections.observableArrayList(teams);

        // Binder dataen til TableView
        table_Teams.setItems(teamList);

        // Konfigurerer hver kolonne til at vise en specifik egenskab fra TeamDBO-klassen
        col_teamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));
        col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Score.setCellValueFactory(new PropertyValueFactory<>("score"));
        col_Wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        col_Loss.setCellValueFactory(new PropertyValueFactory<>("losses"));
        col_Draw.setCellValueFactory(new PropertyValueFactory<>("draws"));
        col_Draw.setCellValueFactory(new PropertyValueFactory<>("CoachID"));
    }

    // Skifter vindue til "Create Team"-siden
    @FXML
    void on_createTeam(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/CreateTeamPage.fxml", event);
    }

    // Skifter vindue til "Match View"-siden
    @FXML
    void onAction_goToMatchView(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/MatchViewPage.fxml", event);
    }

    @FXML
    void on_deleteTeam(ActionEvent event) {

        System.out.println("Funktion til at slette hold skal implementeres.");
    }
}
