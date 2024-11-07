package progfigurageometrica_menu;
import java.util.Scanner;

public class ProgFiguraGeometrica_menu {

    public static void main(String[] args) throws Exception  {
        Scanner tastiera = new Scanner(System.in);
        int cosa = -1;
        double a=0,b=0,c=0;
        char t=' ';
        
        while(cosa!=0) {
           System.out.println("1 - Rettangolo");
           System.out.println("2 - Cerchio");
           System.out.println("3 - Triangolo (b/a)");
           System.out.println("4 - Triangolo (lati)");

           System.out.println("0 - Fine");

           System.out.println();
           System.out.print("Cosa scegli: ");
           cosa = tastiera.nextInt();
           
           switch(cosa) {
               case 1: {
                   System.out.println("Caso Rettangolo");
                   t='R';
                   System.out.print("Inserisci altezza: ");
                   a = tastiera.nextDouble();
                   System.out.print("Inserisci base: ");
                   b = tastiera.nextDouble();
                   c=0;
                   
                   FiguraGeometrica A1 = new FiguraGeometrica(t,a,b,c);
                   System.out.println(A1.Stato());  
                   System.out.println("Perimetro: "+A1.getPerCirc());       
                   System.out.println("Area: "+A1.getArea());       

                   break;
               }
               case 2: {
                   System.out.println("Caso Cerchio");
                   t='C';
                   System.out.print("Inserisci raggio: ");
                   c = tastiera.nextDouble();
                   a=0;
                   b=0;
                   
                   FiguraGeometrica C = new FiguraGeometrica(t,a,b,c);
                   System.out.println(C.Stato());  
                   System.out.println("Circonferenza: "+C.getPerCirc());       
                   System.out.println("Area: "+C.getArea());       
                   break;
               }
               case 3: {
                   System.out.println("Caso Triangolo (b/a)");
                   t='T';
                   System.out.print("Inserisci altezza: ");
                   a = tastiera.nextDouble();
                   System.out.print("Inserisci base: ");
                   b = tastiera.nextDouble();
                   c=0;
                   
                   FiguraGeometrica T = new FiguraGeometrica(t,a,b,c);
                   System.out.println(T.Stato());  
                   System.out.println("Perimetro: "+T.getPerCirc());       
                   System.out.println("Area: "+T.getArea());       
                   break;
               }
               case 4: {
                   System.out.println("Caso Triangolo (lati)");
                   t='K';
                   System.out.print("Inserisci lato 1: ");
                   a = tastiera.nextDouble();
                   System.out.print("Inserisci lato 2: ");
                   b = tastiera.nextDouble();
                   System.out.print("Inserisci lato 3: ");
                   c = tastiera.nextDouble();
                   
                   FiguraGeometrica K = new FiguraGeometrica(t,a,b,c);
                   System.out.println(K.Stato());  
                   System.out.println("Perimetro: "+K.getPerCirc());       
                   System.out.println("Area: "+K.getArea());       
                  break;
               }
           }
      
           System.out.println();
        }   
    }
   
}
