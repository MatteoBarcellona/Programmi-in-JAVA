public class Utente {
    private String username;
    private String password;
    private boolean isAdmin;

    public Utente(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean verificaPassword(String password) {
        return this.password.equals(password);
    }
}
