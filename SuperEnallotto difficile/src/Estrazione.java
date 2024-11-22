import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Estrazione {
    private Set<Integer> numerivincenti;
    private int jolly;
    private int superstar;

    public Estrazione() {
        this.numerivincenti = generaNumeriVincenti();
        this.jolly = generaNumeroUnico();
        this.superstar = generaNumeroUnico();
    }

    private Set<Integer> generaNumeriVincenti() {
        Random random = new Random();
        Set<Integer> numeri = new HashSet<>();
        while (numeri.size() < 6) {
            numeri.add(random.nextInt(90) + 1);
        }
        return numeri;
    }

    private int generaNumeroUnico() {
        return new Random().nextInt(90) + 1;
    }

    public Set<Integer> getNumeriVincenti() {
        return numerivincenti;
    }

    public int getJolly() {
        return jolly;
    }

    public int getSuperStar() {
        return superstar;
    }

    @Override
    public String toString() {
        return "estrazione{" + "numerivincenti=" + numerivincenti + ", jolly=" + jolly + ", superstar=" + superstar + '}';
    }
}

