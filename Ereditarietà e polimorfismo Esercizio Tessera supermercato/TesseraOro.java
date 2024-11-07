
package progsupermercto;


class TesseraOro extends Tessera{
    
    private String cliente;
    private int codice;
    private double punti;
    

public TesseraOro(String cliente,int codice){    
super(cliente,codice);
punti=10;
}   

    public void Aquisto(float spesa){
        
    if(spesa>100){
    this.punti=(spesa/10+(spesa/100)*10)*2;
    }else{
    this.punti=spesa/10;
    }
    
    }
    public void vDati2(){
    System.out.println("la sua tessera "+this.cliente+" e il suo codice "+this.codice+" ha "+this.punti+"punti");
}
    
}
