import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("gestione Torneo di Scacchi");
        while (true) {

            System.out.println("---------------------------");
            System.out.println("---1-registra giocatore");
            System.out.println("---2-avvia torneo");
            System.out.println("---3-mostra Partite");
            System.out.println("---4-mostra classifica");
            System.out.println("---5-esci");
            System.out.println("---scegli fra queste opzioni");
            System.out.println("----------------------------");


            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline

            switch (scelta) {
                case 1 -> {
                    System.out.print("nome giocatore: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID giocatore: ");
                    String id = scanner.nextLine();
                    System.out.print("ranking iniziale: ");
                    int ranking = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        torneo.registraGiocatore(new Giocatore(nome, id, ranking));
                        System.out.println("giocatore registrato con successo!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> torneo.avviaTorneo();
                case 3 -> torneo.mostraPartite();
                case 4 -> torneo.mostraClassifica();

                case 5 -> {
                    System.out.println("uscita");
                    return;
                }
                default -> System.out.println("scelta non valida.");
            }
        }
    }
}
