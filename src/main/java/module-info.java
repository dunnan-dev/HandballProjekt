module com.example.handballprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Export the Controllers package specifically for use by JavaFX
    exports com.example.handballprojekt.Controllers;

    // Export the main package so JavaFX runtime can access the Main class
    exports com.example.handballprojekt;

    // Open the base package to javafx.fxml for reflective access
    opens com.example.handballprojekt to javafx.fxml;

    // Open the Controllers package to javafx.fxml for reflective access
    opens com.example.handballprojekt.Controllers to javafx.fxml;

    // Open the DBO package to javafx.base for PropertyValueFactory access
    opens com.example.handballprojekt.DBO to javafx.base;
}
