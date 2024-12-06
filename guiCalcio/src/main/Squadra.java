import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private String nome;
    private String logo;
    private int vittorie;
    private int sconfitte;
    private int golFatti;
    private int golSubiti;
    private int punti;
    private int numgiocatori;
    private List<Giocatore> giocatori;
    // Costruttore
    public Squadra(String nome,String logo, int numgiocatori) {
        this.nome = nome;
        this.logo = logo;
        this.vittorie = 0;
        this.sconfitte = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
        this.punti = 0;
        this.numgiocatori = numgiocatori;
        this.giocatori = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    public int getSconfitte() {
        return sconfitte;
    }



    public void setSconfitte(int sconfitte) {
        this.sconfitte = sconfitte;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti = golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti = golSubiti;
    }

    // Metodo per calcolare i punti
    public int getPunti() {
        return (vittorie * 3); // 3 punti per vittoria
    }

    // Metodo per calcolare la differenza reti
    public int getDifferenzaReti() {
        return golFatti - golSubiti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    // Metodo per restituire una rappresentazione stringa della squadra
    @Override
    public String toString() {
        return nome + " (Vittorie: " + vittorie + ", Sconfitte: " + sconfitte + ", Gol Fatti: " + golFatti + ", Gol Subiti: " + golSubiti + ")";
    }


    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public int setGiocatori(int giocatori) {
        return giocatori;
    }


    public String visualizzaInfo() {
        StringBuilder info = new StringBuilder("Squadra: " + nome + "\nLogo: " + logo + "\nGiocatori:\n");
        for (Giocatore g : giocatori) {
            info.append("- " + g.getNome() + "\n");
        }
        return info.toString();
    }



    public void aggiungiGiocatore(Giocatore giocatore) {
        giocatori.add(giocatore);
    }

    public void rimuoviGiocatore(String giocatore) {
        giocatori.remove(giocatore);
    }
}
