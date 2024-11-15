import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalaCinema salaCinema = new SalaCinema(5, 10);

        while (true) {
            System.out.println("\nBenvenuto al sistema di prenotazione del cinema!");
            System.out.println("1-Prenota un posto");
            System.out.println("2-Annulla una prenotazione");
            System.out.println("3-Visualizza lo stato della sala");
            System.out.println("4-Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci il numero della fila: ");
                    int fila = scanner.nextInt();
                    System.out.print("Inserisci il numero del posto: ");
                    int numero = scanner.nextInt();
                    salaCinema.prenotaPosto(fila, numero);
                }
                case 2 -> {
                    System.out.print("Inserisci il numero della fila: ");
                    int fila = scanner.nextInt();
                    System.out.print("Inserisci il numero del posto: ");
                    int numero = scanner.nextInt();
                    salaCinema.annullaPrenotazionePosto(fila, numero);
                }
                case 3 -> salaCinema.visualizzaSala();

                case 4 -> {
                    System.out.println("Grazie per aver usato il sistema di prenotazione del Cinema!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }
    }
}
