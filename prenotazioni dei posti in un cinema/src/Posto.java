public class Posto {
    private int numerofila;
    private int numeroposto;
    private boolean occupato;

    public Posto(int numerofilaa, int numeropostoo) {
        this.numerofila = numerofilaa;
        this.numeroposto = numeropostoo;
        this.occupato = false;
    }

    public void prenota() {
        this.occupato = true;
    }

    public void annullaPrenotazione() {
        this.occupato = false;
    }

    public boolean isOccupato() {
        return occupato;
    }

    @Override
    public String toString() {
        return occupato ? "X" : "O";
    }
}
