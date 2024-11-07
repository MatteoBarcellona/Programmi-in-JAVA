
package java_gui_giocodel15;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Java_GUI_giocodel15 extends JFrame {

    JButton R = new JButton("reset");
    JLabel L = new JLabel("Conta:");
    JTextField C = new JTextField("");

    JButton[][] B = new JButton[4][4];

    GestBottone K = new GestBottone();

    int conta;
    int old_r, old_c;

    public Java_GUI_giocodel15() {

        int i = -1, j = -1;
        int n = 0, k = 0, n1 = 0, n2 = 0;
        int[] numeri = new int[16];

        this.setLayout(null);

        this.add(R);
        this.add(L);
        this.add(C);

        R.setBounds(10, 300, 70, 30);
        R.addActionListener(K);
        L.setBounds(150, 300, 50, 30);
        C.setBounds(200, 300, 50, 30);
        C.setEditable(false);

        for (k = 0; k < 16; k++) {
            numeri[k] = k;
        }
        for (k = 0; k < 100; k++) {
            n1 = (int) Math.floor(Math.random() * 16);
            n2 = (int) Math.floor(Math.random() * 16);
            n = numeri[n1];
            numeri[n1] = numeri[n2];
            numeri[n2] = n;
        }

        k = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                B[i][j] = new JButton();
                this.add(B[i][j]);
                B[i][j].setBounds(10 + (i * 52), 10 + (j * 42), 50, 40);
                B[i][j].setText(String.valueOf(numeri[k]));
                if (numeri[k] != 0) {
                    B[i][j].setVisible(true);
                } else {
                    B[i][j].setVisible(false);
                    old_c = i;
                    old_r = j;
                }
                B[i][j].addActionListener(K);
                k++;
            }
        }

        conta = 0;
        C.setText(String.valueOf(conta));

        this.setLocation(200, 100);
        this.setSize(400, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Java_GUI_giocodel15();
    }

    class GestBottone implements ActionListener {

        public void actionPerformed(ActionEvent E) {
            int i = -1, j = -1;
            int nn = 0, newnum = -1;
            int n, n1, n2, r, k;
            String w = "";
            int[] numeri = new int[16];

            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    if (E.getSource() == B[i][j]) {
                        r = 0;
                        if (i == old_c - 1 && j == old_r) {
                            r = 1;
                            // bottone sotto
                        }
                        if (i == old_c + 1 && j == old_r) {
                            r = 1;
                            // bottone sopra 
                        }
                        if (j == old_r - 1 && i == old_c) {
                            r = 1;
                            // bottone sx 
                        }
                        if (j == old_r + 1 && i == old_c) {
                            r = 1;
                            // bottone dx 
                        }
                        if (r == 1) {
                            w = B[i][j].getText();
                            B[i][j].setText("0");
                            B[i][j].setVisible(false);
                            B[old_c][old_r].setText(w);
                            B[old_c][old_r].setVisible(true);
                            old_c = i;
                            old_r = j;
                            conta++;
                            C.setText(String.valueOf(conta));
                        }
                    }
                }
            }

            if (E.getSource() == R) {

                for (k = 0; k < 16; k++) {
                    numeri[k] = k;
                }
                for (k = 0; k < 100; k++) {
                    n1 = (int) Math.floor(Math.random() * 16);
                    n2 = (int) Math.floor(Math.random() * 16);
                    n = numeri[n1];
                    numeri[n1] = numeri[n2];
                    numeri[n2] = n;
                }

                k=0;
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        B[i][j].setText(String.valueOf(numeri[k]));
                        if (numeri[k] != 0) {
                            B[i][j].setVisible(true);
                        } else {
                            B[i][j].setVisible(false);
                            old_c = i;
                            old_r = j;
                        }
                        k++;
                    }
                }
                conta = 0;
                C.setText(String.valueOf(conta));
            }
        }

    }

}