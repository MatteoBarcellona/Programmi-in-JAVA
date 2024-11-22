
public class Squadra {

    private String nome;
    private int partiteGiocate;
    private int vinte;
    private int perse;
    private int pareggiate;
    private int punteggio;


    public Squadra(String nome) {
        this.nome = nome;
        this.partiteGiocate = 0;
        this.vinte = 0;
        this.perse = 0;
        this.pareggiate = 0;
        this.punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void aggiornaStatistiche(int golFatti, int golSubiti) {
        this.partiteGiocate++;
        if (golFatti > golSubiti) {
            this.vinte++;
            this.punteggio += 3;
        } else if (golFatti < golSubiti) {
            this.perse++;
        } else {
            this.pareggiate++;
            this.punteggio++;
        }
    }

    @Override
    public String toString() {
        return "--nome squadra:"+nome+"--partite giocate:"+partiteGiocate+"--partite vinte:" +vinte+ "--partite paregiate."+pareggiate+
                "--partite perse:" +perse+ "--punteggio totale:"+ punteggio;
    }
}
