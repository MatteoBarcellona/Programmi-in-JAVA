
package test;

public class test {
    
public static void main(String[] args){
System.out.println("i dati del calcolo del rettangolo");
rettangolo r1 = new rettangolo(7,8);
System.out.println("la base vale "+r1.getBase());
rettangolo r2 = new rettangolo(7,8);
System.out.println("la altezza vale "+r2.getAltezza()); 
System.out.println("il perimetro e "+ r1.getcalcolaperimetro());
System.out.println("l area e "+ r2.getcalcolarea());
r1.calcolaperimetro(7, 8);
r2.calcolarea(7,8);
}   
}
