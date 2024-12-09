import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class SistemaPrenotazioniTest {
    private GestorePrenotazioni gestore;
    private Prenotazione prenotazioneValida;

    @Before
    public void setUp() {
        gestore = new GestorePrenotazioni(100.0); // Limite massimo di 100 biglietti
        prenotazioneValida = new Prenotazione("Giovanni Bianchi", 2, new Date(), "Standard");
    }

    @Test
    public void testAggiuntaPrenotazioneValida() {
        boolean risultato = gestore.prenotaBiglietti(prenotazioneValida);
        assertTrue("La prenotazione valida dovrebbe essere aggiunta.", risultato);
    }

    @Test
    public void testRimozionePrenotazione() {

    }

    @Test
    public void testLimiteMassimoBiglietti() {

    }
}
