package com.example.handballprojekt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MatchViewController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Indlæs MatchView.fxml som den første scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MatchView.fxml"));
            Parent root = loader.load();

            // Opret en scene og vis hovedvinduet
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Handball Project");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button bn_Back;

    @FXML
    private Button bn_AddMatch;

    @FXML
    void onAction_ReturnToFrontpage(ActionEvent event) {
        // Logik for at gå tilbage til forsiden (kan implementeres senere)
    }

    @FXML
    void onAction_goToCreateMatch(ActionEvent event) {
        try {
            // Indlæs CreateMatch.fxml for at skifte scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateMatch.fxml"));
            Parent root = loader.load();

            // Få fat i det nuværende vindue og skift scenen
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Start JavaFX-applikationen
    }
}
