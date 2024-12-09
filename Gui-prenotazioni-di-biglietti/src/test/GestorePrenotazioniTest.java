import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class GestorePrenotazioniTest {

    private GestorePrenotazioni gestore;

    @BeforeEach
    void setUp() {
        gestore = new GestorePrenotazioni(20.0); // Costo base del biglietto è 20€
    }

    @Test
    void testCalcoloCostoBigliettoStandard() {
        double costoTotale = gestore.calcolaCostoTotale(3, "Standard");
        assertEquals(60.0, costoTotale, 0.01);
    }

    @Test
    void testCalcoloCostoBigliettoPremium() {
        double costoTotale = gestore.calcolaCostoTotale(3, "Premium");
        assertEquals(90.0, costoTotale, 0.01); // 3 biglietti * 20€ + 50%
    }

    @Test
    void testCalcoloSconto() {
        double costoTotale = gestore.calcolaCostoTotale(6, "Standard");
        assertEquals(108.0, costoTotale, 0.01); // 6 biglietti * 20€ con 10% di sconto
    }
}
