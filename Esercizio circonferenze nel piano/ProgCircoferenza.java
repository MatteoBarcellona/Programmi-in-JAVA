
package progcircoferenza;


public class ProgCircoferenza {

   
    public static void main(String[] args) {
        //dichiaro il mio array.
        cerchio c[]=new cerchio[10];
        //dichiaro le variabili
        double raggio=0,media;
        int i,contaverde=0,contpos=0;

        for(i=0;i<10;i++){
         //genrazione casuale. 
        raggio=(double) (Math.random()*18-9)+1;
              
        //10 array di cerchio.
        c[0]=new cerchio(raggio,"giallo");
        c[1]=new cerchio(raggio,"rosso");
        c[2]=new cerchio(raggio,"verde");
        c[3]=new cerchio(raggio,"giallo");
        c[4]=new cerchio(raggio,"rosso");
        c[5]=new cerchio(raggio,"verde");
        c[6]=new cerchio(raggio,"giallo");
        c[7]=new cerchio(raggio,"rosso");
        c[8]=new cerchio(raggio,"verde");
        c[9]=new cerchio(raggio,"verde");
      
        if(c[i].getColore()=="verde"){
            contaverde++;
        }               
          
        if(c[i].getRaggio()>0){
            contpos++;
        }
        
        media=c[i].Area()/c[i].getRaggio();
               
        System.out.println("il valore del raggio e " +c[i].getRaggio());
        System.out.println("il colore  e " +c[i].getColore());
        System.out.println("cerchi di colre verde sono "+contaverde);
        System.out.println("la media e  "+media);
        System.out.println("i cerchi con l'ascissa positiva sono  "+contpos);
        
        }    
    } 
}
