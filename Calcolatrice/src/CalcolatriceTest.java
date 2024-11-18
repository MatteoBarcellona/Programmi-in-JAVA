import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcolatriceTest {

    private Calcolatrice calcolatrice;

    @BeforeEach
    void setUp() {
        calcolatrice = new Calcolatrice();
    }

    @Test
    void testSomma() {
        assertEquals(5, calcolatrice.somma(2, 3));
        assertEquals(0, calcolatrice.somma(3, -3));
        assertEquals(-7, calcolatrice.somma(-4, -3));
    }

    @Test
    void testSottrazione() {
        assertEquals(1, calcolatrice.sottrai(3, 2));
        assertEquals(6, calcolatrice.sottrai(3, -3));
        assertEquals(-1, calcolatrice.sottrai(-4, -3));
    }

    @Test
    void testMoltiplicazione() {
        assertEquals(6, calcolatrice.moltiplica(2, 3));
        assertEquals(-6, calcolatrice.moltiplica(2, -3));
        assertEquals(0, calcolatrice.moltiplica(2, 0));
    }

    @Test
    void testDivisione() {
        assertEquals(2.0, calcolatrice.dividi(6, 3));
        assertEquals(-2.0, calcolatrice.dividi(6, -3));
        assertThrows(IllegalArgumentException.class, () -> calcolatrice.dividi(6, 0));
    }
}
