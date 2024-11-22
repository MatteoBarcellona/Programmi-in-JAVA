public class Libro {
    private String titolo;
    private String autore;
    private String isbn;
    private int annoPubblicazione;

    public Libro(String titolo, String autore, String isbn, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String toString() {
        return titolo + " - " + autore + " (ISBN: " + isbn + ", Anno: " + annoPubblicazione + ")";
    }
}
