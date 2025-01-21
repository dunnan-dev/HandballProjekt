package com.example.handballprojekt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





    public class DBConnection {
        private static Connection connection;

        public Connection dbConnect() {
            try {
                loadJdbcDriver();
                getConnection("MidtVejsProjekt_V2");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }

        private static boolean loadJdbcDriver() {
            try {
                System.out.println("Loading JDBC driver...");

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                System.out.println("JDBC driver loaded");

                return true;
            }
            catch (ClassNotFoundException e) {
                System.out.println("Could not load JDBC driver!");
                return false;
            }
        }

        private static Boolean getConnection(String dbName) {
            String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";trustServerCertificate=true;";
            String username = "admin";
            String password = "admin";

            try {
                connection = DriverManager.getConnection(connectionString, username, password);
                System.out.println("Connected to SQL Server successfully!");
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

