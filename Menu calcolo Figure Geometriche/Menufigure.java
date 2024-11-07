
package menufigure;
import java.util.Scanner;

public class Menufigure {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dato;
        int base,altezza,lato1,lato2,lato3;  
        double raggio;
           //valori al utente
           System.out.print("dimmi la base :");
           base=in.nextInt();
           System.out.print("dimmi altezza :");
           altezza=in.nextInt();
           System.out.print("dimmi lato1 :");
           lato1=in.nextInt();
           System.out.print("dimmi lato2 :");
           lato2=in.nextInt();
           System.out.print("dimmi lato3 :");
           lato3=in.nextInt();
           System.out.print("dimmi raggio :");
           raggio=in.nextDouble();
           System.out.print("dimmi il numero della figura :");     
           dato=in.nextInt();
           
           //le mie figure
               figureee f = new figureee(base,altezza,lato1,lato2,lato3,raggio);
               figureee f2 = new figureee(base,altezza,lato1,lato2,lato3,raggio);
               figureee f3 = new figureee(base,altezza,lato1,lato2,lato3,raggio);
               figureee f4 = new figureee(base,altezza,lato1,lato2,lato3,raggio);
                
        switch(dato){
            
            //Rettangolo
            case 1: 
                System.out.println("rettangolo dati");
                System.out.println("base del rettangolo e " + f.getBase());
                System.out.println("altezza del rettangolo e " + f.getAltezza());
                System.out.println("perimetro del rettangolo e "+ f.PerimetroR());
                System.out.println("area del rettangolo e "+ f.AreaR());
                break;
                //Triangolo con base e altezza
            case 2: 
                System.out.println("triangolo (base e altezza) dati");
                System.out.println("base del triangolo e " + f2.getBase());
                System.out.println("altezza del triangolo e " + f2.getAltezza());
                System.out.println("perimetro del triangolo e "+ f2.PerimetroT2());
                System.out.println("area del triangolo e "+ f2.AreaT2());
                break;
                //Cerchio
            case 3: 
                System.out.println("cerchio dati");
                System.out.println("raggio del cerchio e " + f3.getRaggio());
                System.out.println("perimetro del cerchio e "+ f3.PerimetroC());
                System.out.println("area del cerchio e "+ f3.AreaC());
                break;  
                 //Triangolo con 3 lati
            case 4: 
                System.out.println("traingolo (3 lati) dati");
                System.out.println("lato1 del triangolo e " + f4.getLato1());
                System.out.println("lato2 del triangolo e " + f4.getLato2());
                System.out.println("lato3 del triangolo e " + f4.getLato3());
                System.out.println("perimetro del triangolo e "+ f4.PerimetroT());
                System.out.println("area del triangolo e "+ f4.AreaT());
                break;
            default:
                System.out.println("uscita");
}
}
}
