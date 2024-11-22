import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mercato mercato = new Mercato();
        Scanner scanner = new Scanner(System.in);

        try {
            mercato.aggiungiAzione("M", "m", 550);
            mercato.aggiungiAzione("G", "g", 2800);
            mercato.registraInvestitore("Mario", 19000);
            mercato.registraInvestitore("Matteo", 12000);

            boolean continua = true;

            while (continua) {
                System.out.println("---------------------------");
                System.out.println("--1-Mostra azioni");
                System.out.println("--2-Mostra investitori");
                System.out.println("--3-Acquista azioni");
                System.out.println("--4-Vendi azioni");
                System.out.println("--5-Aggiorna prezzi");
                System.out.println("--6-Esci");
                System.out.println("--scegli fra queste opzioni");
                System.out.println("-----------------------------");


                int scelta = scanner.nextInt();

                switch (scelta) {
                    case 1 -> mercato.mostraAzioni();
                    case 2 -> mercato.mostraInvestitori();
                    case 3 -> {

                        System.out.print("nome investitore: ");
                        String nome = scanner.next();
                        System.out.print("ticker: ");
                        String ticker = scanner.next();
                        System.out.print("quantità: ");
                        int quantita = scanner.nextInt();
                        try {
                            mercato.acquistaAzione(nome, ticker, quantita);
                        } catch (Exception e) {
                            System.out.println("errore: " + e.getMessage());
                        }
                    }
                    case 4 -> {

                        System.out.print("nome investitore: ");
                        String nome = scanner.next();
                        System.out.print("ticker: ");
                        String ticker = scanner.next();
                        System.out.print("quantità: ");
                        int quantita = scanner.nextInt();
                        try {
                            mercato.vendiAzione(nome, ticker, quantita);
                        } catch (Exception e) {
                            System.out.println("errore: " + e.getMessage());
                        }
                    }

                    case 5 -> mercato.aggiornaPrezzi();
                    case 6 -> continua = false;
                    default -> System.out.println("scelta non valida.");
                }
            }

        } catch (Exception e) {
            System.out.println("errore: " + e.getMessage());
        }

        scanner.close();
    }
}
