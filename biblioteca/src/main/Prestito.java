import java.time.LocalDate;

public class Prestito {
    private Libro libro;
    private Utente utente;
    private LocalDate dataPrestito;
    private LocalDate dataRestituzionePrevista;

    public Prestito(Libro libro, Utente utente) {
        this.libro = libro;
        this.utente = utente;
        this.dataPrestito = LocalDate.now();
        this.dataRestituzionePrevista = dataPrestito.plusDays(7);
    }

    public Libro getLibro() {
        return libro;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    @Override
    public String toString() {
        return "prestito: " + libro + " a " + utente.getNome() + " (scadenza: " + dataRestituzionePrevista + ")";
    }
}
