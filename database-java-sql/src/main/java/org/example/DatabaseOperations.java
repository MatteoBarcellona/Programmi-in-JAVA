package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {

    public static void fetchData() {
        // Query per recuperare i dati dalla tabella Utenti
        String query = "SELECT * FROM Utenti";

        // Connessione al database e recupero dei dati
        try (Connection conn = DatabaseConnector.connect();  // Connessione
             Statement stmt = conn.createStatement();         // Creazione della query
             ResultSet rs = stmt.executeQuery(query)) {       // Esecuzione della query

            System.out.println("Query eseguita con successo!");

            // Ciclo per stampare i dati recuperati dalla query
            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                System.out.println("ID: " + rs.getInt("ID") +
                        ", Nome: " + rs.getString("Nome") +
                        ", Cognome: " + rs.getString("Cognome") +
                        ", Email: " + rs.getString("Email"));
            }

            // Se non ci sono risultati
            if (!hasResults) {
                System.out.println("Nessun dato trovato nella tabella Utenti.");
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query: " + e.getMessage());
        }
    }
}
