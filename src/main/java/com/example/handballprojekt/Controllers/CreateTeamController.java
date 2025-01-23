package com.example.handballprojekt.Controllers;

import java.io.IOException;

import com.example.handballprojekt.DB.DBTeamStatements;

import HelperMethods.HelperMethods.HelperMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateTeamController {

    @FXML
    private Button btn_returnFrontpage;

    @FXML
    private Button btn_saveTeamDB;

    @FXML
    private TextField tfield_inputName;

    @FXML
    void on_returnFrontpage(ActionEvent event) throws IOException {
    HelperMethods.switchWindow("com/example/handballprojekt/Frontpage.fxml", event);
    }

    @FXML
    void on_saveTeamDB(ActionEvent event) {

        DBTeamStatements dbCon = new DBTeamStatements(); // Burde nok være static da den kaldes på klassen og ikke behøver en instiansering af nyt objekt ved hvert event (minor)

        String Name = tfield_inputName.getText();
        
        if(Name.isBlank())
        {
            HelperMethods.showAlert("Fejl ved oprettelse af hold", "Hold navn må ikke være tomt!");
        }
        else
        {
            dbCon.CreateTeam(Name);
            HelperMethods.showAlert("Hold oprettet", "Hold " + Name + " er nu oprettet");
        }
    }
}