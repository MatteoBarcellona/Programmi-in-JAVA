import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarrelloTest {

    @Test
    public void testAggiungiProdotto() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Pasta", 1.5, 2));
        assertEquals(1, carrello.getProdotti().size());
    }

    @Test
    public void testRimuoviProdotto() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Pasta", 1.5, 2));
        carrello.rimuoviProdotto("Pasta");
        assertTrue(carrello.getProdotti().isEmpty());
    }

    @Test
    public void testModificaQuantita() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Pasta", 1.5, 2));
        carrello.modificaQuantita("Pasta", 5);
        assertEquals(5, carrello.getProdotti().get(0).getQuantita());
    }

    @Test
    public void testCalcolaTotale() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Pasta", 1.5, 2));
        carrello.aggiungiProdotto(new Prodotto("Sugo", 2.0, 3));
        assertEquals(9.0, carrello.calcolaTotale());
    }

    @Test
    public void testCalcolaTotaleConSconto() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Prodotto Costoso", 120, 1));
        assertEquals(108.0, carrello.calcolaTotaleConSconto());
    }
}
