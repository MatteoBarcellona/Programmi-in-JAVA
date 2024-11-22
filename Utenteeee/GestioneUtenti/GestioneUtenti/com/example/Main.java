package com.example;

import com.example.dao.UtenteDAO;
import com.example.model.Utente;
import com.example.service.UtenteService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UtenteDAO utenteDAO = new com.example.dao.InMemoryUtenteDAO(); // Implementazione mockata in memoria
        UtenteService utenteService = new UtenteService(utenteDAO);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aggiungi utente");
            System.out.println("2. Trova utente per ID");
            System.out.println("3. Visualizza tutti gli utenti");
            System.out.println("4. Elimina utente");
            System.out.println("5. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.print("inserisci ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("inserisci Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("inserisci Email: ");
                    String email = scanner.nextLine();
                    utenteService.aggiungiUtente(new Utente(id, nome, email));
                    break;
                case 2:
                    System.out.print("inserisci ID: ");
                    Utente utente = utenteService.trovaUtente(scanner.nextInt());
                    System.out.println(utente != null ? utente : "utente non trovato.");
                    break;
                case 3:
                    utenteService.tuttiGliUtenti().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("inserisci ID: ");
                    boolean removed = utenteService.eliminaUtente(scanner.nextInt());
                    System.out.println(removed ? "utente rimosso." : "utente non trovato.");
                    break;
                case 5:
                    System.out.println("uscita.");
                    return;
                default:
                    System.out.println("scelta non valida.");
            }
        }
    }
}
