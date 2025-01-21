package com.example.handballprojekt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class hanballLeague extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Indlæs FXML-filen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/handballprojekt/handballleague.fxml"));

        // Brug loader.load() til at oprette root-elementet
        Scene scene = new Scene(loader.load());

        // Opsætning af stage
        stage.setTitle("Håndboldliga");
        stage.setScene(scene);
        stage.show();
        final ObservableList<String> teams = FXCollections.observableArrayList();
        final ObservableList<String> matches = FXCollections.observableArrayList();

    }

    public static void main(String[] args) {
        launch();
    }


    public void on_createTeam(ActionEvent actionEvent) {
        System.out.println("");
    }
}
