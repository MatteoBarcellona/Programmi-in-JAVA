

package progtest;


public class Alimentari extends prodotto {
   
    public Alimentari(String codice, String nome, double prezzo) {
        super(codice, nome, prezzo);
    }
   
@Override
public String toString(){
return nome+codice+prezzo;
}

  public double ApplicaSconto(){
  return prezzo-(prezzo*20)/100;
  }
  
}
