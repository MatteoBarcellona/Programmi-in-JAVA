import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Torneo {
    private List<Giocatore> giocatori;
    private List<Partita> partite;

    public Torneo() {
        this.giocatori = new ArrayList<>();
        this.partite = new ArrayList<>();
    }

    public void registraGiocatore(Giocatore giocatore) throws IllegalArgumentException {
        for (Giocatore g : giocatori) {
            if (g.getId().equals(giocatore.getId())) {
                throw new IllegalArgumentException("giocatore con ID " + giocatore.getId() + " già registrato.");
            }
        }
        giocatori.add(giocatore);
    }

    public void avviaTorneo() {
        if (giocatori.size() % 2 != 0) {
            System.out.println("numero di giocatori dispari, aggiungere un altro giocatore per iniziare il torneo.");
            return;
        }

        giocatori.sort(Comparator.comparingInt(Giocatore::getRankingIniziale).reversed());

        for (int i = 0; i < giocatori.size(); i += 2) {
            Partita partita = new Partita(giocatori.get(i), giocatori.get(i + 1));
            partita.simulaRisultato();
            partite.add(partita);
        }

        System.out.println("partite simulate con successo!");
    }

    public void mostraClassifica() {
        giocatori.sort(Comparator.comparingInt(Giocatore::getPunteggio).reversed()
                .thenComparingInt(Giocatore::getRankingIniziale).reversed());

        System.out.println("classifica del torneo:");
        for (int i = 0; i < giocatori.size(); i++) {
            System.out.println((i + 1) + ". " + giocatori.get(i));
        }
    }

    public void mostraPartite() {
        System.out.println("risultati delle partite:");
        for (Partita partita : partite) {
            System.out.println(partita);
        }
    }
}