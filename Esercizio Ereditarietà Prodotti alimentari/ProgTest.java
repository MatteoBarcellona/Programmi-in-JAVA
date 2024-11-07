
package progtest;

public class ProgTest {

    
    public static void main(String[] args) {
        //i miei oggetti
        prodotto p = new prodotto("324234","scatola1",26.7);
        Alimentari a = new  Alimentari("1234","scatola2",526.0);
        nonAlimentari na = new  nonAlimentari("123412","scatola3",9026.0);
        //scrivo i dati
        System.out.println("dati dei prodotti");
        System.out.println("i dati del prodotto sono"+p.toString());
        System.out.println("i dati dei Alimentatori sono" +p.toString());
        System.out.println("i dati dei non Alimentatori sono "+p.toString());
        System.out.println("il prezzo aplicato lo sconto e "+p.AplicaSconto());
        System.out.println("il prezzo aplicato lo sconto e "+a.AplicaSconto());
        System.out.println("il prezzo aplicato lo sconto e "+na.AplicaSconto());
    }
}
