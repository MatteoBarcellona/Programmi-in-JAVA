/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tessera;

import java.io.InputStream;

/**
 *
 * @author matteo.barcellona
 */
public class teserrac {
private double puntibase;
private double codice;
private String cliente;
private double aquisto;

public teserrac(double puntibase,String cliente,double codice,double aquisto){
this.puntibase=puntibase;
this.cliente=cliente; 
this.codice=codice;
this.aquisto=aquisto;
}

    teserrac(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodi set
public double getPuntibase(){
return puntibase;    
}

public double getCodice(){
return codice;    
}

public String getCliente(){
return cliente;    
}

//metodi set
public void setPuntibase(double puntibase){
this.puntibase=puntibase; 
}

public void setcodice(double codice){
this.codice=codice;
}

public void setcliente(String cliente){
this.cliente=cliente; 
}

public double Aquisto(double aquisto){
if(aquisto==10){
puntibase++;  
}    
return aquisto;    
}

public void ritirapremio(){
puntibase++;
}

    void getCodice(double num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
