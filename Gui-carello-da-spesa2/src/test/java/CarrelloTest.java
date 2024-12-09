import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarrelloTest {

    @Test
    public void testAggiungiProdotto() {
        Carrello carrello = new Carrello();
        Prodotto prodotto = new Prodotto("Mela", 0.5, 10);
        carrello.aggiungiProdotto(prodotto);
        assertEquals(1, carrello.getProdotti().size());
    }

    @Test
    public void testRimuoviProdotto() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Mela", 0.5, 10));
        assertTrue(carrello.rimuoviProdotto("Mela"));
        assertEquals(0, carrello.getProdotti().size());
    }

    @Test
    public void testModificaQuantita() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Mela", 0.5, 10));
        assertTrue(carrello.modificaQuantita("Mela", 20));
        assertEquals(20, carrello.getProdotti().get(0).getQuantita());
    }

    @Test
    public void testCalcolaTotale() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Mela", 0.5, 10));
        carrello.aggiungiProdotto(new Prodotto("Pane", 1.0, 5));
        assertEquals(10, carrello.calcolaTotale());
    }

    @Test
    public void testCalcolaTotaleConSconto() {
        Carrello carrello = new Carrello();
        carrello.aggiungiProdotto(new Prodotto("Prodotto Costoso", 120, 1));
        assertEquals(108, carrello.calcolaTotaleConSconto(), 0.01);
    }

    @Test
    public void testAggiuntaConValoriNonValidi() {

    }
}
