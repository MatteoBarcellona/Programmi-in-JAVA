import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.util.stream.Collectors;

public class GestorePrenotazioni {
    private static final int LIMITE_BIGLIETTI_GIORNALIERI = 500;
    private List<Prenotazione> prenotazioni;
    private double costoBaseBiglietto;

    // Costruttore con costo base configurabile
    public GestorePrenotazioni(double costoBaseBiglietto) {
        this.costoBaseBiglietto = costoBaseBiglietto;
        prenotazioni = new ArrayList<>();
        caricaPrenotazioni();  // Carica le prenotazioni salvate
    }

    // Costruttore senza parametri con valore di costo base predefinito
    public GestorePrenotazioni() {
        this(20.0);  // Prezzo predefinito del biglietto 20€
    }

    public boolean prenotaBiglietti(String nomeUtente, int numeroBiglietti, Date dataVisita, String tipoBiglietto) {
        // Validazione input
        if (!validazioneDati(nomeUtente, numeroBiglietti, dataVisita)) {
            return false;
        }

        // Verifica che la data non sia passata
        if (dataVisita.before(new Date())) {
            return false;
        }

        // Verifica il limite massimo di biglietti
        int bigliettiTotali = getTotaleBigliettiPerData(dataVisita);
        if (bigliettiTotali + numeroBiglietti > LIMITE_BIGLIETTI_GIORNALIERI) {
            return false;
        }

        Prenotazione prenotazione = new Prenotazione(nomeUtente, numeroBiglietti, dataVisita, tipoBiglietto);
        prenotazioni.add(prenotazione);
        salvaPrenotazioni();  // Salva le prenotazioni su file

        // Mostra una finestra di conferma
        JOptionPane.showMessageDialog(null, "Prenotazione effettuata con successo!", "Conferma Prenotazione", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    private boolean validazioneDati(String nomeUtente, int numeroBiglietti, Date dataVisita) {
        // Controlla il numero di biglietti
        if (numeroBiglietti <= 0) {
            return false;
        }

        // Controlla che il nome utente non sia vuoto o null
        if (nomeUtente == null || nomeUtente.trim().isEmpty()) {
            return false;
        }

        // Controlla che la data non sia nel passato
        if (dataVisita.before(new Date())) {
            return false;
        }

        return true;
    }

    private int getTotaleBigliettiPerData(Date data) {
        int totale = 0;
        // Usa una SimpleDateFormat per comparare solo le date, ignorando l'orario
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataStr = sdf.format(data);

        for (Prenotazione p : prenotazioni) {
            if (sdf.format(p.getDataVisita()).equals(dataStr)) {
                totale += p.getNumeroBiglietti();
            }
        }
        return totale;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void cancellaPrenotazione(Prenotazione prenotazione) {
        prenotazioni.remove(prenotazione);
        salvaPrenotazioni();  // Salva le modifiche su file
    }

    private void salvaPrenotazioni() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prenotazioni.dat"))) {
            oos.writeObject(prenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void caricaPrenotazioni() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prenotazioni.dat"))) {
            prenotazioni = (List<Prenotazione>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean rimuoviPrenotazione(Prenotazione prenotazione) {
        return prenotazioni.remove(prenotazione);
    }

    public int getNumeroBigliettiTotali() {
        return prenotazioni.stream().mapToInt(Prenotazione::getNumeroBiglietti).sum();
    }

    public double calcolaCostoTotale(int numeroBiglietti, String tipoBiglietto) {
        double costoTotale = numeroBiglietti * costoBaseBiglietto;
        if (tipoBiglietto.equals("Premium")) {
            costoTotale += costoTotale * 0.5; // 50% in più per i biglietti Premium
        }
        if (numeroBiglietti > 5) {
            costoTotale *= 0.9; // Sconto del 10% per più di 5 biglietti
        }
        return costoTotale;
    }

    // Esporta le prenotazioni in un file CSV
    public void esportaPrenotazioniCSV() {
        try (PrintWriter writer = new PrintWriter(new File("prenotazioni.csv"))) {
            writer.println("Nome Utente,Numero Biglietti,Data Visita,Tipo Biglietto,Costo Totale");

            for (Prenotazione prenotazione : prenotazioni) {
                writer.printf("%s,%d,%s,%s,%.2f\n",
                        prenotazione.getNomeUtente(),
                        prenotazione.getNumeroBiglietti(),
                        new SimpleDateFormat("yyyy-MM-dd").format(prenotazione.getDataVisita()),
                        prenotazione.getTipoBiglietto(),
                        calcolaCostoTotale(prenotazione.getNumeroBiglietti(), prenotazione.getTipoBiglietto()));
            }
            JOptionPane.showMessageDialog(null, "Prenotazioni esportate correttamente in prenotazioni.csv", "Esportazione Completata", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Calcola gli incassi totali per ogni data
    public Map<String, Double> calcolaIncassiPerData() {
        Map<String, Double> incassiPerData = new HashMap<>();

        for (Prenotazione prenotazione : prenotazioni) {
            String data = new SimpleDateFormat("yyyy-MM-dd").format(prenotazione.getDataVisita());
            double incasso = calcolaCostoTotale(prenotazione.getNumeroBiglietti(), prenotazione.getTipoBiglietto());

            incassiPerData.put(data, incassiPerData.getOrDefault(data, 0.0) + incasso);
        }

        // Mostra gli incassi per ogni data
        for (Map.Entry<String, Double> entry : incassiPerData.entrySet()) {
            System.out.printf("Data: %s, Incasso Totale: %.2f\n", entry.getKey(), entry.getValue());
        }

        return incassiPerData;
    }

    public boolean prenotaBiglietti(Prenotazione prenotazioneValida) {
        prenotazioni.remove(prenotazioneValida);
        return prenotazioni.isEmpty();
    }
}
