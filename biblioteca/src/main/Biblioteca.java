import java.util.*;
import java.time.LocalDate;

public class Biblioteca {
    private Map<String, Libro> libri;
    private List<Utente> utenti;
    private List<Prestito> prestiti;

    public Biblioteca() {
        this.libri = new HashMap<>();
        this.utenti = new ArrayList<>();
        this.prestiti = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.put(libro.getCodiceISBN(), libro);
    }

    public void registraUtente(Utente utente) {
        utenti.add(utente);
    }

    public void effettuaPrestito(String codiceISBN, String nomeUtente) {
        Libro libro = libri.get(codiceISBN);
        if (libro == null || !libro.isDisponibile()) {
            throw new RuntimeException("libro non disponibile o non trovato.");
        }
        Utente utente = utenti.stream()
                .filter(u -> u.getNome().equals(nomeUtente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("utente non trovato."));
        Prestito prestito = new Prestito(libro, utente);
        libro.setDisponibile(false);
        utente.getPrestitiAttuali().add(prestito);
        prestiti.add(prestito);
    }

    public void restituisciLibro(String codiceISBN, String nomeUtente) {
        Utente utente = utenti.stream()
                .filter(u -> u.getNome().equals(nomeUtente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("utente non trovato."));
        Prestito prestito = utente.getPrestitiAttuali().stream()
                .filter(p -> p.getLibro().getCodiceISBN().equals(codiceISBN))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("prestito non trovato."));
        Libro libro = prestito.getLibro();
        libro.setDisponibile(true);
        utente.getPrestitiAttuali().remove(prestito);

        if (LocalDate.now().isAfter(prestito.getDataRestituzionePrevista())) {
            long giorniRitardo = LocalDate.now().toEpochDay() - prestito.getDataRestituzionePrevista().toEpochDay();
            double importo = giorniRitardo * 1.0; // 1 euro per giorno di ritardo
            Sanzione sanzione = new Sanzione(importo, "ritardo di " + giorniRitardo + " giorni");
            utente.getSanzioni().add(sanzione);
        }
    }

    public List<Libro> visualizzaLibriDisponibili() {
        List<Libro> disponibili = new ArrayList<>();
        for (Libro libro : libri.values()) {
            if (libro.isDisponibile()) {
                disponibili.add(libro);
            }
        }
        return disponibili;
    }

    public List<Prestito> visualizzaPrestitiUtente(String nomeUtente) {
        Utente utente = utenti.stream()
                .filter(u -> u.getNome().equals(nomeUtente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("utente non trovato."));
        return utente.getPrestitiAttuali();
    }
}
