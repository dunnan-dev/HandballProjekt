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

    // Methode til at skifte UI side
    public static void switchWindow(String fxmlFileName, Event event) throws IOException {
        Parent root = FXMLLoader.load(HelperMethods.class.getResource("/" + fxmlFileName));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null); 
        alert.setContentText(content); 
        alert.showAndWait();
    }
}
