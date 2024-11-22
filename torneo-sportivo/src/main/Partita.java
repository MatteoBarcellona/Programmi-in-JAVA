import java.util.Random;

public class Partita {
    private Squadra squadra1;
    private Squadra squadra2;
    private int golSquadra1;
    private int golSquadra2;

    public Partita(Squadra squadra1, Squadra squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
    }

    public void simulaPartita() {
        Random random = new Random();
        golSquadra1 = random.nextInt(5); // Genera un numero casuale di gol (0-4)
        golSquadra2 = random.nextInt(5);
        squadra1.aggiornaStatistiche(golSquadra1, golSquadra2);
        squadra2.aggiornaStatistiche(golSquadra2, golSquadra1);
    }

    @Override
    public String toString() {
        return  "nome squadra"+squadra1.getNome()+"gol squadra"+ golSquadra1+"gol squadra1"+ golSquadra2+"gol squadra2"+ squadra2.getNome()+"nome squadra";
    }
}
