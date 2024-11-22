import java.util.*;

public class SuperEnalotto {
    private Map<String, Giocata> giocate = new HashMap<>();
    private Map<String, Integer> statistiche = new HashMap<>();

    public void aggiungiGiocata(String id, Giocata giocata) {
        giocate.put(id, giocata);
    }

    public void eseguiEstrazione() {
        Estrazione estrazione = new Estrazione();
        System.out.println("estrazione: " + estrazione);
        for (Giocata giocata : giocate.values()) {
            calcolaVincite(giocata, estrazione);
        }
    }

    private void calcolaVincite(Giocata giocata, Estrazione estrazione) {
        Set<Integer> numeriGiocati = giocata.getNumeri();
        Set<Integer> numeriVincenti = estrazione.getNumeriVincenti();
        int numeriIndovinati = 0;

        for (int numero : numeriGiocati) {
            if (numeriVincenti.contains(numero)) {
                numeriIndovinati++;
            }
        }

        boolean jollyIndovinato = numeriGiocati.contains(estrazione.getJolly());
        boolean superStarIndovinato = giocata.getSuperStar() == estrazione.getSuperStar();

        String categoria = determinaCategoria(numeriIndovinati, jollyIndovinato, superStarIndovinato);
        statistiche.put(categoria, statistiche.getOrDefault(categoria, 0) + 1);

        System.out.println("giocata " + giocata.getId() + ":" +
                numeriIndovinati + " numeri indovinati, Jolly: " +
                (jollyIndovinato ? "sì" : "no") + "superStar: " +
                (superStarIndovinato ? "sì" : "no") + " (categoria: " + categoria + ")");
    }

    private String determinaCategoria(int numeriIndovinati, boolean jolly, boolean superStar) {
        if (numeriIndovinati == 6) return "6";
        if (numeriIndovinati == 5 && jolly) return "5+Jolly";
        if (numeriIndovinati == 5) return "5";
        if (numeriIndovinati == 4) return "4";
        if (numeriIndovinati == 3 && superStar) return "3+superstar";
        return "nessuna vincita";
    }

    public void visualizzaStatistiche() {
        System.out.println("statistiche finali:");
        for (Map.Entry<String, Integer> entry : statistiche.entrySet()) {
            System.out.println("- vincite " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
