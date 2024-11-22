public class Prenotazione {
    private Utente utente;
    private Volo volo;
    private int postiPrenotati;

    public Prenotazione(Utente utente, Volo volo, int postiPrenotati) {
        this.utente = utente;
        this.volo = volo;
        this.postiPrenotati = postiPrenotati;
    }

    public Utente getUtente() {
        return utente;
    }

    public Volo getVolo() {
        return volo;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }
}
