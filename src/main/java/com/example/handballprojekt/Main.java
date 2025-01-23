package com.example.handballprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//Tevfik

// Hovedklassen for JavaFX-applikationen, der styrer opstarten
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Indlæser FXML-filen, der definerer layoutet for forsiden
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Frontpage.fxml"));

        // Opretter en ny scene baseret på FXML-layoutet og angiver størrelsen
        Scene scene = new Scene(fxmlLoader.load(), 650, 240);

        // Sætter titlen på applikationsvinduet
        stage.setTitle("Hello!");

        // Tilknytter scenen til vinduet (Stage)
        stage.setScene(scene);

        // Viser vinduet
        stage.show();
    }

    // Hovedmetoden, der starter applikationen
    public static void main(String[] args) {
        // Starter JavaFX-applikationen ved at kalde `start`-metoden
        launch();
    }
}
