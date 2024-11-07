
package prova_di_grafica;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Container;

public class Prova_di_grafica extends JFrame {
    
    JLabel titolo= new JLabel("Cubo Giramondo");

    JButton button1= new JButton("PLAY");
    JButton button2= new JButton("EXIT");
    
    JLabel nCrediti= new JLabel("Crediti:");
    JLabel quiCrediti= new JLabel("0");
    
    public Prova_di_grafica(){
        JFrame frame= new JFrame("Image Label Example");
        frame.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        
        JPanel panel= new JPanel(new BorderLayout());
        
        JLabel label= new JLabel();
        
        ImageIcon icon= new ImageIcon("prova di sfondo di gioco 2.jpg");

        label.setIcon(icon);
        Dimension size= label.getPreferredSize();
        label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        
        panel.add(label, BorderLayout.CENTER);
        
        this.add(titolo);
        this.add(button1);
        this.add(button2);
        this.add(nCrediti);
        this.add(quiCrediti);
        
        titolo.setBounds(470, 70, 800, 350);
        button1.setBounds(732, 500, 110, 50);
        button2.setBounds(730, 560, 110, 50);
        nCrediti.setBounds(30, 725, 130, 50);
        quiCrediti.setBounds(130, 730, 100, 40);
        
        titolo.setFont(new Font("Engravers MT", Font.BOLD, 50));
        titolo.setForeground(Color.WHITE);
        button1.setFont(new Font("Engravers MT", Font.BOLD, 20));
        button1.setForeground(Color.LIGHT_GRAY);
        button2.setFont(new Font("Engravers MT", Font.BOLD, 20));
        button2.setForeground(Color.LIGHT_GRAY);
        nCrediti.setFont(new Font("Engravers MT", Font.BOLD, 15));
        nCrediti.setForeground(Color.GREEN);
        quiCrediti.setFont(new Font("Engravers MT", Font.BOLD, 15));
        quiCrediti.setForeground(Color.GREEN);
        
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent E){
                System.out.println("3883");
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent E){
                System.out.println("8338");
            }
        });
        
        Container contentPane= this.getContentPane();
        contentPane.add(panel);

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Prova_di_grafica();
    }
    
}