import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaPrenotazioni {
    private ArrayList<Volo> voli = new ArrayList<>();
    private ArrayList<Utente> utenti = new ArrayList<>();
    private ArrayList<Prenotazione> prenotazioni = new ArrayList<>();

    public void aggiungiVolo(String codiceVolo, String destinazione, Date data, int postiMax) {
        // Aggiungi il volo solo se il codice non è già presente
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                JOptionPane.showMessageDialog(null, "Errore: Il volo con questo codice esiste già!", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Se il codice non esiste, aggiungi il volo
        voli.add(new Volo(codiceVolo, destinazione, data, postiMax));
    }



    public void aggiungiUtente(int id, String nome, String cognome) {
        utenti.add(new Utente(id, nome, cognome));
    }

    public void prenotarePosti(int utenteId, String codiceVolo, int posti) {
        Utente utente = trovaUtente(utenteId);
        Volo volo = trovaVolo(codiceVolo);
        if (utente != null && volo != null && volo.disponibilita(posti)) {
            volo.prenota(posti);
            prenotazioni.add(new Prenotazione(utente, volo, posti));
        }
    }

    public void cancellaPrenotazione(int utenteId, String codiceVolo) {
        Prenotazione prenotazione = trovaPrenotazione(utenteId, codiceVolo);
        if (prenotazione != null) {
            prenotazione.getVolo().cancellaPrenotazione(prenotazione.getPostiPrenotati());
            prenotazioni.remove(prenotazione);
        }
    }

    private Utente trovaUtente(int id) {
        for (Utente utente : utenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

    private Volo trovaVolo(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo;
            }
        }
        return null;
    }

    private Prenotazione trovaPrenotazione(int utenteId, String codiceVolo) {
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getUtente().getId() == utenteId && prenotazione.getVolo().getCodiceVolo().equals(codiceVolo)) {
                return prenotazione;
            }
        }
        return null;
    }

    public ArrayList<Volo> getVoliDisponibili() {
        return voli;
    }

    public ArrayList<Prenotazione> getPrenotazioniPerUtente(int utenteId) {
        ArrayList<Prenotazione> risultato = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getUtente().getId() == utenteId) {
                risultato.add(prenotazione);
            }
        }
        return risultato;
    }

    public Volo getVolo(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo; // Se trovato, restituisci il volo
            }
        }
        return null; // Se non trovato, restituisci null
    }


    public void ordinaVoliPerData() {
        voli.sort((v1, v2) -> {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dataVolo1 = format.parse(v1.getData());
                Date dataVolo2 = format.parse(v2.getData());
                return dataVolo1.compareTo(dataVolo2); // Ordinamento crescente
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        });
    }

    public void esportaVoli() {
        // Chiedi il nome del file per l'esportazione
        String fileName = JOptionPane.showInputDialog("Inserisci il nome del file per esportare i voli:");

        if (fileName != null && !fileName.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
                writer.write("Elenco dei Voli:\n");
                writer.write("========================\n");

                for (Volo volo : voli) {
                    // Scrivi i dettagli del volo
                    writer.write("Codice Volo: " + volo.getCodiceVolo() + "\n");
                    writer.write("Destinazione: " + volo.getDestinazione() + "\n");
                    writer.write("Data: " + volo.getData() + "\n");
                    writer.write("Posti Disponibili: " + volo.getPostiDisponibili() + "\n");
                    writer.write("========================\n");
                }
                JOptionPane.showMessageDialog(null, "Esportazione completata con successo!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Errore durante l'esportazione dei voli: " + e.getMessage());
            }
        }
    }

    // Metodo per esportare le prenotazioni
    public void esportaPrenotazioni() {
        // Chiedi il nome del file per l'esportazione
        String fileName = JOptionPane.showInputDialog("Inserisci il nome del file per esportare le prenotazioni:");

        if (fileName != null && !fileName.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + "_prenotazioni.txt"))) {
                writer.write("Elenco delle Prenotazioni:\n");
                writer.write("===============================\n");

                for (Prenotazione prenotazione : prenotazioni) {
                    // Scrivi i dettagli della prenotazione
                    writer.write("ID Utente: " + prenotazione.getUtente().getId() + "\n");
                    writer.write("Nome Utente: " + prenotazione.getUtente().getNome() + " " + prenotazione.getUtente().getCognome() + "\n");
                    writer.write("Codice Volo: " + prenotazione.getVolo().getCodiceVolo() + "\n");
                    writer.write("Destinazione: " + prenotazione.getVolo().getDestinazione() + "\n");
                    writer.write("Data: " + prenotazione.getVolo().getData() + "\n");
                    writer.write("Posti Prenotati: " + prenotazione.getPostiPrenotati() + "\n");
                    writer.write("===============================\n");
                }
                JOptionPane.showMessageDialog(null, "Esportazione completata con successo!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Errore durante l'esportazione delle prenotazioni: " + e.getMessage());
            }
        }
    }
}


