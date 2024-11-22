import java.time.LocalTime;
import java.util.*;

// Classe Stazione
class Stazione {
    String nome;
    List<Treno> treniInArrivo = new ArrayList<>();
    List<Treno> treniInPartenza = new ArrayList<>();

    public Stazione(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Treno> getTreniInArrivo() {
        return treniInArrivo;
    }

    public List<Treno> getTreniInPartenza() {
        return treniInPartenza;
    }

    public void aggiungiTrenoInArrivo(Treno treno) {
        treniInArrivo.add(treno);
    }

    public void aggiungiTrenoInPartenza(Treno treno) {
        treniInPartenza.add(treno);
    }

    public void rimuoviTrenoInArrivo(Treno treno) {
        treniInArrivo.remove(treno);
    }

    public void rimuoviTrenoInPartenza(Treno treno) {
        treniInPartenza.remove(treno);
    }
}

// Classe Treno
class Treno {
    String id;
    Stazione partenza;
    Stazione destinazione;
    LocalTime orarioPartenza;

    public Treno(String id, Stazione partenza, Stazione destinazione, LocalTime orarioPartenza) {
        this.id = id;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.orarioPartenza = orarioPartenza;
    }

    public String getId() {
        return id;
    }

    public Stazione getPartenza() {
        return partenza;
    }

    public Stazione getDestinazione() {
        return destinazione;
    }

    public LocalTime getOrarioPartenza() {
        return orarioPartenza;
    }
}

// Classe Passeggero
class Passeggero {
    String nome;
    List<Biglietto> biglietti = new ArrayList<>();

    public Passeggero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void aggiungiBiglietto(Biglietto biglietto) {
        biglietti.add(biglietto);
    }
}

// Classe Biglietto
class Biglietto {
    String id;
    Treno treno;
    Passeggero passeggero;

    public Biglietto(String id, Treno treno, Passeggero passeggero) {
        this.id = id;
        this.treno = treno;
        this.passeggero = passeggero;
    }
}

// Sistema Ferroviario
class SistemaFerroviario {
    Map<String, Stazione> stazioni = new HashMap<>();
    Map<String, Treno> treni = new HashMap<>();
    Map<String, Passeggero> passeggeri = new HashMap<>();

    public void aggiungiStazione(String nome) {
        stazioni.put(nome, new Stazione(nome));
    }

    public void aggiungiTreno(String id, String partenza, String destinazione, LocalTime orario) {
        Stazione stazionePartenza = stazioni.get(partenza);
        Stazione stazioneDestinazione = stazioni.get(destinazione);
        Treno treno = new Treno(id, stazionePartenza, stazioneDestinazione, orario);
        treni.put(id, treno);
        stazionePartenza.aggiungiTrenoInPartenza(treno);
        stazioneDestinazione.aggiungiTrenoInArrivo(treno);
    }

    public List<Treno> cercaTreni(String partenza, String destinazione) {
        List<Treno> risultato = new ArrayList<>();
        for (Treno treno : treni.values()) {
            if (treno.getPartenza().getNome().equals(partenza) && treno.getDestinazione().getNome().equals(destinazione)) {
                risultato.add(treno);
            }
        }
        return risultato;
    }

    public Biglietto prenotaBiglietto(String idTreno, String nomePasseggero) {
        Treno treno = treni.get(idTreno);
        Passeggero passeggero = passeggeri.computeIfAbsent(nomePasseggero, Passeggero::new);
        Biglietto biglietto = new Biglietto(treno.getId() + "-" + passeggero.getNome(), treno, passeggero);
        passeggero.aggiungiBiglietto(biglietto);
        return biglietto;
    }

    public List<Biglietto> visualizzaBiglietti(String nomePasseggero) {
        Passeggero passeggero = passeggeri.get(nomePasseggero);
        return passeggero.getBiglietti();
    }
}
