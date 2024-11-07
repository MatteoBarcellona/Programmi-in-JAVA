
package progvettore;

public class Dipendente {
    //variabili per sapere un informazione del dipendente.
    private String nome;
    private String cognome;
    private String dipartimento;
    private int numl;
    private int stipendio=1300;
    
    //metodo costruttore.
    public Dipendente(String nome,String cognome,String dipartimento,int numl){
        //che consente di istanziare i miei altributi
        this.nome=nome;
        this.cognome=cognome;
        this.dipartimento=dipartimento;
        this.numl=numl;
    }
    
    //metodi get dei altributi
    
    public String getNome(){
        return nome;
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public String getDipartimento(){
        return dipartimento;
    }
    
    public int getNumeroliv(){
        return numl;
    }
    
    public int Aumento(){
        return stipendio+(stipendio*2);
    }
    //metodo a piacere
    public void  Linceciamento(){
       String ricerca=dipartimento;
    }
    
}
