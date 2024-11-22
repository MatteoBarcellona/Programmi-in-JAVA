public class Azione {
    private String nome;
    private String ticker;
    private double prezzo;

    public Azione(String nome, String ticker, double prezzo) {
        this.nome = nome;
        this.ticker = ticker;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void aggiornaPrezzo(double nuovoPrezzo) {
        this.prezzo = nuovoPrezzo;
    }

    @Override
    public String toString() {
        return "Ticket:"+ticker + ", IL nome :" + nome + " e il Prezzo: " + prezzo;
    }
}
