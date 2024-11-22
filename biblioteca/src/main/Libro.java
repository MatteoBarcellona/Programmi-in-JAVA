public class Libro {
    private String titolo;
    private String autore;
    private String codiceISBN;
    private String categoria;
    private boolean disponibile;

    public Libro(String titolo, String autore, String codiceISBN, String categoria) {
        this.titolo = titolo;
        this.autore = autore;
        this.codiceISBN = codiceISBN;
        this.categoria = categoria;
        this.disponibile = true; // Disponibile di default
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return titolo + " di " + autore + " (categoria: " + categoria + ", ISBN: " + codiceISBN + ")";
    }
}
