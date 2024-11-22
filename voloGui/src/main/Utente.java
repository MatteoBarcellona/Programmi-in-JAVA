public class Utente {
    private int id;
    private String nome;
    private String cognome;

    public Utente(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (ID: " + id + ")";
    }
}
