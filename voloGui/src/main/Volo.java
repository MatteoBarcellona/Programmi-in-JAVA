import java.util.Date;

public class Volo {
    private String codiceVolo;
    private String destinazione;
    private String data;
    private int postiDisponibili;
    private int postiPrenotati;

    public Volo(String codiceVolo, String destinazione, Date data, int postiDisponibili) {
        this.codiceVolo = codiceVolo;
        this.destinazione = destinazione;
        this.data = String.valueOf(data);
        this.postiDisponibili = postiDisponibili;
        this.postiPrenotati = 0;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getData() {
        return data;
    }

    public int getPostiDisponibili() {
        return postiDisponibili - postiPrenotati;
    }

    public boolean disponibilita(int posti) {
        return posti <= getPostiDisponibili();  // Restituisce true se i posti richiesti sono disponibili
    }

    public void prenota(int posti) {
        if (disponibilita(posti)) {
            postiPrenotati += posti;
        }
    }

    public void cancellaPrenotazione(int posti) {
        if (posti <= postiPrenotati) {
            postiPrenotati -= posti;
        }
    }

    @Override
    public String toString() {
        return "Codice: " + codiceVolo + ", Destinazione: " + destinazione + ", Data: " + data + ", Posti disponibili: " + getPostiDisponibili();
    }
}
