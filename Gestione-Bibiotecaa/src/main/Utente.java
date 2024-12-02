import java.util.ArrayList;
import java.util.List;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private List<Libro> libriInPrestito;

    public Utente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.libriInPrestito = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Libro> getLibriInPrestito() {
        return libriInPrestito;
    }

    public void aggiungiLibroPrestato(Libro libro) {
        libriInPrestito.add(libro);
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + email + ")";
    }

    public String getNome() {
        return nome;
    }
}
