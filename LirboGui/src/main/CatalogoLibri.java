import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoLibri {
    private List<Libro> libri;

    public CatalogoLibri() {
        this.libri = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public List<Libro> getLibri() {
        return new ArrayList<>(libri);
    }

    public List<Libro> cercaLibro(String query) {
        return libri.stream()
                .filter(libro -> libro.getTitolo().toLowerCase().contains(query.toLowerCase()) ||
                        libro.getAutore().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean rimuoviLibro(String isbn) {
        return libri.removeIf(libro -> libro.getIsbn().equals(isbn));
    }
}
