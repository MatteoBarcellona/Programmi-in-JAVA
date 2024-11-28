import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TitleScreen extends JFrame {

    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JButton playButton;
    private JButton manualButton;
    private JButton exitButton;

    public TitleScreen() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        titleLabel = new JLabel("Videogioco Snake", SwingConstants.CENTER);
        titleLabel.setForeground(new Color(102, 255, 102));  // Verde brillante
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 100));

        subtitleLabel = new JLabel("Fatto da Matteo Barcellona", SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Ink Free", Font.ITALIC, 155));

        titlePanel.add(titleLabel, gbc);
        gbc.gridy = 1;
        titlePanel.add(subtitleLabel, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Layout verticale per i pulsanti
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        playButton = new JButton("            Gioca          ");
        playButton.setFont(new Font("Ink Free", Font.BOLD, 50));
        playButton.setPreferredSize(new Dimension(11900, 60));  // Impostiamo la dimensione iniziale dei pulsanti
        playButton.setFocusPainted(false);
        playButton.setBackground(new Color(0, 128, 0)); // Verde
        playButton.setForeground(Color.WHITE);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra il pulsante
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GiocoSnake();
            }
        });

        manualButton = new JButton("         Manuale       ");
        manualButton.setFont(new Font("Ink Free", Font.BOLD, 50));
        manualButton.setPreferredSize(new Dimension(11900, 60));  // Impostiamo la dimensione iniziale dei pulsanti
        manualButton.setFocusPainted(false);
        manualButton.setBackground(new Color(255, 204, 0)); // Giallo
        manualButton.setForeground(Color.BLACK);
        manualButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra il pulsante
        manualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Usa le frecce direzionali per controllare il serpente.\n" +
                                "Mangia le mele per crescere e guadagnare punti.\n" +
                                "Evita di scontrarti con te stesso o con i bordi del gioco.",
                        "Manuale del Gioco",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton = new JButton("            Esci          ");
        exitButton.setFont(new Font("Ink Free", Font.BOLD, 50));
        exitButton.setPreferredSize(new Dimension(11900, 60));  // Impostiamo la dimensione iniziale dei pulsanti
        exitButton.setFocusPainted(false);
        exitButton.setBackground(new Color(255, 0, 0)); // Rosso
        exitButton.setForeground(Color.WHITE);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra il pulsante
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Termina il programma
                System.exit(0);
            }
        });

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 50)));  // Distanza tra titolo e pulsanti
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Distanza tra i pulsanti
        buttonPanel.add(manualButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Distanza tra i pulsanti
        buttonPanel.add(exitButton);

        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateTitleAndButtons();
            }
        });

        setVisible(true);
    }

    private void updateTitleAndButtons() {
        int newFontSize = Math.min(getWidth(), getHeight()) / 7;
        titleLabel.setFont(new Font("Impact", Font.BOLD, newFontSize));

        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, newFontSize / 2));

        int newButtonWidth = getWidth() / 2;
        int newButtonHeight = getHeight() / 6;

        playButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));
        manualButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));
        exitButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manualButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new TitleScreen();
    }
}

