import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GestioneSquadreGUI {
    private JFrame frame;
    private JTextArea infoTextArea;
    private JTextField nomeSquadraField, logoSquadraField, nomeGiocatoreField;
    private Squadra squadra;
    private List<Squadra> squadre;

    public GestioneSquadreGUI() {
        squadre = new ArrayList<>();

        frame = new JFrame("Gestione Squadre");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Nome Squadra:"));
        nomeSquadraField = new JTextField();
        panel.add(nomeSquadraField);

        panel.add(new JLabel("Logo Squadra:"));
        logoSquadraField = new JTextField();
        panel.add(logoSquadraField);

        panel.add(new JLabel("Nome Giocatore:"));
        nomeGiocatoreField = new JTextField();
        panel.add(nomeGiocatoreField);

        // Pulsante per creare una squadra
        JButton creaSquadraButton = new JButton("Crea Squadra");
        creaSquadraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeSquadra = nomeSquadraField.getText();
                String logoSquadra = logoSquadraField.getText();
                int giocatore = Integer.parseInt(nomeGiocatoreField.getText());

                if (!nomeSquadra.isEmpty() && !logoSquadra.isEmpty()) {
                    squadra = new Squadra(nomeSquadra, logoSquadra,giocatore);
                    squadre.add(squadra); // Aggiunge la squadra alla lista
                    nomeSquadraField.setText(""); // Svuota il campo dopo la creazione
                    logoSquadraField.setText(""); // Svuota il campo logo
                    aggiornaInfo(); // Aggiorna la visualizzazione delle informazioni
                    JOptionPane.showMessageDialog(frame, "Squadra creata con successo!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Inserisci nome e logo della squadra.");
                }
            }
        });
        panel.add(creaSquadraButton);

        // Pulsante per aggiungere un giocatore alla squadra corrente
        JButton aggiungiButton = new JButton("Aggiungi Giocatore");
        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (squadra != null) {
                    String nomeGiocatore = nomeGiocatoreField.getText();
                    if (!nomeGiocatore.isEmpty()) {
                        squadra.aggiungiGiocatore(new Giocatore(nomeGiocatore));
                        nomeGiocatoreField.setText(""); // Svuota il campo dopo l'aggiunta
                        aggiornaInfo(); // Aggiorna la visualizzazione delle informazioni
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Devi prima creare una squadra.");
                }
            }
        });
        panel.add(aggiungiButton);

        // Pulsante per visualizzare le informazioni della squadra
        JButton visualizzaButton = new JButton("Visualizza Squadre");
        visualizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiornaInfo(); // Mostra le informazioni della squadra
            }
        });
        panel.add(visualizzaButton);

        // Area di testo per visualizzare le informazioni della squadra
        infoTextArea = new JTextArea(10, 30);
        infoTextArea.setEditable(false);

        // Aggiunge il pannello dei controlli e l'area di testo alla finestra principale
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoTextArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Metodo per aggiornare le informazioni della squadra nella text area
    private void aggiornaInfo() {
        StringBuilder info = new StringBuilder();
        if (squadra != null) {
            info.append(squadra.visualizzaInfo());
        } else {
            info.append("Crea una squadra per iniziare.\n");
        }

        infoTextArea.setText(info.toString()); // Visualizza le informazioni aggiornate
    }

    // Metodo main per lanciare l'applicazione
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestioneSquadreGUI();
            }
        });
    }
}