public class Libro {
    private String titolo;
    private String autore;
    private int anno;
    private String genere;
    private int numeroPrestiti;

    public Libro(String titolo, String autore, int anno, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.genere = genere;
        this.numeroPrestiti = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }

    public String getGenere() {
        return genere;
    }

    public int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    public void incrementaPrestiti() {
        this.numeroPrestiti++;
    }

    @Override
    public String toString() {
        return titolo + " di " + autore + " (" + anno + ") - " + genere;
    }
}
