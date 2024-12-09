import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti;

    // Costruttore
    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    // Aggiunge un prodotto
    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    // Rimuove un prodotto
    public boolean rimuoviProdotto(String nomeProdotto) {
        return prodotti.removeIf(p -> p.getNome().equalsIgnoreCase(nomeProdotto));
    }

    // Modifica quantità di un prodotto
    public boolean modificaQuantita(String nomeProdotto, int nuovaQuantita) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getNome().equalsIgnoreCase(nomeProdotto)) {
                prodotto.setQuantita(nuovaQuantita);
                return true;
            }
        }
        return false;
    }

    // Calcola il totale del carrello
    public double calcolaTotale() {
        return prodotti.stream().mapToDouble(Prodotto::calcolaTotale).sum();
    }

    // Applica uno sconto del 10% se il totale supera i 100€
    public double calcolaTotaleConSconto() {
        double totale = calcolaTotale();
        return totale > 100 ? totale * 0.9 : totale;
    }

    // Ottiene tutti i prodotti
    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodottiCaricati) {
        prodotti = prodottiCaricati;
    }
}
