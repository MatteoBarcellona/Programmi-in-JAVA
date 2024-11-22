public class Giocatore {
    private String nome;
    private String id;
    private int rankingIniziale;
    private int punteggio;

    public Giocatore(String nome, String id, int rankingIniziale) {
        this.nome = nome;
        this.id = id;
        this.rankingIniziale = rankingIniziale;
        this.punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public int getRankingIniziale() {
        return rankingIniziale;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void aggiungiPunti(int punti) {
        this.punteggio += punti;
    }

    @Override
    public String toString() {
        return nome + " ID del giocatore: " + id + ", Ranking: " + rankingIniziale + ", il punteggio del giocatore: " + punteggio ;
    }
}
