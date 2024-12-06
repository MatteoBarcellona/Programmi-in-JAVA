import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto) throws IllegalArgumentException {
        if (prodotto.getNome().isEmpty()) {
            throw new IllegalArgumentException("Il nome del prodotto non può essere vuoto.");
        }
        if (prodotto.getPrezzo() < 0) {
            throw new IllegalArgumentException("Il prezzo del prodotto non può essere negativo.");
        }
        if (prodotto.getQuantita() <= 0) {
            throw new IllegalArgumentException("La quantità deve essere maggiore di zero.");
        }
        prodotti.add(prodotto);
    }

    public void salvaSuFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Prodotto prodotto : prodotti) {
                writer.write(prodotto.getNome() + "," + prodotto.getPrezzo() + "," + prodotto.getQuantita());
                writer.newLine();
            }
        }
    }

    public void caricaDaFile(String fileName) throws IOException {
        prodotti.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];
                double prezzo = Double.parseDouble(parts[1]);
                int quantita = Integer.parseInt(parts[2]);
                prodotti.add(new Prodotto(nome, prezzo, quantita));
            }
        }
    }

    public void ordinaPerNome() {
        prodotti.sort(Comparator.comparing(Prodotto::getNome));
    }

    public void ordinaPerPrezzo() {
        prodotti.sort(Comparator.comparingDouble(Prodotto::getPrezzo));
    }

    public void modificaQuantita(String nomeProdotto, int nuovaQuantita) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getNome().equals(nomeProdotto)) {
                prodotto.setQuantita(nuovaQuantita);
                return;
            }
        }
    }

    public double calcolaTotale() {
        return prodotti.stream().mapToDouble(Prodotto::calcolaTotale).sum();
    }

    public double calcolaTotaleConSconto() {
        double totale = calcolaTotale();
        return totale > 100 ? totale * 0.9 : totale;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void rimuoviProdotto(String nomeProdotto) {
        prodotti.removeIf(p -> p.getNome().equals(nomeProdotto));
    }

    public void svuotaCarrello() {
        prodotti.clear();
    }

}
