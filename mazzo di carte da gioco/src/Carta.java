public class Carta {

    private String seme;
    private String valore;

    public Carta(String semee, String valoree) {
        this.seme = semee;
        this.valore = valoree;
    }

    @Override
    public String toString() {
        return valore + " di " + seme;
    }
}
