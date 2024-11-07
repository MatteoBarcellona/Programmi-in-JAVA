
package test;

public class cilindro extends cerchio  {
    //faccio extends per la classe.
    private double altezza;
//faccio il metodo con super.
    public cilindro(double altezza) {
        super(altezza);
    }
    
    public double getAltezza(){
        return altezza;
    }
   
   public double Volume(){
     return super.Area()*altezza;
   }
    
    
}
