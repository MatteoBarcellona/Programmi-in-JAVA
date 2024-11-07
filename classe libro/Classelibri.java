
package classelibri;

public class Classelibri {
public static void main(String[] args) {
System.out.println("Dati del libro");
//3 oggetti
libri l1= new libri(31,"avvetura"); 
libri l2= new libri(100,"piante"); 
libri l3= new libri(50,"casa"); 
//scrivo i dati del libro
System.out.println("il nome del libro1 e "+ l1.getnome());
System.out.println("il nome del libro2 e "+ l2.getnome());
System.out.println("il nome del libro3 e "+ l3.getnome());
System.out.println("il prezzo del libro1 e "+ l1.getLibrop() +"$");
System.out.println("il prezzo del libro2 e "+ l2.getLibrop() +"$");
System.out.println("il prezzo del libro3 e "+ l3.getLibrop() +"$");
System.out.println("lo sconto del libro1 e "+ l1.setAplicasconto() +"$");
System.out.println("lo sconto del libro2 e "+ l2.setAplicasconto() +"$");
System.out.println("lo sconto del libro3 e "+ l3.setAplicasconto() +"$");
}
    
}
