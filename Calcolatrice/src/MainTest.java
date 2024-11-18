import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class MainTest {

    @Test
    void testInputOpzioneValida() {
        String simulatedInput = "1\n5\n3\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(new String[] {});

        assertTrue(output.toString().contains("Benvenuto nella Calcolatrice!"));
        assertTrue(output.toString().contains("risultato: 8"));
    }

    @Test
    void testInputNonValido() {
        String simulatedInput = "a\n2\n5\n3\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(new String[] {});

        assertTrue(output.toString().contains("opzione non valida!"));
    }

    @Test
    void testDivisionePerZero() {
        String simulatedInput = "4\n5\n0\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(new String[] {});

        assertTrue(output.toString().contains("errore: Divisione per zero non consentita!"));
    }
}
