import java.util.HashMap;

public class Login {
    private HashMap<String, Utente> utenti;

    public Login() {
        utenti = new HashMap<>();
        // Aggiungi utente di esempio
        utenti.put("admin", new Utente("admin", "admin123", true));
        utenti.put("user", new Utente("user", "user123", false));
    }

    public boolean verificaAccesso(String username, String password) {
        Utente utente = utenti.get(username);
        return utente != null && utente.verificaPassword(password);
    }

    public boolean isAdmin(String username) {
        Utente utente = utenti.get(username);
        return utente != null && utente.isAdmin();
    }
}
