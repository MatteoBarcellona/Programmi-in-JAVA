import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nella Calcolatrice!");

        while (true) {
            System.out.println("------------------------");
            System.out.println("-Scegli un'operazione:");
            System.out.println("1-Somma");
            System.out.println("2-Sottrazione");
            System.out.println("3-Moltiplicazione");
            System.out.println("4-Divisione");
            System.out.println("5-Esci");
            System.out.println("------------------------");

            int scelta = scanner.nextInt();

            if (scelta == 5) {
                System.out.println("uscita dal programma.");
                break;
            }

            System.out.println("inserisci il primo numero:");
            int num1 = scanner.nextInt();
            System.out.println("inserisci il secondo numero:");
            int num2 = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("risultato: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("risultato: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("risultato: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("risultato: " + ((double) num1 / num2));
                    } else {
                        System.out.println("errore: divisione per zero non consentita!");
                    }
                    break;
                default:
                    System.out.println("opzione non valida!");
                    break;
            }
        }
        scanner.close();
    }
}
