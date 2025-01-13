package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Metodo per connettersi al database
    public static Connection connect() throws SQLException {
        // Definisci l'URL di connessione al database
        String url = "jdbc:mysql://localhost:3306/EsercizioDB"; // Sostituisci con il tuo database
        String username = "root"; // Username MySQL
        String password = "1matteo2"; // Password MySQL

        // Crea e restituisce la connessione
        return DriverManager.getConnection(url, username, password);
    }
}
