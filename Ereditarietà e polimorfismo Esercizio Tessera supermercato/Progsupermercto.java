package progsupermercto;

public class Progsupermercto {
    
    
    public static void main(String[] args) {
        System.out.println("i dati della spesa dei clienti sono:");
        //metto 6 oggetti
        Tessera t = new Tessera("mario",56);
        Tessera t2 = new Tessera("luigi",123);
        Tessera t3 = new Tessera("luca",523);        
        //tesseraoro
        TesseraOro t4 = new TesseraOro("andrea",52346);
        TesseraOro t5 = new TesseraOro("giussepe",5611);
        TesseraOro t6 = new TesseraOro("franco",96);        
                
              
  
        //faccio la visualizzazione dati.
        t.vDati();  
          t2.vDati();  
             t3.vDati();  
                t4.vDati2();  
                   t5.vDati2();  
                      t6.vDati2();  
                   
          
    }  
}