import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.List;

public class CarrelloGUI extends JFrame {
    private Carrello carrello = new Carrello();
    private DefaultTableModel tableModel;

    public CarrelloGUI() {
        // Applica un tema moderno
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Impostazioni della finestra principale
        setTitle("Gestione Carrello - Persistenza");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Pannello Tabella
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Prodotti nel Carrello"));
        tablePanel.setBackground(Color.WHITE);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Prezzo", "Quantità", "Totale"}, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        // Personalizzazione della tabella: Linee nere
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Pannello Input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Dettagli Prodotto"));
        inputPanel.setBackground(new Color(240, 240, 240));

        JTextField nomeField = new JTextField();
        JTextField prezzoField = new JTextField();
        JTextField quantitaField = new JTextField();
        JLabel totaleLabel = new JLabel("Totale: 0.0€");
        totaleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totaleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputPanel.add(new JLabel("Nome:", JLabel.RIGHT));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Prezzo:", JLabel.RIGHT));
        inputPanel.add(prezzoField);
        inputPanel.add(new JLabel("Quantità:", JLabel.RIGHT));
        inputPanel.add(quantitaField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(totaleLabel);

        // Pannello Pulsanti
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton aggiungiButton = new JButton("Aggiungi Prodotto");
        JButton rimuoviButton = new JButton("Rimuovi Prodotto");
        JButton svuotaCarrelloButton = new JButton("Svuota Carrello");
        JButton salvaCarrelloButton = new JButton("Salva Carrello");
        JButton caricaCarrelloButton = new JButton("Carica Carrello");

        // Stile dei pulsanti
        aggiungiButton.setFont(new Font("Arial", Font.BOLD, 14));
        aggiungiButton.setBackground(new Color(76, 175, 80));
        aggiungiButton.setForeground(Color.WHITE);

        rimuoviButton.setFont(new Font("Arial", Font.BOLD, 14));
        rimuoviButton.setBackground(new Color(244, 67, 54));
        rimuoviButton.setForeground(Color.WHITE);

        svuotaCarrelloButton.setFont(new Font("Arial", Font.BOLD, 14));
        svuotaCarrelloButton.setBackground(new Color(33, 150, 243));
        svuotaCarrelloButton.setForeground(Color.WHITE);

        salvaCarrelloButton.setFont(new Font("Arial", Font.BOLD, 14));
        salvaCarrelloButton.setBackground(new Color(255, 193, 7));
        salvaCarrelloButton.setForeground(Color.BLACK);

        caricaCarrelloButton.setFont(new Font("Arial", Font.BOLD, 14));
        caricaCarrelloButton.setBackground(new Color(103, 58, 183));
        caricaCarrelloButton.setForeground(Color.WHITE);

        buttonPanel.add(aggiungiButton);
        buttonPanel.add(rimuoviButton);
        buttonPanel.add(svuotaCarrelloButton);
        buttonPanel.add(salvaCarrelloButton);
        buttonPanel.add(caricaCarrelloButton);

        // Aggiungi Componenti alla Finestra
        add(tablePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Eventi
        aggiungiButton.addActionListener(e -> {
            try {
                String nome = nomeField.getText().trim();
                double prezzo = Double.parseDouble(prezzoField.getText());
                int quantita = Integer.parseInt(quantitaField.getText());

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Il nome del prodotto non può essere vuoto.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (prezzo < 0 || quantita < 0) {
                    JOptionPane.showMessageDialog(this, "Prezzo e quantità devono essere positivi.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Prodotto prodotto = new Prodotto(nome, prezzo, quantita);
                carrello.aggiungiProdotto(prodotto);
                aggiornaTabella();
                totaleLabel.setText("Totale: " + String.format("%.2f", carrello.calcolaTotaleConSconto()) + "€");
                nomeField.setText("");
                prezzoField.setText("");
                quantitaField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Inserisci valori validi per prezzo e quantità.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        rimuoviButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String nome = (String) tableModel.getValueAt(selectedRow, 0);
                carrello.rimuoviProdotto(nome);
                aggiornaTabella();
                totaleLabel.setText("Totale: " + String.format("%.2f", carrello.calcolaTotaleConSconto()) + "€");
            } else {
                JOptionPane.showMessageDialog(this, "Seleziona un prodotto da rimuovere.", "Errore", JOptionPane.WARNING_MESSAGE);
            }
        });

        svuotaCarrelloButton.addActionListener(e -> {
            int conferma = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler svuotare il carrello?", "Conferma", JOptionPane.YES_NO_OPTION);
            if (conferma == JOptionPane.YES_OPTION) {
                carrello = new Carrello();
                aggiornaTabella();
                totaleLabel.setText("Totale: 0.0€");
            }
        });

        // Salva il carrello su un file di testo
        salvaCarrelloButton.addActionListener(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("carrello.txt"))) {
                for (Prodotto prodotto : carrello.getProdotti()) {
                    String linea = prodotto.getNome() + "," + prodotto.getPrezzo() + "," + prodotto.getQuantita();
                    writer.write(linea);
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(this, "Carrello salvato con successo!", "Salva", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Errore durante il salvataggio del carrello.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Carica il carrello da un file di testo
        caricaCarrelloButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("carrello.txt"))) {
                String linea;
                carrello = new Carrello(); // Pulisce il carrello corrente
                while ((linea = reader.readLine()) != null) {
                    String[] dati = linea.split(",");
                    String nome = dati[0];
                    double prezzo = Double.parseDouble(dati[1]);
                    int quantita = Integer.parseInt(dati[2]);

                    Prodotto prodotto = new Prodotto(nome, prezzo, quantita);
                    carrello.aggiungiProdotto(prodotto);
                }
                aggiornaTabella();
                totaleLabel.setText("Totale: " + String.format("%.2f", carrello.calcolaTotaleConSconto()) + "€");
                JOptionPane.showMessageDialog(this, "Carrello caricato con successo!", "Carica", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Errore durante il caricamento del carrello.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void aggiornaTabella() {
        tableModel.setRowCount(0);
        for (Prodotto prodotto : carrello.getProdotti()) {
            tableModel.addRow(new Object[]{
                    prodotto.getNome(),
                    prodotto.getPrezzo(),
                    prodotto.getQuantita(),
                    String.format("%.2f", prodotto.calcolaTotale())
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarrelloGUI gui = new CarrelloGUI();
            gui.setVisible(true);
        });
    }
}
