import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class SistemaPrenotazioni {
    private final Map<String, Evento> eventi;
    private final Map<String, Cliente> clienti;

    public SistemaPrenotazioni() {
        this.eventi = new HashMap<>();
        this.clienti = new HashMap<>();
    }

    public void aggiungiEvento(String nome, Date data, int postiMax) {
        if (eventi.containsKey(nome)) {
            System.out.println("evento con questo nome già esistente.");
        }
        eventi.put(nome, new Evento(nome, data, postiMax));
    }

    public void aggiungiCliente(String id, String nome) {
        if (clienti.containsKey(id)) {
            System.out.println("cliente con questo ID già esistente.");
        }
        clienti.put(id, new Cliente(id, nome));
    }

    public void prenotaBiglietti(String clienteId, String eventoNome, int numeroBiglietti) {
        Cliente cliente = clienti.get(clienteId);
        Evento evento = eventi.get(eventoNome);

        if (cliente == null) {
            System.out.println("cliente non trovato.");
        }
        if (evento == null) {
            throw new IllegalArgumentException("evento non trovato.");
        }

        Prenotazione prenotazione = new Prenotazione(cliente, numeroBiglietti, evento);
        evento.aggiungiPrenotazione(prenotazione);
    }

    public void annullaPrenotazione(String clienteId, String eventoNome) {
        Cliente cliente = clienti.get(clienteId);
        Evento evento = eventi.get(eventoNome);

        if (cliente == null) {
            System.out.println("cliente non trovato.");
        }
        if (evento == null) {
            throw new IllegalArgumentException("evento non trovato.");
        }

        Prenotazione daAnnullare = null;
        for (Prenotazione prenotazione : evento.getPrenotazioni()) {
            if (prenotazione.getCliente().equals(cliente)) {
                daAnnullare = prenotazione;
                break;
            }
        }

        if (daAnnullare == null) {
            throw new IllegalArgumentException("prenotazione non trovata.");
        }

        evento.annullaPrenotazione(daAnnullare);
    }

    public void mostraPrenotazioni(String eventoNome) {
        Evento evento = eventi.get(eventoNome);

        if (evento == null) {
            throw new IllegalArgumentException("evento non trovato.");
        }

        System.out.println("prenotazioni per l'evento " + eventoNome + ":");
        for (Prenotazione prenotazione : evento.getPrenotazioni()) {
            System.out.println(prenotazione);
        }
    }
}