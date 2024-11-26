import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private static final int PADDLE_WIDTH = 20, PADDLE_HEIGHT = 130, BALL_SIZE = 37;
    private int leftPaddleY = 250, rightPaddleY = 250;
    private int ballX = 400, ballY = 300, ballVelX = -7, ballVelY = 7;
    private int leftScore = 0, rightScore = 0;
    private Timer timer;
    private boolean leftUp = false, leftDown = false;
    private boolean rightUp = false, rightDown = false;

    public GamePanel(JFrame frame) {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(1000 / 500, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        g.setColor(Color.RED);
        g.fillRect(10, leftPaddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.setColor(Color.BLUE);
        g.fillRect(getWidth() - 40, rightPaddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.setColor(Color.WHITE);
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(Color.WHITE);
        g.drawString("Punteggio Giocatore 1: " + leftScore, 50, 30);
        g.drawString("Punteggio Giocatore 2: " + rightScore, getWidth() - 360, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ballX += ballVelX;
        ballY += ballVelY;

        // Rimbalzo sui bordi superiori e inferiori
        if (ballY <= 0 || ballY >= getHeight() - BALL_SIZE) {
            ballVelY = -ballVelY;
        }

// Controllo delle collisioni con le racchette
        if (ballX <= 20 && ballY >= leftPaddleY && ballY <= leftPaddleY + PADDLE_HEIGHT) {
            ballVelX = -ballVelX;
        }

        if (ballX >= getWidth() - 60 && ballY >= rightPaddleY && ballY <= rightPaddleY + PADDLE_HEIGHT) {
            ballVelX = -ballVelX;
        }

        if (ballX <= 0) {
            rightScore++;
            resetBall();
        }
        if (ballX >= getWidth() - BALL_SIZE) {
            leftScore++;
            resetBall();
        }

        if (leftUp && leftPaddleY > 0) {
            leftPaddleY -= 14;
        }
        if (leftDown && leftPaddleY < getHeight() - PADDLE_HEIGHT) {
            leftPaddleY += 14;
        }
        if (rightUp && rightPaddleY > 0) {
            rightPaddleY -= 14;
        }
        if (rightDown && rightPaddleY < getHeight() - PADDLE_HEIGHT) {
            rightPaddleY += 14;
        }

        repaint();
    }

    private void resetBall() {
        ballX = getWidth() / 2 - BALL_SIZE / 2;
        ballY = getHeight() / 2 - BALL_SIZE / 2;
        ballVelX = -ballVelX;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            leftUp = true;
        }
        if (key == KeyEvent.VK_S) {
            leftDown = true;
        }
        if (key == KeyEvent.VK_UP) {
            rightUp = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            rightDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            leftUp = false;
        }
        if (key == KeyEvent.VK_S) {
            leftDown = false;
        }
        if (key == KeyEvent.VK_UP) {
            rightUp = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            rightDown = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
