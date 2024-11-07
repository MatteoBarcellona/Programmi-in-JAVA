
package vdata;
//faccio 3 librerire
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VData {

  
     public static String vedi_data(GregorianCalendar est){
	String data="-";
	int gg,mm,aaaa;
	if(est!=null){
	   gg=est.get(Calendar.DAY_OF_MONTH);
	   mm=est.get(Calendar.MONTH)+1;
	   aaaa=est.get(Calendar.YEAR);
	   data=String.valueOf(gg)+"-"+String.valueOf(mm)+"-"+String.valueOf(aaaa);
	}
	return(data);
   }

    public static void main(String[] args) {
        int i=0;
        
        //faccio il vettore delle 2 persone
      persone[] p = new persone[2];
      
      p[0] = new  persone("Mario",new GregorianCalendar(1966,(2-1),10));
      p[1] = new  persone("Luigi",new GregorianCalendar(1968,(1-1),7));
      
      System.out.println();
      
      for(i=0;i<2;i++){
         System.out.println(p[i].tdata()+" "+p[i].tdata());
      } 
      
      GregorianCalendar nuovo = new GregorianCalendar();   
      System.out.println();
      System.out.println("Oggi   : "+vedi_data(nuovo));
      nuovo.add(Calendar.DAY_OF_MONTH,-1);
      System.out.println("Ieri   : "+vedi_data(nuovo));
      nuovo.add(Calendar.DAY_OF_MONTH,+2);
      System.out.println("Domani : "+vedi_data(nuovo));
            

      GregorianCalendar oggi = new GregorianCalendar();   
      System.out.println();
      for(i=0;i<2;i++)
      {
         System.out.println(p[i].tdata()+" ha "+p[i].anni(oggi)+" anni");
      } 

    }
}
