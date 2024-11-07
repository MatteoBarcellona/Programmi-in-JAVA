
package randommatrixbutton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomMatrixButton extends JFrame {
    
    private JPanel panel;
    private JLabel[][] labels;
    private JButton button;
    
    public RandomMatrixButton() {
        setTitle("Random Matrix");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 5));
        add(panel);
        
        labels = new JLabel[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                labels[i][j] = new JLabel("");
                panel.add(labels[i][j]);
            }
        }
        
        button = new JButton("Genera");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 5; j++) {
                        labels[i][j].setText(Integer.toString(rand.nextInt(100)));
                    }
                }
            }
        });
        panel.add(button);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new RandomMatrixButton();
    }
}