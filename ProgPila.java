
package progpila;
import java.util.Stack;

public class ProgPila {
    
    public static void main(String argv[]){

        Stack<Integer> pila = new Stack<Integer>();
        int num;
        Integer numObj;
        
        for(int i=0;i<10;i++){
          num= (int)(Math.random()*100);
          numObj= new Integer(num);
          System.out.print(numObj+" ");
          pila.push(numObj);
        }
        System.out.println("\nElementi nella pila: "+pila.size());
        
        while(!pila.empty()){
          numObj= pila.pop();
          System.out.print(numObj+" ");
        }
        System.out.println();
    }
}