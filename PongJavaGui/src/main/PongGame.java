import javax.swing.*;

public class PongGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        GamePanel titlePanel = new GamePanel(frame);
        frame.add(titlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
