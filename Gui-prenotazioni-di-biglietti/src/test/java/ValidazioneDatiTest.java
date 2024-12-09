import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ValidazioneDatiTest {

    @Test
    public void testNumeroBigliettiNegativo() {

    }

    @Test
    public void testDataNelPassato() {
        Date dataPassato = new Date(System.currentTimeMillis() - 1000000000L); // Data nel passato
        Prenotazione prenotazione = new Prenotazione("Elena", 1, dataPassato, "Premium");
    }

    @Test
    public void testNomeUtenteVuoto() {
        Prenotazione prenotazione = new Prenotazione("", 1, new Date(), "Standard");
    }

    @Test
    public void testNomeUtenteNull() {
        Prenotazione prenotazione = new Prenotazione(null, 1, new Date(), "Premium");
    }
}
