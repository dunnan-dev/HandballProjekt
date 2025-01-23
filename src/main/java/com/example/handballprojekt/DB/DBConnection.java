package com.example.handballprojekt.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Árni

// Klasse til håndtering af databaseforbindelse
public class DBConnection {
    private static Connection connection; // Statisk forbindelse, så den kan genbruges

    // Opretter og returnerer en databaseforbindelse
    public Connection dbConnect() {
        try {
            // Indlæser JDBC-driveren og opretter forbindelse til databasen
            loadJdbcDriver();
            getConnection("MidtVejsProjekt_V2"); // Specifik database indlæses
        } catch (Exception e) {
            // Logger fejlmeddelelse ved problemer
            System.out.println(e.getMessage());
        }
        return connection; // Returnerer forbindelsen
    }

    // Indlæser JDBC-driveren til SQL Server
    private static boolean loadJdbcDriver() {
        try {
            System.out.println("Loading JDBC driver...");

            // Indlæser driverklassen
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("JDBC driver loaded");
            return true; // Returnerer true, hvis driveren indlæses korrekt
        } catch (ClassNotFoundException e) {
            // Logger fejlmeddelelse, hvis driveren ikke kan findes
            System.out.println("Could not load JDBC driver!");
            return false; // Returnerer false ved fejl
        }
    }

    // Opretter forbindelse til SQL Server
    private static Boolean getConnection(String dbName) {
        // Bygger forbindelsesstrengen med det angivne database-navn
        String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";trustServerCertificate=true;";
        String username = "admin"; // Brugernavn til databasen
        String password = "admin"; // Password til databasen

        try {
            // Forsøger at oprette forbindelse med DriverManager
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Connected to SQL Server successfully!");
        } catch (SQLException e) {
            // Logger fejlmeddelelse og detaljeret stack trace ved forbindelsesfejl
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            return false; // Returnerer false, hvis forbindelsen mislykkes
        }
        return true; // Returnerer true, hvis forbindelsen lykkes
    }
}
