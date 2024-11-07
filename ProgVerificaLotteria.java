
package progverificalotteria;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class ProgVerificaLotteria extends JFrame {
    
    JButton[][] B= new JButton[20][1];
    JButton R= new JButton("Reset");
    
    JLabel contIndovinati= new JLabel("Indovinati:");
    JTextField T= new JTextField("0");
    
    int[] numeri= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    
    int contd=0;
    int cont2=0;
    
    JTextField Indovinati= new JTextField(cont2);
    
    GestBottoni S1= new GestBottoni();
    
    public ProgVerificaLotteria(){
        int i=-1, j=-1;
        
        this.setLayout(null);
        
        for(i=0;i<20;i++){
          for(j=0;j<1;j++){
            B[i][j]= new JButton();
            this.add(B[i][j]);
            B[i][j].setBounds((55*i)+20, (35*j)+50, 50, 30);
            B[i][j].addActionListener(S1);
          }
        }
        
        this.add(R);
        this.add(contIndovinati);
        this.add(T);
        R.setBounds(110, 400, 100, 30);
        R.addActionListener(S1);
        contIndovinati.setBounds(310, 400, 100, 30);
        T.setBounds(375, 400, 100, 30);
        
        int pos=0;
        for(i=0;i<20;i++){
          if(numeri[i]==20){
            pos=i;
          }
        }
        
        int contz=0;
        for(i=0;i<20;i++){
          for(j=0;j<1;j++){
            B[i][j].setText(String.valueOf(numeri[contz]));
            contz++;
          }
        }
        
        this.setLocation(200, 100);
        this.setSize(1150, 500);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ProgVerificaLotteria();
    }
    
    class GestBottoni implements ActionListener {
        public void actionPerformed(ActionEvent E) {
            int i, j;
            int n=0;
            
            contd++;
            if(contd>10){
              for(i=0;i<20;i++){
                for(j=0;j<1;j++){
                  Indovinati.setText(String.valueOf(contd));
                  B[i][j].setText(String.valueOf(Indovinati));
                }
              }
            }
            contd=0;
            Indovinati.setText(String.valueOf(contd));
            
            //Reset
            if(E.getSource()==R){
              for(i=0;i<20;i++){
                for(j=0;j<1;j++){
                  n= (int)Math.floor(Math.random()*20)+1;
                  if(n!=0){
                    B[i][j].setText(String.valueOf(n));
                  }
                }
              }
              cont2=0;
              Indovinati.setText(String.valueOf(cont2));
            }
        }
    }
}