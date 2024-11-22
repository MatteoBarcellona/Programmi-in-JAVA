import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    private ArrayList<Carta> carte;
    private ArrayList<Carta> cartePescate;

    public Mazzo() {
        carte = new ArrayList<>();
        cartePescate = new ArrayList<>();
        String[] semi = {"cuori", "quadri", "fiori", "picche"};
        String[] valori = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String seme : semi) {
            for (String valore : valori) {
                carte.add(new Carta(seme, valore));
            }
        }
    }

    public void mescola() {
        Collections.shuffle(carte);
        System.out.println("il mazzo è stato mescolato.");
    }

    public Carta pesca() {
        if (carte.isEmpty()) {
            System.out.println("errore: il mazzo è vuoto.");
            return null;
        }
        Carta cartaPescata = carte.remove(0);
        cartePescate.add(cartaPescata);
        return cartaPescata;
    }

    public void visualizzaCarte() {
        if (carte.isEmpty()) {
            System.out.println("il mazzo è vuoto.");
        } else {
            System.out.println("carte rimanenti:");
            for (Carta carta : carte) {
                System.out.println(carta);
            }
        }
    }

    public void visualizzaCartePescate() {
        if (cartePescate.isEmpty()) {
            System.out.println("non sono state pescate carte.");
        } else {
            System.out.println("carte pescate:");
            for (Carta carta : cartePescate) {
                System.out.println(carta);
            }
        }
    }
}
