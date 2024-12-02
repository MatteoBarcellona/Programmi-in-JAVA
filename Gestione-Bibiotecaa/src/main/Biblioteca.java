import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libri;
    private List<Utente> utenti;
    private List<Prestito> prestiti;

    public Biblioteca() {
        libri = new ArrayList<>();
        utenti = new ArrayList<>();
        prestiti = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public void registraUtente(Utente utente) {
        utenti.add(utente);
    }

    public List<Libro> cercaLibri(String titolo, String autore) {
        List<Libro> risultati = new ArrayList<>();
        for (Libro libro : libri) {
            if ((titolo.isEmpty() || libro.getTitolo().contains(titolo)) &&
                    (autore.isEmpty() || libro.getAutore().contains(autore))) {
                risultati.add(libro);
            }
        }
        return risultati;
    }

    public Utente autenticaUtente(String email) {
        for (Utente utente : utenti) {
            if (utente.getEmail().equals(email)) {
                return utente;
            }
        }
        return null;
    }

    public boolean prestitoLibro(Libro libro, Utente utente) {
        if (utente.getLibriInPrestito().size() < 3) {
            utente.aggiungiLibroPrestato(libro);
            Prestito prestito = new Prestito(libro, utente);
            prestiti.add(prestito);
            return true;
        }
        return false;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public List<Libro> getLibriPiùPopolari() {
        List<Libro> libriPopolari = new ArrayList<>(libri);
        libriPopolari.sort((l1, l2) -> Integer.compare(l2.getNumeroPrestiti(), l1.getNumeroPrestiti()));
        return libriPopolari;
    }

    public void rimuoviLibro(Libro libroDaRimuovere) {
        if (libri.remove(libroDaRimuovere)) {
            System.out.println("Libro rimosso con successo: " + libroDaRimuovere);
        } else {
            System.out.println("Libro non trovato: " + libroDaRimuovere);
        }
    }

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }
}
