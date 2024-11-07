package java_esercizio_stringhe;

import java.util.Scanner;

public class Java_esercizio_stringhe {

   public static void main(String args[])
   {

      Scanner in = new Scanner(System.in); //istanzia un oggetto lettore di tipo Scanner
   
      int RIGHE=3;
      String elenco[] = new String[RIGHE];
      int conta1[] = new int[RIGHE];
      int conta2[] = new int[RIGHE];
      String app;
      int i,k,cont;
      char c2;

      System.out.println("\nInserimento righe");
      for(i=0;i<RIGHE;i++) {
         System.out.print("Inserisci la riga n."+i+" : ");
         elenco[i] = in.nextLine();
      }

      System.out.println("\nRighe inserite");
      for(i=0;i<RIGHE;i++) {
         System.out.println(i+" - "+elenco[i]);
      }   

      for(i=0;i<RIGHE-1;i++) {
        for(k=i+1;k<RIGHE;k++) {
           if(elenco[i].length()>elenco[k].length())
           {
              app=elenco[i];
              elenco[i]=elenco[k];
              elenco[k]=app;
           }
        }
      }  

      System.out.println("\nRighe riordinate per lunghezza");
      for(i=0;i<RIGHE;i++) {
         System.out.println(i+" - "+elenco[i]);
      }   

      System.out.println("\nConta vocali");
      for(i=0;i<RIGHE;i++) {
         cont=0;
         for(k=0;k<elenco[i].length();k++)
            if(elenco[i].charAt(k)=='a' ||
               elenco[i].charAt(k)=='e' ||
               elenco[i].charAt(k)=='i' ||
               elenco[i].charAt(k)=='o' ||
               elenco[i].charAt(k)=='u') {
                  cont++;
            }      
         conta1[i]=cont;
      }
      for(i=0;i<RIGHE;i++) {
         System.out.println(i+" - "+conta1[i]+" - "+elenco[i]);
      }      

 
      System.out.println("\nConta doppie");
      for(i=0;i<RIGHE;i++) {
         cont=0;
         c2=elenco[i].charAt(0);
         for(k=1;k<elenco[i].length();k++)
         {
            if(elenco[i].charAt(k)==c2) {
               cont++;
            }   
            c2=elenco[i].charAt(k);
         }
         conta2[i]=cont;
      }
      for(i=0;i<RIGHE;i++) {
         System.out.println(i+" - "+conta2[i]+" - "+elenco[i]);
      }   

   }
  
}
