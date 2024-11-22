import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SistemaPrenotazioni sistema = new SistemaPrenotazioni();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataConcerto = dateFormat.parse("15/12/2024");
            Date dataTeatro = dateFormat.parse("20/12/2024");

            System.out.println("creazione Eventi");
            sistema.aggiungiEvento("Concerto Rock", dataConcerto, 100);
            sistema.aggiungiEvento("Teatro Classico", dataTeatro, 50);
            System.out.println("eventi creati con successo!");

            System.out.println("registrazione Clienti ==");
            sistema.aggiungiCliente("C001", "Mario Rossi");
            sistema.aggiungiCliente("C002", "Giulia Bianchi");
            System.out.println("clienti registrati con successo!");

            System.out.println("prenotazioni");
            sistema.prenotaBiglietti("C001", "Concerto Rock", 2);
            System.out.println("prenotazione effettuata: Mario Rossi per 2 biglietti al Concerto Rock.");

            sistema.prenotaBiglietti("C002", "Concerto Rock", 4);
            System.out.println("prenotazione effettuata: Giulia Bianchi per 4 biglietti al Concerto Rock.");

            sistema.prenotaBiglietti("C001", "Teatro Classico", 1);
            System.out.println("prenotazione effettuata: Mario Rossi per 1 biglietto al Teatro Classico.");

            System.out.println("prenotazioni per Concerto Rock");
            sistema.mostraPrenotazioni("Concerto Rock");

            System.out.println("annullamento prenotazioni");
            sistema.annullaPrenotazione("C002", "Concerto Rock");
            System.out.println("prenotazione di Giulia Bianchi per il Concerto Rock annullata con successo.");

            System.out.println("prenotazioni aggiornate per Concerto Rock");
            sistema.mostraPrenotazioni("Concerto Rock");

            System.out.println("tentativo di prenotare troppi biglietti");
            sistema.prenotaBiglietti("C002", "Teatro Classico", 60);

        } catch (Exception e) {
            System.err.println("errore: " + e.getMessage());
        }
    }
}

