import java.util.Date;

public class Prenotazione {
    private String nomeUtente;
    private int numeroBiglietti;
    private Date dataVisita;
    private String tipoBiglietto;
    private double costoTotale;

    public Prenotazione(String nomeUtente, int numeroBiglietti, Date dataVisita, String tipoBiglietto) {
        this.nomeUtente = nomeUtente;
        this.numeroBiglietti = numeroBiglietti;
        this.dataVisita = dataVisita;
        this.tipoBiglietto = tipoBiglietto;
        this.costoTotale = costoTotale;
    }

    private void calcolaCosto() {
        double costoBase = 20.0;
        double costoBiglietto = tipoBiglietto.equals("Premium") ? costoBase * 1.5 : costoBase;
        costoTotale = numeroBiglietti * costoBiglietto;

        // Applicazione dello sconto del 10% se sono più di 5 biglietti
        if (numeroBiglietti > 5) {
            costoTotale *= 0.9;
        }
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public int getNumeroBiglietti() {
        return numeroBiglietti;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public Date getDate() {
        return dataVisita;
    }

    public String getTipoBiglietto() {
        return tipoBiglietto;
    }

    public double getCostoTotale() {
        double costoBase = tipoBiglietto.equalsIgnoreCase("Premium") ? 15.0 : 10.0;
        double supplemento = tipoBiglietto.equalsIgnoreCase("Premium") ? 3.0 : 0.0;
        return (costoBase + supplemento) * numeroBiglietti;
    }

    @Override
    public String toString() {
        return nomeUtente + " | " + numeroBiglietti + " | " + dataVisita + " | " + tipoBiglietto + " | " + costoTotale;
    }

    public void setNumeroBiglietti(int i) {
        numeroBiglietti = 1;
    }
}
