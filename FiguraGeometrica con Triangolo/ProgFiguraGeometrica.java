package progfigurageometrica;
 
public class ProgFiguraGeometrica {

    public static void main(String[] args) {
        System.out.println("dati figure geeometriche");
        FiguraGeometrica A1 = new FiguraGeometrica('R',4,3,1.77,7,7,7);
        FiguraGeometrica T = new FiguraGeometrica('T',7,4,3.88,6,6,6);
        FiguraGeometrica C = new FiguraGeometrica('C',670,7,5.55,7,7,7);
        System.out.println("dati figure geeometriche stato");
        System.out.println(A1.Stato());       
        System.out.println(T.Stato());       
        System.out.println(C.Stato());
        System.out.println("dati figure geeometriche perimetri");
        System.out.println("Perimetro rettangolo: "+A1.getPerCirc());       
        System.out.println("Perimetro triangolo;:"+ T.getPerCirc());       
        System.out.println("Perimetro Circonferenza: "+C.getPerCirc());
        System.out.println("dati figure geeometriche aree");
        System.out.println("Area: "+A1.getArea());       
        System.out.println("Area: "+T.getArea());       
        System.out.println("Area: "+C.getArea());
    }
    
} 