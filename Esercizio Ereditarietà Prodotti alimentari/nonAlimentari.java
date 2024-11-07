
package progtest;

public class nonAlimentari extends prodotto {

public nonAlimentari(String codice, String nome, double prezzo) {
super(codice, nome, prezzo);
}
    
@Override
public String toString(){
return nome+codice+prezzo;
}

 public double ApplicaSconto(){
 return prezzo-(prezzo*100)/10;
 }
}
