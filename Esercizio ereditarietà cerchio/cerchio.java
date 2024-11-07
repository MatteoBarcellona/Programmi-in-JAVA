
package test;

public class cerchio {
    
    private double raggio;
    
    //metodo costruttore
    public cerchio(double raggio){
    this.raggio=raggio;
    }
    
    //metodi get e set
    public double getRaggio(){
        return raggio;
    }
    
    public double setRaggio(){
        return raggio;
    }
    //faccio Area
    public double Area(){
        return Math.PI*(raggio*raggio);
    }
    //faccio Circoferenza
    public double Circonferenza(){
      return Math.PI*raggio*2;
    }
    
    
}

