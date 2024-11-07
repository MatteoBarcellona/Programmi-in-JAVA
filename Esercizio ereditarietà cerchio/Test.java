
package test;


public class Test {


    public static void main(String[] args) {
        //faccio 2 oggetti.
        cerchio c = new cerchio(13.5);
        cilindro c1= new cilindro(45.7);
        //faccio la visializzazione dei altrubiti del cerchio
            System.out.println("dati del cerchio");
            System.out.println("raggio e :" +c.getRaggio());
            System.out.println("area e :" +c.Area());
            System.out.println("circoferenza e :" +c.Circonferenza());
                //faccio la visializzazione dei altrubiti del cilindro
            System.out.println("dati del cilindro");
            System.out.println("altezza e :" + c1.getAltezza());
            System.out.println("Volume e :" + c1.Volume());
    }
    
}
