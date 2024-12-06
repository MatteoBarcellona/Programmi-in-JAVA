public class Partita {
    private Squadra squadraCasa;      // Squadra che gioca in casa
    private Squadra squadraTrasferta; // Squadra che gioca in trasferta
    private int golCasa;              // Gol segnati dalla squadra di casa
    private int golTrasferta;         // Gol segnati dalla squadra trasferta

    // Costruttore: Inizializza una partita con le due squadre
    public Partita(Squadra squadraCasa, Squadra squadraTrasferta) {
        this.squadraCasa = squadraCasa;
        this.squadraTrasferta = squadraTrasferta;
        this.golCasa = 0;
        this.golTrasferta = 0;
    }



    // Restituisce la squadra di casa
    public Squadra getSquadraCasa() {
        return squadraCasa;
    }

    // Restituisce la squadra trasferta
    public Squadra getSquadraTrasferta() {
        return squadraTrasferta;
    }

    // Restituisce il numero di gol segnati dalla squadra di casa
    public int getGolCasa() {
        return golCasa;
    }

    // Imposta il numero di gol segnati dalla squadra di casa
    public void setGolCasa(int golCasa) {
        if (golCasa >= 0) {
            this.golCasa = golCasa;
        } else {
            System.out.println("I gol non possono essere negativi.");
        }
    }

    // Restituisce il numero di gol segnati dalla squadra trasferta
    public int getGolTrasferta() {
        return golTrasferta;
    }

    // Imposta il numero di gol segnati dalla squadra trasferta
    public void setGolTrasferta(int golTrasferta) {
        if (golTrasferta >= 0) {
            this.golTrasferta = golTrasferta;
        } else {
            System.out.println("I gol non possono essere negativi.");
        }
    }

    // Restituisce il risultato della partita in formato leggibile
    @Override
    public String toString() {
        return String.format("%s %d - %d %s",
                squadraCasa.getNome(),
                golCasa,
                golTrasferta,
                squadraTrasferta.getNome());
    }

    public Squadra getSquadraOspite() {
        return squadraCasa;
    }



    public Object getGolOspite() {
        return squadraTrasferta;
    }
}
