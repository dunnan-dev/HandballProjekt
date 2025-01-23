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

public class FrontPageController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Handball Project");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private Button bn_goToTeamList;

    @FXML
    private Button bn_goToMatchView;

    @FXML
    private Button bn_goToHandballLeague;

    @FXML
    void onAction_goToHandballLeague(ActionEvent event) {

    }

    @FXML
    void onAction_goToMatchView(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MatchView.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onAction_goToTeamList(ActionEvent event) {
    }
    public static void main(String[] args) {
        launch();
    }

}



