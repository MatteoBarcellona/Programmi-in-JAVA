import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();
        System.out.println("benvenuto al Gestore del Torneo Sportivo!");
        System.out.println("inserisci i nomi delle squadre (digita 'fine' per terminare):");

        while (true) {
            System.out.print("nome squadra: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fine")) {
                break;
            }
            try {
                torneo.registraSquadra(nome);
                System.out.println("squadra registrata: " + nome);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            torneo.generaCalendario();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("chiusura programma. Aggiungi almeno due squadre per creare un torneo.");
            scanner.close();
            return;
        }

        System.out.println("calendario generato! Inizio simulazione delle partite...");
        torneo.simulaTorneo();

        System.out.println("classifica finale:");
        torneo.mostraClassifica();

        scanner.close();
    }
}
