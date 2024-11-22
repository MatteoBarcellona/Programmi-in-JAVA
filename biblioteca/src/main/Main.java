public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "12345", "Fantasy");
        Libro libro2 = new Libro("1984", "George Orwell", "67890", "Distopia");
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);

        Utente utente1 = new Utente("Mario Rossi", "2024-11-19");
        biblioteca.registraUtente(utente1);

        biblioteca.effettuaPrestito("12345", "Mario Rossi");

        System.out.println("Libri disponibili: " + biblioteca.visualizzaLibriDisponibili());
        biblioteca.restituisciLibro("12345", "Mario Rossi");
    }
}
