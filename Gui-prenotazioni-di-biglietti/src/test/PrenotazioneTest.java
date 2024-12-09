import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class PrenotazioneTest {
    private Prenotazione prenotazioneStandard;
    private Prenotazione prenotazionePremium;

    @Before
    public void setUp() {
        // Imposta un esempio di prenotazione per tipo Standard e Premium
        prenotazioneStandard = new Prenotazione("Mario Rossi", 2, new Date(), "Standard");
        prenotazionePremium = new Prenotazione("Luigi Verdi", 2, new Date(), "Premium");
    }

    @Test
    public void testCalcoloCostoTotaleStandard() {
        double costo = prenotazioneStandard.getCostoTotale();
        double expected = 20.0; // Supponendo che il costo del biglietto standard sia 10
        System.out.println("Il costo totale per il biglietto premium non è corretto." +"il ocsto:"+costo+"expected:"+expected);
    }

    @Test
    public void testCalcoloCostoTotalePremium() {
        double costo = prenotazionePremium.getCostoTotale();
        double expected = 30.0; // Supponendo che il costo del biglietto premium sia 15
        System.out.println("Il costo totale per il biglietto premium non è corretto." +"il ocsto:"+costo+"expected:"+expected);
    }

    @Test
    public void testApplicazioneSconto() {
        prenotazionePremium.setNumeroBiglietti(3); // Modifica per 3 biglietti
        double costo = prenotazionePremium.getCostoTotale();
        double expected = 40.0; // Supponendo che ci sia uno sconto per 3 biglietti
        System.out.println("Il costo totale per il biglietto premium non è corretto." +"il ocsto:"+costo+"expected:"+expected);
    }
}
