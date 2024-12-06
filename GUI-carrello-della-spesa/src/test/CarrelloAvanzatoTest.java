import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class CarrelloAvanzatoTest {

    @Test
    public void testValidazioneDati() {
        Carrello carrello = new Carrello();
        assertThrows(IllegalArgumentException.class, () -> carrello.aggiungiProdotto(new Prodotto("", 10, 1)));
        assertThrows(IllegalArgumentException.class, () -> carrello.aggiungiProdotto(new Prodotto("Pane", -5, 1)));
        assertThrows(IllegalArgumentException.class, () -> carrello.aggiungiProdotto(new Prodotto("Latte", 5, -2)));
    }

    @Test
    public void testSalvataggioCarrello() throws IOException {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Pasta", 1.5, 2));
        carrello.salvaSuFile("test.txt");

        Carrello carrelloCaricato = new Carrello();
        carrelloCaricato.caricaDaFile("test.txt");

        assertEquals(1, carrelloCaricato.getProdotti().size());
        assertEquals("Pasta", carrelloCaricato.getProdotti().get(0).getNome());
    }
}
