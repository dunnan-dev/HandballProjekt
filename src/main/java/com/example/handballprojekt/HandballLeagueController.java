package com.example.handballprojekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HandballLeagueController {

    @FXML
    private Button btn_createTeam;

    @FXML
    private Button btn_deleteTeam;

    @FXML
    private Label welcomeText;

    @FXML
    void on_createTeam(ActionEvent event) {
        String text = welcomeText.getText();
        System.out.println(text);
        welcomeText.setText("Jeg er læst");
    }

}
