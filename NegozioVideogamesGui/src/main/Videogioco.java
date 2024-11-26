import java.io.Serializable;

public class Videogioco implements Serializable {
    private String titolo;
    private String sviluppatore;
    private double prezzo;
    private double sconto;
    private String copertina; // Percorso del file immagine

    public Videogioco(String titolo, String sviluppatore, double prezzo, double sconto, String copertina) {
        this.titolo = titolo;
        this.sviluppatore = sviluppatore;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.copertina = copertina;
    }

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public String getSviluppatore() { return sviluppatore; }
    public void setSviluppatore(String sviluppatore) { this.sviluppatore = sviluppatore; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public double getSconto() { return sconto; }
    public void setSconto(double sconto) { this.sconto = sconto; }

    public String getCopertina() { return copertina; }
    public void setCopertina(String copertina) { this.copertina = copertina; }

    public double calcolaPrezzoScontato() {
        return prezzo - (prezzo * sconto / 100);
    }
}
