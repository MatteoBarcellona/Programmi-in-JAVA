public class Prodotto {
    private String nome;
    private double prezzo;
    private int quantita;

    // Costruttore con validazione
    public Prodotto(String nome, double prezzo, int quantita) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Prezzo deve essere positivo");
        }
        if (quantita < 0) {
            throw new IllegalArgumentException("Quantità deve essere positiva");
        }
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Prezzo deve essere positivo");
        }
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        if (quantita < 0) {
            throw new IllegalArgumentException("Quantità deve essere positiva");
        }
        this.quantita = quantita;
    }

    // Metodo per calcolare il totale
    public double calcolaTotale() {
        return prezzo * quantita;
    }

    @Override
    public String toString() {
        return nome + " - Prezzo: " + prezzo + "€ x " + quantita + " = " + calcolaTotale() + "€";
    }
}
