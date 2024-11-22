import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        System.out.println("Benvenuto al simulatore di Mazzo di Carte!");

        do {
            System.out.println("\n1-mescola il mazzo");
            System.out.println("2-pesca una carta");
            System.out.println("3-visualizza le carte rimanenti");
            System.out.println("4-visualizza le carte pescate");
            System.out.println("5-esci");
            System.out.print("scegli un'opzione: ");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    mazzo.mescola();
                    break;
                case 2:
                    Carta pescata = mazzo.pesca();
                    if (pescata != null) {
                        System.out.println("hai pescato: " + pescata);
                    }
                    break;
                case 3:
                    mazzo.visualizzaCarte();
                    break;
                case 4:
                    mazzo.visualizzaCartePescate();
                    break;
                case 5:
                    System.out.println("grazie per aver usato il simulatore!");
                    break;
                default:
                    System.out.println("opzione non valida. Riprova.");
            }
        } while (scelta != 5);

        scanner.close();
    }
}
