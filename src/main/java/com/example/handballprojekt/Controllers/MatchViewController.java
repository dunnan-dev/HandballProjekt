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

public class MatchViewController {


    @FXML
    private Button bn_goToFrontPage;

    @FXML
    private Button bn_AddMatch;

    @FXML
    void onAction_ReturnToFrontpage(ActionEvent event) {
        // Logik for at gå tilbage til forsiden (kan implementeres senere)
    }

    @FXML
    void onAction_goToCreateMatch(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/CreateMatchPage.fxml", event);
    }

    @FXML
    private ListView<MatchDBO> list_Matches;

    private DBMatchStatements db = new DBMatchStatements(); // Instans af databaseklassen

    @FXML
    public void initialize() {
        // Hent kampdata og opdater ListView
        ObservableList<MatchDBO> matchDBOS = FXCollections.observableArrayList(db.getAllMatches());
        list_Matches.setItems(matchDBOS);
    }

    @FXML
    void onAction_goToFrontpage(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/Frontpage.fxml", event);

    }
}


