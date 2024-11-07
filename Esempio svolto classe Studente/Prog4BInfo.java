package prog4binfo;

public class Prog4BInfo {

    public static void main(String[] args) {
        System.out.println("sto istaziando un oggetto relativo ad uno studente");
        studente s1=new studente("Fiandaca","Samuele");
        System.out.println("lo studente si chiama "+s1.getNome());
        studente s2=new studente("Golisano","Riccardo");
        System.out.println("lo studente numero 2 si chiama "+s2.getNome());
        s2.setNome("Giorgio");
        System.out.println("lo studente numero 2 si chiama "+s2.getNome());
        System.out.println("le assenze del numero 2 sono "+s2.getNAssenze());
        System.out.println("le assenze del numero 1 sono "+s1.getNAssenze());
        s1.aggiungiAssenza();
        s1.aggiungiAssenza();
        System.out.println("le assenze del numero 1 sono "+s1.getNAssenze());
        s2.rimuoviAssenza();
        System.out.println("lo studente numero 2 si chiama "+s2.getNAssenze());
    }
    
}
