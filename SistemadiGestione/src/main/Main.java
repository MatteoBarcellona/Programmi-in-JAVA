import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderDAO orderDAO = new InMemoryOrderDAO();
        OrderService orderService = new OrderService(orderDAO);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("                       ");
            System.out.println("--- Gestione Ordini ---");
            System.out.println("-1-aggiungi un nuovo ordine");
            System.out.println("-2-trova un ordine per ID");
            System.out.println("-3-visualizza tutti gli ordini");
            System.out.println("-4-elimina un ordine per ID");
            System.out.println("-5-calcola il totale degli ordini");
            System.out.println("-6-esci");
            System.out.println("---Seleziona un'opzione: ");
            System.out.println("                        ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.print("-inserisci ID ordine: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("-inserisci nome cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("-inserisci i prodotti separati da virgola: ");
                    String prodottiInput = scanner.nextLine();
                    List<String> prodotti = List.of(prodottiInput.split(","));
                    System.out.print("-inserisci il prezzo totale: ");
                    double prezzoTotale = scanner.nextDouble();

                    Order ordine = new Order(id, nomeCliente, prodotti, prezzoTotale);
                    if (orderService.aggiungiOrdine(ordine)) {
                        System.out.println("ordine aggiunto con successo!");
                    } else {
                        System.out.println("errore nell'aggiunta dell'ordine.");
                    }
                }
                case 2 -> {
                    System.out.print("inserisci ID ordine: ");
                    int id = scanner.nextInt();
                    try {
                        Order ordine = orderService.trovaOrdine(id);
                        System.out.println("dettagli ordine: " + ordine);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    List<Order> ordini = orderService.tuttiGliOrdini();
                    System.out.println("ordini registrati: ");
                    ordini.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("inserisci ID ordine: ");
                    int id = scanner.nextInt();
                    if (orderService.eliminaOrdine(id)) {
                        System.out.println("ordine eliminato con successo!");
                    } else {
                        System.out.println("errore nell'eliminazione dell'ordine.");
                    }
                }
                case 5 -> {
                    double totale = orderService.calcolaTotaleOrdini();
                    System.out.println("totale degli ordini: " + totale);
                }
                case 6 -> {
                    System.out.println("uscita...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("opzione non valida. Riprova.");
            }
        }
    }


}

