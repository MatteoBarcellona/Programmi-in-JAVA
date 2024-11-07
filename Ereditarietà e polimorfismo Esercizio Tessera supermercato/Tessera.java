
package progsupermercto;


public class Tessera {
    
    private String cliente;
    private int codice;
    private int punti;
    //faccio il metodo costruttore.
public Tessera(String cliente,int codice){
    
this.cliente=cliente;
this.codice=codice;
this.punti=10;

}

//faccio i metodi
public String getCliente(){
return cliente;
}

public int getCodice(){
return codice;
}

public double getPunti(){
return punti;
}

//faccio aquisto
public void Aquisto(int spesa){
    if(spesa>100){
       this.punti=spesa/10+(spesa/100)*10;
    }else{
        this.punti=spesa/10;
    }
}

//ritirapremio
public void ritiraPremio(int punti){
    if(this.punti>punti){
        this.punti=punti-punti;
    }else{
        System.out.println("i punti non sono sufficiemnti");
    }
}

public void vDati(){
    System.out.println("la sua tessera e "+this.cliente+" e il suo codice "+this.codice+" ha "+this.punti+"punti");
}

}