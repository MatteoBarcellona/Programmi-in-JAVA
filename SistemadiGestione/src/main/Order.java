import java.util.List;

public class Order {
    private int id;
    private String nomeCliente;
    private List<String> prodotti;
    private double prezzoTotale;

    public Order(int id, String nomeCliente, List<String> prodotti, double prezzoTotale) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.prodotti = prodotti;
        this.prezzoTotale = prezzoTotale;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<String> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<String> prodotti) {
        this.prodotti = prodotti;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    @Override
    public String toString() {
        return "Ordine {id=" + id + ", nome cliente='" + nomeCliente + '\'' + ", prodotti=" + prodotti + ", prezzo totale=" + prezzoTotale + '}';
    }
}
