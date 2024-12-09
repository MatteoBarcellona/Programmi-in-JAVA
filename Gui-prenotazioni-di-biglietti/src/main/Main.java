import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Creazione del gestore delle prenotazioni
        GestorePrenotazioni gestore = new GestorePrenotazioni(25.0); // Costo base biglietto 25€

        // Prenotazione di biglietti
        boolean risultato = gestore.prenotaBiglietti("Giovanni", 3, new Date(), "Standard");
        System.out.println("Prenotazione riuscita: " + risultato);

        // Calcolo del costo totale per 3 biglietti "Premium"
        double costoTotale = gestore.calcolaCostoTotale(3, "Premium");
        System.out.println("Costo totale: " + costoTotale);

        // Visualizza tutte le prenotazioni
        gestore.getPrenotazioni().forEach(p -> {
            System.out.println("Prenotazione: " + p.getNomeUtente() + " - " + p.getNumeroBiglietti() + " biglietti");
        });
    }
}
