
package progcircoferenza;


public class cerchio {
    //dichiaro le mie variabili
    private double raggio;
    private String colore;
    
    public cerchio(double raggio,String colore){
        
        this.raggio=raggio;
        this.colore=colore;
    }
    
    
    public double getRaggio(){
        return raggio;
    }
    
    public String getColore(){
        return colore;
    }
    
   public double Area(){
       return (raggio*raggio)*Math.PI;
   }
    
}
