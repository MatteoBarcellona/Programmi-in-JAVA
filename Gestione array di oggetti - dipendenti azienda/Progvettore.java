
package progvettore;
import java.util.Scanner;

public class Progvettore {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //metto il vettore classe
        Dipendente d[] = new Dipendente[7];
        //dichiarazioni delle variabili
        int i,stipendiob=0,produzionec=0,mensilità=0,scelta=-1,dip=0,numl=10,contd=0;
        String nome,cognome,dipatimento;
         //faccio il menu per gestire gli dipendenti

           while(scelta!=0){
               
           System.out.print("dimmi una scelta");
           scelta=in.nextInt();
               
            switch(scelta){
    
                case 1:
                    //chiedo il dipedente
                    System.out.print("1-dimmi un dipendente");
                    dip=in.nextInt();
                    
                    //faccio ciclo for per sapere quanti dipendenti ho inserito.
                    for(i=0;i<dip;i++){
                        
                        //chiedo il nome e il cognome da inserire
                        System.out.println("dimmi il nome e cognome");
                       
                        
                        
                        
                        
                        nome=in.nextLine();

                        cognome=in.nextLine();
                         
                        //chiedo il nome del dipartimento in cui lavora
                        System.out.println("dimmi il dipartimento in cui lavora tra (produzione, commerciale, amministrazione)");
                        dipatimento=in.nextLine();
                        
                        //chiedo il livello da inserire
                        
                        while(numl>7){//verifica che livello ha superato 7 lo deve inserire da capo.
                        System.out.println("dimmi il livello");
                        numl=in.nextInt();
                        }
                        
                        d[i]=new Dipendente(nome,cognome,dipatimento,numl);
                    }
                    
                    break;
                    
                case 2:
                    
                    System.out.println("2-stampa quanti dipendenti hanno il livello più alto (livello 7)");
                    //metto il ciclo for per stampare gli livelli dei dipendeti
                    for(i=0;i<dip;i++){
                        System.out.println("livello dipendente: "+d[i].getNumeroliv());
                        //mette i valori dal dipartimento in cui lavora.
                        //produzione
                        if(d[i].getDipartimento()=="produzione"){
                            stipendiob=1300;
                        }
                        //commerciale
                        if(d[i].getDipartimento()=="commerciale"){
                            produzionec=1500;
                        }
                        //mensilità
                         if(d[i].getDipartimento()=="mensilità"){
                            mensilità=13;
                        }
                        //aumento lo stipendio del 10%
                        if(numl<2){
                            d[i].Aumento();
                        }
                    }
                   
                    break;
                    
                case 3:
                    System.out.println("3-stampa quanti dipendenti lavorano in produzione visualizzando nome e cognome");
                    
                    for(i=0;i<dip;i++){
                        System.out.println("nome dipendente: "+d[i].getNome());
                        System.out.println("cognome dipendente: "+d[i].getCognome());
                        contd++;
                    }
                    
                    System.out.println("i dipendenti sono in totlae :"+contd);
                    break;
                    
                case 4:
                    System.out.println("4-stampa licenziamento di un dipendente con metodo di ricerca a piacere");
                    //licenziamento.
                    for(i=0;i<dip;i++){
                    d[i].Linceciamento();
                    }
                    
                    break;   
               
                    
                    default:
                     System.out.println("uscita");
            
        }       
            //faccio confronto.      
      }
    }       
 }

