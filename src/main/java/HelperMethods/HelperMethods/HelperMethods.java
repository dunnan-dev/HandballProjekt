package HelperMethods.HelperMethods;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HelperMethods {

    // Metode til at skifte UI-side
    public static void switchWindow(String fxmlFileName, Event event) throws IOException {
        // Indlæser det ønskede FXML-layout
        Parent root = FXMLLoader.load(HelperMethods.class.getResource("/" + fxmlFileName));

        // Henter det nuværende vindue (Stage) fra eventet
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Opretter en ny scene baseret på det indlæste layout
        Scene scene = new Scene(root);

        // Opdaterer scenen i vinduet og viser det
        stage.setScene(scene);
        stage.show();
    }

    // Metode til at vise en informationsbesked i et popup-vindue (Alert)
    public static void showAlert(String title, String content) {
        // Opretter en alert af typen INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Sætter titel på alert
        alert.setTitle(title);

        // Ingen overskrift for denne alert
        alert.setHeaderText(null);

        // Sætter beskeden (indholdet)
        alert.setContentText(content);

        // Viser alerten og venter på brugerinteraktion
        alert.showAndWait();
    }
}
