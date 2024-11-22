import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.List;

public class SistemaFerroviarioTest {

    private SistemaFerroviario sistema;

    @BeforeEach
    public void setup() {
        sistema = new SistemaFerroviario();
        sistema.aggiungiStazione("Roma");
        sistema.aggiungiStazione("Milano");
        sistema.aggiungiStazione("Napoli");
    }

    @Test
    public void testAggiungiStazione() {
        sistema.aggiungiStazione("Torino");
        assertNotNull(sistema.stazioni.get("Torino"));
    }

    @Test
    public void testAggiungiTreno() {
        sistema.aggiungiTreno("T001", "Roma", "Milano", LocalTime.of(10, 30));
        Treno treno = sistema.treni.get("T001");
        assertNotNull(treno);
        assertEquals("Roma", treno.getPartenza().getNome());
        assertEquals("Milano", treno.getDestinazione().getNome());
    }

    @Test
    public void testCercaTreni() {
        sistema.aggiungiTreno("T001", "Roma", "Milano", LocalTime.of(10, 30));
        sistema.aggiungiTreno("T002", "Roma", "Napoli", LocalTime.of(11, 30));
        List<Treno> treni = sistema.cercaTreni("Roma", "Milano");
        assertEquals(1, treni.size());
        assertEquals("T001", treni.get(0).getId());
    }

    @Test
    public void testPrenotaBiglietto() {
        sistema.aggiungiTreno("T001", "Roma", "Milano", LocalTime.of(10, 30));
        Biglietto biglietto = sistema.prenotaBiglietto("T001", "Mario");
        assertNotNull(biglietto);
        assertEquals("Mario", biglietto.passeggero.getNome());
        assertEquals("T001", biglietto.treno.getId());
    }

    @Test
    public void testVisualizzaBiglietti() {
        sistema.aggiungiTreno("T001", "Roma", "Milano", LocalTime.of(10, 30));
        sistema.prenotaBiglietto("T001", "Mario");
        List<Biglietto> biglietti = sistema.visualizzaBiglietti("Mario");
        assertEquals(1, biglietti.size());
        assertEquals("T001", biglietti.get(0).treno.getId());
    }
}
