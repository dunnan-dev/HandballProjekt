package com.example.handballprojekt.Controllers;

import HelperMethods.HelperMethods.HelperMethods;
import com.example.handballprojekt.DB.DBMatchStatements;
import com.example.handballprojekt.DBO.MatchDBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

//Árni

// Controller-klasse til visning og håndtering af kampe i applikationen
public class MatchViewController {

    @FXML
    private Button bn_goToFrontPage; // Knap til at navigere tilbage til forsiden

    @FXML
    private Button bn_AddMatch; // Knap til at navigere til oprettelse af ny kamp

    @FXML
    private ListView<MatchDBO> list_Matches; // Listevisning til at vise alle kampe

    private DBMatchStatements db = new DBMatchStatements(); // Instans af databaseklassen til kampdata

    // Metode til at navigere tilbage til forsiden
    @FXML
    void onAction_ReturnToFrontpage(ActionEvent event) {
        // Placeholder til logik for navigation til forsiden (kan udvides)
    }

    // Metode til at navigere til siden for oprettelse af en ny kamp
    @FXML
    void onAction_goToCreateMatch(ActionEvent event) throws IOException {
        // Skifter vindue til oprettelse af kamp
        HelperMethods.switchWindow("com/example/handballprojekt/CreateMatchPage.fxml", event);
    }

    // Initialiseringsmetode, der kører automatisk, når scenen indlæses
    @FXML
    public void initialize() {
        // Henter alle kampe fra databasen
        ObservableList<MatchDBO> matchDBOS = FXCollections.observableArrayList(db.getAllMatches());

        // Binder kampdata til ListView
        list_Matches.setItems(matchDBOS);
    }

    // Metode til at navigere til forsiden
    @FXML
    void onAction_goToFrontpage(ActionEvent event) throws IOException {
        // Skifter vindue til forsiden
        HelperMethods.switchWindow("com/example/handballprojekt/Frontpage.fxml", event);
    }
}
