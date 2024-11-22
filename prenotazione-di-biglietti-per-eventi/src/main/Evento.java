
import java.util.*;

class Evento {
    private String nome;
    private Date data;
    private int postimax;
    private int postidis;
    private List<Prenotazione> prenotazioni;

    public Evento(String nome, Date data, int postimax) {
        this.nome = nome;
        this.data = data;
        this.postimax = postimax;
        this.postidis = postimax;
        this.prenotazioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }

    public int getPostiDisponibili() {
        return postidis;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }


    public void aggiungiPrenotazione(Prenotazione prenotazione) throws IllegalArgumentException {
        if (prenotazione.getNumeroBiglietti() > postidis) {
            System.out.println("posti esauriti per l'evento: " + nome);
        }
        postidis -= prenotazione.getNumeroBiglietti();
        prenotazioni.add(prenotazione);
    }


    public void annullaPrenotazione(Prenotazione prenotazione) throws IllegalArgumentException {
        if (!prenotazioni.remove(prenotazione)) {
            System.out.println("prenotazione non trovata.");
        }
        postidis += prenotazione.getNumeroBiglietti();
    }
}
