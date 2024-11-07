
package progmanipolazionearraydinamici;
import java.util.ArrayList;
import java.util.Random;

public class ProgManipolazioneArrayDinamici {
    
    public static void main(String[] args) {
        ArrayList<Integer> vettoreUno= new ArrayList<Integer>(10);
        ArrayList<Integer> vettoreDue= new ArrayList<Integer>(20);
        Random random= new Random();
        int maxNumber= Integer.MIN_VALUE;
        String vectorName="";
      
        for(int i=0;i<10;i++){
          int number= random.nextInt(101)-50;
          vettoreUno.add(number);
          if(number>maxNumber){
            maxNumber=number;
            vectorName="primo";
          }
        }
        
        for(int i=0;i<20;i++){
          int number= random.nextInt(101)-50;
          vettoreDue.add(number);
          if(number>maxNumber){
            maxNumber=number;
            vectorName="secondo";
          }
        }
        
        System.out.println("Primo vettore: "+vettoreUno);
        System.out.println("Secondo vettore: "+vettoreDue);
        
        System.out.println("Numero Massimo: "+maxNumber+" (trovato nel "+vectorName+" vettore)");
        
        for(int number: vettoreDue){
          if(!vettoreUno.contains(number)){
            vettoreUno.add(number);
          }
        }
        System.out.println("Primo vettore: "+vettoreUno);
    }
    
}