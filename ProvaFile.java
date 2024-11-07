
package provafile;
import java.io.*;

public class ProvaFile {
    
public static void main(String[] args) throws IOException {
  
        try {

FileReader filein = new FileReader("prova.txt");
int next;
do {
  next = filein.read(); 
  if (next != -1) {
    char nextc = (char) next;
    System.out.print(nextc); 
  }
} while (next != -1);
filein.close(); 

}
catch (IOException e) {
  System.out.println(e); }
    }
    
}