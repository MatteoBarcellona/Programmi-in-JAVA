
package tessera;

import java.util.Scanner;

public class Tessera {
   
public static void main(String[] args) throws Exception {
Scanner in = new Scanner(System.in);
Scanner in2 = new Scanner(System.in2);
double num;
String nome;

teserrac tesa = new teserrac(System.in);
System.out.println("dati del cliente tessera");
//codice
System.out.print("dimmi il codice del cliente");
num=in.nextDouble();   
tesa.getCodice(num);
//prezzo
System.out.print("dimmi il prezzo");
num=in.nextDouble();   
tesa.Aquisto(num);       
//nome del cliente
System.out.print("dimmi il nome del cliente");
nome=in2.nextString();   
tesa.setCliente(nome);  
}  
}
