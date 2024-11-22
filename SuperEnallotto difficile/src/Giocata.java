import java.util.Set;

public class Giocata {
    private String id;
    private Set<Integer> numeri;
    private int superstar;

    public Giocata(String id, Set<Integer> numeri, int superStar) {
        this.id = id;
        this.numeri = numeri;
        this.superstar = superStar;
    }

    public String getId() {
        return id;
    }

    public Set<Integer> getNumeri() {
        return numeri;
    }

    public int getSuperStar() {
        return superstar;
    }

    @Override
    public String toString() {
        return "giocata{" + "id='" + id + '\'' + ", numeri=" + numeri + ", superStar=" + superstar + '}';
    }
}
