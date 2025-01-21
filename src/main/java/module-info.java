module com.example.handballprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.handballprojekt to javafx.fxml;
    exports com.example.handballprojekt;
}