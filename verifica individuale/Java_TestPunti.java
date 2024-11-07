package java_testpunti;
import java.util.Scanner;

public class Java_TestPunti {

    public static void main (String args[]) {

    Scanner tastiera = new Scanner(System.in);

    int scelta=-1, sc1=-1;
    Punti P1 = new Punti("P1");
    Punti P2 = new Punti("P2");
    Punti P3 = new Punti("P3");

    while (scelta!=0)
    {

	System.out.println();
        System.out.println(P1.Quale()+" ("+P1.Leggix()+";"+P1.Leggiy()+")");
        System.out.println(P2.Quale()+" ("+P2.Leggix()+";"+P2.Leggiy()+")");
        System.out.println(P3.Quale()+" ("+P3.Leggix()+";"+P3.Leggiy()+")");

	System.out.println();
	System.out.println("0 - Fine");
	System.out.println("1 - Muovi P1");
	System.out.println("2 - Controlla da P1");
	System.out.println("3 - Muovi P2");
	System.out.println("4 - Controlla da P2");
	System.out.println("5 - Muovi P3");
	System.out.println("6 - Controlla da P3");
	System.out.print("Scelta : ");
        scelta = tastiera.nextInt();

	switch (scelta)
	{
            case 1:{
		System.out.print("Direzione P1 (1-left; 2-right; 3-up; 4-down) : ");
  	        sc1 = tastiera.nextInt();
		P1.Muovi(sc1);
		break;}

            case 2:{
		System.out.println();
                if (P1.Leggix()==P2.Leggix())
                    System.out.println(P1.Quale()+": stessa ascissa di  "+P2.Quale()+": "+P1.Leggix());
		if (P1.Leggiy()==P2.Leggiy())
                    System.out.println(P1.Quale()+": stessa ordinata di "+P2.Quale()+": "+P1.Leggiy());
  		if (P1.Leggix()==P3.Leggix())
                    System.out.println(P1.Quale()+": stessa ascissa di  "+P3.Quale()+": "+P1.Leggix());
		if (P1.Leggiy()==P3.Leggiy())
                    System.out.println(P1.Quale()+": stessa ordinata di "+P3.Quale()+": "+P1.Leggiy());
                break;}

            case 3:{
		System.out.print("Direzione P2 (1-left; 2-right; 3-up; 4-down) : ");
		sc1 = tastiera.nextInt();
		P2.Muovi(sc1);
		break;}

            case 4:{
		System.out.println();
                if (P2.Leggix()==P1.Leggix())
                    System.out.println(P2.Quale()+": stessa ascissa di  "+P1.Quale()+": "+P2.Leggix());
		if (P2.Leggiy()==P1.Leggiy())
                    System.out.println(P2.Quale()+": stessa ordinata di "+P1.Quale()+": "+P2.Leggiy());
  		if (P2.Leggix()==P3.Leggix())
                    System.out.println(P2.Quale()+": stessa ascissa di  "+P3.Quale()+": "+P2.Leggix());
		if (P2.Leggiy()==P3.Leggiy())
                    System.out.println(P2.Quale()+": stessa ordinata di "+P3.Quale()+": "+P2.Leggiy());
		break;}

            case 5:{
		System.out.println("Direzione P3 (1-left; 2-right; 3-up; 4-down)");
		sc1 = tastiera.nextInt();
		P3.Muovi(sc1);
                break;}

            case 6:{
		System.out.println();
                if (P3.Leggix()==P1.Leggix())
                    System.out.println(P3.Quale()+": stessa ascissa di  "+P1.Quale()+": "+P3.Leggix());
		if (P3.Leggiy()==P1.Leggiy())
                    System.out.println(P3.Quale()+": stessa ordinata di "+P1.Quale()+": "+P3.Leggiy());
  		if (P3.Leggix()==P2.Leggix())
                    System.out.println(P3.Quale()+": stessa ascissa di  "+P2.Quale()+": "+P3.Leggix());
		if (P3.Leggiy()==P2.Leggiy())
                    System.out.println(P3.Quale()+": stessa ordinata di "+P2.Quale()+": "+P3.Leggiy());
		break;}

	}

    }

    }

}
