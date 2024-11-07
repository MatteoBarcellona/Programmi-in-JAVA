package prog4binfo;

public class studente {
    //parte di codice per gli attributi
    private String cognome;
    private String nome;
    private int nAssenze;
    
    //mestodo costruttore
    studente(String cognome,String nome){
        this.cognome=cognome;
        this.nome=nome;
        this.nAssenze=0;
    }
    //altrim metodi
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public int getNAssenze(){
        return nAssenze;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void aggiungiAssenza(){
        this.nAssenze++;
    }
    public void rimuoviAssenza(){
        if(this.nAssenze>0)
            this.nAssenze--;
        else{
            System.out.println("non puoi eliminare l'assenza");
        }
    }
}

