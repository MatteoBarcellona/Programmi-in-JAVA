import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> combinazioneVincente = generaCombinazione();
        int jollyVincente = combinazioneVincente.remove(6);

        List<List<Integer>> giocateUtente = new ArrayList<>();
        boolean uscita = false;

        System.out.println("benvenuto al simulatore del SuperEnalotto!");

        while (!uscita) {
            System.out.println("0-menu:");
            System.out.println("1-inserisci la tua giocata");
            System.out.println("2-genera una giocata casuale");
            System.out.println("3-visualizza i risultati");
            System.out.println("4-esci");
            System.out.print("scegli un'opzione: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    List<Integer> giocata = inserisciGiocata(scanner);
                    if (giocata != null) {
                        giocateUtente.add(giocata);
                        System.out.println("giocata registrata!");
                    }
                    break;

                case 2:
                    List<Integer> giocataCasuale = generaCombinazione();
                    giocataCasuale.remove(6);
                    giocateUtente.add(giocataCasuale);
                    System.out.println("giocata casuale generata: " + giocataCasuale);
                    break;

                case 3:
                    System.out.println("\ncombinazione vincente: " + combinazioneVincente + " (Jolly: " + jollyVincente + ")");
                    for (int i = 0; i < giocateUtente.size(); i++) {
                        List<Integer> g = giocateUtente.get(i);
                        int[] risultati = confronta(g, combinazioneVincente, jollyVincente);
                        System.out.println("giocata #" + (i + 1) + ": " + g);
                        System.out.println("numeri indovinati: " + risultati[0] + ", Hai indovinato il Jolly? " + (risultati[1] == 1 ? "Sì" : "No"));
                    }
                    break;

                case 4:
                    uscita = true;
                    System.out.println("grazie per aver giocato!");
                    break;

                default:
                    System.out.println("opzione non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
    }

    public static List<Integer> generaCombinazione() {
        Random random = new Random();
        Set<Integer> numeri = new HashSet<>();

        while (numeri.size() < 6) {
            numeri.add(random.nextInt(90) + 1);
        }

        List<Integer> combinazione = new ArrayList<>(numeri);
        Collections.sort(combinazione);
        combinazione.add(random.nextInt(90) + 1);
        return combinazione;
    }

    public static List<Integer> inserisciGiocata(Scanner scanner) {
        System.out.println("inserisci 6 numeri distinti tra 1 e 90 (separati da spazi): ");
        scanner.nextLine(); // Pulisce il buffer
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        Set<Integer> giocata = new HashSet<>();

        try {
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num < 1 || num > 90) {
                    System.out.println("numero non valido: " + num + ". I numeri devono essere tra 1 e 90.");
                    return null;
                }
                giocata.add(num);
            }

            if (giocata.size() != 6) {
                System.out.println("devi inserire esattamente 6 numeri distinti.");
                return null;
            }

        } catch (NumberFormatException e) {
            System.out.println("errore di input. Assicurati di inserire solo numeri.");
            return null;
        }

        return new ArrayList<>(giocata);
    }

    public static int[] confronta(List<Integer> giocata, List<Integer> vincente, int jolly) {
        int numeriIndovinati = 0;
        int jollyIndovinato = giocata.contains(jolly) ? 1 : 0;

        for (int numero : giocata) {
            if (vincente.contains(numero)) {
                numeriIndovinati++;
            }
        }

        return new int[]{numeriIndovinati, jollyIndovinato};
    }
}