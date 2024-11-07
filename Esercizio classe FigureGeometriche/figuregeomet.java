
package figuregeomet;

public class figuregeomet {
     
public static void main(String[] args) {
int base=7;
int altezza=8;
int raggio=10;
int pigreto=3;
int lato1=6;
int lato2=12;
int lato3=11;
rettangolo r = new rettangolo(base,altezza);
cerchio c = new cerchio(raggio,pigreto);
triangolo t = new triangolo(lato1,lato2,lato3,base,altezza);

System.out.println("dati calcolo del Rettangolo");
System.out.println("Perimetro del rettangolo e = "+r.getPerimetro());
System.out.println("Area del rettangolo e = "+r.getArea());
System.out.println("dati calcolo del Cerchio");
System.out.println("area del cerchio e = "+c.getAreac());
System.out.println("perimetro del cerchio e = "+c.getPerimetroc());
System.out.println("dati calcolo del Triangolo");
System.out.println("Perimetro del triangolo e = "+t.getPerimetrot());
System.out.println("Area del triangolo e = "+t.getAreat());
}
}
