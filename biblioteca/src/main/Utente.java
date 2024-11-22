import java.util.ArrayList;
import java.util.List;

public class Utente {
    private String nome;
    private String dataIscrizione;
    private List<Prestito> prestitiAttuali;
    private List<Sanzione> sanzioni;

    public Utente(String nome, String dataIscrizione) {
        this.nome = nome;
        this.dataIscrizione = dataIscrizione;
        this.prestitiAttuali = new ArrayList<>();
        this.sanzioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Prestito> getPrestitiAttuali() {
        return prestitiAttuali;
    }

    public List<Sanzione> getSanzioni() {
        return sanzioni;
    }

    @Override
    public String toString() {
        return nome + " (iscritto dal: " + dataIscrizione + ")";
    }
}

