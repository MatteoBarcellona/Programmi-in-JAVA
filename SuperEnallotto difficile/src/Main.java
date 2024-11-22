import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SuperEnalotto superEnalotto = new SuperEnalotto();

        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("---benvenuto al Simulatore del SuperEnalotto!--");
            System.out.println("---1-aggiungi una giocata                    --");
            System.out.println("---2-visualizza tutte le giocate             --");
            System.out.println("---3-esegui un'estrazione                    --");
            System.out.println("---4-Vvisualizza statistiche                 --");
            System.out.println("---5-esci                                    --");
            System.out.println("---scegli un'opzione:                        --");
            System.out.println("-----------------------------------------------");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.print("inserisci un identificativo per la giocata: ");
                    String id = scanner.next();
                    Set<Integer> numeri = new HashSet<>();
                    System.out.println("inserisci 6 numeri distinti tra 1 e 90:");
                    while (numeri.size() < 6) {
                        int numero = scanner.nextInt();
                        if (numero < 1 || numero > 90 || numeri.contains(numero)) {
                            System.out.println("numero non valido o già inserito. Riprova.");
                        } else {
                            numeri.add(numero);
                        }
                    }
                    System.out.print("inserisci un numero SuperStar (facoltativo): ");
                    int superStar = scanner.nextInt();
                    superEnalotto.aggiungiGiocata(id, new Giocata(id, numeri, superStar));
                    System.out.println("giocata aggiunta con successo!");
                }

                case 2 -> superEnalotto.visualizzaStatistiche();

                case 3 -> superEnalotto.eseguiEstrazione();

                case 4 -> superEnalotto.visualizzaStatistiche();

                case 5 -> {
                    System.out.println("grazie per aver giocato!");
                    return;
                }

                default -> System.out.println("opzione non valida. Riprova.");
            }
        }
    }
}
