
package progtest;


//il negozio gestisce 
public class prodotto {
    
    String codice;
    String nome;
    double prezzo;
    
    //metodo costruttore.
    public prodotto(String codice,String nome,double prezzo){
        this.codice=codice;
        this.nome=nome;
        this.prezzo=prezzo;
    }
    
    //metodi get
    public String getCodice(){
        return codice;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getPrezzo(){
        return prezzo;
    }
     
    //metodi set
    public void setCoodice(String codice){
        this.codice=codice;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setPrezzo(double prezzo){
        this.prezzo=prezzo;
    }
   
    
    public double AplicaSconto(){
        return prezzo-(prezzo*5)/100;
    }
            
    
    @Override
    public String toString(){
    return nome+codice+prezzo;
    }
}
