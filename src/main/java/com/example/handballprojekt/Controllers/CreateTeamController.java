package com.example.handballprojekt.Controllers;

import java.io.IOException;

import com.example.handballprojekt.DB.DBTeamStatements;

import HelperMethods.HelperMethods.HelperMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Controller-klasse til oprettelse af nye hold
public class CreateTeamController {

    @FXML
    private Button btn_returnFrontpage; // Knap til at returnere til forsiden

    @FXML
    private Button btn_saveTeamDB; // Knap til at gemme hold i databasen

    @FXML
    private TextField tfield_inputName; // Tekstfelt til at indtaste holdets navn

    // Metode, der håndterer returknappen for at gå tilbage til forsiden
    @FXML
    void on_returnFrontpage(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/Frontpage.fxml", event);
    }

    // Metode, der håndterer gemmeknappen og opretter et nyt hold
    @FXML
    void on_saveTeamDB(ActionEvent event) {

        DBTeamStatements dbCon = new DBTeamStatements(); // Opretter en ny databaseforbindelse

        String Name = tfield_inputName.getText(); // Henter teksten fra inputfeltet

        // Validering: Tjekker, om feltet med holdnavnet er tomt
        if (Name.isBlank()) {
            // Viser en advarsel til brugeren, hvis navnet er tomt
            HelperMethods.showAlert("Fejl ved oprettelse af hold", "Hold navn må ikke være tomt!");
        } else {
            // Kalder metoden til at oprette holdet i databasen
            dbCon.CreateTeam(Name);

            // Viser en besked, der bekræfter oprettelsen
            HelperMethods.showAlert("Hold oprettet", "Hold " + Name + " er nu oprettet");
        }
    }
}
