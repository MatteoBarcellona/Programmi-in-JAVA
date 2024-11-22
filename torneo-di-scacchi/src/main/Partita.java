public class Partita {
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private String risultato;

    public Partita(Giocatore giocatore1, Giocatore giocatore2) {
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.risultato = null;
    }

    public void simulaRisultato() {
        int esito = (int) (Math.random() * 3);
        switch (esito) {
            case 0 -> {
                risultato = "VITTORIA1";
                giocatore1.aggiungiPunti(3);
            }
            case 1 -> {
                risultato = "VITTORIA2";
                giocatore2.aggiungiPunti(3);
            }
            case 2 -> {
                risultato = "PAREGGIO";
                giocatore1.aggiungiPunti(1);
                giocatore2.aggiungiPunti(1);
            }
        }
    }

    @Override
    public String toString() {
        String descrizioneRisultato = switch (risultato) {
            case "VITTORIA1" -> giocatore1.getNome() + " ha vinto";
            case "VITTORIA2" -> giocatore2.getNome() + " ha vinto";
            case "PAREGGIO" -> "Pareggio";
            default -> "Partita non ancora giocata";
        };
        return giocatore1.getNome() + " vs " + giocatore2.getNome() + ": " + descrizioneRisultato;
    }
}
