import java.util.*;

public class Torneo {

    private List<Squadra> squadre;
    private List<Partita> partite;

    public Torneo() {
        this.squadre = new ArrayList<>();
        this.partite = new ArrayList<>();
    }

    public void registraSquadra(String nome) throws IllegalArgumentException {
        for (Squadra s : squadre) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                throw new IllegalArgumentException("la squadra con questo nome esiste già!");
            }
        }
        squadre.add(new Squadra(nome));
    }

    public void generaCalendario() throws IllegalStateException {
        if (squadre.size() < 2) {
            throw new IllegalStateException("il torneo deve avere almeno due squadre!");
        }

        for (int i = 0; i < squadre.size(); i++) {
            for (int j = i + 1; j < squadre.size(); j++) {
                partite.add(new Partita(squadre.get(i), squadre.get(j)));
            }
        }
    }

    public void simulaTorneo() {
        for (Partita partita : partite) {
            partita.simulaPartita();
            System.out.println(partita);
        }
    }

    public void mostraClassifica() {
        squadre.sort(Comparator.comparingInt(Squadra::getPunteggio).reversed());
        System.out.println("classifica:");
        for (Squadra squadra : squadre) {
            System.out.println(squadra);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();

        System.out.println("inserisci i nomi delle squadre (digita 'fine' per terminare):");
        while (true) {
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fine")) break;
            try {
                torneo.registraSquadra(nome);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            torneo.generaCalendario();
            torneo.simulaTorneo();
            torneo.mostraClassifica();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
