import java.time.LocalDate;

public class Sanzione {
    private double importo;
    private String descrizione;
    private LocalDate dataApplicazione;

    public Sanzione(double importo, String descrizione) {
        this.importo = importo;
        this.descrizione = descrizione;
        this.dataApplicazione = LocalDate.now();
    }

    @Override
    public String toString() {
        return "sanzione di €" + importo + ": " + descrizione + " (applicata il: " + dataApplicazione + ")";
    }
}
